import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson11 {
    public static void main(String[] args) {
        int[] N = {3, 1, 2, 3, 6};
//        int[] sieveOfErato = arrayF(6);
//        for (int i = 0; i < sieveOfErato.length; i++) {
//            System.out.println(i+" "+sieveOfErato[i]);
//        }
//        System.out.println("---------------");
//        List<Integer> a = factorization(1, sieveOfErato);
//        a.forEach(System.out::println);
        System.out.println("---------------");
        int[] Result = solution(N);
        for (int j : Result) {
            System.out.println(j);
        }
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
}
