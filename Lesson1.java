public class Lesson1 {
    public int solution(int N) {
        if (N > 0 && N < Integer.MAX_VALUE) {
            String binaryInt = Integer.toBinaryString(N);
            String[] zeros = binaryInt.split("1");
            int binaryGapLength = 0;
            int length = binaryInt.lastIndexOf("0") == binaryInt.length() - 1 ? zeros.length - 1 : zeros.length;
            for (int i = 0; i < length; i++)
                if (zeros[i].length() > binaryGapLength)
                    binaryGapLength = zeros[i].length();
            return binaryGapLength;
        }
        return 0;
    }
}
