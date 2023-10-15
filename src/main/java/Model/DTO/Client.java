package Model.DTO;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public final class Client extends Person {
    private String code;
    private String address;


    public Client(String firstname, String lastname, LocalDate date, String phoneNumber, String address, String Code) {
        super(firstname, lastname, date, phoneNumber);
//        setFirstName(firstname);
//        setLastName(lastname);
//        setBirthDate(date);
//        setPhoneNumber(phoneNumber);
        setAddress(address);
        setCode(Code);
    }

}