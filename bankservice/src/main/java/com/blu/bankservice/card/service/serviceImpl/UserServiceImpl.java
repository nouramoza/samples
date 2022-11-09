package com.blu.bankservice.card.service.serviceImpl;

import com.blu.bankservice.card.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s.equals("atm")){
            List<GrantedAuthority> authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority("admin"));
            User user = new User("atm", new BCryptPasswordEncoder().encode("atm"), authority);
            return user;
        } else {
            throw new UsernameNotFoundException("User with username = " + s + " Not Found");
        }
    }
}
