import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] coins;
    static long[] dp;
    static int n;

    static long getCnt() {
        dp[0] = 1;

        for (int x : coins) {
            for (int i = x; i <= n; i++) {
                dp[i] += dp[i - x];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dp = new long[n + 1];
        coins = new int[v];

        for (int i = 0; i < v; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        long answer = getCnt();

        System.out.println(answer);

    }
}