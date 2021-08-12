package com.trainings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L11_Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        int[] N = {3, 1, 2, 3, 6};
//        int[] sieveOfErato = arrayF(6);
//        for (int i = 0; i < sieveOfErato.length; i++) {
//            System.out.println(i+" "+sieveOfErato[i]);
//        }
//        System.out.println("---------------");
//        List<Integer> a = factorization(1, sieveOfErato);
//        a.forEach(System.out::println);
//        System.out.println("---------------");
//        int[] Result = solution(N);
//        for (int j : Result) {
//            System.out.println(j);
//        }
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        solution(26, P, Q);
    }

    public static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        int i = 2;
        while (i * i <= n) {
            if (sieve[i]) {
                int k = i * i;
                while (k <= n) {
                    sieve[k] = false;
                    k += i;
                }
            }
            i += 1;
        }
        return sieve;
    }

    public static int[] arrayF(int n) {
        int[] F = new int[n + 1];
        int i = 2;
        while (i * i <= n) {
            if (F[i] == 0) {
                int k = i * i;
                while (k <= n) {
                    if (F[k] == 0) {
                        F[k] = i;
                    }
                    k += i;
                }
            }
            i += 1;
        }
        return F;
    }

    public static List<Integer> factorization(int x, int[] F) {
        List<Integer> primeFactors = new ArrayList<>();
        while (F[x] > 0) {
            primeFactors.add(F[x]);
            x /= F[x];
        }
        primeFactors.add(x);
        return primeFactors;
    }


    //------------------------------------
    //  CountNonDivisors
    //------------------------------------
    public static int[] solution(int[] A) {
        int N = A.length;
        int[] non_divisors = new int[N];
        int[] counts = new int[2 * N + 1];
        for (int k : A) {
            counts[k] += 1;
        }

        for (int i = 0; i < N; i++) {
            int divisors = 0;
            for (int j = 1; j * j <= A[i]; ++j) {
                if (A[i] % j == 0) {
                    divisors += counts[j];
                    if (A[i] / j != j) {
                        divisors += counts[A[i] / j];
                    }
                }
            }
            non_divisors[i] = N - divisors;
        }
        return non_divisors;
    }

    //------------------------------------
    // CountSemiprimes
    //------------------------------------
    public static int[] solution(int N, int[] P, int[] Q) {
        Integer[] primes = sievePrimes(N / 2 + 1);

        int[] temp = new int[N + 1];
        for (Integer firstPrime : primes) {
            for (Integer secondPrime : primes) {
                int semiPrime = firstPrime * secondPrime;
                if (semiPrime <= N)
                    temp[semiPrime] = 1;
            }
        }

        int[] prefix = new int[N + 1];
        for (int i = 1; i < temp.length; i++) {
            prefix[i] = temp[i] + prefix[i - 1];
        }

        int[] results = new int[P.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = prefix[Q[i]] - prefix[P[i] - 1];
        }
        return results;
    }

    public static Integer[] sievePrimes(int n) {
        boolean[] sieved = new boolean[n + 1];
        Arrays.fill(sieved, true);
        sieved[0] = sieved[1] = false;
        int divisor = 2;
        while (divisor * divisor <= n) {
            for (int j = divisor * divisor; j < sieved.length; j++) {
                if (sieved[j] && j % divisor == 0) {
                    sieved[j] = false;
                }
            }
            divisor += 1;
        }
        List<Integer> primes = new ArrayList<>();
        for (divisor = 0; divisor < sieved.length; divisor++) {
            if (sieved[divisor]) primes.add(divisor);
        }
        return primes.toArray(new Integer[0]);
    }
}
