package anderk222.hellojwt.config.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import anderk222.hellojwt.model.Usuario;
import io.jsonwebtoken.lang.Collections;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Usuario user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {

        return this.user.getPassword();

    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public java.util.Map<String, ?> claims(){

        return Map.of(
            "id" , user.getId(),
            "subject", user.getUserName(), 
            "email", user.getMail(),
            "saludo", "Holaaaa"
            );

    }

}
