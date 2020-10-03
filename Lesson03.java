import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson03 {
    public int solution(int X, int Y, int D) {
        if (X > Y || X > 1000000000 || Y > 1000000000 || D > 1000000000)
            return -1;
        else if (X < 1 || Y < 1 || D < 1)
            return -1;
        else {
            int frogPosX = X;
            int jumps = (Y - X) / D;
            if ((Y - X) % D != 0) jumps += 1;
            return jumps;
        }
    }

    public int solution(int[] A) {
        if (A.length == 0) return 1;
        List<Integer> distinctNums = new ArrayList<>();
        for (int a : A) distinctNums.add(a);
        Collections.sort(distinctNums);
        int a = 1;
        for (Integer value : distinctNums) {
            if (!value.equals(a)) {
                return a;
            }
            ++a;
        }
        return a;
    }

    public int solution3(int[] A) {
        if (A.length < 2 || A.length > 100000) return -1;
        else {
            int min = Integer.MAX_VALUE;
            int p = 0;
            int sum = 0;
            for (Integer integer : A) sum += integer;
            for (int i = 0; i < A.length - 1; ++i) {
                p += A[i];
                int q = sum - p;
                if (Math.abs(p - q) < min) min = Math.abs(p - q);
            }
            return min;
        }
    }
}
