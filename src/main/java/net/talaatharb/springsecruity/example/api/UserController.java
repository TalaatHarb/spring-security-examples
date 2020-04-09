package net.talaatharb.springsecruity.example.api;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

	@GetMapping(path = "/user")
	public Principal userGet(final Principal user) {
		return user;
	}

	@PostMapping(path = "/user")
	public UserDetails userPost(final String name) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(name);
		System.out.println(userDetails);
		return userDetails;
	}
}
