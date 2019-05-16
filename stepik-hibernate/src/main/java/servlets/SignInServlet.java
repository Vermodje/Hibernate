package servlets;


import userService.UserService;
import users.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private UserService userService = new UserService();

    public SignInServlet() {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        /*if (login == null) {
            resp.getWriter().println("Please enter login or password");
        }*/
        Users users = userService.getUsersByLogin(login);
        if (users == null || !users.getPass().equals(pass)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Unauthorized");
            return;

        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("Authorized: " + login);


    }
}
