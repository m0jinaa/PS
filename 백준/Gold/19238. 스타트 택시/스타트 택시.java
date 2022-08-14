import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][] v;
	static boolean[] done;
	static int[][] passengers;
	static int[][] destinations;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	static void getFastestRoute(int a, int b) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		for(int i = 0;i<n;i++) {
			Arrays.fill(v[i], -1);
		}
		q.offer(new int[] {a,b});
		v[a][b] = 0;
		int x,y,nx,ny;
		int[] now;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(inRange(nx,ny)&&map[nx][ny]!=1&&v[nx][ny]==-1) {
					v[nx][ny] = v[x][y]+1;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	static boolean notDone() {
		for(boolean b:done) {
			if(!b)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		v = new int[n][n];
		map = new int[n][n];
		done = new boolean[m];
		passengers = new int[m][2];
		destinations = new int[m][2];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer (br.readLine()," ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		
		int startx = Integer.parseInt(st.nextToken())-1;
		int starty = Integer.parseInt(st.nextToken())-1;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			passengers[i][0] = Integer.parseInt(st.nextToken())-1;
			passengers[i][1] = Integer.parseInt(st.nextToken())-1;
			destinations[i][0] = Integer.parseInt(st.nextToken())-1;
			destinations[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		int cnt,nx=0,ny=0,a,b,ind= -1,destx,desty;
		end: while(notDone()) {	
			cnt = Integer.MAX_VALUE;
			getFastestRoute(startx, starty);
			for(int i = 0;i<m;i++) {
				if(done[i])
					continue;

				a = passengers[i][0];
				b = passengers[i][1];
				if(v[a][b]==-1) {
					fuel = -1;
					break end;
				}
				if(v[a][b]<cnt) {
					nx = a;
					ny = b;
					cnt = v[a][b];
					ind = i;
				}
				else if(v[a][b]==cnt && (a<nx||(a==nx &&b<ny))) {
					nx = a;
					ny = b;
					ind = i;
				}
			}
			
			if(cnt>fuel) {
				fuel = -1;
				break;
			}
			fuel-=cnt;
			
			getFastestRoute(nx,ny);
			destx = destinations[ind][0];
			desty = destinations[ind][1];
			if(v[destx][desty] == -1 || v[destx][desty]>fuel) {
				fuel = -1;
				break;
			}
			
			fuel+=v[destx][desty];
			done[ind] = true;
			startx = destx;
			starty = desty;
		}		
		System.out.println(fuel);
	}
}
