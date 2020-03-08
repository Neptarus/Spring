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

import Mensagem.entities.Artigo;
import Mensagem.entities.ResponseModel;
import Mensagem.repository.ArtigoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/artigos")

public class ArtigoService {
	@Autowired
	private ArtigoRepository artigoRepository;
	
	
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Artigo artigo) {
		try {
		this.artigoRepository.save(artigo);
		     return new ResponseModel(1, "Registro salvo com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update (@RequestBody Artigo artigo) {
		try {
		this.artigoRepository.save(artigo);
		     return new ResponseModel(1, "Registro atualizado com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseModel delete (@PathVariable("id") Long id) {
		try {
		this.artigoRepository.deleteById(id);
		     return new ResponseModel(1, "Registro excluido com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@GetMapping
	public @ResponseBody List<Artigo> findAll(){
		return this.artigoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artigo> findById (@PathVariable("id") Long id) {
	    Optional<Artigo> artigo = this.artigoRepository.findById(id);
	    
	    if (artigo == null) {
	    	return ResponseEntity.notFound().build();
	    }
	    else {
	    	return ResponseEntity.ok(artigo.get());
	    }
	}

}
