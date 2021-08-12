package com.trainings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L07_Stacks_Queues {
    //-------------------------------------------------------------------------
    // BRACKETS
    //-------------------------------------------------------------------------
    public static int solution(String S) {
        if (S.isEmpty()) return 1;
        else {
            List<String> bracketsOrder = new ArrayList<>();
            int curly = 0, square = 0, openBrackets = 0;
            int endCurly = 0, endSquare = 0, closeBrackets = 0;
            for (char c : S.toCharArray()) {
                int lastIndex = bracketsOrder.isEmpty() ? -1 : bracketsOrder.size() - 1;
                if (c == ']') {
                    if (square <= endSquare) return 0;
                    else if (!bracketsOrder.get(lastIndex).equals("[")) return 0;
                    else {
                        endSquare += 1;
                        bracketsOrder.remove(lastIndex);
                    }
                } else if (c == ')') {
                    if (openBrackets <= closeBrackets) return 0;
                    else if (!bracketsOrder.get(lastIndex).equals("(")) return 0;
                    else {
                        closeBrackets += 1;
                        bracketsOrder.remove(lastIndex);
                    }
                } else if (c == '}') {
                    if (curly <= endCurly) return 0;
                    else if (!bracketsOrder.get(lastIndex).equals("{")) return 0;
                    else {
                        endCurly += 1;
                        bracketsOrder.remove(lastIndex);
                    }
                } else if (c == '{') {
                    curly += 1;
                    bracketsOrder.add("{");
                } else if (c == '[') {
                    square += 1;
                    bracketsOrder.add("[");
                } else if (c == '(') {
                    openBrackets += 1;
                    bracketsOrder.add("(");
                }
            }
            if (curly != endCurly || openBrackets != closeBrackets || square != endSquare) return 0;
        }
        return 1;
    }

    //-------------------------------------------------------------------------
    // FISH
    //-------------------------------------------------------------------------
    public static int solution(int[] A, int[] B) {
        Stack<Integer> indexesB = new Stack<>();
        Stack<Integer> indexesA = new Stack<>();

        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                indexesA.push(i);
            } else {
                while (!indexesA.empty()) {
                    int indexA = indexesA.pop();
                    if (A[i] < A[indexA]) {
                        indexesA.push(indexA);
                        break;
                    }
                }
                if (indexesA.empty()) indexesB.push(i);
            }
        }
        return indexesA.size() + indexesB.size();
    }

    //-------------------------------------------------------------------------
    // NESTED
    //-------------------------------------------------------------------------
    public static int solution2(String S) {
        if (S.isEmpty()) return 1;
        else if (S.startsWith(")")) return 0;
        else {
            int openBrackets = 0;
            int closeBrackets = 0;
            for (char c : S.toCharArray()) {
                if (c == ')') {
                    if (openBrackets <= closeBrackets)
                        return 0;
                    else
                        closeBrackets += 1;
                }
                // (c=='(')
                else
                    openBrackets += 1;
            }
            if (openBrackets != closeBrackets) return 0;
        }
        return 1;
    }

    //-------------------------------------------------------------------------
    // STONEWALL
    //-------------------------------------------------------------------------
    public static int solution(int[] H) {
        int numbersOfBlocks = 0;
        Stack<Integer> blocks = new Stack<>();
        for (int height : H) {
            while (!blocks.empty() && blocks.peek() > height)
                blocks.pop();
            if (blocks.empty() || blocks.peek() != height) {
                numbersOfBlocks++;
                blocks.push(height);
            }
        }
        return numbersOfBlocks;
    }
}