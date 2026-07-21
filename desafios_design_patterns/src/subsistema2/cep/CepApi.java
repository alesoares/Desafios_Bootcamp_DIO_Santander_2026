package subsistema2.cep;

public class CepApi {
    private static CepApi instancia = new CepApi();
    private CepApi() {}
    public static CepApi getInstancia() { return instancia; }
    
    // Simula a busca de cidade e estado com base no CEP informado
    public String recuperarCidade(String cep) { return "São Paulo"; }
    public String recuperarEstado(String cep) { return "SP"; }
}
