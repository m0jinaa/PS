import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] matched;
    static boolean[] used;
    static ArrayList<Integer>[] canMatch;
    static int[] answer;

    static boolean match(int x) {
        for (int y : canMatch[x]) {
            if (used[y] || matched[y] == x)
                continue;
            used[y] = true;

            if (matched[y] == 0 || match(matched[y])) {
                matched[y] = x;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        used = new boolean[m + 1];
        matched = new int[m + 1];
        canMatch = new ArrayList[n + 1];

        int s, g;
        int[] limit = new int[n + 1];

        int[] cnt = new int[m + 1];
        double[] sum = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            canMatch[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            s = Integer.parseInt(st.nextToken());

            for (int j = 0; j < s; j++) {
                g = Integer.parseInt(st.nextToken());
                canMatch[g].add(i);
                sum[g] += 1.0 / s;
            }
        }

        // 각 소당 가져갈 수 있는 회의 개수 구하기

        for (int i = 1; i <= n; i++) {
            limit[i] = (int) Math.ceil(sum[i]);
        }

        // 이분매칭
        boolean success = false;

        int t;

        for (int i = 1; i <= n; i++) {
            t = limit[i];

            while (t-- > 0) {
                Arrays.fill(used, false);
                if (match(i)) {
                    success = true;
                } else {
                    break;
                }
            }

            if (!success) {
                break;
            }
        }

        if (!success) {
            sb.append(-1).append("\n");
        } else {
            for (int i = 1; i <= m; i++) {
                sb.append(matched[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}