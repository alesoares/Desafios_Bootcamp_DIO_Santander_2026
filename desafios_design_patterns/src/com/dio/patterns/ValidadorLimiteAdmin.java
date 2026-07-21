package com.dio.patterns;

// 🛑 ELO 2: Validação de Limite por Perfil
public class ValidadorLimiteAdmin extends Validador {

    @Override
    public void validar(int valor, String usuario) {
        if (valor > 5000 && !usuario.equalsIgnoreCase("admin")) {
            System.out.println("❌ [CADEIA DE REJEIÇÃO] - Operação cancelada: Usuário '" + usuario + "' não tem limite para valores acima de 5000.");
            return; // Corta a execução da corrente aqui!
        }
        
        // Se passou pela barreira, o fluxo segue
        if (proximo != null) {
            proximo.validar(valor, usuario);
        } else {
            // Fim da linha: Sucesso absoluto!
            System.out.println("✅ [CADEIA DE SUCESSO] - Transação de R$ " + valor + " autorizada para o usuário '" + usuario + "'.");
        }
    }
}
