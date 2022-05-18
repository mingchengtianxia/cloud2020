package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 返回的带有@Configuration的类会用来配置ContextLoaderListener创建的应用上下文的bean
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 返回的带有@Configuration的类会用来定义DispatcherServlet应用上下文的bean
        return new Class[]{WebConfig.class};
    }

    // 将一个或多个路径映射到DispatcherServlet上
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   // 应用的默认的DispatcherServlet,会处理进入应用的所有请求
    }
}
