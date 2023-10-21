package hm.bank.Model.DAO.IMPLEMANTATION;

import hm.bank.Model.DAO.INTERFACES.EmployeeDAO;
import hm.bank.Model.DTO.Employee;
import hm.bank.Utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class EmployeeIMPL implements EmployeeDAO {

    private final EntityManager entityM;

    public EmployeeIMPL() {
        entityM = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public EmployeeIMPL(EntityManager eM) {
        this.entityM = eM;
    }
    @Override
    @Transactional
    public Optional<Employee> create(Employee employee) {

        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            entityM.persist(employee);
            transaction.commit();
            return Optional.of(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Employee> findEmployeeById(String registrationNum) {
        EntityTransaction transaction = entityM.getTransaction();
        try {
            transaction.begin();
            String jpql = "SELECT e FROM Employee e WHERE e.registrationNbr = :registrationNum";
            TypedQuery<Employee> query = entityM.createQuery(jpql, Employee.class);
            query.setParameter("registrationNum", registrationNum);

            Employee resultList = query.getSingleResult();
            transaction.commit();

            return Optional.ofNullable(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
