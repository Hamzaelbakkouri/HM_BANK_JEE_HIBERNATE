package hm.bank.Model;

import hm.bank.Model.DTO.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class main {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("/Hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        LocalDate date = LocalDate.now();
        Client client = new Client("firstn", "laste", date, "phoner", "adress" , "code3");
        try {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
