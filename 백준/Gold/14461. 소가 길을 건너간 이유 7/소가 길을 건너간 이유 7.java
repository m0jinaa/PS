import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,t;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][][] dp;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		dp = new int[n][n][3];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[3]-n2[3]);
		q.add(new int[] {0,0,2,0});
		int[] now;
		int x,y,d,time,nx,ny,nd,nt;
		int answer = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			d = now[2];
			time = now[3];
			if(dp[x][y][d]<time)
				continue;
			if(x==n-1&&y==n-1) {
				answer = time;
				break;
			}
				
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				
				if(!inRange(nx,ny))
					continue;
				nt = time+(d==0?map[nx][ny]:0)+t;
				nd = d==0?2:d-1;
				if(dp[nx][ny][nd]>nt) {
					dp[nx][ny][nd] = nt;
					q.offer(new int[] {nx,ny,nd,nt});
				}
			}
		}
		System.out.println(answer);	
	}
}