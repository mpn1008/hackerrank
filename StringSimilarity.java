class CResult {

  /*
   * Complete the 'stringSimilarity' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int stringSimilarity(String s) {
    int totalSimilarity = 0;
    int n = s.length();

    for (int i = 0; i < n; i++) {
      totalSimilarity += calculateCommonPrefix(s, s.substring(i));
    }

    return totalSimilarity;
  }

  private static int calculateCommonPrefix(String s1, String s2) {
    int length = 0;

    // Compare characters of s1 and s2 until they don't match
    while (length < s1.length() && length < s2.length() && s1.charAt(length) == s2.charAt(length)) {
      length++;
    }

    return length;
  }
}

public class StringSimilarity {
  /*
  * Explanation
  * For the first case, the suffixes of the string are "ababaa",
  * "babaa", "abaa", "baa", "aa" and "a". The similarities of these strings
  * with the string "ababaa" are 6,0,3,0,1, & 1 respectively.
  * Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.*/

  // Note: Failed perf intense test cases 10 11
  public static void main(String[] args) {
    var s = "abaaba";
    int result = CResult.stringSimilarity(s);

    System.out.println(result); // 11
  }
}
