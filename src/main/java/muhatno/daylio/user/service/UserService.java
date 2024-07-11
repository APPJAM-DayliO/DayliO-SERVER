package muhatno.daylio.user.service;

import lombok.RequiredArgsConstructor;
import muhatno.daylio.user.domain.User;
import muhatno.daylio.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(String nickName, Time alertTime) {
        User user = User.builder()
                .nickName(nickName)
                .alertTime(alertTime)
                .build();
        return userRepository.save(user);
    }
    public User getUserByNickName(String nickName) {
        return userRepository.findByNickName(nickName);
    }
}
