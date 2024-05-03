import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] v;
    static LinkedList<Mineral> q;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };

    static class Mineral {
        int x, y;

        public Mineral(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static boolean inRange(int x, int y) {
        if (x < 0 || x >= r || y < 0 || y >= c)
            return false;
        return true;
    }

    public static int checkCluster() {
        q.clear();

        int cnt = 0;

        for (int i = 0; i < r; i++) {
            Arrays.fill(v[i], false);
        }

        for (int i = 0; i < c; i++) {
            if (map[r - 1][i] == 'x') {
                q.add(new Mineral(r - 1, i));
                v[r - 1][i] = true;
                cnt++;
            }
        }

        Mineral now;
        int nx, ny;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || map[nx][ny] == '.' || v[nx][ny])
                    continue;
                v[nx][ny] = true;
                cnt++;
                q.add(new Mineral(nx, ny));
            }
        }

        return cnt;
    }

    public static int throwBar(int h, int d) {

        if (d == 0) {
            for (int i = 0; i < c; i++) {
                if (map[h][i] == 'x') {
                    map[h][i] = '.';
                    return 1;
                }
            }
        } else {
            for (int i = c - 1; i >= 0; i--) {
                if (map[h][i] == 'x') {
                    map[h][i] = '.';
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void dropCluster() {
        int h = r - 1;

        // 얼마나 떨어뜨려야할지 계산
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (v[i][j] || map[i][j] == '.')
                    continue;
                h = Math.min(h, r - 1 - i);

                for (int k = 1; k < r - i; k++) {
                    if (map[i + k][j] == 'x' && v[i + k][j]) {
                        h = Math.min(h, k - 1);
                        break;
                    }
                }
            }
        }

        // 떨어뜨리기
        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                if (v[i][j] || map[i][j] == '.')
                    continue;
                map[i + h][j] = 'x';
                v[i + h][j] = true;
                map[i][j] = '.';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        map = new char[r][];
        v = new boolean[r][c];

        int cnt = 0;

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x') {
                    cnt++;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        int h;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            h = r - Integer.parseInt(st.nextToken());
            cnt -= throwBar(h, i % 2);

            if (cnt != checkCluster()) {
                dropCluster();
            }
        }

        for (int i = 0; i < r; i++) {
            sb.append(String.valueOf(map[i])).append("\n");
        }

        System.out.print(sb.toString());
    }
}