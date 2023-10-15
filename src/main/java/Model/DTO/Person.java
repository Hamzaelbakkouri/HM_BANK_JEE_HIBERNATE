package Model.DTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    protected String firstName;
    @NonNull
    protected String lastName;
    @NonNull
    protected LocalDate birthDate;
    @NonNull
    protected String phoneNumber;

}

