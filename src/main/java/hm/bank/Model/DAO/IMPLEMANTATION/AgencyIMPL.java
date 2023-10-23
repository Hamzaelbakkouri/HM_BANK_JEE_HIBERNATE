package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Model.DAO.INTERFACES.AgencyDAO;
import hm.bank.Model.DTO.Agency;
import hm.bank.Utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class AgencyIMPL implements AgencyDAO {

    private final EntityManager entityM;

    public AgencyIMPL() {
        entityM = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Optional<Agency> create(Agency agency) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            entityM.persist(agency);
            transaction.commit();
            return Optional.of(agency);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Agency> findAgencyById(String agencynbr) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            String jpql = "SELECT e FROM Agency e WHERE e.code = :code";
            TypedQuery<Agency> query = entityM.createQuery(jpql, Agency.class);
            query.setParameter("code", agencynbr);

            Agency resultList = query.getSingleResult();
            transaction.commit();
            return Optional.ofNullable(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
