package hm.bank.Model.DTO;

import hm.bank.Model.DAO.INTERFACES.CreditState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public final class CreditRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nbr;

    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "agency_code")
    private Agency agency;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_code")
    private Client client;


    @NonNull
    private double amount;
    @NonNull
    private int monthDuration;
    @NonNull
    private double monthlyPayment;
    @NonNull
    private LocalDate creationDate;
    @NonNull
    private String notes;

    @NonNull
    @Enumerated(EnumType.STRING)
    private CreditState state;
}
