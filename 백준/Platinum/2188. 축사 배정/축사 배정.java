import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] want;
    static boolean[] connected;
    static int[] barn;

    public static boolean dfs(int x) {
        for(int i:want[x]) {
            if(connected[i])
                continue;
            connected[i] = true;

            if(barn[i]==0 || dfs(barn[i])) {
                barn[i] = x;
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

        barn = new int[m + 1];
        connected = new boolean[m + 1];
        want = new ArrayList[n + 1];

        int c, w;

        for (int i = 1; i <= n; i++) {
            want[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine(), " ");

            c = Integer.parseInt(st.nextToken());
            while (c-- > 0) {
                w = Integer.parseInt(st.nextToken());
                want[i].add(w);
            }
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