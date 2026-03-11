📦 Sistema de Gestão de Estoque & Patrimônio
Este é um projeto Fullstack de alta performance desenvolvido para gerenciar ativos e produtos. O sistema integra um backend robusto que processa a lógica de inventário e um frontend dinâmico para visualização de dados e relatórios.

🚀 Tecnologias de Última Geração
Backend (Core)

Java 25: Utilizando as funcionalidades mais recentes da linguagem para performance e segurança.

Spring Boot 3.4+: Framework para construção de APIs REST escaláveis.

Spring Data JPA: Abstração de persistência de dados.

Maven: Gestão de dependências e build.

Frontend

Next.js 15/16: Framework React para uma experiência de usuário rápida.

Tailwind CSS: Design responsivo e minimalista.

jsPDF: Biblioteca para geração de relatórios de estoque diretamente no cliente.

✨ Funcionalidades Principais
📊 Dashboard de Patrimônio: Cálculo automático do valor total investido no inventário.

📄 Relatórios Exportáveis: Geração de PDFs profissionais para controle administrativo.

🔍 Filtro em Tempo Real: Localização rápida de produtos e categorias.

🏗️ Arquitetura Escalável: Organização seguindo os padrões de camadas (Controller, Service, Repository).

🛠️ Como rodar o projeto
1. Pré-requisitos

JDK 25 instalado e configurado nas variáveis de ambiente.

Node.js instalado para o frontend.

2. Configuração do Backend

Bash
# Entre na pasta do projeto Java
cd controle-estoque
# Execute a aplicação
./mvnw spring-boot:run
API rodando em: http://localhost:8080

3. Configuração do Frontend

Bash
# Entre na pasta do frontend
cd controle-estoque-front
# Instale as dependências e inicie
npm install && npm run dev
Interface rodando em: http://localhost:3000
