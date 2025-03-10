import java.util.ArrayList;
import java.util.List;

public class GetWays {
  //Total ways to get coin change
  public static long getWays(int n, List<Long> c) {
    // Write your code here
    long[] ways = new long[n + 1];
    ways[0] = 1;

    for (long coin : c) {
      for (int amount = (int) coin; amount <= n; amount++) {
        ways[amount] += ways[amount - (int) coin];
      }
    }
    return ways[n];
  }

  public static void main(String[] args) {
    List<Long> l = new ArrayList<>();
    l.add(1L);
    l.add(2L);
    l.add(5L);
    var res = getWays(5, l); //4
    System.out.println(res);
  }
}
