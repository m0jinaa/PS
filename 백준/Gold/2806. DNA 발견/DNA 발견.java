import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static int n;
    static char[] dna;
    static final int INF = 1_000_000_007;

    static int getMin(int x, int c) {
        if (x < 0)
            return 0;
        else if (dp[c][x] != -1)
            return dp[c][x];

        int cnt = INF;

        if ((dna[x] == 'A' && c == 0) || (dna[x] == 'B' && c == 1)) {
            cnt = getMin(x - 1, c);
        } else {
            cnt = Math.min(getMin(x - 1, 1 - c), getMin(x - 1, c)) + 1;
        }

        return dp[c][x] = cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dna = br.readLine().toCharArray();

        dp = new int[2][n];

        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = getMin(n - 1, 0);

        System.out.println(answer);
    }
}