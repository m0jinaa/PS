import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    public static int t, w;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[][][] dp = new int[1001][31][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr.add(-1);
        for (int i = 0; i < t; i++) {
            int tree = Integer.parseInt(br.readLine());
            arr.add(tree);
        }

        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        int res = 0;
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) { //0은 움직이지 않는것
                if (arr.get(i) == 1) {
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                    res = Math.max(dp[i][j][1], dp[i][j][2]);
                } else {
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][1];
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
                    res = Math.max(dp[i][j][1], dp[i][j][2]);
                }
            }
        }
        System.out.println(res);
    }
}