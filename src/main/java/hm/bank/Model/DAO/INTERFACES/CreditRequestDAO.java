package hm.bank.Model.DAO.INTERFACES;


import hm.bank.Model.DTO.CreditRequest;

import java.util.List;
import java.util.Optional;

public interface CreditRequestDAO extends DAO<CreditRequest, String> {
    Optional<CreditRequest> UpdateCredit(CreditRequest creditRequest);
    List<CreditRequest> getAllCreditRequest();
}
