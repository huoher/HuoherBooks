package top.qiuchi.huoher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.qiuchi.huoher.component.LoginHandlerInterceptor;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // super.addViewControllers(registry);
//        //浏览器发送 /atguigu 请求来到 success
//        registry.addViewController("/user/login").setViewName("login");
//    }

    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main").setViewName("admin/adminindex");
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/adminlogin").setViewName("/admin/login");
//                registry.addViewController("/admin/addbook").setViewName("/admin/addBook");
            }

            //注册拦截器,允许静态资源通过
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                super.addInterceptors(registry);

                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/user/login","/login.html","/login","/admin/login","/adminlogin");
            }
        };
        return adapter;
    }
}