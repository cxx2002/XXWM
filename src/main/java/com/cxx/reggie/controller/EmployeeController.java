package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.mapper.EmployeeMapper;
import com.cxx.reggie.pojo.Employee;
import com.cxx.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 员工信息(Employee)表控制层
 *
 * @author 陈喜喜
 * @since 2022-08-18 10:19:51
 */
@Slf4j
@RestController
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param request  作用域
     * @param employee 封装前端的json数据
     * @return R
     * @RequestBody 可以拿到前端传过来的json数据，用Employee类来封装存储前端传过来的json数据
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        if (emp == null) return R.error("登录失败！用户名不存在！");
        if (!password.equals(emp.getPassword())) return R.error("登录失败！密码错误！");
        if (emp.getStatus() == 0) return R.error("登录失败！账号已禁用！");
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }

    /**
     * 员工退出
     *
     * @param request 作用域
     * @return R
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("退出成功！");
    }

    /**
     * 新增员工
     *
     * @param employee 实体
     * @return 新增员工
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee) {
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        /*employee. setCreateTime (new Date()) ;
        employee. setUpdateTime (new Date()) ;
        //获得当前登录用户的id
        Long empId = (Long) request. getSession (). getAttribute( "employee");
        employee. setCreateUser (empId) ;
        employee. setUpdateUser (empId) ;*/
        EmployeeController.log.info("新增员工，员工信息：{}", employee.toString());
        employeeService.save(employee);
        EmployeeController.log.info("新增员工，员工信息：{}", employee.toString());
        return R.success("新增员工成功！");
    }

    /**
     * @param page     起始页
     * @param pageSize 页面大小
     * @param name     搜索查询
     * @return 查询结果
     */
    @GetMapping("/page")
    public R<Page<Employee>> queryByPage(int page, int pageSize, String name) {
        EmployeeController.log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        //分页构造器
        Page<Employee> employeePage = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        employeeService.page(employeePage, queryWrapper);
        return R.success(employeePage);
    }

    /**
     * 编辑数据  根据id修改员工信息 员工姓名的模糊查询
     *
     * @param employee 实体
     * @return 编辑结果
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee) {
        /*Long employeeId = (Long)request.getSession().getAttribute("employee")
        employee.setUpdateUser(employeeId)
        employee.setUpdateTime(new Date());*/
        long id = Thread.currentThread().getId();
        EmployeeController.log.info("update线程id为{}", id);
        employeeService.updateById(employee);
        return R.success("员工信息修改成功！");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<Employee> queryById(@PathVariable("id") Long id) {
        EmployeeController.log.info("根据id查询员工信息");
        Employee employee = employeeService.getById(id);
        if (employee == null) return R.error("没有查询到员工信息！");
        return R.success(employee);
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

}

