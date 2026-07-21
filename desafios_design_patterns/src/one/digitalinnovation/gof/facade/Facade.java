package one.digitalinnovation.gof.facade;

import subsistema1.crm.CrmService;
import subsistema2.cep.CepApi;

// 🚀 DESIGN PATTERN: Facade (Fachada)
// Fornece uma interface unificada para simplificar o acesso aos subsistemas de CEP e CRM.
public class Facade {
    public void migrarCliente(String nome, String cep) {
        // Recupera os dados de endereço consultando a API de CEP externa
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);
        
        // Alimenta o sistema de CRM com as informações completas mastigadas
        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
