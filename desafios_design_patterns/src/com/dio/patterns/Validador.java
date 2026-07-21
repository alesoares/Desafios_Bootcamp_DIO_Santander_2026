package com.dio.patterns;

//🚀 DESIGN PATTERN: Chain of Responsibility (Cadeia de Responsabilidade)
//Esta classe abstrata define o contrato para o próximo elo da corrente.
public abstract class Validador {
 
 protected Validador proximo;

 // Conecta o próximo filtro da esteira bancária
 public void setProximo(Validador proximo) {
     this.proximo = proximo;
 }

 // Método abstrato que cada filtro vai implementar com sua própria regra
 public abstract void validar(int valor, String usuario);
}
