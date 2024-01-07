import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int n = 8;
    static int[] dx = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
    static int[] dy = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

    static boolean[][] board;

    static class Node {
        int x, y, c;

        public Node(int x, int y, int c) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return false;
        return true;
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(sx, sy, 0));
        board[sx][sy] = true;

        Node now;
        int nx, ny;

        int answer = -1;

        while (!q.isEmpty()) {
            now = q.poll();

            if (now.x == ex && now.y == ey) {
                answer = now.c;
                break;
            }

            for (int i = 0; i < 8; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || board[nx][ny])
                    continue;
                board[nx][ny] = true;

                q.add(new Node(nx, ny, now.c + 1));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] start = br.readLine().toCharArray();
        int sx = start[0] - 'a';
        int sy = start[1] - '1';

        char[] end = br.readLine().toCharArray();
        int ex = end[0] - 'a';
        int ey = end[1] - '1';

        board = new boolean[n][n];

        int answer = bfs(sx, sy, ex, ey);

        System.out.println(answer);
    }
}