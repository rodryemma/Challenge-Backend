package net.alkemi.Challenge.Backend.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.alkemi.Challenge.Backend.Service.IPostService;
import net.alkemi.Challenge.Backend.entity.postB;
import net.alkemi.Challenge.Backend.repository.PostRepository;

@RestController
@CrossOrigin
public class PostBlog {
	
	@Autowired
	IPostService iPoSer;
	@Autowired
	PostRepository postRepo;
	
	
	@GetMapping("/posts")
	public List<postB> postsTitle(@RequestParam (value="title", required = false, defaultValue = "") String titulo,@RequestParam (value="category", required = false, defaultValue = "") String categoria){
		if(titulo.equals("") && !(categoria.equals(""))) {
			List<postB> listaOr = postRepo.findByCategoriaOrderByFechadecreacionDesc(categoria);
			return  listaOr;
		}
		
		if( !(titulo.equals("")) && (categoria.equals(""))) {
			List<postB> listaO = postRepo.findByTituloOrderByFechadecreacionDesc(titulo);
			return  listaO;
		}
		if(!(titulo.equals("")) && (!(categoria.equals("")))) {
			List<postB> listaOr = postRepo.findByTituloAndCategoriaOrderByFechadecreacionDesc(titulo,categoria);
			return  listaOr;
		}
		return null;
	}
	
	
	
	/*@GetMapping("/posts")
	public List<postB> postsCategory(@RequestParam (value="category") String categoria){
		List<postB> listaOr = postRepo.findByCategoriaOrderByFechadecreacionDesc(categoria);
		return  listaOr;
	}*/
	
	
	
	//buscar posts por ID
	@GetMapping("/posts/{id}")
	public ResponseEntity<Object> postsId(@PathVariable("id")Integer pos) {
		if( iPoSer.buscarPorId(pos)== null){
		return new ResponseEntity<Object>("Ingreso un id no existente",HttpStatus.EXPECTATION_FAILED);	
		}else {
		return  new ResponseEntity<Object>(iPoSer.buscarPorId(pos),HttpStatus.OK);
		}
	}
	
	/*@GetMapping("/posts/{id}")
	public postB postsId(@PathVariable("id")Integer pos) {
		iPoSer.buscarPorId(pos).getContenido();
		return iPoSer.buscarPorId(pos);
		
	}*/
	
	
	//Crear posts
	@PostMapping("/posts")
	public postB guardarPost(@RequestBody postB post) {
		iPoSer.guardar(post);
		return post;
	}
	
	//Actualizar posts
	@PatchMapping("/posts/{id}")
	public ResponseEntity<Object> modificarPost(@RequestBody postB post,@PathVariable("id") Integer id) {
		if(iPoSer.buscarPorId(id)== null) {
			return ResponseEntity.ok("Error");
		}
		else
		iPoSer.modificar(post, id);
		return new ResponseEntity<Object>(post,HttpStatus.OK);
	}
	
	//Eliminar posts
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<?> eliminarPost(@PathVariable("id") Integer id){
		if(iPoSer.buscarPorId(id)== null) {
			return ResponseEntity.ok("Error, no existe");
		}
		else
			iPoSer.eliminar(id);
		return ResponseEntity.ok("Eliminado");
	}
	
	
}
