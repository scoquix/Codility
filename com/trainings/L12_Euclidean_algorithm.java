package com.trainings;

public class L12_Euclidean_algorithm {
    public static void main(String[] args) {
        //  ChocolateByNumbers
//        System.out.println(solution(10, 4));
//        System.out.println(solution(1_000_000_000, 1));
//        long start = System.currentTimeMillis();
//        System.out.println(solution(415633212, 234332));
//        long end = System.currentTimeMillis();
//        System.out.println("Time: "+(end-start));

        // CommonPrimeDivisors
        int[] A = new int[100];
        int[] B = new int[100];
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                A[count] = i;
                B[count] = j;
                count += 1;
            }
        }
        System.out.println("CommonPrimeDivisors: " + commonPrimeDivisors(A, B));
    }

    //------------------------------------
    //  ChocolateByNumbers
    //------------------------------------
    public static int solution(int N, int M) {
        return N / greatestCommonDivisor(N, M);
    }

    public static int greatestCommonDivisor(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return greatestCommonDivisor(b, a % b);
    }

    //------------------------------------
    //  CommonPrimeDivisors
    //------------------------------------
    public static int commonPrimeDivisors(int[] A, int[] B) {
        int commonDivisors = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                commonDivisors += 1;
            }
        }
        return commonDivisors;
    }

    public static boolean hasSamePrimeDivisors(int a, int b) {
        int gcdValue = greatestCommonDivisor(a, b);
        int internalA = internalGcd(a, gcdValue);
        if (internalA != 1) {
            return false;
        }
        b = internalGcd(b, gcdValue);
        return b == 1;
    }

    private static int internalGcd(int a, int gcdValue) {
        while (a != 1) {
            int gcd = greatestCommonDivisor(a, gcdValue);
            if (gcd == 1)
                break;
            a /= gcd;
        }
        return a;
    }
}
