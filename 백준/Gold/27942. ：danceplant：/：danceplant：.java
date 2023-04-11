import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = -90000;
        int n = Integer.parseInt(br.readLine());

        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int lx = n / 2;
        int ly = n / 2;
        int rx = lx + 1;
        int ry = ly + 1;

        int u, d, l, r, max; // 상,하,좌,우
        int total = 0;
        String answer = "";

        while (true) {
            max = INF;
            if (lx != 1) {// 위로 갈 수 있음
                u = sum[lx - 1][ry] - sum[lx - 2][ry] - sum[lx - 1][ly - 1] + sum[lx - 2][ly - 1];
                max = Math.max(max, u);
            } else {
                u = INF;
            }
            if (rx != n) {// 위로 갈 수 있음
                d = sum[rx + 1][ry] - sum[rx][ry] - sum[rx + 1][ly - 1] + sum[rx][ly - 1];
                max = Math.max(max, d);
            } else {
                d = INF;
            }
            if (ly != 1) {// 위로 갈 수 있음
                l = sum[rx][ly - 1] - sum[lx - 1][ly - 1] - sum[rx][ly - 2] + sum[lx - 1][ly - 2];
                max = Math.max(max, l);
            } else {
                l = INF;
            }
            if (ry != n) {// 오른쪽로 갈 수 있음
                r = sum[rx][ry + 1] - sum[rx][ry] - sum[lx - 1][ry + 1] + sum[lx - 1][ry];
                max = Math.max(max, r);
            } else {
                r = INF;
            }

            if (max<=0)
                break;
            else if (max == u) {
                answer += "U";
                lx-=1;
                total += max;
            } else if (max == d) {
                answer += "D";
                total += max;
                rx+=1;
            } else if (max == l) {
                answer += "L";
                total += max;
                ly-=1;
            } else {
                answer += "R";
                total += max;
                ry+=1;
            }
        }

        System.out.println(total);
        System.out.println(answer);
    }
}