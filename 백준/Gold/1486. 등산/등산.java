import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,t,d;
	static int[][] asc;
	static int[][] desc;
	static int[][] map;
	static Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);

	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	static void ascending() {
		q.add(new int[] {0,0,0});
		asc[0][0] = 0;
		int[] now;
		int x,y,time,nx,ny,nt;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			time = now[2];
			//System.out.println(x+ " "+y+ " "+time+ " "+h);
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny)||Math.abs(map[x][y]-map[nx][ny])>t||nx==0&&ny==0)
					continue;
				if(map[x][y]>=map[nx][ny])
					nt = time+1;
				else
					nt = time+(int)Math.pow(map[x][y]-map[nx][ny],2);
				if(nt>d)
					continue;
				if(asc[nx][ny]>nt) {
					asc[nx][ny] = nt;
					q.offer(new int[] {nx,ny,nt});
				}
			}
		}
	}
	static void descending() {
		q.clear();
		q.add(new int[] {0,0,0});
		desc[0][0] = 0;
		int[] now;
		int x,y,time,nx,ny,nt;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			time = now[2];
			//System.out.println(x+ " "+y+ " "+time+ " "+h);
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny)||Math.abs(map[x][y]-map[nx][ny])>t||nx==0&&ny==0)
					continue;
				if(map[x][y]>map[nx][ny])
					nt = time+(int)Math.pow(map[x][y]-map[nx][ny],2);
				else
					nt = time+1;
				if(nt>d)
					continue;
				if(desc[nx][ny]>nt) {
					desc[nx][ny] = nt;
					q.offer(new int[] {nx,ny,nt});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		char[] arr;
		map = new int[n][m];
		asc = new int[n][m];
		desc = new int[n][m];
		int limit = d*2;
		for(int i = 0;i<n;i++) {
			arr = br.readLine().toCharArray();
			Arrays.fill(asc[i], limit);
			Arrays.fill(desc[i], limit);
			for(int j = 0;j<m;j++) {
				if(arr[j]<=90)//대문자
					map[i][j] = arr[j]-65;
				else//소문자
					map[i][j] = arr[j]-71;
			}
		}
		int answer = map[0][0];
		ascending();
		descending();
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(asc[i][j]+desc[i][j]<=d)
					answer = answer<map[i][j]?map[i][j]:answer;
			}
		}
		System.out.println(answer);
	}
}