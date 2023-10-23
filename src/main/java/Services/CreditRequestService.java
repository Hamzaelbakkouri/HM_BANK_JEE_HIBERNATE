package Services;


import hm.bank.Model.DAO.IMPLEMANTATION.CreditRequestIMPL;
import hm.bank.Model.DAO.INTERFACES.CreditRequestDAO;
import hm.bank.Model.DAO.INTERFACES.CreditState;
import hm.bank.Model.DTO.CreditRequest;
import hm.bank.Model.DTO.CreditRequestState;

import java.util.List;
import java.util.Optional;

public class CreditRequestService {

    CreditRequestDAO instanceCreditdao;

    public CreditRequestService() {
        this.instanceCreditdao = new CreditRequestIMPL();
    }

    public CreditRequest CreateCreditRequest(CreditRequest creditRequest) {
        Optional<CreditRequest> newCredit = Optional.empty();
        try {
            newCredit = this.instanceCreditdao.insert(creditRequest);
            if (newCredit.isPresent()) {
                return newCredit.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CreditRequest> getAllCreditRequests()
    {
        return this.instanceCreditdao.getAllCreditRequests();

    }

    public void acceptCreditRequest(String entityId)
    {
        this.instanceCreditdao.updateCreditRequestState(entityId,CreditState.Accepted);

    }

    public void refuseCreditRequest(String entityId)
    {
        this.instanceCreditdao.updateCreditRequestState(entityId,CreditState.Refused);

    }

    public List<CreditRequestState> getCreditRequestHistory(String nbr)
    {
        return this.instanceCreditdao.getCreditRequestState(nbr);
    }

}
