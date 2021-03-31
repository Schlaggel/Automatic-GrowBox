package com.example.webApp.Servie;

import com.example.webApp.repository.UserRepository;
import com.example.webApp.util.User;
import com.example.webApp.util.UserSecur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceSecurity implements UserDetailsService {
   @Autowired
   private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserSecur(user);
    }
}
