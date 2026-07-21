package com.dio.patterns;

// 🛑 ELO 1: Validação de Valor Mínimo
public class ValidadorValor extends Validador {

    @Override
    public void validar(int valor, String usuario) {
        if (valor <= 0) {
            System.out.println("❌ [CADEIA DE REJEIÇÃO] - Operação cancelada: Valor inválido (" + valor + ").");
            return; // Corta a execução da corrente aqui!
        }
        
        // Se o valor for correto, repassa para o próximo elo se ele existir
        if (proximo != null) {
            proximo.validar(valor, usuario);
        }
    }
}
