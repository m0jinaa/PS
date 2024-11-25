import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };
    static int[][] map;
    static boolean[][] v;
    static LinkedList<Node> queue;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    static boolean inRange(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

    static void bfs(int x, int y) {
        queue.clear();

        queue.add(new Node(x, y));
        v[x][y] = true;

        Node now;
        int nx, ny;

        while (!queue.isEmpty()) {
            now = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || map[nx][ny] != 1 || v[nx][ny])
                    continue;

                queue.add(new Node(nx, ny));
                v[nx][ny] = true;
            }
        }
    }

    static int check() {

        for (int i = 0; i < n; i++) {
            Arrays.fill(v[i], false);
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1 || v[i][j])
                    continue;
                bfs(i, j);
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int q;

        char[] row;

        String o;
        int x, y, z;

        queue = new LinkedList<>();

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            v = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                row = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    map[i][j] = row[j] - '0';
                }
            }

            q = Integer.parseInt(br.readLine());

            sb.append("Case #").append(t).append(":\n");

            while (q-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");

                o = st.nextToken();

                switch (o) {
                case "Q":
                    sb.append(check()).append("\n");
                    break;
                case "M":
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    z = Integer.parseInt(st.nextToken());

                    map[x][y] = z;
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}