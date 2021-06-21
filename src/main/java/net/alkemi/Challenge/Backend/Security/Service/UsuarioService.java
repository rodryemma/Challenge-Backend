package net.alkemi.Challenge.Backend.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.alkemi.Challenge.Backend.Security.Entity.Usuario;
import net.alkemi.Challenge.Backend.Security.Repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return  usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
