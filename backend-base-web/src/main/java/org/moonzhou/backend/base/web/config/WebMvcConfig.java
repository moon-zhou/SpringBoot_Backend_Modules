package org.moonzhou.backend.base.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.moonzhou.backend.base.web.interceptor.CommonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CommonInterceptor commonInterceptor;

    @Bean
    public ServletListenerRegistrationBean requestContextListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new RequestContextListener());
        return servletListenerRegistrationBean;
    }

    /**
     * 添加拦截器
     * 该拦截器添加上下文参数、MDC添加线程号
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index" + SystemConstants.REQUEST_SUFFIX);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        // 初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        // 初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 设置fastjson的SerializerFeature序列化属性
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullListAsEmpty);
        // 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConvert);
        super.configureMessageConverters(converters);

    }
}
