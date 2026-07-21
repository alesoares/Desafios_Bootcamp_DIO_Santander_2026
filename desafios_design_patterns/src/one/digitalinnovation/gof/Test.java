
package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;

public class Test {
    public static void main(String[] args) {
        
        // 🧪 1. TESTANDO O PADRÃO DESIGN PATTERN: SINGLETON
        System.out.println("=== 🏦 TESTANDO PADRÃO SINGLETON ===");
        
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println("Lazy Endereço Memória 1: " + lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println("Lazy Endereço Memória 2: " + lazy);
        
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println("Eager Endereço Memória 1: " + eager);
        eager = SingletonEager.getInstancia();
        System.out.println("Eager Endereço Memória 2: " + eager);
        
        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println("Holder Endereço Memória 1: " + holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println("Holder Endereço Memória 2: " + holder);
        System.out.println("-----------------------------------------\n");

        // 🧪 2. TESTANDO O PADRÃO DESIGN PATTERN: STRATEGY
        System.out.println("=== 🤖 TESTANDO PADRÃO STRATEGY ===");
        
        ComportamentoNormal normal = new ComportamentoNormal();
        ComportamentoDefensivo defensivo = new ComportamentoDefensivo();
        ComportamentoAgressivo agressivo = new ComportamentoAgressivo();
        
        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        
        robo.setComportamento(defensivo);
        robo.mover();
        
        robo.setComportamento(agressivo);
        robo.mover();
        System.out.println("-----------------------------------------\n");

        // 🧪 3. TESTANDO O PADRÃO DESIGN PATTERN: FACADE
        System.out.println("=== 💾 TESTANDO PADRÃO FACADE ===");
        
        Facade facade = new Facade();
        facade.migrarCliente("Alessandro Soares", "03800000");
        System.out.println("=========================================");
    }
}
