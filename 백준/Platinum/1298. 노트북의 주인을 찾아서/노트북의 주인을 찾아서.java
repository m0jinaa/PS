import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] think;
    static boolean[] connected;
    static int[] laptop;

    public static boolean dfs(int x) {
        for(int i:think[x]) {
            if(connected[i])
                continue;
            connected[i] = true;

            if(laptop[i]==0 || dfs(laptop[i])) {
                laptop[i] = x;
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        laptop = new int[n + 1];
        connected = new boolean[n + 1];
        think = new ArrayList[n + 1];

        int a, b;

        for (int i = 1; i <= n; i++) {
            think[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            think[a].add(b);

        }
        int answer = 0;
        for(int i = 1;i<=n;i++) {
            Arrays.fill(connected, false);
            if(dfs(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}