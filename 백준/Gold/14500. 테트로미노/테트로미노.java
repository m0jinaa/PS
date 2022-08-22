import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[][] map;
	static int answer;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	static void dfs(int a, int b,int cnt,int sum) {
		if(cnt==4) {
			answer = answer<sum?sum:answer;
			return;
		}
		int x,y;
		for(int i = 0;i<4;i++) {
			x = a+dx[i];
			y = b+dy[i];
			if(!inRange(x,y)||visited[x][y])
				continue;
			visited[x][y] = true;
			dfs(x,y,cnt+1,sum+map[x][y]);
			visited[x][y] = false;
		}
	}
	static void bfs(int a, int b) {
		int sum = map[a][b];
		int min = 1001;
		int cnt = 0;
		int x,y;
		for(int i = 0;i<4;i++) {
			x = a+dx[i];
			y = b+dy[i];
			if(!inRange(x,y))
				continue;
			cnt++;
			min = min>map[x][y]?map[x][y]:min;
			sum+=map[x][y];
		}
		if(cnt==3)
			answer = answer<sum?sum:answer;
		else if(cnt==4)
			answer = answer<sum-min?sum-min:answer;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				bfs(i,j);
			}
		}
		System.out.println(answer);
	}
}