package muhatno.daylio.answer.service;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.answer.domain.Answer;
import muhatno.daylio.answer.domain.AnswerRepository;
import muhatno.daylio.answer.presentation.AnswerCreateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional
    public Answer saveAnswer(AnswerCreateRequestDto requestDto) {
        Answer answer = new Answer();
        answer.setContent(requestDto.getContent());
        return answerRepository.save(answer);
    }
}
