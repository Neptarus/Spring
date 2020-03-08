package Mensagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Mensagem.entities.Leitor;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {

}