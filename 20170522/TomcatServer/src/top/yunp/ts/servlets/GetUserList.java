package top.yunp.ts.servlets;

import org.json.JSONArray;
import top.yunp.ts.models.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by plter on 5/23/17.
 */
@WebServlet(name = "GetUserList", urlPatterns = "/users")
public class GetUserList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray users = new JSONArray();
        users.put(new User("XiaoMing", 10, "男").getJsonObject());
        users.put(new User("XiaoHua", 12, "男").getJsonObject());
        users.put(new User("XiaoLi", 11, "女").getJsonObject());
        users.put(new User("张三", 11, "男").getJsonObject());
        users.put(new User("李四", 13, "男").getJsonObject());
        users.put(new User("王五", 9, "男").getJsonObject());
        users.put(new User("赵六", 15, "男").getJsonObject());

//        ServletOutputStream out = response.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
//        writer.write("你好");
//        out.write("你好".getBytes("utf-8"));

        response.setCharacterEncoding("utf-8");
        PrintWriter write = response.getWriter();
        write.append(users.toString());
    }
}
