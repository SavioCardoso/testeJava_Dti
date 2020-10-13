# Sistema Consultório de Nutrição
Sistema em Java que faz o gerenciamento de um consultório de nutrição

## Autor
Desenvolvido por Sávio Cardoso em um processo seletivo para a [dti](https://dtidigital.com.br/)

## Linguagem
Sistema Desenvolvido em Java, utilizando o framework JUnit

## Premissas Assumidas
Mariana dispõe de 9 alimentos, que serão divididos em 3 grupos, de acordo com sua quantidade calórica:

**========== GRUPO 1 ==========**

"Leite desnatado", 50.0 Kcal

"Banana", 60.0 Kcal

"Iogurte", 100.0 Kcal
 
 
**========== GRUPO 2 ==========**

"Arroz", 200.0 Kcal

"Feijao", 250.0 Kcal

"Macarrao", 300.0 Kcal


**========== GRUPO 3 ==========**

"Batata frita", 400.0 Kcal

"Chocolate", 500.0 Kcal

"Pizza", 900.0 Kcal


Quando Mariana fornecer uma determinada meta de consumo calórico, o sistema deverá fornecer uma dieta, que consiste em **todas as combinações possíveis entre 1 elemento de cada grupo que não extrapole essa meta**

**Exemplo:**

**Meta de Consumo Calórico:** 670.0 Kcal

**Dietas possíveis:** Batata frita, arroz e leite desnatado | Batata frita, arroz e banana


Mariana deverá ser capaz ao utilizar o sistema de:
- Cadastrar seus clientes
- Visualizar os clientes cadastrados
- Cadastrar uma consulta com um cliente já cadastrado (informando uma meta de consumo calórico)
- Visualizar as consultas cadastradas (recebendo as dietas possíveis)
- Visualizar os alimentos à sua disposição e suas quantidades calóricas

## Decisões de Projeto
![diagrama_de_classes](https://user-images.githubusercontent.com/44077820/95796295-e465d600-0cc2-11eb-875f-5cf8112ed9b8.png)


## Instruções de Build
- Faça o download do [repositório](https://github.com/SavioCardoso/testeJava_Dti/)
- Faça o download do [Eclipse IDE](https://www.eclipse.org/downloads/) e selecione a opção *"Eclipse IDE for Java developers"* na instalação
- Abra o arquivo na IDE

## Instruções de Uso
O usuário navegará por um Menu com 6 opções, conforme ilustra o fluxograma abaixo:
![fluxo_de_uso](https://user-images.githubusercontent.com/44077820/95737811-a0d98080-0c5e-11eb-8055-a9776a693cb1.png)

Exemplo de uso do sistema:
![exempo_de_uso](https://user-images.githubusercontent.com/44077820/95796761-1d527a80-0cc4-11eb-845e-951b9c67f60e.gif)
