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
          case "/getCreditsList":
                creditsList(req,resp);
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
  
  private void creditsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(req.getParameter("nbr")==null) {

            List<CreditRequest> creditRequests = new CreditRequestService().getAllCreditRequests();



            if(req.getParameter("crreqstate")!=null)
            {
                creditRequests = creditRequests.stream()
                        .filter(creditRequest -> creditRequest.getState().name().equals(req.getParameter("crreqstate")))
                        .collect(Collectors.toList());

            }

            if(req.getParameter("creationdate")!=null)
            {
                creditRequests = creditRequests.stream()
                        .filter(creditRequest -> creditRequest.getCreationDate().equals(LocalDate.parse(req.getParameter("creationdate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                        .collect(Collectors.toList());

            }


            req.setAttribute("creditRequests", creditRequests);

            req.getRequestDispatcher("creditrequests.jsp").forward(req, resp);

        }
        else
        {

            if(req.getParameter("action")==null)
            {
                List<CreditRequestState> creditRequestStates = new CreditRequestService().getCreditRequestHistory(req.getParameter("nbr"));

                //resp.setContentType("text/html");
                //resp.getWriter().println("<html><head><title>Hello, World</title></head><body><h1>"+creditRequestStates.size()+"</h1></body></html>");


                req.setAttribute("items",creditRequestStates);
                req.getRequestDispatcher("creditrequesthistory.jsp").forward(req, resp);

            }
            else
            {
                if (req.getParameter("action").equals("accept"))
                {
                    new CreditRequestService().acceptCreditRequest(req.getParameter("nbr"));

                }
                else
                {
                    new CreditRequestService().refuseCreditRequest(req.getParameter("nbr"));

                }

                List<CreditRequest> creditRequests = new CreditRequestService().getAllCreditRequests();

                req.setAttribute("creditRequests",creditRequests);

                req.getRequestDispatcher("creditrequests.jsp").forward(req, resp);

            }

        }
  }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
