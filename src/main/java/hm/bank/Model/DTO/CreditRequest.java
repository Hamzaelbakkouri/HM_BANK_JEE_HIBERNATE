package hm.bank.Model.DTO;

import hm.bank.Model.DAO.INTERFACES.CreditState;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CreditRequest {

    private int nbr;
    private Agency agency;
    private Client client;
    private double amount;
    private int monthDuration;
    private double monthlyPayment;
    private LocalDate creationDate;
    private String notes;
    private CreditState state;
}
