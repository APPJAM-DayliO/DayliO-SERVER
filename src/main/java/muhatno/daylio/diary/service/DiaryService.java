package muhatno.daylio.diary.service;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.diary.domain.Diary;
import muhatno.daylio.diary.domain.DiaryRepository;
import muhatno.daylio.mood.domain.Mood;
import muhatno.daylio.mood.domain.MoodRepository;
import muhatno.daylio.user.domain.User;
import muhatno.daylio.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final MoodRepository moodRepository;
    private final UserService userService;


    public Diary saveDiary(String nickName, String content, String keyword, List<String> moods) {
        User user = userService.getUserByNickName(nickName);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Diary diary = Diary.builder()
                .user(user)
                .content(content)
                .keyword(keyword)
                .date(new Timestamp(System.currentTimeMillis()))
                .build();
        diaryRepository.save(diary);

        for (String mood : moods) {
            Mood moodEntity = Mood.builder()
                    .diary(diary)
                    .expression(mood)
                    .build();
            moodRepository.save(moodEntity);
        }

        return diary;
    }
}
