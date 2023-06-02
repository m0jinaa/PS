import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] pick;
    static boolean[] used;
    static ArrayList<Integer>[] want;

    static boolean dfs(int x) {
        for (int y : want[x]) {
            if (used[y])
                continue;
            used[y] = true;
            if (pick[y] == 0 || dfs(pick[y])) {
                pick[y] = x;
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

        HashMap<String, Integer> map = new HashMap<>();
        String name;
        for(int i = 1;i<=m;i++) {
            name = br.readLine();
            map.put(name, i);
        }

        want = new ArrayList[n + 1];
        pick = new int[m+1];
        used = new boolean[m+1];

        int k,ind;

        for(int i = 1;i<=n;i++) {
            want[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());

            while(k-->0) {
                name = st.nextToken();
                ind = map.get(name);
                want[i].add(ind);
            }
        }

        int cnt = 0;

        for(int p = 1;p<=n;p++) {
            Arrays.fill(used, false);
            if(dfs(p)) {
                cnt++;
            }
        }   

        if(cnt==n) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO\n"+cnt);
        }
    }
}