import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Treasure {
        int v, w;

        public Treasure(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }
    }

    static int capacity;
    static long[] dp;
    static Treasure[] treasures;

    static long getMax() {

        for (Treasure t : treasures) {
            for (int x = capacity; x >= t.w; x--) {
                dp[x] = Math.max(dp[x], dp[x - t.w] + t.v);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int n, w, v;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            capacity = Integer.parseInt(st.nextToken());

            treasures = new Treasure[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                treasures[i] = new Treasure(v, w);
            }

            dp = new long[capacity + 1];

            sb.append(getMax()).append("\n");
        }

        System.out.print(sb.toString());
    }
}