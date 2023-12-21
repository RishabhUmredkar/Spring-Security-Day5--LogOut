package com.example.demo.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Implement.UserDetailsImpliments;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUname(username);	
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		
		return new UserDetailsImpliments(user);
	}

}
