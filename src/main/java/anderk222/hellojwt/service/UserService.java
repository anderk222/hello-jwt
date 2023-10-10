package anderk222.hellojwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import anderk222.hellojwt.model.User;
import anderk222.hellojwt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder; 

    @Autowired
    UserRepository repository;

    public User findByuserName(String name) {

        return repository.findByUserName(name)
                .orElseThrow(() -> new RuntimeException("user not found"));

    }


    public User register(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);


    }

}
