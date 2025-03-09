import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindow {
  public static void main(String[] args) {
    List<List<Integer>> arr = new ArrayList<>();
    int[][] initValue = {
        {1, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0},
        {0, 0, 2, 4, 4, 0},
        {0, 0, 0, 2, 0, 0},
        {0, 0, 1, 2, 4, 0}
    };

    for (int[] a : initValue) {
      arr.add(Arrays.stream(a).boxed().toList());
    }

    int result = Result.hourglassSum(arr);
    System.out.println(result);
  }
}

class Result {

  //Extra convert step to match Hackerrank's problem.
  public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    var col = arr.size();
    var row = arr.getFirst().size();
    var max = Integer.MIN_VALUE;
    if (col == 0) return 1;
    Integer[][] array2D = new Integer[arr.size()][arr.size()];
    int k = 0;
    for (List<Integer> nestedList : arr) {
      array2D[k++] = nestedList.toArray(new Integer[0]);
    }

    for (int i = 0; i < row-2; i++) {
      for (int j = 0; j < col-2; j++) {
        var sum = array2D[i][j] + array2D[i][j+1] + array2D[i][j+2] + array2D[i+1][j+1]
            + array2D[i+2][j] +array2D[i+2][j+1] +array2D[i+2][j+2];
        if (sum > max) max = sum;
      }
    }
    return max;
  }

}