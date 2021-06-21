package net.alkemi.Challenge.Backend.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.alkemi.Challenge.Backend.Security.Entity.Usuario;
import net.alkemi.Challenge.Backend.Security.Entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario =usuarioService.getByNombreUsuario(nombreUsuario).get();
		return UsuarioPrincipal.build(usuario);
	}

	
}
