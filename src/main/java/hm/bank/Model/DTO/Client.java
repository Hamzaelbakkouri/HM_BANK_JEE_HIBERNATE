package hm.bank.Model.DTO;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public final class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String code;

    private String address;

    public Client(String firstName, String lastName, LocalDate birthDate, String phoneNumber, String Code,String address) {
        super(firstName, lastName, birthDate, phoneNumber);
        setCode(Code);
        setAddress(address);
    }

}