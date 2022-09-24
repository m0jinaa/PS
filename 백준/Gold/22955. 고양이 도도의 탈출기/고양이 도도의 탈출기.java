import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static char[][] map;
	static int[][] cost;
	static int INF=Integer.MAX_VALUE;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][];
		cost = new int[n][m];
		
		int sx = 0,sy = 0,ex = 0,ey = 0;
		for(int i = 0;i<n;i++) {
			Arrays.fill(cost[i], INF);
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(map[i][j] == 'C') {
					sx = i;
					sy = j;
					map[i][j] = 'F';
				}
				else if(map[i][j] == 'E') {
					ex = i;
					ey = j;
					map[i][j] = 'F';
				}
			}
		}
		
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		q.add(new int[] {sx,sy,0});
		cost[sx][sy] = 0;
		int[] now;
		int x,y,nx,ny,c,nc;
		int answer = -1;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			c = now[2];
			if(cost[x][y]<c)
				continue;
			if(x==ex && y==ey) {
				answer = c;
				break;
			}
			
			switch(map[x][y]) {
			case 'L':
				//left
				nx = x-1;
				ny = y;
				nc = c+5;
				if(inRange(nx,ny) && map[nx][ny]!='D' && cost[nx][ny]>nc) {
					cost[nx][ny] = nc;
					q.add(new int[] {nx,ny,nc});
				}				
			case 'F':
				//right
				nx = x;
				ny = y+1;
				nc = c+1;
				if(inRange(nx,ny) && map[nx][ny]!='D' && cost[nx][ny]>nc) {
					cost[nx][ny] = nc;
					q.add(new int[] {nx,ny,nc});
				}
				//left
				nx = x;
				ny = y-1;
				nc = c+1;
				if(inRange(nx,ny) && map[nx][ny]!='D' && cost[nx][ny]>nc) {
					cost[nx][ny] = nc;
					q.add(new int[] {nx,ny,nc});
				}
				//down
				nx = x+1;
				ny = y;
				nc = c+5;
				if(inRange(nx,ny) && map[nx][ny]=='L' && cost[nx][ny]>nc) {
					cost[nx][ny] = nc;
					q.add(new int[] {nx,ny,nc});
				}			
				break;
			case 'X':
				nx = x+1;
				ny = y;
				if(inRange(nx,ny)&&(map[nx][ny]=='F'||map[nx][ny]=='L')) {
					nc = c+10;
					if(cost[nx][ny]>nc) {
						cost[nx][ny] = nc;
						q.add(new int[] {nx,ny,nc});
					}
				}
				else if(inRange(nx,ny)&&map[nx][ny]=='X') {
					nc = c;
					if(cost[nx][ny]>nc) {
						cost[nx][ny] = nc;
						q.add(new int[] {nx,ny,nc});
					}					
				}
				break;
			}
		}
		System.out.println(answer==-1?"dodo sad":answer);
    }
}