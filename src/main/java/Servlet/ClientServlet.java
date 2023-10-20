package Servlet;

import java.io.*;

import Services.ClientService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/addClient", "/checkClient"})
public class ClientServlet extends HttpServlet {

    ClientService clientService;

    public void init() {
        clientService = new ClientService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/addClient":
                break;
            case "/checkClient":
                break;
        }
    }

    private void CreateClient(HttpServletRequest request, HttpServletResponse response) {
        String firstname = request.getParameter("");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }


    public void destroy() {
    }
}
