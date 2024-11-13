import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] parent;

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static boolean union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a == b)
            return false;
        else if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int a, b, cnt;

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cnt = 0;

            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            while (k-- > 0) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (union(a, b))
                    cnt++;
            }

            sb.append(cnt == n - 1 ? "Connected.\n" : "Not connected.\n");
        }

        System.out.println(sb.toString());
    }
}