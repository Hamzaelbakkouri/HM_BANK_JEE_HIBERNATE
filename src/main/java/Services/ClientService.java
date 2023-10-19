package Services;


import hm.bank.Model.DAO.IMPLEMANTATION.ClientIMPL;
import hm.bank.Model.DAO.INTERFACES.ClientDAO;
import hm.bank.Model.DTO.Client;

import java.util.Optional;

public class ClientService {
    ClientDAO clientDAO;

    public ClientService() {
        clientDAO = new ClientIMPL();
    }

    public Client createClient(Client client) {
        Client client1 = null;
        try {
            Optional<Client> newClient = this.clientDAO.insert(client);
            if (newClient.isPresent()) {
                client1 = newClient.get();
            } else {
                System.out.println("Client insertion rejected");
            }
        } catch (Exception e) {
            new Exception("Client insertion rejected");
        }
        return client1;
    }

    public Client getClientByCode(String code) {
        Client client1 = null;
        try {
            Optional<Client> newClient = this.clientDAO.getOne(code);
            if (newClient.isPresent()) {
                client1 = newClient.get();
            } else {
                System.out.println("Client not found");
            }
        } catch (Exception e) {
            new Exception("Client not found");
        }
        return client1;
    }


}
