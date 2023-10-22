package hm.bank.Model.DAO.INTERFACES;


import hm.bank.Model.DTO.CreditRequest;
import hm.bank.Model.DTO.CreditRequestState;

import java.util.List;
import java.util.Optional;

public interface CreditRequestDAO extends DAO<CreditRequest, String> {
    Optional<CreditRequest> UpdateCredit(CreditRequest creditRequest);
    List<CreditRequest> getAllCreditRequests();

    void updateCreditRequestState(String entityId, CreditState creditState);

    List<CreditRequestState> getCreditRequestState(String nbr);


}
