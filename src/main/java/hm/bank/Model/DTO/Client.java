package hm.bank.Model.DTO;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public final class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String code;
    private String address;

    public Client(String firstname, String lastname, LocalDate date, String phoneNumber, String address, String Code) {
        super(firstname, lastname, date, phoneNumber);
        setAddress(address);
        setCode(Code);
    }
}