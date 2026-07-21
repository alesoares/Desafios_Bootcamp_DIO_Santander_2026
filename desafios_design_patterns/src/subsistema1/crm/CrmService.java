package subsistema1.crm;

public class CrmService {
    private CrmService() {}
    public static void gravarCliente(String nome, String cep, String cidade, String estado) {
        System.out.println("💾 [CRM] Cliente salvo com sucesso no banco de dados!");
        System.out.println("👉 Nome: " + nome + " | CEP: " + cep + " | Cidade: " + cidade + " / " + estado);
    }
}
