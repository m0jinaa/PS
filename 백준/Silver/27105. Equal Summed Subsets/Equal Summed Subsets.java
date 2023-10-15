import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int target;
    static long[] dp;
    static int n;

    static long getCnt() {
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }

        return dp[target] / 2;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int total = (n * (n + 1)) / 2;

        long answer;

        if (total % 2 != 0) {
            answer = 0;
        } else {
            target = total / 2;
            dp = new long[target + 1];

            answer = getCnt();
        }

        System.out.println(answer);
    }
}