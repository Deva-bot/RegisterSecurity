package LoginAndRegisterProject.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import LoginAndRegisterProject.DtoLayer.RegisterDto;
import LoginAndRegisterProject.Model.RoleModel;
import LoginAndRegisterProject.Model.UserModel;
import LoginAndRegisterProject.Repository.RoleRepository;
import LoginAndRegisterProject.Repository.UserRepository;

@Service
public class RegisterService 
{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public String register(RegisterDto registerDto)
	{
		if(userRepository.existsByUserName(registerDto.getUserName()))
		{
			throw new UsernameNotFoundException("userName Alredy Exists....");
		}
		if(userRepository.existsByEmail(registerDto.getEmail()))
		{
			throw new UsernameNotFoundException("Email already Exists.....");
		}
		
		UserModel user = new UserModel();
		user.setName(registerDto.getName());
		user.setUserName(registerDto.getUserName());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setRole(registerDto.getRole());
		
		RoleModel roleModel = roleRepository.findByRoleName(user.getRole());
        if (roleModel == null) {
            // If the role doesn't exist, create a new one and save it
            roleModel = new RoleModel();
            roleModel.setRoleName(user.getRole());
            roleRepository.save(roleModel);
        }

        // Add the role to the user
        Set<RoleModel> roles = new HashSet<>();
        roles.add(roleModel);
        user.setRoles(roles);
        userRepository.save(user);
        
        return "Registration successful......";
        
    }
	
	
}
