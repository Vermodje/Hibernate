package servlet;

import userService.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private UserService userService = new UserService();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null) {
            resp.getWriter().println("Please add login or password");
        } else {
            userService.addUser(login, password);
            resp.getWriter().println("User was added");
        }


    }
}
