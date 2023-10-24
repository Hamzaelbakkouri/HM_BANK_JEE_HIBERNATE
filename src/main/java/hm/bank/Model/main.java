package hm.bank.Model;

import Services.ClientService;
import Services.CreditRequestService;
import hm.bank.Model.DAO.IMPLEMANTATION.AgencyIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.ClientIMPL;
import hm.bank.Model.DAO.IMPLEMANTATION.CreditRequestIMPL;
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


//Agency agency = new Agency("111", "youcode", "safi", "0101010101");
//AgencyIMPL agenctest = new AgencyIMPL();
//agenctest.create(agency);

//LocalDate date = LocalDate.now();
//Client client = new Client("Mustapha", "FATIHI", date, "0650813123", "client111", "safi");
//ClientService clientServ = new ClientService();
//clientServ.createClient(client);

// Agency agency = new Agency("code2","mustafa","hay youcode","0625182280");

//Client client = new Client();
//client.setCode("client111");
//client.setId(1);


//CreditRequest creditRequest = new CreditRequest(agency, client, 10000, 10, 1000, LocalDate.now(), "Notes", CreditState.Pending);

//CreditRequestIMPL creditRequestIMPL = new CreditRequestIMPL();
//creditRequestIMPL.insert(creditRequest);


//            EmployeeDAO newEmployee = new EmployeeIMPL();
//            Optional<Employee> employeeresult = newEmployee.findEmployeeById("employee1");
//            System.out.println(employeeresult.get().getEmail());

//
//            Transaction transaction = session.beginTransaction();
//            session.save(client);
//            transaction.commit();
//            System.out.println("Data inserted successfully.");

            //System.out.println(new CreditRequestService().getAllCreditRequests().get(0).getCreationDate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
