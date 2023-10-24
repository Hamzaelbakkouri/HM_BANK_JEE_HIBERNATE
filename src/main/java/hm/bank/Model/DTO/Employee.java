package hm.bank.Model.DTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employees")
public final class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String registrationNbr;

    private LocalDate recruitmentDate;

    private String email;

    public Employee(String firstName, String lastName, LocalDate birthDate, String phoneNumber, String registrationNbr,LocalDate recruitmentDate) {
        super(firstName, lastName, birthDate, phoneNumber);
        setRegistrationNbr(registrationNbr);
        setRecruitmentDate(recruitmentDate);
    }

}