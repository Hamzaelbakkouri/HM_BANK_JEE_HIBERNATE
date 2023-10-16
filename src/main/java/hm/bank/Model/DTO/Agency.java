package hm.bank.Model.DTO;
import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Agency {
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String adresse;
    @NonNull
    private String phoneNumber;

    List<CreditRequest> credits;
}

