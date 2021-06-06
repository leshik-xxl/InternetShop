package kpi.stud.servletProject.controller;

import kpi.stud.servletProject.controller.command.Command;
import kpi.stud.servletProject.controller.command.LogOut;
import kpi.stud.servletProject.controller.command.Login;
import kpi.stud.servletProject.controller.command.Registration;
import kpi.stud.servletProject.controller.command.Exception;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("logout", new LogOut());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("exception" , new Exception());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp)");
        String page = command.execute(request);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}


//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class Servlet extends HttpServlet {
//
//    public void init() {
//
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
////        processRequest(request, response);
//
//        request.setCharacterEncoding("UTF-8");
//
//        try {
//
//            SqlUserDao sqlUserDao = new SqlUserDao();
//
//            List<User> users = sqlUserDao.getAllUser();
//            request.setAttribute("users", users);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
//            dispatcher.forward(request, response);
//        }catch (Exception ex){
//            //response.sendRedirect(request.getParameter(FROM));
////            String from = request.getParameter(FROM);
////            request.getRequestDispatcher(from.substring(from.indexOf('/', 0))).forward(request, response);
//            //processRequest(request, response);
//        }
//
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
////        processRequest(request, response);
//
//
//        request.setCharacterEncoding("UTF-8");
//
//        try {
//
//            SqlUserDao sqlUserDao = new SqlUserDao();
//
//            List<User> users = sqlUserDao.getAllUser();
//            request.setAttribute("users", users);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("index");
//            dispatcher.forward(request, response);
//        }catch (Exception ex){
//            //response.sendRedirect(request.getParameter(FROM));
////            String from = request.getParameter(FROM);
////            request.getRequestDispatcher(from.substring(from.indexOf('/', 0))).forward(request, response);
//            //processRequest(request, response);
//        }
//
//
//
//    }
//
//}
