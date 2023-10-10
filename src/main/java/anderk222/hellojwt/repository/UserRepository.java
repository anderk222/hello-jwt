package anderk222.hellojwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.hellojwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUserName(String name);

}
