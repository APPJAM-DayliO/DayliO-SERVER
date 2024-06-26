package muhatno.daylio.mood.domain;

import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.diary.domain.Diary;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Column(length = 10)
    private String expression;
}
