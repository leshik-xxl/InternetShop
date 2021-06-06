package kpi.stud.servletProject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "redirect:/InternetShop_war/index.jsp";
    }
}
