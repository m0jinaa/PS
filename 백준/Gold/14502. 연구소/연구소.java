import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][] graph;
	static int answer;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<int[]> virus = new ArrayList<int[]>();
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void init() {
		graph = new int[n][];
		for(int i = 0;i<n;i++) {
			graph[i] = Arrays.copyOf(map[i], m);
		}
		q.clear();
		q.addAll(virus);
	}
	public static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static int spreadVirus() {
		int[] now;
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny)||graph[nx][ny]!=0)
					continue;
				graph[nx][ny] = 2;
				q.offer(new int[] {nx,ny});
			}
		}
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(graph[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					virus.add(new int[] {i,j});
			}
		}

		int limit = n*m;
		for(int i = 0;i<limit;i++) {
			if(map[i/m][i%m]!=0)
				continue;
			for(int j = i+1;j<limit;j++) {
				if(map[j/m][j%m]!=0)
					continue;
				for(int k = j+1;k<limit;k++) {
					if(map[k/m][k%m]!=0)
						continue;
					map[i/m][i%m]=map[j/m][j%m]=map[k/m][k%m]=1;
					init();
					answer = Math.max(answer,spreadVirus());
					map[i/m][i%m]=map[j/m][j%m]=map[k/m][k%m]=0;
				}
			}
		}
		System.out.println(answer);
	}
}