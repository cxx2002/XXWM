package com.cxx.reggie.interceptor;

import com.alibaba.fastjson.JSON;
import com.cxx.reggie.common.BaseContext;
import com.cxx.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈喜喜
 * @date 2022-08-19 16:00
 * response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
 * 这条代码会让没有登录就直接服务index.html，一旦发生了请求就直接跳转到登陆页面(前端JS实现)
 * index.html这个页面有一个加载完的钩子函数，会自动发起一个/employee/page的请求，所以会直接跳回登陆页面
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("employee") != null) {
            LoginInterceptor.log.info("用户已登录，用户id为:{}", request.getSession().getAttribute("employee"));
            long id = Thread.currentThread().getId();
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            LoginInterceptor.log.info("拦截器线程id为{}", id);
            LoginInterceptor.log.info("拦截了：" + request.getRequestURI() + "[放行]");
            return true;
        } else if (request.getSession().getAttribute("user") != null) {
            LoginInterceptor.log.info("用户已登录，用户id为:{}", request.getSession().getAttribute("user"));
            long id = Thread.currentThread().getId();
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            LoginInterceptor.log.info("拦截器线程id为{}", id);
            LoginInterceptor.log.info("拦截了：" + request.getRequestURI() + "[放行]");
            return true;
        } else {
            LoginInterceptor.log.info("拦截了：" + request.getRequestURI() + "[不放行]");
            response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("PostHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //log.info("afterCompletion");
    }
}
