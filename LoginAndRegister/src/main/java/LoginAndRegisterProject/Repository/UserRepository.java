package LoginAndRegisterProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import LoginAndRegisterProject.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long>
{
	Optional<UserModel> findByUserNameOrEmail(String userName,String email);
	Boolean existsByUserName(String userName);
	Boolean existsByEmail(String email);
}
