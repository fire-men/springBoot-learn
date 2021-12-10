package cn.fire.interceptor;

import cn.fire.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author:zl
 * @Date:2020/12/22 06:40:19
 * @Userful:
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----preHandler-----");
        User user = new User();
        user.setNick("小红");
        user.setLoginAccount("zl123456");
        user.setLoginPassword("12456");
        user.setEmail("zl@qq.com");
       // request.getSession().setAttribute("user", user);

        if (request.getSession().getAttribute("user") == null) {
            response.setContentType("application/text;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("还没有登录呢，请先去登录！");
            writer.close();
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-----postHandler-----");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("-----afterCompletion-----");
    }
}
