package Servlet;

import Services.CreditRequestService;

import hm.bank.Model.DTO.CreditRequest;
import hm.bank.Model.DTO.CreditRequestState;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Client;

import hm.bank.Model.DAO.INTERFACES.CreditState;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/simulation", "/createcredit", "/creditrequests"})
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
            case "/simulation":
                getSimulation(req, resp);
                break;
            case "/createcredit":
                createSimulation(req, resp);
                break;
            case "/creditrequests":
                creditsList(req, resp);
                break;
            default:
                System.out.println("not found");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void getSimulation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int time = Integer.parseInt(request.getParameter("time"));
        float balance = Float.parseFloat(request.getParameter("balance"));
        float monthly_balance = Float.parseFloat(request.getParameter("monthly_balance"));

            session.setAttribute("time", time);
            session.setAttribute("balance", balance);
            session.setAttribute("mb", monthly_balance);
            request.getRequestDispatcher("home.jsp").forward(request, response);

//        request.getRequestDispatcher("firstStep.jsp").forward(request, response);
    }

    public void createSimulation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int time = (int) session.getAttribute("time");
        float balance = (Float) session.getAttribute("balance");
        float monthly_balance = (Float) session.getAttribute("mb");
        Client client = (Client) session.getAttribute("client");
        Agency agency = (Agency) session.getAttribute("agency");
        String notes = request.getParameter("notes");
        LocalDate date = LocalDate.now();
        CreditRequest CreditRequest = new CreditRequest(agency, client, balance, time, monthly_balance, date, notes, CreditState.Pending);
        CreditRequest isInserted = this.creditRequestService.CreateCreditRequest(CreditRequest);
        if (isInserted != null) {
//          request.setAttribute("message", "credit inserted successfully");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    public void creditsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("nbr") == null) {

            List<CreditRequest> creditRequests = new CreditRequestService().getAllCreditRequests();


            if (req.getParameter("crreqstate") != null) {
                creditRequests = creditRequests.stream()
                        .filter(creditRequest -> creditRequest.getState().name().equals(req.getParameter("crreqstate")))
                        .collect(Collectors.toList());

            }

            if (req.getParameter("creationdate") != null) {
                creditRequests = creditRequests.stream()
                        .filter(creditRequest -> creditRequest.getCreationDate().equals(LocalDate.parse(req.getParameter("creationdate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                        .collect(Collectors.toList());

            }


            req.setAttribute("creditRequests", creditRequests);

            req.getRequestDispatcher("creditrequests.jsp").forward(req, resp);

        } else {

            if (req.getParameter("action") == null) {
                List<CreditRequestState> creditRequestStates = new CreditRequestService().getCreditRequestHistory(req.getParameter("nbr"));


                req.setAttribute("items", creditRequestStates);
                req.getRequestDispatcher("creditrequesthistory.jsp").forward(req, resp);

            } else {
                if (req.getParameter("action").equals("accept")) {
                    new CreditRequestService().acceptCreditRequest(req.getParameter("nbr"));

                } else {
                    new CreditRequestService().refuseCreditRequest(req.getParameter("nbr"));

                }

                List<CreditRequest> creditRequests = new CreditRequestService().getAllCreditRequests();

                req.setAttribute("creditRequests", creditRequests);

                req.getRequestDispatcher("creditrequests.jsp").forward(req, resp);

            }

        }
    }

}
