package LoginAndRegisterProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LoginAndRegisterProject.DtoLayer.RegisterDto;
import LoginAndRegisterProject.Service.RegisterService;

@RestController
@RequestMapping("/api/auth")
public class RegisterController 
{
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value= {"/signup","/register"})
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto)
	{
//		String userReigster = registerService.register(registerDto);
//		return new ResponseEntity<>(userReigster,HttpStatus.CREATED);
		try 
		{
	        String message = registerService.register(registerDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(message);
	    } 
		catch (UsernameNotFoundException ex) 
		{
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	    }
	}
} 
