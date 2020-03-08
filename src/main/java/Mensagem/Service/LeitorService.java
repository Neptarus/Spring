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
import Mensagem.entities.Leitor;
import Mensagem.entities.ResponseModel;
import Mensagem.repository.LeitorRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leitores")

public class LeitorService {
	@Autowired
	private LeitorRepository leitorRepository;
	
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Leitor leitor) {
		try {
		this.leitorRepository.save(leitor);
		     return new ResponseModel(1, "Registro salvo com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update (@RequestBody Leitor leitor) {
		try {
		this.leitorRepository.save(leitor);
		     return new ResponseModel(1, "Registro atualizado com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseModel delete (@PathVariable("id") Long id) {
		try {
		this.leitorRepository.deleteById(id);
		     return new ResponseModel(1, "Registro excluido com sucesso");
		}
		catch(Exception e) {
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	@GetMapping
	public @ResponseBody List<Leitor> findAll(){
		return this.leitorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Leitor> findById (@PathVariable("id") Long id) {
	    Optional<Leitor> leitor = this.leitorRepository.findById(id);
	    
	    if (leitor == null) {
	    	return ResponseEntity.notFound().build();
	    }
	    else {
	    	return ResponseEntity.ok(leitor.get());
	    }
	}
	
}
