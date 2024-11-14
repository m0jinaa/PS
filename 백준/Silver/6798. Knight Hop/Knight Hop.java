import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] v;
    static int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

    static boolean inRange(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8)
            return false;
        return true;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    static int getDist(int sx, int sy, int ex, int ey) {
        for (int i = 1; i <= 8; i++) {
            Arrays.fill(v[i], -1);
        }

        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(sx, sy));
        v[sx][sy] = 0;

        Node now;
        int nx, ny;

        while (!q.isEmpty() && v[ex][ey] == -1) {
            now = q.poll();

            for (int i = 0; i < 8; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || v[nx][ny] != -1)
                    continue;
                v[nx][ny] = v[now.x][now.y] + 1;
                q.add(new Node(nx, ny));
            }
        }
        return v[ex][ey];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        v = new int[9][9];

        System.out.println(getDist(sx, sy, ex, ey));
    }
}