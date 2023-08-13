package com.bonbon.knowns.configuration.intercept;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.bonbon.knowns.configuration.context.UserContext;
import com.bonbon.knowns.model.entity.KnownsUser;
import com.bonbon.knowns.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiazhiyuan
 * @date 2023/8/12 9:04 PM
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            return false;
        }
        DecodedJWT decodedJWT = TokenUtil.verify(token);
        Long id = decodedJWT.getClaim("id").asLong();
        String username = decodedJWT.getClaim("username").asString();
        KnownsUser knownsUser = new KnownsUser();
        knownsUser.setId(id);
        knownsUser.setUsername(username);
        UserContext.put(knownsUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
    }
}



    
