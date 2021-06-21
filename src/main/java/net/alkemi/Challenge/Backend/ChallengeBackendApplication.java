package net.alkemi.Challenge.Backend;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import net.alkemi.Challenge.Backend.entity.postB;

import net.alkemi.Challenge.Backend.repository.PostRepository;

@SpringBootApplication
public class ChallengeBackendApplication implements CommandLineRunner{

	
	
	@Autowired
	PostRepository postRepoM;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//cargarUsers();
		
		//cargarPostB();
		//mostrarpostBOrdenado();
		//mostraTitularOrdenado();
		//mostraTitularCategoriaOrdenado();
	}

	private void mostrarpostBOrdenado() {
		List<postB> lista = postRepoM.findByCategoriaOrderByFechadecreacionDesc("Music Video");
		for(postB b : lista) {
			System.out.println(b.getId());
		}
		
	
	}
	
	private void mostraTitularOrdenado() {
		List<postB> l = postRepoM.findByTituloOrderByFechadecreacionDesc("Emminem");
		for(postB pos : l) {
			System.out.println(pos.getId());
		}
		
	}
	
	private void mostraTitularCategoriaOrdenado() {
		List<postB> lco = postRepoM.findByTituloAndCategoriaOrderByFechadecreacionDesc("Emminem","Music Video") ;
		for(postB pos : lco) {
			System.out.println(pos.getId());
		}
		
		}
	
	}
	
	

