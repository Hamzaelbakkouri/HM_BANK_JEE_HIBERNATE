package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Utils.JPAUtil;
import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DTO.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class ClientIMPL implements ClientDAO {

//    private final HibarenateConfiguration configHibernate;
//    private final Session session;

    private final EntityManager entityM;

    public ClientIMPL() {
        entityM = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public ClientIMPL(EntityManager eM) {
        this.entityM = eM;
    }

//
//    public ClientIMPL() {
//        configHibernate = new HibarenateConfiguration();
//        session = configHibernate.getSession();
//    }

    @Override
    public Optional<Client> insert(Client client) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            entityM.persist(client);
            transaction.commit();
            return Optional.of(client);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Client> getOne(String t) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            Client client = entityM.find(Client.class, t);
            transaction.commit();
            return Optional.ofNullable(client);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Client> update(Client client) {
        Client existingClient = entityM.find(Client.class, client.getCode());
        EntityTransaction transaction = entityM.getTransaction();
        if (existingClient != null) {
            existingClient.setLastName(client.getLastName());
            existingClient.setFirstName(client.getFirstName());
            existingClient.setBirthDate(client.getBirthDate());
            existingClient.setPhoneNumber(client.getPhoneNumber());
            existingClient.setAddress(client.getAddress());

            entityM.merge(existingClient);
            transaction.commit();
            return Optional.of(existingClient);
        } else {
            transaction.rollback();
            return Optional.empty();
        }
    }
}
