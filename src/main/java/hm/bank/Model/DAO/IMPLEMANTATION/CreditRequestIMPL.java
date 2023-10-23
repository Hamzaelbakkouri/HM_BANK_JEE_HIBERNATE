package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Model.DAO.INTERFACES.CreditState;
import hm.bank.Model.DTO.CreditRequestState;
import hm.bank.Utils.JPAUtil;
import hm.bank.Model.DAO.INTERFACES.CreditRequestDAO;
import hm.bank.Model.DTO.CreditRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreditRequestIMPL implements CreditRequestDAO {
    private final EntityManager entityM;

    public  CreditRequestIMPL() {
        entityM = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Optional<CreditRequest> insert(CreditRequest creditRequest) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            entityM.merge(creditRequest);
            transaction.commit();
            return Optional.of(creditRequest);
        } catch (PersistenceException e) {
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
    public List<CreditRequest> getAllCreditRequests() {

        List<CreditRequest> creditRequests = new ArrayList<>();

        try {
            creditRequests = this.entityM.createQuery("FROM CreditRequest ORDER BY nbr DESC", CreditRequest.class)
                                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return creditRequests;
    }


    @Override
    public void updateCreditRequestState(String entityId, CreditState creditState){

        CreditRequest creditRequest = entityM.find(CreditRequest.class, Integer.parseInt(entityId));

        creditRequest.setState(creditState);

        EntityTransaction transaction = entityM.getTransaction();
        transaction.begin();
        entityM.merge(creditRequest);
        transaction.commit();

    }

    public List<CreditRequestState> getCreditRequestState(String nbr)
    {
        List<CreditRequestState> creditRequestStates = new ArrayList<>();

        try {
            creditRequestStates = entityM.createQuery("FROM CreditRequestState WHERE creditRequest.nbr = :creditRequest ORDER BY creationDate DESC", CreditRequestState.class)
                                        .setParameter("creditRequest", nbr)
                                        .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return creditRequestStates;


    }


    @Override
    public Optional<CreditRequest> getOne(String t) {
        return Optional.empty();
    }
}
