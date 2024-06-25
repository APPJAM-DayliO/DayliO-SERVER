package muhatno.daylio.diary.domain;

import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.user.domain.User;
import muhatno.daylio.weekly.domain.Weekly;
import org.w3c.dom.Text;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "weekly_id")
    private Weekly weekly;

    @Column(length = 500)
    private String content;

    private String keyword;

    private Timestamp date;
}
