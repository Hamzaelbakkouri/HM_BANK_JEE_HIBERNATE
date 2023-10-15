package Model.DAO.IMPLEMANTATION;

import Model.DAO.INTERFACES.ClientDAO;
import Model.DTO.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class ClientIMPL implements ClientDAO {

    private final Session session;
    private final SessionFactory sessionFactory;

    public ClientIMPL() {
        Configuration configuration = new Configuration();
        configuration.configure("/Hibernate/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public Optional<Client> insert(Client client) {
        Optional<Client> client1 = Optional.empty();
        try {
            Transaction transaction = session.beginTransaction();
            System.out.println(client.getBirthDate());
            session.save(client);
            transaction.commit();
            System.out.println("Data inserted successfully.");
            client1 = Optional.of(client);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return client1;
    }


    @Override
    public Optional<Client> getOne(String t) {
        return Optional.empty();
    }
}
