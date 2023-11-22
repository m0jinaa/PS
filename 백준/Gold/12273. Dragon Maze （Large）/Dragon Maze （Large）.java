import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, sx, sy, ex, ey;
    static int[][] v;
    static int[][] dist;
    static int[][] map;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };
    static LinkedList<Node> q;
    static final int INF = 1_000_000_007;

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    static class Node {
        int x, y, d, p;

        public Node(int x, int y, int d, int p) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
            this.p = p;
        }
    }

    static int getMax() {
        if (map[sx][sy] == -1 || map[ex][ey] == -1)
            return -1;

        int answer = -1;
        q.clear();

        q.add(new Node(sx, sy, 0, map[sx][sy]));
        Node now;
        dist[sx][sy] = 0;
        int nx, ny, np;

        while (!q.isEmpty()) {
            now = q.poll();
            if (v[now.x][now.y] > now.p)
                continue;
            else if (now.x == ex && now.y == ey) {
                answer = now.p;
                break;
            }
            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];
                
                if (!inRange(nx, ny) || map[nx][ny] == -1 || dist[nx][ny] < now.d + 1)
                    continue;
                
                np = now.p + map[nx][ny];
                
                if (v[nx][ny] >= np)
                    continue;
                
                v[nx][ny] = np;
                dist[nx][ny] = now.d + 1;
                
                q.add(new Node(nx, ny, now.d + 1, np));
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int answer;
        q = new LinkedList<>();

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            v = new int[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                Arrays.fill(dist[i], INF);
                
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = getMax();
            
            sb.append("Case #").append(t).append(": ").append(answer == -1 ? "Mission Impossible." : answer)
                    .append("\n");
        }

        System.out.print(sb.toString());
    }
}