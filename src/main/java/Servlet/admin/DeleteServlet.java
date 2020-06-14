package Servlet.admin;

import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
    UserService userService = UserService.getInstance();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("id");
            Arrays.asList(ids).forEach(id -> {
                try {
                    userService.deleteUser(Long.valueOf(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        resp.sendRedirect("/admin/read");
    }
}

