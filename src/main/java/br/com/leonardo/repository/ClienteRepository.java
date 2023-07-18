package br.com.leonardo.repository;

import br.com.leonardo.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * nunca esqueça da anotação REPOSITORY para que o spring cuide da porra toda
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
