package Services;

import hm.bank.Model.DAO.IMPLEMANTATION.ClientIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.EmployeeIMPL;
import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DAO.INTERFACES.EmployeeDAO;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthService {
//    @Inject
//    private AgencyDAO agencyDAO;
    @Inject
    private EmployeeDAO employeeDAO;

    public AuthService() {
        employeeDAO = new EmployeeIMPL();
    }
}
