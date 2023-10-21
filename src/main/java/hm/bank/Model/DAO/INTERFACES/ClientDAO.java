package hm.bank.Model.DAO.INTERFACES;

import hm.bank.Model.DTO.Client;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface ClientDAO extends DAO<Client, String> {
    @Transactional
    Optional<Client> update(Client client);
}
