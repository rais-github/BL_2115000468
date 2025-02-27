package in.sp.backend;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
    description = "Login Servlet",
    urlPatterns = {"/loginservlet"},
    initParams = {
        @WebInitParam(name = "username", value = "Himanshu"),
        @WebInitParam(name = "password", value = "H1m@nshu")
    }
)
public class LoginServlet extends HttpServlet {

    private String validUsername;
    private String validPassword;

    private static final String USERNAME_REGEX = "^[A-Z][a-z]{2,}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9])[A-Za-z\\d[^A-Za-z0-9]]{8,}$";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        validUsername = config.getInitParameter("username");
        validPassword = config.getInitParameter("password");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (PrintWriter writer = resp.getWriter()) {
            if (username == null || password == null) {
                writer.print("Please fill both fields!");
                return;
            }

            if (!Pattern.matches(USERNAME_REGEX, username)) {
                writer.print("<font color='red'>Invalid username! It should start with a capital letter and have at least 3 characters.</font>");
                return;
            }

            if (!Pattern.matches(PASSWORD_REGEX, password)) {
                writer.print("<font color='red'>Invalid password! It must be at least 8 characters, contain 1 uppercase letter, 1 number, and exactly 1 special character.</font>");
                return;
            }

            if (validUsername.equals(username) && validPassword.equals(password)) {
                req.setAttribute("username", username);
                req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
            } else {
                writer.println("<font color='red'>Either username or password mismatched.</font>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                rd.include(req, resp);
            }
        }
    }
}
