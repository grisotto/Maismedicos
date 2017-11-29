/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos;

import mais.medicos.domain.Usuario;

import java.util.ArrayList;
import java.util.Collection;

import mais.medicos.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyeimys
 */
@Service
public class SecurityUserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserService.class);

    @Autowired
    private UsuarioRepository userRepository;

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info(String.format("Find user %s!", username));
        Usuario user = userRepository.userForAuth(username);
        LOGGER.info(String.format("Role:  %s!", user.getTipoUsuario()));

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        return new RepositoryUserDetails(user);
    }

    private final static class RepositoryUserDetails extends Usuario implements UserDetails {

        public RepositoryUserDetails(Usuario user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            ArrayList<TipoUsuario> arrayList = new ArrayList<>();
            arrayList.add(getTipoUsuario());
            LOGGER.info(String.format("getAuthorities %s!", arrayList.toArray()));
            return arrayList;
        }

        @Override
        public String getUsername() {
            return getLogin();
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

        @Override
        public String getPassword() {
            return getSenha();
        }

    }
}
