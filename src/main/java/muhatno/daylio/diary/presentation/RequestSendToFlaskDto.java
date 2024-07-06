package muhatno.daylio.diary.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestSendToFlaskDto {
    private String nickName;
    private String content;
    private String keyword;
    private List<String> moods;
}
