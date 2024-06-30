package muhatno.daylio.user.presentation;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.user.domain.User;
import muhatno.daylio.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestParam String nickName, @RequestParam String alertTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Time time = Time.valueOf(LocalTime.parse(alertTime, formatter));
        User user = userService.saveUser(nickName, time);
        return ResponseEntity.ok(user);
    }
}
