package pl.portfolio.piohouse.auth.registration.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {
    Optional<User> findUserByUsername(String username);
}
