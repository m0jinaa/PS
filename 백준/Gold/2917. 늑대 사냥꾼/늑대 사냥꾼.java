import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static char[][] map;
	static int[][] tree;
	static int[][] dist;
	static Queue<int[]> tq;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][];
		tree = new int[n][m];
		dist = new int[n][m];
		tq = new LinkedList<int[]>();
		int startx=0,starty=0,endx=0,endy=0;
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n2[2]-n1[2]);
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(tree[i], Integer.MAX_VALUE);
			for(int j = 0;j<m;j++) {
				if(map[i][j] == '+') {
					tq.add(new int[] {i,j,0});
					tree[i][j] = 0;
				}
				else if(map[i][j] =='V') {
					startx = i;
					starty = j;
				}
				else if(map[i][j] =='J') {
					endx = i;
					endy = j;
				}
			}
		}
		int[] now;
		int x,y;
		while(!tq.isEmpty()) {
			now = tq.poll();
			for(int i = 0;i<4;i++) {
				x = now[0]+dx[i];
				y = now[1]+dy[i];
				if(!inRange(x,y)||tree[x][y]<=now[2]+1) {
					continue;
				}
				tree[x][y] = now[2]+1;
				tq.offer(new int[] {x,y,tree[x][y]});
			}
		}
		
		q.offer(new int[] {startx,starty,tree[startx][starty]});
		dist[startx][starty] = tree[startx][starty];
		int nx,ny,nd;
		int answer = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			if(now[0] == endx &&now[1]==endy) {
				answer = dist[endx][endy];
			}
			if(dist[now[0]][now[1]]<now[2])
				continue;
			for(int i = 0;i<4;i++) {
				nx = now[0]+dx[i];
				ny = now[1]+dy[i];
				if(!inRange(nx,ny))
					continue;
				nd = Math.min(now[2], tree[nx][ny]);
				if(dist[nx][ny]>=nd)
					continue;
				dist[nx][ny] = nd;
				q.add(new int[] {nx,ny,nd});
			}
		}
		System.out.println(answer);
	}
}