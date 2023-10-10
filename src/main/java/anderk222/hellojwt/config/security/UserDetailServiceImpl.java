package anderk222.hellojwt.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import anderk222.hellojwt.model.User;
import anderk222.hellojwt.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository
                .findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        System.out.println(user);

        return new UserDetailsImpl(user);

    }

}
