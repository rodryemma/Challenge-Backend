package net.alkemi.Challenge.Backend.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.alkemi.Challenge.Backend.Security.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
}
