import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] root, size;

    static int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;
        else if (size[x] > size[y]) {
            root[y] = x;
            size[x] += size[y];
        } else {
            root[x] = y;
            size[y] += size[x];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String s, e;
        int c, n, m, N;
        int cost = 0, cnt;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            map.clear();

            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            N = 2 * n;
            root = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                root[i] = i;
                size[i] = 1;
            }

            int t = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                s = st.nextToken();
                e = st.nextToken();

                if (map.putIfAbsent(s, t) == null)
                    t++;
                if (map.putIfAbsent(e, t) == null)
                    t++;

                union(map.get(s), map.get(e));

                sb.append(size[find(map.get(s))]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

}