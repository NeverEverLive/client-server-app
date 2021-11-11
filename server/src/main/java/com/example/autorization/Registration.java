package com.example.autorization;

import models.Jaxb;
import models.User;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

@WebServlet(name="registr", value="/registration")
public class Registration extends HttpServlet {
    File file = new File("/home/nel/Desktop/myxml.xml");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String main_registration = "<html>" +
//                "<head>" +
//                "<title>Autorization</title>" +
//                "</head>" +
//                "<body>" +
//                "<form action='autorization' method='post'>" +
//                "<input type='text' name='username'/>" +
//                "<br><br>" +
//                "<input type='password' name='password'/>" +
//                "<br><br>" +
//                "<input type='submit' name='sign up'/>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//        String correct_register = "<html>" +
//                "<head>" +
//                "<title>Autorization</title>" +
//                "</head>" +
//                "<body>" +
//                "<h1>Successful sign up</h1>" +
//                "</body>" +
//                "</html>";

       // resp.getWriter().write(main_registration);
        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        System.out.println("Register:");
        System.out.println("username = " + username);
        System.out.println("password = " + pass);
        Users users = null;
        try {
            users = Jaxb.read(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        int id_new_user;
        if (users == null) {
            id_new_user = 1;
        }
        else{
            id_new_user = users.getUsers().size() + 1;
        }
        User new_user = new User(id_new_user, username, pass);

        if (users != null && Jaxb.contains(users, new_user)) {
            System.out.println("That user exists");
        }
        else{
            try {
                Jaxb.write(users, new_user, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("success_registr.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        System.out.println("Register:");
        System.out.println("username = " + username);
        System.out.println("password = " + pass);
        Users users = null;
        try {
            users = Jaxb.read(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        int id_new_user;
        if (users == null) {
            id_new_user = 1;
        }
        else{
            id_new_user = users.getUsers().size() + 1;
        }

        User new_user = new User(id_new_user, username, pass);

        if (users != null && Jaxb.contains(users, new_user)) {
            System.out.println("That user exists");
        }
        else{
            try {
                Jaxb.write(users, new_user, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("success_registr.jsp").forward(req, resp);
        }
    }

}
