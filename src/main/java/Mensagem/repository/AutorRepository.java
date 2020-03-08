package Mensagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Mensagem.entities.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long> {

}
