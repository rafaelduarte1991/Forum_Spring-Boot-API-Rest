package com.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.forum.config.security.TokenService;
import com.forum.controller.dto.TokenDto;
import com.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
@Profile(value = {"prod", "test"})
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form){ 
		
		UsernamePasswordAuthenticationToken loginData = form.convert();
		
		try {
			Authentication authentication = authenticationManager.authenticate(loginData);
			String token = tokenService.generateToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer")); 
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}		
	}
}
