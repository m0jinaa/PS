import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][] map;
	static int[][] v;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		v = new int[n][n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		
		v[0][0] = 0;
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		q.add(new int[] {0,0,0});
		int[] now;
		int x,y,c,nx,ny,nc;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			c = now[2];
			if(x==n-1&&y==n-1)
				break;
			if(v[x][y]<c)
				continue;
			
			for(int i = 0;i<2;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny))
					continue;
				nc = c+(map[nx][ny]>=map[x][y]?map[nx][ny]-map[x][y]+1:0);
				if(v[nx][ny]<=nc)
					continue;
				v[nx][ny] = nc;
				q.add(new int[] {nx,ny,nc});
			}
		}
		System.out.println(v[n-1][n-1]);
	}
}