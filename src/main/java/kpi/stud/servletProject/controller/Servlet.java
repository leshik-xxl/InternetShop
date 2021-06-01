package kpi.stud.servletProject.controller;

import kpi.stud.servletProject.model.User;
import kpi.stud.servletProject.model.dao.SqlUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        processRequest(request, response);

        request.setCharacterEncoding("UTF-8");

        try {

            SqlUserDao sqlUserDao = new SqlUserDao();

            List<User> users = sqlUserDao.getAllUser();
            request.setAttribute("users", users);

            RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
            dispatcher.forward(request, response);
        }catch (Exception ex){
            //response.sendRedirect(request.getParameter(FROM));
//            String from = request.getParameter(FROM);
//            request.getRequestDispatcher(from.substring(from.indexOf('/', 0))).forward(request, response);
            processRequest(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        processRequest(request, response);


        request.setCharacterEncoding("UTF-8");

        try {

            SqlUserDao sqlUserDao = new SqlUserDao();

            List<User> users = sqlUserDao.getAllUser();
            request.setAttribute("users", users);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index");
            dispatcher.forward(request, response);
        }catch (Exception ex){
            //response.sendRedirect(request.getParameter(FROM));
//            String from = request.getParameter(FROM);
//            request.getRequestDispatcher(from.substring(from.indexOf('/', 0))).forward(request, response);
            processRequest(request, response);
        }



    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/page1.html")
                .forward(request, response);

    }
}
