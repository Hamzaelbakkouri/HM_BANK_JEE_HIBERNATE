package hm.bank.Model;

import Services.ClientService;
import Services.CreditRequestService;
import hm.bank.Model.DAO.IMPLEMANTATION.AgencyIMPL;
import hm.bank.Model.DAO.INTERFACES.AgencyDAO;
import hm.bank.Model.DAO.INTERFACES.CreditState;
import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Client;
import hm.bank.Model.DTO.CreditRequest;
import hm.bank.Model.DTO.Employee;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.Optional;


public class main {
    public static void main(String[] args) {
        try {
//            Query query = session.createQuery("FROM Client WHERE code LIKE :codeValue ");
//            Client result = (Client) query.setParameter("codeValue", "%code%").uniqueResult();
//            System.out.println(result.getBirthDate());


//            Agency agency = new Agency("555", "hamza", "test", "0625182280");
//            CreditRequest CreditRequest = new CreditRequest(2, agency.get(), client, 555, 6666, 666, date, "the first desc", CreditState.Pending);
//            CreditRequestService creditNew = new CreditRequestService();
//            creditNew.CreateCreditRequest(CreditRequest);

//            AgencyDAO agenctest = new AgencyIMPL();
//            agenctest.create(agency);
//            LocalDate date = LocalDate.now();
//            Client client = new Client("hamza", "elbakkouri", date, "0625182280", "hay dchiar", "code56");
//
//            ClientService clientService = new ClientService();
//            clientService.createClient(client);

//            EmployeeDAO newEmployee = new EmployeeIMPL();
//            Optional<Employee> employeeresult = newEmployee.findEmployeeById("employee1");
//            System.out.println(employeeresult.get().getEmail());

//
//            Transaction transaction = session.beginTransaction();
//            session.save(client);
//            transaction.commit();
//            System.out.println("Data inserted successfully.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
