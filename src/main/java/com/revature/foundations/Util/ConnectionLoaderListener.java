package com.revature.foundations.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.DAO.UserDaoPostgres;
import com.revature.foundations.services.UserService;
import com.revature.foundations.servlets.UserServlet;
import com.revature.foundations.servlets.AuthServlet;
import com.revature.foundations.servlets.UserServlet;

import javax.servlet.*;
import java.time.LocalDateTime;


public class ConnectionLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();

        UserDaoPostgres userDaoPostgres = new UserDaoPostgres();
        UserService userService = new UserService(userDaoPostgres);
        UserServlet userServlet = new UserServlet(mapper, userService);

        UserServlet userServlet = new UserServlet(mapper);
        AuthServlet authServlet = new AuthServlet(mapper);

        ServletContext context = sce.getServletContext();

//        CustomFilter customFilter = new CustomFilter();
//        context.addFilter("CustomFilter", customFilter)
//               .addMappingForUrlPatterns(EnumSet.of(DispatcherType.), true, "/*");

        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
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
