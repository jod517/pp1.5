package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/user/*",
        filterName = "UserFilter",
        description = "Filter all user URLs")

public class UserFilter implements Filter {

    private final String loginPage = "/index.jsp";
    private final String restricted = "You don't have the access rights to go there! \r Moving you back to your place.";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("user_role") != null) {
            if (session.getAttribute("user_role").equals("user")) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("message", restricted);
                request.getRequestDispatcher("/user").forward(request, response);
            }
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
