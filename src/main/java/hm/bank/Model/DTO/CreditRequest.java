package hm.bank.Model.DTO;

import hm.bank.Model.DAO.INTERFACES.CreditState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "creditrequests")
public final class CreditRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nbr;

    @ManyToOne
    @JoinColumn(name = "agency_code")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "client_code")
    private Client client;

    private double amount;
    private int monthDuration;
    private double monthlyPayment;
    private LocalDate creationDate;
    private String notes;

    @Enumerated(EnumType.STRING)
    private CreditState state;
}
