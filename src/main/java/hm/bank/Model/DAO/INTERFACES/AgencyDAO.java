package hm.bank.Model.DAO.INTERFACES;

import hm.bank.Model.DTO.Agency;
import hm.bank.Model.DTO.Employee;

import java.util.Optional;

public interface AgencyDAO {
    Optional<Agency> create(Agency employee);

    Optional<Agency> findAgencyById(String agencynbr);
}
