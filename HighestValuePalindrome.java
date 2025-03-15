import java.util.ArrayList;
import java.util.List;

public class HighestValuePalindrome {
  /*
  * Time complexity: O(n)
  * Space complexity: O(n)
  * */
  public static void main(String[] args) {
    var a = highestVal("11331", 4);
    System.out.println(a); // 99399
  }

  public static String highestVal(String s, int k) {
    char[] chars = s.toCharArray();

    List<Integer> changeIndex = new ArrayList<>();
    int cnt = 0;

    if (k >= s.length()) {
      return "9".repeat(s.length());
    }

    if (chars.length == 1) {
      chars[0] = '9';
      cnt++;
    }

    for (int i = 0, j = s.length() - 1; i < s.length() && j > 0; i++, j--) {
      if (chars[i] != chars[j] && cnt < k) {
        if (chars[i] < chars[j]) {
          chars[i] = chars[j];
          changeIndex.add(i);
          cnt++;
        } else {
          chars[j] = chars[i];
          changeIndex.add(j);
          cnt++;
        }
      }
    }

    if (cnt < k) {
      for (int i = 0, j = chars.length - 1; i < chars.length && j > 0; i++, j--) {

        if (chars[i] != '9' && chars[j] != '9') {
          if (!changeIndex.contains(i) && !changeIndex.contains(j) && cnt< k-1) {
            chars[i] = '9';
            chars[j] = '9';
            cnt = cnt + 2;
          }
          if (changeIndex.contains(j) && changeIndex.contains(i)) {
            chars[j] = '9';
            chars[i] = '9';
          }

          if ((changeIndex.contains(i) != changeIndex.contains(j)) && cnt < k) {
            chars[i] = '9';
            chars[j] = '9';
            cnt++;
          }

        }
      }
      if (chars.length % 2 != 0 && cnt < k) {
        chars[chars.length/2] = '9';
      }
    }

    var s1 = String.valueOf(chars);
    for (int i = 0, j = s1.length() - 1; i < s1.length() && j > 0; i++, j--) {
      if (s1.charAt(i) != s1.charAt(j)) {
        return "-1";
      }
    }
    return s1;
  }

}
