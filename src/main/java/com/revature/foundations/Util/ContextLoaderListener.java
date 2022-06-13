package com.revature.foundations.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.services.AuthService;
import com.revature.foundations.services.UserService;
import com.revature.foundations.servlets.UserServlet;
import com.revature.foundations.servlets.AuthServlet;

import javax.servlet.*;
import java.time.LocalDateTime;


public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService();
        UserServlet userServlet = new UserServlet(mapper, userService);

        AuthService authService = new AuthService();
        AuthServlet authServlet = new AuthServlet(mapper);

        ServletContext context = sce.getServletContext();


        context.addServlet("UserServlet", userServlet).addMapping("/users");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");

        ServletRegistration.Dynamic registeredServlet = context.addServlet("UserServlet", userServlet);
        registeredServlet.setLoadOnStartup(3);
        registeredServlet.setInitParameter("user-servlet-key", "user-servlet-value");
        registeredServlet.setInitParameter("another-param", "another-value");
        registeredServlet.addMapping("/users/*");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }
}
