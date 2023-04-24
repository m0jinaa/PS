import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] dx = new int[] {1,-1,0,0}, dy = new int[]{0,0,1,-1};
    static int n,m,answer;
    static int[][] map;
    static boolean[][] escape,visited;

    static boolean inRange(int a, int b) {
        if(a<0 || a>=n || b<0 || b>=m)
            return false;
        return true;
    }

    static boolean dfs(int x, int y, int c) {
        int nx = x+dx[map[x][y]];
        int ny = y+dy[map[x][y]];
        if(!inRange(nx,ny)) {
            answer+=c;
            return escape[x][y] = true;
        }
        else if(!visited[nx][ny]) {
            visited[nx][ny] = true;
            return escape[x][y] = dfs(nx,ny,c+1);
        }
        else if(escape[nx][ny]) {
            answer+=c;
            return escape[x][y] = true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[n][m];
        escape = new boolean[n][m];
        visited = new boolean[n][m];

        char[] arr;

        for(int i = 0;i<n;i++) {

            arr = br.readLine().toCharArray();

            for(int j = 0;j<m;j++) {
                switch(arr[j]) {
                case 'U':
                    map[i][j] = 1;
                    break;

                case 'D':
                    map[i][j] = 0;
                    break;

                case 'L':
                    map[i][j] = 3;
                    break;

                default:
                    map[i][j] = 2;
                    break;
                }
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(visited[i][j])
                    continue;
                visited[i][j] = true;
                dfs(i,j,1);
            }
        }

        System.out.println(answer); 
    }
}