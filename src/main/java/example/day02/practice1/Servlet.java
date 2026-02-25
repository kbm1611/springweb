package example.day02.practice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day02/practice1")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet.doGet");
        int value = Integer.parseInt(req.getParameter("value"));
        resp.getWriter().println(value + 2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet.doPost");
        int value = Integer.parseInt(req.getParameter("value"));
        resp.getWriter().println(value * 2);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet.doPut");
        int value = Integer.parseInt(req.getParameter("value"));
        resp.getWriter().println(value / 2);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet.doDelete");
        int value = Integer.parseInt(req.getParameter("value"));
        resp.getWriter().println(value % 2);
    }
}
