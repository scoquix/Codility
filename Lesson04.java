import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson04 {
    public int solution(int X, int[] A) {
        if (X < 1 || X > 100000) return -1;
        else if (A.length < 1 || A.length > 100000) return -1;
        else {
            Set<Integer> arr = new HashSet<>();
            for (int i = 0; i < A.length; ++i)
                if (A[i] <= X) {
                    arr.add(A[i]);
                    if (arr.size() == X) return i;
                }
            return -1;
        }
    }

    public int[] solution2(int N, int[] A) {
        int[] counters = new int[N];
        int mostOccurIndex = 0;
        int fillValue = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                if (i == A.length - 1) {
                    Arrays.fill(counters, mostOccurIndex);
                } else {
                    if (A[i] != A[i + 1]) {
                        counters = new int[N];
                        fillValue += mostOccurIndex;
                        mostOccurIndex = 0;
                    }

                }
            } else {
                if (mostOccurIndex < ++counters[A[i] - 1]) {
                    mostOccurIndex = counters[A[i] - 1];
                }
            }
        }
        for (int i = 0; i < counters.length; i++)
            counters[i] += fillValue;
        return counters;
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        if (A[0] != 1) return 0;
        for (int i = 0; i < A.length; i++)
            if (A[i + 1] - A[i] != 1)
                return 0;
        return 1;
    }
}
