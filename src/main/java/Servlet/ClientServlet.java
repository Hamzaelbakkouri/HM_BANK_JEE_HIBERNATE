package Servlet;

import java.io.*;

import Services.ClientService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class ClientServlet extends HttpServlet {

    ClientService clientService;

    public void init() {
        clientService = new ClientService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }


    public void destroy() {
    }
}
