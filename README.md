Sistema de Busca Distribuída com Sockets em Java

Este projeto implementa um sistema de busca distribuída utilizando Java 17 e Sockets TCP, permitindo a execução de buscas em um conjunto de artigos científicos divididos entre dois servidores.

🎯 Objetivo

Desenvolver um sistema que simula uma arquitetura distribuída, onde um cliente solicita uma busca textual (substring), e três servidores trabalham em conjunto:

Servidor A: Coordena a operação, recebendo a busca do cliente e distribuindo para B e C.

Servidor B/C: Realizam a busca em suas respectivas metades do dataset.

O sistema simula como funciona a distribuição de tarefas, comunicação por rede, e resposta conjunta a partir de fontes separadas.

🧱 Estrutura do Projeto

BuscaDistribuida/
├── Cliente.java
├── ServidorA.java
├── ServidorB.java
├── ServidorC.java
├── Artigo.java
├── utils/
│   └── JsonLoader.java
├── dados/
│   ├── arxiv_B.json
│   └── arxiv_C.json
├── README.md

⚙️ Tecnologias e Recursos

Java 17

java.net.Socket / ServerSocket

BufferedReader, PrintWriter, ObjectOutputStream

JSON parsing com json-simple

▶️ Como Executar

1. Compile os arquivos

javac Artigo.java utils/JsonLoader.java ServidorB.java ServidorC.java ServidorA.java Cliente.java

2. Inicie os servidores (em terminais separados)

java ServidorB
java ServidorC
java ServidorA

3. Execute o cliente

java Cliente

🔄 Fluxo de Comunicação

Cliente <--> Servidor A <--> Servidor B
                       \--> Servidor C

Cliente envia string

Servidor A envia para B e C

B e C realizam a busca

A coleta e envia a resposta para o Cliente

📁 Formato dos Dados Trafegados

Cliente <--> Servidor A:

String via PrintWriter

Lista de Artigo via ObjectOutputStream

Servidor A <--> Servidores B/C:

String via PrintWriter

Lista de Artigo via ObjectOutputStream

🔍 Algoritmo de Busca

Algoritmo utilizado: Busca Ingênua (Naive Search)

Motivos:

Simples e eficiente para arquivos moderados

Compatível com String.contains()

Permite leitura clara do código

✅ Requisitos Atendidos



👨‍💻 Autor

Arthur Batista de Sousa - UC23200833
Rogerio Teixeira - UC23200885


📚 Referências

Tanenbaum, A. S., & van Steen, M. (2007). Distributed Systems: Principles and Paradigms. Prentice-Hall.

GeeksForGeeks. https://www.geeksforgeeks.org/pattern-searching/

