package Servlet;

import Services.AuthService;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Employee;
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

//        String code = req.getParameter("code");
        String agencyparam = req.getParameter("agency");
        try {
//            Employee employee = this.authservice.getEmployee(code);
//            if (employee != null) {
//                session.setAttribute("employee", employee);
//            }
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
