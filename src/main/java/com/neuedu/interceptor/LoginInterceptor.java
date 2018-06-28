package com.neuedu.interceptor;

import com.neuedu.entity.User;
import com.neuedu.mappper.UserMapper;
import com.neuedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("user");
        if(user != null){
            return true;
        }else{
            Cookie[] cookie = httpServletRequest.getCookies();
            Map<String,Cookie> cookieMap = new HashMap<>();
            if (cookie != null){
                for (Cookie cookie1 : cookie) {
                    cookieMap.put(cookie1.getName(),cookie1);
                }
                if (cookieMap.get("username") != null){
                    String username = cookieMap.get("username").getValue();
                    User user1 = new User();
                    user1.setUsername(username);
                    httpSession.setAttribute("user",user1);
                    return true;
                }else {
                    httpServletResponse.sendRedirect("/empdemo2/user/loginView");
                    return false;
                }
            }else {
                httpServletResponse.sendRedirect("/empdemo2/user/loginView");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
