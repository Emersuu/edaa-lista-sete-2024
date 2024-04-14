package App;

import java.util.*;

public class Atividades {

    public static void AtividadeUmLetraA(){
        Stack<String> stack = new Stack<>();
        stack.push("ESTE EXERCÍCIO É MUITO FÁCIL.");

        while (!stack.empty()) {
            String[] palavras = stack.pop().replace(".", "").split(" ");
            Stack<Character> stackChar = new Stack<>();
            StringBuilder fraseReversa = new StringBuilder();

            for(String palavra : palavras){
                char[] chars = palavra.toCharArray();

                for(char c: chars)
                    stackChar.push(c);

                while (!stackChar.empty())
                    fraseReversa.append(stackChar.pop());

                fraseReversa.append(" ");
            }

            System.out.println(fraseReversa);
        }
    }

    public static void AtividadeUmLetraB(){
        Stack<Character> stack = new Stack<>();
        String palavra = "TENET";
        char[] charArray = palavra.toCharArray();

        for(char c : charArray)
            stack.push(c);

        for (char c : charArray){
            if(c != stack.pop()){
                System.out.println("A palavra '" + palavra + "' não é um políndromo");
                return;
            }
        }

        System.out.println("A palavra '" + palavra + "' é um políndromo");
    }

    public static void AtividadeUmLetraC(){

        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(80);
        stack.push(50);

        Stack<Integer> stackTemp = new Stack<>();
        while (!stack.empty()){
            int temp = stack.pop();

            while (!stackTemp.empty() && stackTemp.peek() > temp)
                stack.push(stackTemp.pop());


            stackTemp.push(temp);
        }

        while (!stackTemp.isEmpty())
            stack.push(stackTemp.pop());

        while (!stack.empty())
            System.out.println(stack.pop());
    }

    public static void AtividadeUmLetraD(){
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(6);
        stack.push(10);
        stack.push(-200);
        stack.push(22);
        stack.push(20);
        stack.push(97);

        int stackSize = stack.size();
        double largestNumber = Double.NEGATIVE_INFINITY;
        double sumArithmeticMean = 0;
        double minimumNumber = Double.POSITIVE_INFINITY;

        while (!stack.isEmpty()){
            int number = stack.pop();

            if(number > largestNumber)
                largestNumber = number;

            if(number < minimumNumber)
                minimumNumber = number;

            sumArithmeticMean += number;
        }

        System.out.println("Maior: " + largestNumber);
        System.out.println("Menor: " + minimumNumber);
        System.out.println("Média Aritmética: " + sumArithmeticMean / stackSize);
    }

    public static void AtividadeDois(){
        final char ESCOLHA_B = 'B';
        final char ESCOLHA_C = 'C';
        final String HEX_DIGITS = "0123456789ABCDEF";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número decimal que deseja converter:");
        int numeroDecimal = scanner.nextInt();

        System.out.println("Escolha a base para a conversão:");
        System.out.println("a) Decimal para Binário");
        System.out.println("b) Decimal para Octal");
        System.out.println("c) Decimal para Hexadecimal");

        char escolha = scanner.next().toUpperCase().charAt(0);
        int divisaoBase = escolha == ESCOLHA_C ? 16 : escolha == ESCOLHA_B ? 8 : 2;

        Stack<Integer> pilha = new Stack<>();

        while (numeroDecimal > 0) {
            pilha.push(numeroDecimal % divisaoBase);
            numeroDecimal /= divisaoBase;
        }

        StringBuilder sb = new StringBuilder("Resultado da conversão: ");
        while (!pilha.isEmpty()){
            if (escolha == ESCOLHA_C) {
                sb.append(HEX_DIGITS.charAt(pilha.pop()));
                continue;
            }

            sb.append(pilha.pop());
        }

        System.out.println(sb);

        scanner.close();
    }
}
