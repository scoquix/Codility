package com.trainings;

public class L05_Prefix_Sums {
    //TASK 1
    public int solution(int[] A) {
        int zeroIncrementer = 0;
        int counter = 0;
        for (int value : A) {
            if (value == 0)
                zeroIncrementer++;
            else {
                counter += zeroIncrementer;
                if (counter > 1000000000) return -1;
            }
        }
        return counter;
    }

    //TASK 2
    public int solution2(int[] A) {
        double minAvr = (A[0] + A[1]) / 2.0;
        int sliceIndex = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            double sum = A[i];
            for (int j = i + 1, count = 2; j < A.length / 2 || count < 5; ++j, ++count) {
                sum += A[j];
                double avr = sum / count;
                if (avr < minAvr) {
                    sliceIndex = i;
                    minAvr = avr;
                }
            }
        }
        return sliceIndex;
    }

    //TASK 3
    public int solution3(int A, int B, int K) {
        int higherBound = B / K;
        int lowerBound = A / K;
        int counter = higherBound - lowerBound;
        if (A % K == 0) counter += 1;
        return counter;
    }

    //TASK 4
    public int[] solution4(String S, int[] P, int[] Q) {
        int[] results = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            String temp = S.substring(P[i], Q[i] + 1);
            if (temp.contains("A"))
                results[i] = 1;
            else if (temp.contains("C"))
                results[i] = 2;
            else if (temp.contains("G"))
                results[i] = 3;
            else if (temp.contains("T"))
                results[i] = 4;
        }
        return results;
    }
}
