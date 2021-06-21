package net.alkemi.Challenge.Backend.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.alkemi.Challenge.Backend.Security.Entity.Rol;
import net.alkemi.Challenge.Backend.Security.Enum.RolNombre;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
