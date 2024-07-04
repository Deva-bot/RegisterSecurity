package LoginAndRegisterProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LoginAndRegisterProject.Model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel,Long>
{
	RoleModel	findByRoleName(String roleName);
		
}
