import java.util.HashMap;
import java.util.Map;

public class Lesson8 {
    //-------------------------------------------------------------------------
    // EquiLeader
    //-------------------------------------------------------------------------
    public int solution(int[] A) {
        if (A.length == 1) return 0;
        Map<Integer, Integer> valuesCounter = new HashMap<>();
        int leader = A[0];
        int leaderMaxValue = 1;
        for (int elementValue : A) {
            int counterForI = valuesCounter.merge(elementValue, 1, Integer::sum);
            if (counterForI > leaderMaxValue) {
                leaderMaxValue = counterForI;
                leader = elementValue;
            }
        }

        if (leaderMaxValue <= A.length / 2)
            return 0;

        int leaderCounter = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader)
                leaderCounter++;
            if (leaderCounter > (i + 1) / 2) {
                if (leaderMaxValue - leaderCounter > (A.length - (i + 1)) / 2)
                    result++;
            }
        }
        return result;
    }

    //-------------------------------------------------------------------------
    // Dominator
    //-------------------------------------------------------------------------
    public int solution2(int[] A) {
        HashMap<Integer, Integer> dominators = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int currentValue = 1;
            if (dominators.containsKey(A[i])) {
                currentValue = dominators.get(A[i]) + 1;
            }
            dominators.put(A[i], currentValue);
            if (currentValue > A.length / 2) return i;
        }
        return -1;
    }

}
