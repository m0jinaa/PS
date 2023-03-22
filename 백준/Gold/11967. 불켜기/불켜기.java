import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	
	static boolean inRange(int a, int b) {
		if(a<0 || a>=n || b<0 || b>=n)
			return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] buttons = new ArrayList[n*n];
		
		boolean[][] light = new boolean[n][n];
		boolean[][] canGo = new boolean[n][n];
		boolean[][] visited = new boolean[n][n];
		
		light[0][0] = canGo[0][0] = visited[0][0] = true;
		
		LinkedList<Point> q = new LinkedList<Point>();
		int x,y;
		
		for(int i = 0;i<n*n;i++) {
			buttons[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = (Integer.parseInt(st.nextToken())-1)*n+(Integer.parseInt(st.nextToken())-1);
			y = (Integer.parseInt(st.nextToken())-1)*n+(Integer.parseInt(st.nextToken())-1);
			
			buttons[x].add(y);
		}
		
		q.add(new Point(0,0));
		int cnt = 1;
		int nx,ny;
		Point now;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now.x*n+now.y;
			for(int i:buttons[x]) {
				if(light[i/n][i%n])
					continue;
				cnt++;
				light[i/n][i%n] = true;
				if(canGo[i/n][i%n] && !visited[i/n][i%n]) {
					visited[i/n][i%n] = true;
					q.add(new Point(i/n,i%n));
				}
			}
			
			for(int i = 0;i<4;i++) {
				nx = now.x+dx[i];
				ny = now.y+dy[i];
				if(!inRange(nx,ny) || visited[nx][ny])
					continue;
				canGo[nx][ny] = true;
				if(light[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny));
				}
			}
		}
		System.out.println(cnt);
	
	}
}