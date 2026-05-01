package com.restapi.SmartContactManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.restapi.SmartContactManager.dao.UserRepository;
import com.restapi.SmartContactManager.entities.User;

@Service   // ⚠️ IMPORTANT (warna bean create nahi hoga)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // fetch user from database
        User user = userRepository.getUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("could not found user !!");
        }

        return new CustomUserDetails(user);  // ✔ correct
    }
}