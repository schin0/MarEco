
# 🌊 MarEco App

Bem-vindo ao repositório do MarEco! Este projeto é dividido em duas partes principais: o backend, Java com Spring Boot, que contém três APIs, e o frontend, que é um projeto Kotlin com Jetpack Compose.

## 📂 Estrutura do Projeto

```
├── backend
│   ├── api Usuario (porta 8080)
│   ├── api Evento (porta 8082)
│   └── api Ocorrencia (porta 8083)
└── frontend
    └── MarEcoApp
```

## 🚀 Como Rodar o Projeto

### Backend

1. Navegue até o diretório `backend` na sua IDE de preferência (Recomendamos o uso do IntelliJ IDEA).
2. Rode as três APIs, cada uma em sua respectiva porta:
    - API Usuario : Porta 8080
    - API Evento: Porta 8082
    - API Ocorrencia: Porta 8083

### Frontend

1. Abra o Android Studio.
2. Navegue até o diretório `frontend/MarEcoApp` e abra o projeto.

### Emulador

#### Emulador do Android Studio

Se você for rodar o app no emulador do Android Studio, não é necessária nenhuma alteração nas configurações de rede.

#### Emulador Físico

Se você for rodar o app em um dispositivo físico, será necessário alterar as rotas configuradas. Siga os passos abaixo:

1. Navegue até o pacote `factories` dentro do projeto `MarEcoApp`.
2. Abra os seguintes arquivos e substitua `10.0.2.2` pelo IP do seu computador:
    - `RetrofitFactory.kt`
    - `RetrofitFactoryLogin.kt`
    - `RetrofitFactoryRegistro.kt`
    - `RetrofitFactoryReporte.kt`

Exemplo de alteração:

```kotlin
// Antes
private const val BASE_URL = "http://10.0.2.2:8081/"

// Depois
private const val BASE_URL = "http://SEU_IP_AQUI:8081/"
```

## 🔗 Links importantes

- 🎨[Figma](https://www.figma.com/proto/MSMqsGqgm5sksNu1j3WS8y/MarEco---Global-Solution?node-id=60-1043&t=HCpmZm88VMKHbVUe-1&scaling=scale-down&page-id=0%3A1&starting-point-node-id=51%3A1129)
- 📈 [Vídeo Pitch]()
- 💻 [Vídeo técnico](https://youtu.be/DokwIp-LZLA?si=S9-Gx5ot4a94wrAP)
- 📋 [Diagrama BPMN da solução](https://drive.google.com/file/d/1p7dJXqmuhJj1QGKauRZJbyewQTlSR9fb/view?usp=sharing)
- 📃 [Documentação completa do projeto](https://docs.google.com/document/d/1brf8BWoDI9XvdqF5tXGKm4oIctjsfJybFNhrB7ldSqg/edit?usp=sharing)

## 📞 Participantes
- [Alex Coelho de Oliveira](https://www.linkedin.com/in/alex-coelho-de-oliveira/)
- [Gabriel Hernandes Schincariol](https://www.linkedin.com/in/gabrielschincariol/)
- [Guilherme Radan Pereira Santos](https://www.linkedin.com/in/guilherme-radan-pereira-santos-0bb65b194/)
- [Lucas da Silva de Almeida Costa](https://www.linkedin.com/in/lucas-costa-7a3b81201/)
---
