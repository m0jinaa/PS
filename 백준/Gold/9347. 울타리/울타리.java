import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };
    static PriorityQueue<Node> pq;
    static LinkedList<Node> q;
    static int fence, flower;

    static class Node implements Comparable<Node> {
        int x, y, f;

        public Node(int x, int y, int f) {
            super();
            this.x = x;
            this.y = y;
            this.f = f;
        }

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    static int countFlower(int x, int y, int f) {
        q.clear();

        q.add(new Node(x, y));
        v[x][y] = true;

        int cnt = 0;

        Node now;
        int nx, ny;

        while (!q.isEmpty()) {
            now = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];
                if (!inRange(nx, ny) || v[nx][ny])
                    continue;
                v[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    pq.add(new Node(nx, ny, f + 1));
                } else {
                    q.add(new Node(nx, ny));
                }
            }
        }

        return cnt;
    }

    static void bfs() {
        pq.clear();
        int cnt = 0;

        // 경계부분 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && i != n - 1 && j != 0 && j != m - 1)
                    continue;
                if (v[i][j])
                    continue;

                if (map[i][j] == 0) {
                    cnt = countFlower(i, j, 0);
                    fence = 0;
                    flower = Math.max(cnt, flower);
                } else {
                    pq.add(new Node(i, j, 1));
                    v[i][j] = true;
                }
            }
        }

        int sum = 0;

        Node now;
        int nx, ny, nf;

        while (!pq.isEmpty()) {
            now = pq.poll();
            sum = 0;
            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!inRange(nx, ny) || v[nx][ny])
                    continue;

                if (map[nx][ny] == 1) {// 울타리
                    nf = now.f + 1;
                    v[nx][ny] = true;
                    pq.add(new Node(nx, ny, nf));
                } else { // 화원
                    sum += countFlower(nx, ny, now.f);
                }
            }

            if (sum == 0) {
                continue;
            } else if (fence < now.f) {
                fence = now.f;
                flower = sum;
            } else if (fence == now.f) {
                flower += sum;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        q = new LinkedList<>();

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            fence = -1;
            flower = -1;

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            v = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

            sb.append(fence).append(" ").append(flower).append("\n");
        }

        System.out.print(sb.toString());
    }
}