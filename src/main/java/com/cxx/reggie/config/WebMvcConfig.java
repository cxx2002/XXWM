package com.cxx.reggie.config;

import com.cxx.reggie.common.JacksonObjectMapper;
import com.cxx.reggie.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-08-20 12:07
 * <p>
 * 静态资源默认放在 resources/static或templates目录下，不然，就需要进行相应的配置
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Resource
    private
    LoginInterceptor loginInterceptor;

    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //指定需要拦截的url地址
        String[] path = {"/**"};
        //指定不需要拦截的的url地址
        String[] excludePath = {"/employee/login", "/employee/logout",
                "/backend/**", "/front/**", "/error",
                "/user/sendMsg", "/user/login", "/user/sendMsg"};

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(path)
                .excludePathPatterns(excludePath);

    }

    // 设置静态资源的映射关系
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfig.log.info("即将进行静态资源的映射:");

        // 将请求路径 /backend/** 映射到 项目静态资源目录 resources/backend 下
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/static/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/static/front/");

    }

    //  扩展SpringMvc的消息转换器
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfig.log.info("自定义消息转化器 被调用!");
        // 创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        // 设置对象转换器，底层使用JackSON 将Java对象 转化为JSON
        messageConverter.setObjectMapper(new JacksonObjectMapper());

        // 将上面的消息转换器对象追加到SpringMVC的 转换器容器 的第一个位置(优先采用下标为 0 位置的消息转换器)
        converters.add(0, messageConverter);


    }
}

