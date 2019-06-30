# backend-base-web

### Description
1. 该模块仅仅存放web层相关代码涉及
    * 代码入口-main函数
    * Controller
    * Interceptor(eg.HandlerInterceptorAdapter)
    * Aspect(eg.Aspect注解类，日志等)
    * Resolver(eg.HandlerExceptionResolver)
    * Response(eg.GenericResponse)
    * Configuration(eg.Configuration注解类，WebMvcConfigurerAdapter)
1. 依赖service，domain，common