package com.th.config;

import com.th.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    //配置不需要拦截和需要拦截的请求
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置不被拦截的路径
       String[] patterns = new String[] {"/tadmin/login","/*.html","/image"};

        registry.addInterceptor(new SysInterceptor())
                .addPathPatterns("/**")  //配置拦截的路径
                .excludePathPatterns(patterns); //剔除掉某些拦截的路径

    }

}