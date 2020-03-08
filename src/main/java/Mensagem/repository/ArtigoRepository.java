package Mensagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Mensagem.entities.Artigo;


public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

}
