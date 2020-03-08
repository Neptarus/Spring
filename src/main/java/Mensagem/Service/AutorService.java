package Mensagem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Mensagem.entities.Autor;
import Mensagem.entities.ResponseModel;
import Mensagem.repository.AutorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/autores")
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;
	
	
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Autor autor) {
		try {
		this.autorRepository.save(autor);
		     return new ResponseModel(1, "Registro salvo com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update (@RequestBody Autor autor) {
		try {
		this.autorRepository.save(autor);
		     return new ResponseModel(1, "Registro atualizado com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseModel delete (@PathVariable("id") Long id) {
		try {
		this.autorRepository.deleteById(id);
		     return new ResponseModel(1, "Registro excluido com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@GetMapping
	public @ResponseBody List<Autor> findAll(){
		return this.autorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> findById (@PathVariable("id") Long id) {
	    Optional<Autor> autor = this.autorRepository.findById(id);
	    
	    if (autor == null) {
	    	return ResponseEntity.notFound().build();
	    }
	    else {
	    	return ResponseEntity.ok(autor.get());
	    }
	}

}
