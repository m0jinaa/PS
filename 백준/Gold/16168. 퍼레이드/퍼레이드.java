import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] root;

    static int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return false;
        else if (x < y)
            root[y] = x;
        else
            root[x] = y;

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int a, b;
        int[] cnt = new int[v + 1];
        root = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            root[i] = i;
        }

        int c = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (union(a, b))
                c++;
            cnt[a]++;
            cnt[b]++;
        }

        int odd = 0;

        for (int i = 1; i <= v; i++) {
            if (cnt[i] % 2 != 0)
                odd++;
        }

        if (c == v - 1 && (odd == 0 || odd == 2))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

}