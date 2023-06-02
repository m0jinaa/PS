import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] v;
    static char[][] map;
    static LinkedList<Point> q;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    static void bfs(int x, int y) {
        q.clear();

        q.add(new Point(x, y));
        v[x][y] = true;

        Point now;
        int nx, ny;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || map[nx][ny] == '.' || v[nx][ny])
                    continue;
                v[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int answer;
        q = new LinkedList<>();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            answer = 0;
            map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }
            v = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '#' && !v[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}