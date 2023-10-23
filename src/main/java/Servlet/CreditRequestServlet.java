package Servlet;

import Services.CreditRequestService;
import hm.bank.Model.DAO.INTERFACES.CreditState;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Client;
import hm.bank.Model.DTO.CreditRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/getsimulation"})
public class CreditRequestServlet extends HttpServlet {
    CreditRequestService creditRequestService;

    @Override
    public void init() {
        this.creditRequestService = new CreditRequestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/getsimulation":
                getSimulation(req, resp);
            case "/createcredit":
                createSimulation(req, resp);
        }
    }

    private void getSimulation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String time = request.getParameter("time");
        String balance = request.getParameter("balance");
        String monthly_balance = request.getParameter("monthly_balance");

        session.setAttribute("time", time);
        session.setAttribute("balance", balance);
        session.setAttribute("mb", monthly_balance);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    private void createSimulation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        double balance = (double) session.getAttribute("balance");
        int time = (int) session.getAttribute("time");
        double monthly_balance = (double) session.getAttribute("mb");
        Client client = (Client) session.getAttribute("client");
        Agency agency = (Agency) session.getAttribute("agency");
        String notes = request.getParameter("notes");
        LocalDate date = LocalDate.now();
        CreditRequest CreditRequest = new CreditRequest(agency, client, balance, time, monthly_balance, date, notes, CreditState.Pending);
        CreditRequest isInserted = this.creditRequestService.CreateCreditRequest(CreditRequest);
        if (isInserted != null) {
            request.setAttribute("message", "credit inserted successfully");
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
