# Conversor de Moedas

## 📝 Descrição
Este projeto é um conversor de moedas desenvolvido em Java. Ele permite ao usuário interagir através do console para obter cotações de conversão em tempo real, consumindo dados da [ExchangeRate-API](https://www.exchangerate-api.com/).

O objetivo é fornecer uma ferramenta simples e prática para o dia a dia, além de servir como um projeto de estudo sobre consumo de APIs, manipulação de JSON e boas práticas de programação em Java.

## ✨ Funcionalidades
- **Menu Interativo:** O programa apresenta um menu de opções no console para o usuário escolher a conversão desejada.
- **Conversão em Tempo Real:** Utiliza uma API para buscar as taxas de câmbio mais recentes, garantindo valores atualizados.
- **Ampla Gama de Moedas:** O menu inclui 6 opções de conversão populares, envolvendo o Dólar Americano, Real Brasileiro, Peso Argentino e Peso Colombiano.
- **Tratamento de Erros:** O sistema está preparado para lidar com entradas inválidas do usuário e falhas na comunicação com a API.

## 🛠️ Tecnologias Utilizadas
- **Java 11:** Versão da linguagem Java utilizada no projeto.
- **Maven:** Ferramenta de automação e gerenciamento de dependências.
- **GSON:** Biblioteca do Google para converter objetos Java em sua representação JSON e vice-versa (desserialização).
- **Java HTTP Client:** Cliente HTTP nativo do Java (a partir da versão 11) para realizar as requisições à API.
- **ExchangeRate-API:** API externa que fornece os dados de câmbio.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- Ter o **JDK 11** (ou superior) instalado.
- Ter o **Apache Maven** instalado e configurado.
- Uma **chave de API** da [ExchangeRate-API](https://www.exchangerate-api.com/). O cadastro é gratuito.

### Passos

1. **Adicione sua chave da API:**
    - Abra o arquivo `src/main/java/org/example/ApiHandler.java`.
    - Localize a linha: `private final String apiKey = "SUA_CHAVE_AQUI";`
    - Substitua `"SUA_CHAVE_AQUI"` pela sua chave de API pessoal.

2. **Compile e execute o projeto com Maven:**
    - No terminal, a partir da raiz do projeto, execute o comando para compilar e empacotar:
    ```bash
    mvn clean install
    ```
    - Após a compilação bem-sucedida, execute o programa com o seguinte comando:
    ```bash
    mvn exec:java -Dexec.mainClass="org.conversor.Main"
    ```

3. **Executando pela IDE (IntelliJ IDEA):**
    - Abra o projeto no IntelliJ.
    - O Maven irá sincronizar e baixar as dependências automaticamente.
    - Abra o arquivo `src/main/java/org/example/Main.java`.
    - Clique com o botão direito no editor e selecione a opção **"Run 'Main.main()'"** ou clique no ícone de "play" verde ao lado da declaração da classe.
