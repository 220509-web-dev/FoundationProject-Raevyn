package com.revature.foundations.servlets;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.revature.foundations.models.appUser;
        import com.revature.foundations.services.UserService;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.time.LocalDateTime;

public class UserServlet extends HttpServlet {

                private final ObjectMapper mapper;

                public UserServlet(ObjectMapper mapper, UserService userService) {
                        this.mapper = mapper;
                }

                @Override
                public void init() throws ServletException {
                        System.out.println("[LOG] - UserServlet instantiated!");
                        System.out.println("[LOG] - Init param, test-init-key: " + this.getServletConfig().getInitParameter("test-init-key"));
                        System.out.println("[LOG]-Init param, user-servlet-key: " + this.getServletConfig().getInitParameter("user-servlet-key"));
                        System.out.println("[LOG]-Init param, another-param: " + this.getServletConfig().getInitParameter("another-param"));
                        System.out.println("[LOG]-Context param, test-context-key: " + this.getServletContext().getInitParameter("test-context-key"));
                }

                @Override
                protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


                        String potentialId = req.getParameter("id");
                        String potentialUsername = req.getParameter("username");

                        if (potentialId != null) {

                                return;
                        }

                        if (potentialUsername != null) {

                                return;
                        }


                }

                @Override
                protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                        System.out.println("[LOG]-UserServlet received a POST request at " + LocalDateTime.now());

                        try {
                                appUser newUser = mapper.readValue(req.getInputStream(), appUser.class);
                                System.out.println(newUser);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        resp.setStatus(204);

                }

                @Override
                protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        super.doPut(req, resp);
                }

                @Override
                protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        super.doDelete(req, resp);
                }

        }
