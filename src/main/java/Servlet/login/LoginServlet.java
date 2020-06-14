package Servlet.login;

import Service.UserService;
import User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    private void goLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    private void redirectFromRole(HttpServletResponse response, String role) throws IOException {
        if ("admin".equals(role)) {
            response.sendRedirect("/admin/read");
        } else {
            response.sendRedirect("/user");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        goLoginPage(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = UserService.getInstance();
        HttpSession session = request.getSession();

        Optional<User> optionalUser = userService.findByLogin(login);

        if (optionalUser.isPresent()) {
            if (optionalUser.get().getPassword().equals(password)) {
                session.setAttribute("user_id", optionalUser.get().getId());
                session.setAttribute("user_role", optionalUser.get().getRole());

                redirectFromRole(response, optionalUser.get().getRole());
                return;
                }
            }
        goLoginPage(request, response);
        }
    }