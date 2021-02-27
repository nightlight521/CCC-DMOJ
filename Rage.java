import java.util.*;
import java.io.*;

public class Rage {
    // mmm... subs...
    public static class Sub {
        Sub leftChild;
        Sub rightChild;
        int startIdx;
        int endIdx;
        int min;
        int max;

        public Sub(int startIdx, int endIdx, int min, int max, Sub leftChild, Sub rightChild) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.min = min;
            this.max = max;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    // ultimately returns the root of the tree
    static Sub makeTree(int startIdx, int endIdx, int[] arr) {
        if (startIdx == endIdx) {
            return new Sub(startIdx, endIdx, arr[startIdx], arr[startIdx], null, null);
        }
        int half = (endIdx - startIdx) / 2 + startIdx;
        Sub leftChild = makeTree(startIdx, half, arr);
        Sub rightChild = makeTree(half + 1, endIdx, arr);
        int min = Math.min(leftChild.min, rightChild.min);
        int max = Math.max(leftChild.max, rightChild.max);
        return new Sub(startIdx, endIdx, min, max, leftChild, rightChild);
    }

    static int[] findMinMax(Sub subArr, int startIdx, int endIdx) {
        if (startIdx == subArr.startIdx && endIdx == subArr.endIdx) {
            return new int[] {subArr.min, subArr.max};
        }
        int half = (subArr.endIdx - subArr.startIdx) / 2 + subArr.startIdx;
        if (endIdx <= half) {
            return findMinMax(subArr.leftChild, startIdx, endIdx);
  } else if (startIdx > half) {
            return findMinMax(subArr.rightChild, startIdx, endIdx);
        } else {
            int[] leftMinMax = findMinMax(subArr.leftChild, startIdx, half);
            int[] rightMinMax = findMinMax(subArr.rightChild, half + 1, endIdx);
            return new int[] {Math.min(leftMinMax[0], rightMinMax[0]),
                              Math.max(leftMinMax[1], rightMinMax[1])};
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bin.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bin.readLine().trim());
        }

        Sub root = makeTree(1, arr.length - 1, arr);
        for (int i = 0; i < q; i++) {
            input = bin.readLine().trim().split(" ");
            int startIdx = Integer.parseInt(input[0]);
            int endIdx = Integer.parseInt(input[1]);
            int[] minMax = findMinMax(root, startIdx, endIdx);
            System.out.println(minMax[1] - minMax[0]);
        }
    }
}