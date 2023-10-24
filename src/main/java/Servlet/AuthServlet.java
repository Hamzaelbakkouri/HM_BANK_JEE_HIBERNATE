package Servlet;

import Services.AuthService;
import hm.bank.Model.DTO.Agency;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    private AuthService authservice;

    @Override
    public void init() throws ServletException {
        this.authservice = new AuthService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String agencyparam = req.getParameter("agency");

        try {

            Agency agency = this.authservice.getAgency(agencyparam);

            if (agency != null) {
                session.setAttribute("agency", agency);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/firstStep.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
