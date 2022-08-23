import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	
	static void RGB(int a, int b) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.offer(a);
		qy.offer(b);
		v[a][b] = true;
		int x,y,nx,ny;
		int val = map[a][b];
		while(!qx.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny)||map[nx][ny]!=val||v[nx][ny])
					continue;
				
				v[nx][ny] = true;
				qx.offer(nx);
				qy.offer(ny);
				
			}
		}
	}
	static void RRB(int a, int b) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.offer(a);
		qy.offer(b);
		v[a][b] = true;
		int x,y,nx,ny;
		int val = Math.abs(map[a][b]);
		while(!qx.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny)||Math.abs(map[nx][ny])!=val||v[nx][ny])
					continue;
				
				v[nx][ny] = true;
				qx.offer(nx);
				qy.offer(ny);
				
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[] arr;
		map = new int[n][n];
		v = new boolean[n][n];
		for(int i = 0;i<n;i++) {
			arr = br.readLine().toCharArray();
			for(int j = 0;j<n;j++) {
				switch(arr[j]) {
				case 'R':
					map[i][j] = 1;
					break;
				case'G':
					map[i][j] = -1;
					break;
				case'B':
					map[i][j] = 0;
					break;
				}
			}
		}
		int rgb = 0;
		int rrb = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(!v[i][j]) {
					rgb++;
					RGB(i,j);
				}
			}
		}
		v = new boolean[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(!v[i][j]) {
					rrb++;
					RRB(i,j);
				}
			}
		}	
		System.out.println(rgb+" "+rrb);
	}
}
