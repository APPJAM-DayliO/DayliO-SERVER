package muhatno.daylio.diary.presentation;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.diary.domain.Diary;
import muhatno.daylio.diary.service.DiaryService;
import muhatno.daylio.diary.service.FlaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final FlaskService flaskService;

    @PostMapping("/create")
    public ResponseEntity<Diary> createDiary(@RequestParam String nickName,
                                             @RequestParam String content,
                                             @RequestParam String keyword,
                                             @RequestParam List<String> moods) {
        Diary diary = diaryService.saveDiary(nickName, content, keyword, moods);

        // Prepare DTO for Flask service
        RequestSendToFlaskDto dto = RequestSendToFlaskDto.builder()
                .nickName(nickName)
                .content(content)
                .keyword(keyword)
                .moods(moods)
                .build();

        // Send data to Flask server
        try {
            String responseFromFlask = flaskService.sendToFlask(dto);
            // Optionally process the response from Flask if needed
        } catch (Exception e) {
            // Handle exception if Flask communication fails
            e.printStackTrace();
        }

        return ResponseEntity.ok(diary);
    }
}
