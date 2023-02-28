import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

    static boolean inRange(int a, int b) {
        if (a < 0 || a >= n || b < 0 || b >= m)
            return false;
        return true;
    }

    static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int sx = 0, sy = 0;
        char[] arr;
        for (int i = 0; i < n; i++) {
            arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j]-'0';
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        LinkedList<Node> q = new LinkedList<Node>();

        boolean[][] v = new boolean[n][m];

        v[sx][sy] = true;

        q.add(new Node(sx, sy, 0));
        Node now;

        int nx, ny;
        int ans = -1;
        end: while (!q.isEmpty()) {
            now = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                nx = now.x+dx[i];
                ny = now.y+dy[i];

                if(!inRange(nx,ny)||v[nx][ny] || map[nx][ny]==1)
                    continue;

                if(map[nx][ny] == 0) {
                    v[nx][ny] = true;
                    q.add(new Node(nx,ny,now.d+1));
                }
                else {
                    ans = now.d+1;
                    break end;
                }
            }
        }

        if(ans==-1) {
            System.out.println("NIE");
        }
        else {
            System.out.println("TAK\n"+ans);
        }
    }
}
