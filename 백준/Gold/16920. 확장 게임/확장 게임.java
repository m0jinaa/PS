import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

    static boolean inRange(int a, int b) {
        if (a < 0 || a >= n || b < 0 || b >= m)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        LinkedList<Point>[] q = new LinkedList[p + 1];

        int[] s = new int[p + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= p; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            if(s[i]>n*m) {
                s[i] = n*m;
            }
            q[i] = new LinkedList<Point>();
        }

        int[][] map = new int[n][m];

        char[] arr;
        int[] cnt = new int[p + 1];
        for (int i = 0; i < n; i++) {
            arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (arr[j] == '.')
                    continue;
                else if (arr[j] == '#') {
                    map[i][j] = -1;
                    continue;
                }
                map[i][j] = arr[j] - '0';
                cnt[map[i][j]]++;
                q[map[i][j]].add(new Point(i, j));
            }
        }

        int c = 0;
        Point now;
        int nx, ny;
        while (true) {
            c = 0;
            for (int i = 1; i <= p; i++) {
                if (q[i].size() == 0)
                    c++;
                for (int j = 0; j < s[i]; j++) {
                    int qsize = q[i].size();
                    if(qsize==0)
                        break;
                    while (qsize-- > 0) {
                        now = q[i].poll();

                        for(int k = 0;k<4;k++) {
                            nx = now.x+dx[k];
                            ny = now.y+dy[k];
                            if(!inRange(nx,ny) 
                                    || map[nx][ny]!=0)
                                continue;
                            map[nx][ny] = i;
                            cnt[i]++;
                            q[i].add(new Point(nx,ny));

                        }
                    }
                }
            }

            if (c == p)
                break;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<=p;i++) {
            sb.append(cnt[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

}