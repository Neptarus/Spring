package Mensagem.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Mensagem.entities.Mensagem;
import Mensagem.entities.ResponseModel;
import Mensagem.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagens")
public class MensagemService {
	@Autowired
	private MensagemRepository mensagemrepository;
	
	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Mensagem mensagem) {
		try {
			this.mensagemrepository.save(mensagem);
			return new ResponseModel(1, "resgistro salvado com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Mensagem mensagem) {
		try {
			this.mensagemrepository.save(mensagem);
			return new ResponseModel(1, "resgistro atualizado com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@DeleteMapping("/(id)")
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id) {
		try {
			this.mensagemrepository.deleteById(id);
			return new ResponseModel(1, "resgistro excluido com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@GetMapping
	public @ResponseBody List<Mensagem> findAll(){
		return this.mensagemrepository.findAll();
	}
	
	@GetMapping("/(id)")
	public ResponseEntity<Mensagem> findById (@PathVariable("id") Long id){
		Optional<Mensagem> mensagem = this.mensagemrepository.findById(id);
		if(mensagem == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(mensagem.get());
		}
	}
}
