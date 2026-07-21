package one.digitalinnovation.gof.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // 📊 Transforma a classe em uma tabela física no H2
public class Cliente {

    @Id // 🔑 Chave primária com auto-incremento automático
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne // 🔌 RELACIONAMENTO: Muitos clientes podem morar no mesmo endereço/CEP
    private Endereco endereco;

    // Getters e Setters obrigatórios
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}

