package muhatno.daylio.user.domain.repository;

import muhatno.daylio.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNickName(String nickName);
}