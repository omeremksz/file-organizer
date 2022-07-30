package kalemyazilim.fileapp.fileorganizer.repository;

import kalemyazilim.fileapp.fileorganizer.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUserNameAndUserPassword(String userName, String userPassword);
    Optional<UserModel> findByUserName(String userName);
}
