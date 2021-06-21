package net.alkemi.Challenge.Backend.Service.MySql;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.alkemi.Challenge.Backend.Service.IPostService;
import net.alkemi.Challenge.Backend.entity.postB;
import net.alkemi.Challenge.Backend.repository.PostRepository;
@Service
public class PostBServiceMySql implements IPostService {

	@Autowired
	PostRepository posRepo;
	
	@Override
	public void guardar(postB postB) {
		posRepo.save(postB);

	}

	@Override
	public List<postB> BuscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public postB buscarPorId(Integer id) {
		 Optional<postB> postBOptional = posRepo.findById(id);
		if(postBOptional.isPresent()) {
			return postBOptional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		posRepo.deleteById(id);

	}

	@Override
	public void modificar(postB postB, Integer i) {
		postB.setId(i);
		posRepo.save(postB);
		
	}

	

}
