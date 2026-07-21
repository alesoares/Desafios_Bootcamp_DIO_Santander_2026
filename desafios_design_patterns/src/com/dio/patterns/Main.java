package com.dio.patterns;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ Instancia os elos da corrente de segurança
        Validador validadorValor = new ValidadorValor();
        Validador validadorLimite = new ValidadorLimiteAdmin();

        // 2️⃣ Conecta os cabos: O validador de valor passa o bastão para o de limite
        validadorValor.setProximo(validadorLimite);

        System.out.println("=== 🏦 INICIANDO SIMULAÇÃO DA ESTEIRA DE TRANSAÇÕES ===\n");

        // 🧪 Cenário 1: Valor Inválido (Deve ser barrado no primeiro elo)
        System.out.println("👉 Testando transação com valor negativo:");
        validadorValor.validar(-50, "user");
        System.out.println("-------------------------------------------------");

        // 🧪 Cenário 2: Usuário comum tentando valor alto (Deve ser barrado no segundo elo)
        System.out.println("👉 Testando usuário comum com valor acima do limite:");
        validadorValor.validar(7500, "user");
        System.out.println("-------------------------------------------------");

        // 🧪 Cenário 3: Administrador liberando valor alto (Sucesso Absoluto!)
        System.out.println("👉 Testando administrador com valor acima do limite:");
        validadorValor.validar(7500, "admin");
        System.out.println("-------------------------------------------------");

        // 🧪 Cenário 4: Usuário comum dentro do limite padrão (Sucesso Absoluto!)
        System.out.println("👉 Testando usuário comum dentro do limite permitido:");
        validadorValor.validar(1500, "user");
        System.out.println("=================================================");
    }
}
