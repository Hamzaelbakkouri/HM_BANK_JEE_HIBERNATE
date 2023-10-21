package hm.bank.Model.DTO;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agencies")
public final class Agency {
    @Id
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;
    @OneToMany(mappedBy = "agency")
    List<CreditRequest> credits;
}

