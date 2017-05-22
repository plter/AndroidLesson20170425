package top.yunp.ts.servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by plter on 5/22/17.
 */
@WebServlet(name = "Hello", urlPatterns = "/hello")
public class Hello extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append("Hello World");

//        JSONObject user = new JSONObject();
//        user.put("name", "XiaoMing");
//        user.put("age", 10);
//        user.put("gender", "male");
//
//        writer.append(user.toString());
    }
}
