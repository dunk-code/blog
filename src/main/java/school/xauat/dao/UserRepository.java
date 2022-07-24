package school.xauat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import school.xauat.po.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
