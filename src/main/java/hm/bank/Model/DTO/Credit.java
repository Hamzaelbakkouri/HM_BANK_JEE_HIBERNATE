package hm.bank.Model.DTO;

import hm.bank.Model.DAO.INTERFACES.CreditStatut;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Credit {
    private int creditNum;

    private double creditBalance;

    private CreditStatut statut;

    private LocalDate CreationDate;

    private Client client;

    private Employee employee;
    private Agence agency;
    private String remarques;

//    durée
}
