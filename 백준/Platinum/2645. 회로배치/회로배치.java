import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,k;
	static boolean[][] occupied;
	static int[][][] bef;
	static int[][] dp;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int endx,endy,startx,starty;
		st = new StringTokenizer(br.readLine());
		endx = Integer.parseInt(st.nextToken())-1;
		endy = Integer.parseInt(st.nextToken())-1;
		startx = Integer.parseInt(st.nextToken())-1;
		starty = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		bef = new int[n][n][2];
		for(int i = 0;i<n;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);				
		}
		occupied = new boolean[n][n];
		int m = Integer.parseInt(br.readLine());
		int r,a,b,c,d;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			for(int j = 1;j<r;j++) {
				c = Integer.parseInt(st.nextToken())-1;
				d = Integer.parseInt(st.nextToken())-1;
				for(int x = (a<c?a:c);x<=(a<c?c:a);x++) {
					for(int y = (b<d?b:d);y<=(b<d?d:b);y++) {
						occupied[x][y] = true;
					}
				}
				a = c;
				b = d;
			}
		}
				
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		dp[startx][starty] = occupied[startx][starty]?k:1;
		q.add(new int[] {startx,starty,dp[startx][starty]});
		int[] now;
		int x,y,nc;
		while(!q.isEmpty()) {
			now = q.poll();
			a = now[0];
			b = now[1];
			c = now[2];
			if(dp[a][b]<c)
				continue;
			if(a == endx &&b==endy) {
				break;
			}
			for(int i = 0;i<4;i++) {
				x = a+dx[i];
				y = b+dy[i];
				if(!inRange(x,y))
					continue;
				nc = c+(occupied[x][y]?k:1);
				if(dp[x][y]<=nc)
					continue;
				dp[x][y] = nc;
				bef[x][y][0] = a;
				bef[x][y][1] = b;
				q.add(new int[] {x,y,nc});
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(dp[endx][endy]);
		int x1,x2,x3,y1,y2,y3;
		x1 = endx;
		y1 = endy;
		sb.append(" ").append(x1+1).append(" ").append(y1+1).append(" ");
		int cnt = 1;
		while(x1!=startx||y1!=starty) {
			x2 = bef[x1][y1][0];
			y2 = bef[x1][y1][1];
			while(true) {
				x3 = bef[x2][y2][0];
				y3 = bef[x2][y2][1];
				if(x1!=x3&&y1!=y3)
					break;
				x2 = x3;
				y2 = y3;
			}
			x1 = x2;
			y1 = y2;
			cnt++;
			sb.append(x1+1).append(" ").append(y1+1).append(" ");
		}
		System.out.print(cnt);
		System.out.print(sb);
	}
}