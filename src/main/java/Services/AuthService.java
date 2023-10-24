package Services;

import hm.bank.Model.DAO.IMPLEMANTATION.AgencyIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.EmployeeIMPL;
import hm.bank.Model.DAO.INTERFACES.AgencyDAO;
import hm.bank.Model.DAO.INTERFACES.EmployeeDAO;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Employee;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AuthService {
    private AgencyIMPL agencyDAOIMPL;
    private EmployeeIMPL employeeDAOIMPL;

    public AuthService() {
        this.agencyDAOIMPL = new AgencyIMPL();
        this.employeeDAOIMPL = new EmployeeIMPL();
    }

    public Employee getEmployee(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Client code cannot be empty or less than zero");
        } else {
            return employeeDAOIMPL.findEmployeeById(code).orElse(null);
        }
    }

    public Agency getAgency(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Client code cannot be empty or less than zero");
        } else {
            return agencyDAOIMPL.findAgencyById(code).orElse(null);
        }
    }
}
