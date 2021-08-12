package com.trainings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L06_Sorting {
    public int solution(int[] A) {
        int intersectsCounter = 0;
        long iPlus, jMinus;
        for (int i = 0; i < A.length - 1; ++i) {
            iPlus = Long.parseLong(String.valueOf(i)) + A[i];
            for (int j = i + 1; j < A.length; ++j) {
                jMinus = Long.parseLong(String.valueOf(j)) - A[j];
                System.out.println(iPlus + " " + jMinus);
                if (iPlus >= jMinus) {
                    intersectsCounter++;
                    if (intersectsCounter > 10000000) return -1;
                }
            }
        }
        return intersectsCounter;
    }

    public int solution2(int[] A) {
        Set<Integer> distinct = new HashSet<>();
        for (int i : A) {
            distinct.add(i);
        }
        return distinct.size();
    }

    public int solution3(int[] A) {
        int max1 = -1000, max2 = -1000, max3 = -1000;
        int min1 = 1000, min2 = 1000;
        for (int i : A) {
            if (i > max3) {
                if (i > max2) {
                    if (i > max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = i;
                    } else {
                        max3 = max2;
                        max2 = i;
                    }
                } else max3 = i;
            }
            if (i < min2) {
                if (i < min1) {
                    min2 = min1;
                    min1 = i;
                } else min2 = i;
            }
        }
        int resultWithMinuses = min1 * min2 * max1;
        int resultWithPluses = max1 * max2 * max3;
        return Math.max(resultWithMinuses, resultWithPluses);
    }

    public int solution4(int[] A) {
        int[] temp = A;
        int n = A.length;
        Arrays.sort(temp);
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; k++) {
                    System.out.println(temp[i] + " " + temp[j] + " " + temp[k]);
                    long sum = (long) temp[i] + temp[j];
                    if (sum > temp[k]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
