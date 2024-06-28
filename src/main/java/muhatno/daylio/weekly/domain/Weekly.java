package muhatno.daylio.weekly.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.monthly.domain.Monthly;
import muhatno.daylio.user.domain.User;
import org.w3c.dom.Text;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Weekly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "monthly_id")
    private Monthly monthly;

    @Column(length = 500)
    private String content;

    private int week;
}
