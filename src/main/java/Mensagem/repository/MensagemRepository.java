package Mensagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Mensagem.entities.Mensagem;


public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
