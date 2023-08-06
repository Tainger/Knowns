package com.bonbon.knowns.configuration.trace;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.utils.EnvUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashSet;
import java.util.Set;

import static com.bonbon.knowns.configuration.trace.TraceIdFilter.TRACE_ID;

/**
 * @author jiazhiyuan
 * @date 2023/8/5 10:15 AM
 */

@RestControllerAdvice
@Slf4j
public class ReusltAdvice<T> implements ResponseBodyAdvice<T>, InitializingBean {


    private final Set<Class<?>> supportedClassSet = new HashSet<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        supportedClassSet.add(Result.class);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        String hostName = EnvUtils.getHostName();
        Class<?> returnType = methodParameter.getMethod().getReturnType();

        log.info("主机名称" + hostName);
        return isAdviceTarget(returnType);
    }

    private boolean isAdviceTarget(Class<?> returnType) {
        for (Class<?> suportedClass : supportedClassSet) {
            if (suportedClass.isAssignableFrom(returnType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                             ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(body != null) {
            Class<?> returnTypeClass = returnType.getMethod().getReturnType();
            if(isAdviceTarget(returnTypeClass)) {
                adviceLogic(body);
            }
        }

        return body;
    }

    private void adviceLogic(Object readValue) {
        if(readValue != null) {
            setValueIfNull(readValue,"hostName", EnvUtils.getHostName());
            setValueIfNull(readValue,"ipAddress", EnvUtils.getHostAddress());
            setValueIfNull(readValue,"traceId", MDC.get(TRACE_ID));
        }
    }


    private void setValueIfNull(Object returnValue, String field, Object value) {
        ConfigurablePropertyAccessor configurablePropertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(returnValue);
        if(null == configurablePropertyAccessor.getPropertyValue(field)) {
            configurablePropertyAccessor.setPropertyValue(field, value);
        }
    }


}



    
