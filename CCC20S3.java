import java.util.*;
import java.io.*;

public class Searching {
    public static int[] countLetters(String section, int start, int needleLength) {
        int[] sectionCounts = new int[26];
        for (int i = 0; i < needleLength; i++) {
            sectionCounts[section.charAt(start + i) - 'a']++;
        }
        return sectionCounts;
    }

    public static boolean isPermutation(int[] counts1, int[] counts2) {
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String needle = input.readLine().trim();
        String haystack = input.readLine().trim();

        if (needle.length() > haystack.length()) {
            System.out.println("0");
            return;
        }

        int[] needleCounts = countLetters(needle, 0, needle.length());
        int[] windowCounts = countLetters(haystack, 0, needle.length());
        long hash1 = 0;
        long hash2 = 0;
        long power1 = 1;
        long power2 = 1;
        for (int i = needle.length() - 1; i >= 0; i--) {
            hash1 += haystack.charAt(i) * power1;
            hash2 += haystack.charAt(i) * power2;
            if (i > 0) {
                power1 *= 31;
                power2 *= 17;
            }
        }

        HashSet<Long> permutations = new HashSet<Long>();

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (isPermutation(windowCounts, needleCounts)) {
                permutations.add(hash1 ^ hash2);
            }
            if (i == haystack.length() - needle.length()) break;
            char first = haystack.charAt(i);
            char next = haystack.charAt(i + needle.length());
            windowCounts[first - 'a']--;
            windowCounts[next - 'a']++;
            hash1 -= first * power1;
            hash2 -= first * power2;
            hash1 *= 31;
            hash2 *= 17;
            hash1 += next;
            hash2 += next;
        }

        System.out.println(permutations.size());
    }

}