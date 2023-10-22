package Servlet;

import Services.CreditRequestService;
import hm.bank.Model.DTO.CreditRequest;
import hm.bank.Model.DTO.CreditRequestState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/creditrequests")
public class CreditRequestServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    }
}
