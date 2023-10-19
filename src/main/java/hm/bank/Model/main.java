package hm.bank.Model;

import hm.bank.Model.DTO.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Optional;


public class main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("/Hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM Client WHERE code LIKE :codeValue ");
            Client result = (Client) query.setParameter("codeValue", "%code%").uniqueResult();
            System.out.println(result.getBirthDate());

//            LocalDate date = LocalDate.now();
//            Client client = new Client("hamza", "elbakkouri", date, "0625182280", "hay dchiar", "code66");
//            Transaction transaction = session.beginTransaction();
//            session.save(client);
//            transaction.commit();
//            System.out.println("Data inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
