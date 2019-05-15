package servlets;

import service.userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private  UserService userService;

    public SignUpServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        if (login == null || pass == null){
            resp.getWriter().println("Please add login or password");
            return;
        }
        else {
                userService.addUser(login,pass);
            resp.getWriter().println("User was added");
        }


    }
}
