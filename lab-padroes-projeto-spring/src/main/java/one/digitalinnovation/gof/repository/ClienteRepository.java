package one.digitalinnovation.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import one.digitalinnovation.gof.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    // 📊 O DIFERENCIAL SAN SOARES: Método customizado padrão para auditoria em tempo real
    default Cliente salvarComAuditoria(Cliente cliente) {
        org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ClienteRepository.class);
        java.time.LocalDateTime agora = java.time.LocalDateTime.now();
        
        if (cliente.getId() == null) {
            log.info("🧱 [AUDITORIA-H2] - Horário: {} | AÇÃO: INSERÇÃO | Novo Cliente: '{}' | CEP: '{}' | Status: SUCESSO", 
                    agora, cliente.getNome(), cliente.getEndereco().getCep());
        } else {
            log.info("🧱 [AUDITORIA-H2] - Horário: {} | AÇÃO: ATUALIZAÇÃO | Cliente ID: {} | Novo Nome: '{}' | Status: SUCESSO", 
                    agora, cliente.getId(), cliente.getNome());
        }
        
        return this.save(cliente);
    }
}
