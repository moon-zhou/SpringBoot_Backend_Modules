package org.moonzhou.backend.base.web.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    private ThreadLocal<String> invokeNo = new ThreadLocal<String>();

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        initMDC();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        request.setAttribute("ctx", request.getContextPath());
        endMDC();
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    private void initMDC() {
        String gInvokeNo = MDC.get("invokeNo");
        if (StringUtils.isEmpty(gInvokeNo)) {
            String lInvokeNo = UUID.randomUUID().toString().replace("-", "");
            invokeNo.set(lInvokeNo);
            MDC.put("invokeNo", lInvokeNo);
        }
    }

    private void endMDC() {
        String lInvokeNo = invokeNo.get();
        if (StringUtils.isNotEmpty(lInvokeNo)) {
            MDC.remove("invokeNo");
        }
    }
}
