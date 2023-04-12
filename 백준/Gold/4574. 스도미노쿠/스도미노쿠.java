import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[][] map;
    static ArrayList<Point> points;
    static boolean[][] domino;
    static StringBuilder sb;
    static int n;
    public static int check(int x, int y, int z) { // (x,y)에 z를 넣고 싶은데 가능?
        int bx = (x / 3) * 3;
        int by = (y / 3) * 3;

        for (int i = 0; i < 9; i++) {
            // 가로
            if (map[x][i] == z)
                return 1;

            // 세로
            if (map[i][y] == z)
                return 2;

            // 정사각형
            if (map[bx + i / 3][by + i % 3] == z)
                return 3;
        }
        return 0;

    }

    public static boolean combi(int ind) {

        if(ind==points.size()) {
            for(int[] row:map) {
                for(int x: row) {
                    sb.append(x);
                }
                sb.append("\n");
            }
            return true;
        }
        int x = points.get(ind).x;
        int y = points.get(ind).y;
        if(map[x][y]!=0) {
            return combi(ind+1);
        }
        else {
            for(int i = 1;i<=9;i++) {
                //(x,y)에 i 못놓아
                if(check(x,y,i)!=0)
                    continue;
                map[x][y] = i;
                //오른쪽
                if(y+1<9 && map[x][y+1]==0) {
                    for(int j = 1;j<=9;j++) {
                        if(i==j || domino[i][j] || check(x,y+1,j)!=0)
                            continue;                   
                        domino[i][j] = domino[j][i] = true;
                        map[x][y+1] = j;
                        if(combi(ind+1)) {
                            map[x][y+1] = 0;
                            return true;
                        }
                        map[x][y+1] = 0;
                        domino[i][j] = domino[j][i] = false;
                    }
                }
                //아래쪽
                if(x+1<9 && map[x+1][y]==0) {
                    for(int j = 1;j<=9;j++) {
                        if(i==j || domino[i][j] || check(x+1,y,j)!=0)
                            continue;                   
                        domino[i][j] = domino[j][i] = true;
                        map[x+1][y] = j;
                        if(combi(ind+1)) {
                            map[x+1][y] = 0;
                            return true;
                        }
                        map[x+1][y] = 0;
                        domino[i][j] = domino[j][i] = false;
                    }
                }
                map[x][y] = 0;
            }
            return false;   
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        points = new ArrayList<Point>();
        int u, ux, uy, v, vx, vy;
        String loc;
        int cnt = 1;
        map = new int[9][9];
        domino = new boolean[10][10];
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            points.clear();
            for(int i = 1;i<10;i++) {
                Arrays.fill(domino[i], false);
                Arrays.fill(map[i-1], 0);
            }
            // 도미노
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());

                loc = st.nextToken();

                ux = loc.charAt(0) - 'A';
                uy = loc.charAt(1) - '1';

                v = Integer.parseInt(st.nextToken());

                loc = st.nextToken();

                vx = loc.charAt(0) - 'A';
                vy = loc.charAt(1) - '1';

                map[ux][uy] = u;
                map[vx][vy] = v;

                domino[u][v] = true;
                domino[v][u] = true;

            }

            // 숫자
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= 9; i++) {
                loc = st.nextToken();

                ux = loc.charAt(0) - 'A';
                uy = loc.charAt(1) - '1';

                map[ux][uy] = i;
            }

            // 빈칸 찾기
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 0) {
                        points.add(new Point(i, j));
                    }
                }
            }

            sb.append("Puzzle ").append(cnt++).append("\n");
            // 모든 경우의 수 살펴보기
            combi(0);

        }
        System.out.println(sb.toString());
    }
}