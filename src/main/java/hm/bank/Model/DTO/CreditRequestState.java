package hm.bank.Model.DTO;

import hm.bank.Model.DAO.INTERFACES.CreditState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "statehistory")
@Entity
public final class CreditRequestState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nbr;

    @ManyToOne
    @JoinColumn(name = "credit_request_nbr")
    private CreditRequest creditRequest;

    @Enumerated(EnumType.STRING)
    private CreditState state;

    private LocalDateTime creationDate;

}
