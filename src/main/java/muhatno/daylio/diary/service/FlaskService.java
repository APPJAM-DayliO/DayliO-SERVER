package muhatno.daylio.diary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import muhatno.daylio.diary.presentation.RequestSendToFlaskDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FlaskService {

    private final ObjectMapper objectMapper;

    @Transactional
    public String sendToFlask(RequestSendToFlaskDto dto) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // DTO 객체를 JSON 문자열로 변환
        String jsonDto = objectMapper.writeValueAsString(dto);

        // HTTP 요청에 담을 HttpEntity 생성
        HttpEntity<String> entity = new HttpEntity<>(jsonDto, headers);

        // Flask 서버로 요청을 보낼 URL
        String url = "http://127.0.0.1:8082/receive_string";

        // POST 요청을 보내고, 받은 응답을 String으로 반환
        return restTemplate.postForObject(url, entity, String.class);
    }
}
