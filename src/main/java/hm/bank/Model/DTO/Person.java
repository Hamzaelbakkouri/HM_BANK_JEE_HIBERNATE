package hm.bank.Model.DTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @NonNull
    protected String firstName;
    @NonNull
    protected String lastName;
    @NonNull
    protected LocalDate birthDate;
    @NonNull
    protected String phoneNumber;

}

