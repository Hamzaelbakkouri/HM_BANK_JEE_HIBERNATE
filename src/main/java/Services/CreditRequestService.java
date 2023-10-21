package Services;


import hm.bank.Model.DAO.IMPLEMANTATION.CreditRequestIMPL;
import hm.bank.Model.DAO.INTERFACES.CreditRequestDAO;
import hm.bank.Model.DTO.CreditRequest;

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
}
