package anderk222.hellojwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.hellojwt.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByUserNameOrMail(String name, String mail);

}
