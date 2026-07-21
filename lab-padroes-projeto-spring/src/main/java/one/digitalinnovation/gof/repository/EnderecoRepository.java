package one.digitalinnovation.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import one.digitalinnovation.gof.model.Endereco;

@Repository // 🔌 Liga o motor automático de persistência no H2
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    // Código enxuto e herdado de fábrica pelo Spring Data JPA
}
