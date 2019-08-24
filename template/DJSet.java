import java.util.Arrays;

/**
 * @author uwi
 */
public class DJSet {
  public int[] upper;

  public DJSet(int n) {
    upper = new int[n];
    Arrays.fill(upper, -1);
  }

  public int root(int x) {
    return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
  }

  public boolean equiv(int x, int y) {
    return root(x) == root(y);
  }

  public boolean union(int x, int y) {
    x = root(x);
    y = root(y);
    if (x != y) {
      if (upper[y] < upper[x]) {
        int d = x;
        x = y;
        y = d;
      }
      upper[x] += upper[y];
      upper[y] = x;
    }
    return x == y;
  }

  public int count() {
    int ct = 0;
    for (int u : upper)
      if (u < 0)
        ct++;
    return ct;
  }
}
