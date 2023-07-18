<h1 align="center">
  <img alt="chatgpt-springboot" title="chatgpt-springboot" src=".github/logo.png" />
</h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-solução">Roteiro</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-como-executar">Como executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

<br>

## ✨ Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [OpenAI](https://platform.openai.com/overview)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring WebFlux](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.reactive)

## 💻 Projeto

Esse projeto foi elaborado [nesse vídeo](https://youtu.be/fC_OdD6zy-Y) que demonstra como construir uma API de geração de notas de estudo utilizando Spring Boot e ChatGPT.

## 🗒️ Roteiro

- [x] ChatGPT e OpenAI
- [x] Criação da API
- [x] Integração com OpenAI
- [x] Testes unitários
- [x] Resultados

## 🚀 Como executar

- Clone o repositório
- Abra em qualquer IDE Java
- Crie uma conta no [OpenAI](https://beta.openai.com/)
- Crie uma api key
- Defina essa api key no arquivo `application.properties` do projeto Spring Boot
  - Ex: openai.api.key=minha-api-key
- Execute o projeto Spring Boot
```

Agora você pode testar em `http://localhost:8080/study-notes`:
```
$ curl http://localhost:8080/study-notes -H "Content-Type: application/json" -d "AWS Cloud"

1.  Fundamentos da AWS
2.  Arquitetura da AWS
3.  Serviços principais da AWS
4.  EC2 (Elastic Compute Cloud)
5.  S3 (Simple Storage Service)
6.  RDS (Relational Database Service)
7.  Lambda (Funções sem servidor)
8.  VPC (Virtual Private Cloud)
9.  IAM (Identity and Access Management)
10. Load Balancing (Balanceamento de carga)
11.   Serviços de segurança da AWS
