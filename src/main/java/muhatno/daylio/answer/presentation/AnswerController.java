package muhatno.daylio.answer.presentation;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.answer.domain.Answer;
import muhatno.daylio.answer.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/create")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerCreateRequestDto requestDto) {
        Answer answer = answerService.saveAnswer(requestDto);
        return ResponseEntity.ok(answer);
    }
}
