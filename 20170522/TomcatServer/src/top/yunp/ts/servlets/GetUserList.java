package top.yunp.ts.servlets;

import org.json.JSONArray;
import top.yunp.ts.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        response.getWriter().append(users.toString());
    }
}
