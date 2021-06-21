package net.alkemi.Challenge.Backend.Service;

import java.util.List;

import net.alkemi.Challenge.Backend.entity.postB;

public interface IPostService {

	void guardar(postB postB);
	void modificar(postB postB, Integer i);
	List<postB> BuscarTodas();
	postB buscarPorId(Integer id);
	void eliminar (Integer id);
	
	
}
