package net.alkemi.Challenge.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import net.alkemi.Challenge.Backend.entity.postB;
@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<postB, Integer> {

	List<postB> findByCategoriaOrderByFechadecreacionDesc(String categoria);
	
	List<postB> findByTituloOrderByFechadecreacionDesc(String titulo);
	
	List<postB> findByTituloAndCategoriaOrderByFechadecreacionDesc(String titulo ,String categoria);
	
}
