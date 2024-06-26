package muhatno.daylio.food.domain;

import jakarta.persistence.*;
import lombok.*;
import muhatno.daylio.answer.domain.Answer;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(length = 20)
    private String name;



}
