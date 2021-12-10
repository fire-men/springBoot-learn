package cn.fire.config.excption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:zl
 * @Date:2020/12/22 07:52:53
 * @Userful:
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public void userExceptionHandler(Throwable ex, HttpServletResponse response) {
        String msg = ex.getMessage();
        System.out.println("-----ex:msg-----"+msg);
        response.setContentType("application/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write("<html><body><font color='red'>"+msg+"</font></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
