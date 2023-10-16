package hm.bank.Model.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public final class Employee extends Person {
    @Id
    private int id;
    private String registrationNbr;
    private LocalDate recruitmentDate;
    private String email;

    public Employee(String firstname, String lastname, LocalDate dateOfbirth, String phonenumber, String registrationnumber, LocalDate recruitmentdate, String Email) {
        super(firstname, lastname, dateOfbirth, phonenumber);
        setEmail(Email);
        setRecruitmentDate(recruitmentdate);
        setRegistrationNbr(registrationnumber);
    }
}
