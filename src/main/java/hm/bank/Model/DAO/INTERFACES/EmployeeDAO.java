package hm.bank.Model.DAO.INTERFACES;

import hm.bank.Model.DTO.Employee;

import java.util.Optional;

public interface EmployeeDAO {
    Optional<Employee> create(Employee employee);

    Optional<Employee> findEmployeeById(String registrationNum);
}
