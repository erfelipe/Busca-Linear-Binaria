package busca.linear.binaria;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class BuscaLinearBinaria {

    public static void main(String[] args) {

        Integer[] vet_int = new Integer[15];
        Random r = new Random();

        for (int i = 0; i < vet_int.length; i++) {
            vet_int[i] = r.nextInt(4000);
            System.out.print(vet_int[i] + " | ");
        }

        Scanner entrada = new Scanner(System.in);
        Integer num_pesq;

        System.out.println("");
        System.out.print("Digite um número a ser pesquisado: ");
        num_pesq = entrada.nextInt();

        /*
        Pesquisa linear:
        */
        
        if (pesquisaLinear(num_pesq, vet_int)) {
            System.out.println("O número pesquisado foi encontrado.");
        } else {
            System.out.println("O número pesquisado NÃO foi encontrado.");
        }
        
        /*
        Pesquisa binária:
        */
        
        vet_int = ordenaVet(vet_int);
        imprimeVetor(vet_int);

        if (pesquisaBinaria(num_pesq, vet_int)) {
            System.out.println("O número pesquisado foi encontrado.");
        } else {
            System.out.println("O número pesquisado NÃO foi encontrado.");
        }

    }//fim do main

    public static boolean pesquisaLinear(Integer valor, Integer[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println("Comparando " + valor + " com " + vet[i]);
            if (vet[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }//fim pesquisa linear

    public static boolean pesquisaBinaria(Integer valor, Integer[] vet) {
        int inicio = 0;
        int fim = vet.length - 1;
        int meio = 0;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            System.out.println("Posição meio: " + meio + " valor " + vet[meio]);
            if (valor.equals(vet[meio])) {
                return true;
            } else if (valor < vet[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
            System.out.println("Início: " + inicio + " fim: " + fim);
        }
        return false;
    }

    public static Integer[] ordenaVet(Integer[] vet) {
        System.out.println("");
        System.out.println("**Início da ordenação de vetor**");
        Integer aux;
        for (int i = 0; i < vet.length - 1; i++) {
            System.out.println("--Iteração: " + i);
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    System.out.println("Troca: " + vet[j] + " com " + vet[j + 1]);
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        System.out.println("**Fim da ordenação**");
        return vet;
    }

    public static void imprimeVetor(Object[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " | ");
        }
        System.out.println("");
    }

}//fim da classe

