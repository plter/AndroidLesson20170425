package top.yunp.ts.servlets;

import top.yunp.ts.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by plter on 5/22/17.
 */
@WebServlet(name = "GetUser", urlPatterns = "/getuser")
public class GetUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append(new User("XiaoMing", 10, "male").toString());
    }
}
