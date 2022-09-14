package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.pojo.User;
import com.cxx.reggie.service.UserService;
import com.cxx.reggie.util.EmailUtil;
import com.cxx.reggie.util.ValidateCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户信息(User)表控制层
 *
 * @author 陈喜喜
 * @since 2022-09-01 19:12:52
 */
@Api(value = "user", tags = {"用户信息(User)表控制层"})
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 发送qq邮箱验证码短信
     *
     * @param user
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = ""),
            @ApiImplicitParam(paramType = "query", dataType = "HttpSession", name = "session", value = "")
    })
    @ApiOperation(value = "发送qq邮箱验证码短信", notes = "发送qq邮箱验证码短信", httpMethod = "POST")
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        //获取邮箱
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            UserController.log.info("code={}", code);
            //调用自己封装的qq邮箱发送器发送邮箱
            EmailUtil.sendAuthCodeEmail(phone, code);
            //将邮箱也保存到session，方便退出时删除
            session.setAttribute("email", phone);
            try {//redis缓存验证码
                redisTemplate.opsForValue().set(phone, code, 2, TimeUnit.MINUTES);
            } catch (Exception e) {//需要将验证码保存到session中
                session.setAttribute(phone, code);
                session.setMaxInactiveInterval(120); //设置session有效期 120秒,这里以后可能会用redis,所以先不设置！
                e.printStackTrace();
                System.out.println("redis服务未启动");
            }
            return R.success("邮箱验证码发送成功");
        }
        return R.error("邮箱发送失败");
    }

    /**
     * 移动端用户登录   phone变量的字符串值是邮箱，对应的在session的value是验证码
     * 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以
     *
     * @param map
     * @param session
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Map", name = "map", value = ""),
            @ApiImplicitParam(paramType = "query", dataType = "HttpSession", name = "session", value = "")
    })
    @ApiOperation(value = "移动端用户登录   phone变量的字符串值是邮箱，对应的在session的value是验证码 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以", notes = "移动端用户登录   phone变量的字符串值是邮箱，对应的在session的value是验证码 这里的接收参数是phone和code,一般肯定单独创建一个dto来接收,这里直接其实使用map也可以", httpMethod = "POST")
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        UserController.log.info("userMap:{}" + map.toString());
        //获取邮箱
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();

        Object codeInSession;
        Boolean flag = false;
        try {// 从Redis中获取缓存验证码
            codeInSession = redisTemplate.opsForValue().get(phone);
            flag = true;
        } catch (Exception e) {//从Session中获取保存的验证码
            codeInSession = session.getAttribute(phone);
            e.printStackTrace();
            System.out.println("redis服务未启动");
        }

        //进行验证码的比对(页面提交的验证码和Session中保存的验证码比对)
        if (codeInSession != null) if (codeInSession.equals(code)) {
            //如果能够比对成功,说明登录成功
            //判断当前手机号对应的用户是否为新用户,如果是新用户就自动完成注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {//说明是新用户
                UserController.log.info("欢迎新用户！！！！！！！！！！！！！！！！！！！！！！！");
                //直接注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            //登录成功,放入对应的用户session数据并返回对应用户的信息
            session.setAttribute("user", user.getId());
            UserController.log.info("user:::{}", user.getId());

            if (flag) redisTemplate.delete(phone);
            return R.success(user);
        } else return R.error("验证码错误");
        return R.error("验证码已过期");
    }

    // logout
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "")
    })
    @ApiOperation(value = "logout", notes = "logout", httpMethod = "POST")
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("email");
        return R.success("安全退出成功！");
    }


    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "User", name = "user", value = "筛选条件"),
            @ApiImplicitParam(paramType = "query", dataType = "PageRequest", name = "pageRequest", value = "分页对象")
    })
    @ApiOperation(value = "分页查询", notes = "分页查询", httpMethod = "GET")
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "主键")
    })
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据", httpMethod = "GET")
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = "实体")
    })
    @ApiOperation(value = "新增数据", notes = "新增数据", httpMethod = "POST")
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "User", name = "user", value = "实体")
    })
    @ApiOperation(value = "编辑数据", notes = "编辑数据", httpMethod = "PUT")
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {
        return null;
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "id", value = "主键")
    })
    @ApiOperation(value = "删除数据", notes = "删除数据", httpMethod = "DELETE")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return null;
    }

}

