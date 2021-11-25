package com.arsal.security.app.restaurantapp.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantDetailService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    public RestaurantDetailService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find UserName : " + userName);
        }

        List<AuthGroup> authGroupList = authGroupRepository.findByUserName(userName);
        return new RestaurantUserPrincipal(user,authGroupList);
    }
}
