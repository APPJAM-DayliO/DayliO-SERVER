package muhatno.daylio.answer.domain;

import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.diary.domain.Diary;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Column(length = 40)
    private String content;
}
