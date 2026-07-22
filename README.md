# 🏦 Trilha Java & Spring Boot - Santander Bootcamps 2026


<table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="100px"></td> <!-- Respiro milimétrico invisível entre as duas caixas -->
    <td width="20%" align="left" valign="middle">
        <p align="center" valign="middle">
           <a href="https://openjdk.org" style="margin: 0 15px; display: inline-block; text-align: center; text-decoration: none; color: inherit;">
                <img width="40px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" alt="Java" title="Java" /><br>
                <b>Java 21</b>
            </a>
        </p>
    </td>
    <td width="100px"></td> <!-- Respiro milimétrico invisível entre as duas caixas -->
    <td width="27%" align="right" valign="middle">
        <p align="center" valign="middle" style="padding-top: 25px;">
            <a href="https://spring.io" style="margin: 0 15px; display: inline-block; text-align: center; text-decoration: none; color: inherit;">
                <img width="40px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" alt="Spring" title="Spring" /><br>
                <b>Spring Boot</b>
            </a>
        </p>
    </td>
    <td width="1%"></td> <!-- Respiro milimétrico invisível entre as duas caixas -->
    <td width="20%" align="left" valign="middle">
        <p align="center" valign="middle">
            <a href="https://docker.com" style="margin: 0 15px; display: inline-block; text-align: center; text-decoration: none; color: inherit;">
                <img width="40px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" alt="Docker" title="Docker" /><br>
                <b>Docker</b>
            </a>
        </p>
    </td>
    <td width="100px"></td> <!-- Respiro milimétrico invisível entre as duas caixas -->
    <td width="28%" align="right" valign="middle">
        <p align="center" valign="middle" style="padding-top: 25px;">
            <a href="https://swagger.io" style="margin: 0 15px; display: inline-block; text-align: center; text-decoration: none; color: inherit;">
                <img width="40px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg" alt="API Swagger" title="API Swagger" /><br>
                <b>Swagger UI</b>
            </a>
        </p>
    </td>
    <td width="100px"></td> <!-- Respiro milimétrico invisível entre as duas caixas -->
  </tr>
</table>

<a href="https://spring.io">
    <img 
        align="left" 
        alt="Spring" 
        title="Spring"
        width="30px" 
        style="padding-right: 10px; padding-bottom: 30px;" 
        src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" 
    />
</a>
<a href="https://docker.com">
    <img 
        align="left" 
        alt="Docker" 
        title="Docker"
        width="30px" 
        style="padding-right: 10px; padding-bottom: 30px;" 
        src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" 
    />
</a>
<a href="https://swagger.io">
    <img 
        align="left" 
        alt="API Swagger" 
        title="API Swagger"
        width="30px" 
        style="padding-right: 10px; padding-bottom: 30px;" 
        src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg" 
    />
</a>

<br clear="left"/>

Este repositório centraliza os projetos de arquitetura de software e engenharia de dados desenvolvidos durante o Bootcamp Santander 2026, focando em padrões corporativos, segurança e rastreabilidade de transações.

---

## 📁 Estrutura do Repositório

### 1. 💼 `budgeting`
Módulo robusto de gerenciamento orçamentário e fluxo de caixa empresarial.
- **Diferenciais Corporativos:** Integração com banco de dados relacional **MySQL** persistido em containers isolados via **Docker Compose**, malha de segurança baseada em **Spring Security** com controle de perfis de acesso (`ADMIN` e `USER`) e auditoria ativa de payloads de mídia no console.

### 2. 🧩 `desafios_design_patterns`
Exploração laboratorial em ambiente isolado dos padrões comportamentais clássicos do GoF (Gang of Four) em Java Puro.
- **Implementação:** Arquitetura limpa aplicando o padrão **Chain of Responsibility** para controle e calibração de barreiras automáticas de saques e limites cadastrais, sem dependências de frameworks.

### 3. 🤖 `lab-padroes-projeto-spring`
Evolução da arquitetura de microsserviços aplicando os padrões estruturais de mercado unificados ao **Spring Boot 4.1.0**.
- **Singleton:** Estratégias avançadas de reaproveitamento de memória via instâncias únicas (`Lazy`, `Eager` e `LazyHolder`).
- **Strategy:** Alternância agnóstica de comportamento do motor em tempo de execução.
- **Facade + OpenFeign:** Fachada de integração que consome o webservice real da **API ViaCEP** via cliente HTTP declarativo e persiste os dados de terno e gravata na tomada dentro do banco de dados **H2 em memória**.
- **Diferencial Exclusivo:** Módulo customizado de **Auditoria de Estado JPA** integrado ao repositório, disparando carimbos de data/hora no console a cada transação relacional realizada.

---

## 🖥️ Como Executar o Ecossistema Spring

### Pré-requisitos
- **Java 21** instalado no osso da máquina.
- **Maven 3.x** para resolução de dependências.

### Partida dos Motores
Navegue até a pasta do projeto Spring Boot e dispare a inicialização automática:
```bash
cd lab-padroes-projeto-spring
mvn spring-boot:run
```

O servidor Tomcat será ativado na porta padrão `8080`. Para explorar os endpoints em tempo real e testar as payloads com a documentação viva da API, acesse a interface visual do Swagger UI através do seu navegador:
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 👤 Desenvolvedor
- **Alessandro Soares** - *Engenheiro de Software & Arquitetura Back-End*
- Repositório Oficial: [GitHub alesoares](https://github.com)
