package Servlet;

import java.io.*;
import java.time.LocalDate;

import Services.ClientService;
import hm.bank.Model.DTO.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/addclient", "/checkclient"})
public class ClientServlet extends HttpServlet {
    ClientService clientService;

    public void init() {
        clientService = new ClientService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/addclient":
                try {
                    CreateClient(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "/checkclient":
                try {
                    CheckIsClient(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private void CreateClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String phoneNumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");

        Client client = new Client(firstname, lastname, date, phoneNumber, address, code);
        this.clientService.createClient(client);

        request.setAttribute("clientdata", client);
        RequestDispatcher dispatcher = request.getRequestDispatcher("thirdStep.jsp");
        dispatcher.forward(request, response);
    }

    private void CheckIsClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String code = request.getParameter("client");
        Client client = this.clientService.getClientByCode(code);
        if (client != null) {
            session.setAttribute("client", client);
            request.getRequestDispatcher("/thirdStep.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
