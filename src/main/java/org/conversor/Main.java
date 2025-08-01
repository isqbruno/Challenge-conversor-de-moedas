package org.conversor;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ApiHandler apiHandler = new ApiHandler();
        int opcao = 0;

        String menu = """
                ***************************************************
                Seja bem-vindo(a) ao Conversor de Moeda!
                
                Escolha uma das opções para conversão:
                
                1) Dólar Americano [USD] =>> Real Brasileiro [BRL]
                2) Real Brasileiro [BRL] =>> Dólar Americano [USD]
                3) Dólar Americano [USD] =>> Peso Argentino [ARS]
                4) Peso Argentino [ARS] =>> Dólar Americano [USD]
                5) Dólar Americano [USD] =>> Peso Colombiano [COP]
                6) Peso Colombiano [COP] =>> Dólar Americano [USD]
                7) Sair
                
                ***************************************************
                """;

        while (opcao != 7) {
            System.out.println(menu);
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = scanner.nextInt();

                if (opcao >= 1 && opcao <= 6) {
                    System.out.print("Digite o valor que deseja converter: ");
                    double valor = scanner.nextDouble();

                    String moedaBase = "";
                    String moedaAlvo = "";

                    switch (opcao) {
                        case 1:
                            moedaBase = "USD";
                            moedaAlvo = "BRL";
                            break;
                        case 2:
                            moedaBase = "BRL";
                            moedaAlvo = "USD";
                            break;
                        case 3:
                            moedaBase = "USD";
                            moedaAlvo = "ARS";
                            break;
                        case 4:
                            moedaBase = "ARS";
                            moedaAlvo = "USD";
                            break;
                        case 5:
                            moedaBase = "USD";
                            moedaAlvo = "COP";
                            break;
                        case 6:
                            moedaBase = "COP";
                            moedaAlvo = "USD";
                            break;
                    }

                    // Chama a API para obter a conversão
                    ApiResponse response = apiHandler.getConversion(moedaBase, moedaAlvo, valor);

                    // Exibe o resultado formatado
                    System.out.println("\n----------- RESULTADO -----------");
                    System.out.printf("O valor de %.2f [%s] corresponde ao valor final de =>> %.2f [%s]%n",
                            valor, moedaBase, response.conversionResult(), moedaAlvo);
                    System.out.println("---------------------------------\n");

                } else if (opcao != 7) {
                    System.out.println("Opção inválida! Por favor, escolha uma opção do menu.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Por favor, digite um número válido para a opção e o valor.");
                scanner.next(); // Limpa o buffer do scanner para evitar um loop infinito
            } catch (RuntimeException e) {
                System.out.println("\nOcorreu um erro: " + e.getMessage());
            }
        }

        System.out.println("\nObrigado por usar o Conversor de Moedas. Programa encerrado.");
        scanner.close();

    }
}