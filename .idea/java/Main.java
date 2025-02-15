package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número para la criba de Eratóstenes: ");
        int maxNumber = scanner.nextInt();

        System.out.println("\nNúmeros primos hasta " + maxNumber + ":");
        int[] primeNumbers = sieveOfEratosthenes(maxNumber);

        for (int i = 0; i < primeNumbers.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(primeNumbers[i] + "\t");
        }

        scanner.close();
    }

    public static int[] sieveOfEratosthenes(int max) {
        if (max < 2) return new int[0];

        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }

        int[] primes = new int[count];
        for (int i = 2, index = 0; i <= max; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }

        return primes;
    }
}
