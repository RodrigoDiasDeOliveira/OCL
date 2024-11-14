import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class RfidTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tagId;

    @NotNull
    private String productName;

    @NotNull
    private String location;

    private LocalDateTime lastScanned;

    // Getter e Setter

    public long getTimeSinceLastScan() {
        if (lastScanned == null) return -1;
        return ChronoUnit.MINUTES.between(lastScanned, LocalDateTime.now());
    }
}
