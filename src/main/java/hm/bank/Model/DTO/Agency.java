package hm.bank.Model.DTO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agencies")
public final class Agency {
    @Id
    private String code;
    private String name;
    private String address;
    private String phoneNumber;
}

