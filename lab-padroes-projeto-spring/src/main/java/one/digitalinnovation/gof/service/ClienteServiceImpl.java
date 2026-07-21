package one.digitalinnovation.gof.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;

@Service // 🧠 Informa ao Spring que este componente gerencia a lógica de negócio do sistema
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    // 🔒 MÉTODO PRIVADO AUXILIAR (A Fachada): Trata o CEP e persiste com auditoria
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        
        // Verifica se o endereço já existe no banco H2 para não duplicar dados desnecessários
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Se não existir localmente, bate no OpenFeign e puxa do ViaCEP real!
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        
        cliente.setEndereco(endereco);
        // 🎉 Aciona o nosso diferencial de auditoria customizada na tabela de clientes
        clienteRepository.salvarComAuditoria(cliente);
    }
}
