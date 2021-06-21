package net.alkemi.Challenge.Backend.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.alkemi.Challenge.Backend.Security.Entity.Rol;
import net.alkemi.Challenge.Backend.Security.Enum.RolNombre;
import net.alkemi.Challenge.Backend.Security.Repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
		
	}
}
