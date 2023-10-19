package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DTO.Client;
import hm.bank.HibernateConfig.HibarenateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ClientIMPL implements ClientDAO {

    private final HibarenateConfiguration configHibernate;
    private final Session session;

    public ClientIMPL() {
        configHibernate = new HibarenateConfiguration();
        session = configHibernate.getSession();
    }

    @Override
    public Optional<Client> insert(Client client) {
        Optional<Client> client1 = Optional.empty();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            System.out.println("Data inserted successfully.");
            client1 = Optional.of(client);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            configHibernate.closeSession();
        }
        return client1;
    }

    @Override
    public Optional<Client> getOne(String t) {
        Optional<Client> client1 = Optional.empty();
        try {
            Query query = session.createQuery("FROM Client WHERE code LIKE :codeValue ");
            Client result = (Client) query.setParameter("codeValue", "%" + t + "%").uniqueResult();
            client1 = Optional.of(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client1;
    }
}
