package Services;


import hm.bank.Model.DAO.IMPLEMANTATION.ClientIMPL;
import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DTO.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class ClientService {
    @Inject
    private ClientDAO clientDAO;

    public ClientService() {
        clientDAO = new ClientIMPL();
    }

    public void createClient(Client client) throws Exception {
        if (client == null) {
            throw new Exception("Client cannot be null");
        } else {
            clientDAO.insert(client).get();
        }
    }

    public Client getClientByCode(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Client code cannot be empty or less than zero");
        } else {
            return clientDAO.getOne(code).orElse(null);
        }
    }


}
