package Mensagem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Leitor {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name= "increment", strategy = "increment")
	    private Long id;
	    
	    @Size (max=100)
	    private String nome;
	    
	    @Size (max=150)
	    private String sobrenome;

		private String Login;
		
		private String Senha;
		
		private String Cidade;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}

		public String getLogin() {
			return Login;
		}

		public void setLogin(String login) {
			Login = login;
		}

		public String getSenha() {
			return Senha;
		}

		public void setSenha(String senha) {
			Senha = senha;
		}

		public String getCidade() {
			return Cidade;
		}

		public void setCidade(String cidade) {
			Cidade = cidade;
		}
}
