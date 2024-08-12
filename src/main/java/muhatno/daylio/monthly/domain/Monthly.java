package muhatno.daylio.monthly.domain;

import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.user.domain.User;
import org.w3c.dom.Text;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Monthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 500)
    private String content;

    private int month;


}
