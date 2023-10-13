package anderk222.hellojwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import anderk222.hellojwt.model.Usuario;
import anderk222.hellojwt.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    PasswordEncoder encoder; 

    @Autowired
    UsuarioRepository repository;

    public Usuario findByuserName(String name) {

        return repository.findByUserNameOrMail(name, name)
                .orElseThrow(() -> new RuntimeException("user not found"));

    }


    public Usuario register(Usuario user){

        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);


    }

}
