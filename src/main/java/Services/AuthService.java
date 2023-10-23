package Services;

import hm.bank.Model.DAO.IMPLEMANTATION.AgencyIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.ClientIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.EmployeeIMPL;
import hm.bank.Model.DAO.INTERFACES.AgencyDAO;
import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DAO.INTERFACES.EmployeeDAO;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class AuthService {
    //    @Inject
    private AgencyDAO agencyDAO;

    private EmployeeDAO employeeDAO;

    public AuthService() {
        this.employeeDAO = new EmployeeIMPL();
        this.agencyDAO = new AgencyIMPL();
    }

    public Employee getEmployee(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Client code cannot be empty or less than zero");
        } else {
            return employeeDAO.findEmployeeById(code).orElse(null);
        }
    }

    public Agency getAgency(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Client code cannot be empty or less than zero");
        } else {
            return agencyDAO.findAgencyById(code).orElse(null);
        }
    }
}
