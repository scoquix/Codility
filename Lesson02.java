import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lesson02 {
    //TASK 1
    public static int[] solution(int[] A, int K) {
        if (A.length == 0 || K == 0)
            return A;
        else if (A.length <= 100 && K > 0 && K <= 100) {
            Queue<Integer> integerList = new LinkedList<>();
            for (int i = A.length - 1; i >= 0; i--)
                integerList.add(A[i]);
            for (int i = 0; i < K; i++) {
                int last = integerList.remove();
                integerList.add(last);
            }
            int[] results = new int[A.length];
            for (int i = A.length - 1; i >= 0; i--)
                results[i] = integerList.remove();
            return results;
        }
        return new int[A.length];
    }

    //TASK 2
    public static int solution(int[] A) {
        if (A.length < 1 || A.length > 1000000)
            return -1;
        Map<Integer, Integer> numbersCountMap = new HashMap<>();
        for (int value : A) {
            if (value < 1 || value > 1000000000)
                return -1;

            Integer keyCountValue = 0;
            if (numbersCountMap.containsKey(value)) {
                keyCountValue = numbersCountMap.get(value);
            }
            numbersCountMap.put(value, ++keyCountValue);
        }
        for (Map.Entry<Integer, Integer> entry : numbersCountMap.entrySet())
            if (entry.getValue() % 2 == 1)
                return entry.getKey();
        return -1;
    }
}
