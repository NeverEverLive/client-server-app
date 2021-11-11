package com.example.autorization;

import models.Jaxb;
import models.User;
import models.Users;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.JAXBException;

@WebServlet(name = "helloServlet", value = "/autorization")
public class Autorization extends HttpServlet {
    File file = new File("/home/nel/Desktop/myxml.xml");
    static int number_try = 0;
    static Boolean correct=false;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + pass);

        if (number_try < 3) {
            try {
                numberReq(username, pass);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        else { System.out.println("You can't autorize"); }
        if(correct) {
            System.out.println("Correct");
            //req.getRequestDispatcher("success_auto.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + pass);

        if (number_try < 3) {
            try {
                numberReq(username, pass);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        else { System.out.println("You can't autorize"); }
        if(correct) {
            System.out.println("Correct");
            req.getRequestDispatcher("success_auto.jsp").forward(req, resp);
        }
    }

    protected void numberReq(String username, String pass) throws JAXBException {
        if (username == null || pass == null) {
            System.out.println("Username or password field is empty");
            return;
        }
        Users users = Jaxb.read(file);
        User user = new User(username, pass);
        if (!users.contains(user)) {
            number_try++;
            System.out.println(number_try);
            return;
        }
        System.out.println("Correct user and pass");
        correct = true;
    }

}