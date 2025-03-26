import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
  public static List<List<Integer>> findAllSubsets(int[] arr, int target) {
    List<List<Integer>>[] dp = new ArrayList[target + 1];

    for (int i = 0; i <= target; i++) {
      dp[i] = new ArrayList<>();
    }
    dp[0].add(new ArrayList<>()); // Base case: empty subset for sum=0

    for (int num : arr) {
      for (int j = target; j >= num; j--) {
        for (List<Integer> subset : dp[j - num]) {
          List<Integer> newSubset = new ArrayList<>(subset);
          newSubset.add(num);
          dp[j].add(newSubset);
        }
      }
    }

    // Return the subsets that sum to the `target`
    return dp[target];
  }

  public static void main(String[] args) {
    int[] arr = {3, 34, 4, 12, 5, 2, 7, 1};
    int target = 11;

    List<List<Integer>> subsets = findAllSubsets(arr, target);

    if (subsets.isEmpty()) {
      System.out.println("No subsets found.");
    } else {
      System.out.println("Subsets that sum to " + target + ":");
      for (List<Integer> subset : subsets) {
        System.out.println(subset);
      }
    }
  }
}