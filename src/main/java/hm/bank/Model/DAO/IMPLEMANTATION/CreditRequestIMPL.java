package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Utils.JPAUtil;
import hm.bank.Model.DAO.INTERFACES.CreditRequestDAO;
import hm.bank.Model.DTO.CreditRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import java.util.List;
import java.util.Optional;

public class CreditRequestIMPL implements CreditRequestDAO {
    private final EntityManager entityM;

    public CreditRequestIMPL() {
        entityM = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public CreditRequestIMPL(EntityManager eM) {
        this.entityM = eM;
    }

    @Override
    public Optional<CreditRequest> insert(CreditRequest creditRequest) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            entityM.persist(creditRequest);
            transaction.commit();
            return Optional.of(creditRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<CreditRequest> UpdateCredit(CreditRequest creditRequest) {
        Optional<CreditRequest> newCreditRequest = Optional.empty();
//        try {
//            this.session.update(creditRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return newCreditRequest;
    }

    @Override
    public List<CreditRequest> getAllCreditRequest() {
        return null;
    }


    @Override
    public Optional<CreditRequest> getOne(String t) {
        return Optional.empty();
    }
}
