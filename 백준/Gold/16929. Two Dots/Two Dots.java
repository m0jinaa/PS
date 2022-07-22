import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean inRange(int n,int m,int a,int b) {
		if(0>a||a>=n||0>b||b>=m)
			return false;
		return true;
	}
	
	static boolean dfs(char[][] g, int[][] v, int a, int b) {
		LinkedList<Point> q = new LinkedList<Point>();
		int n = g.length;
		int m = g[0].length;
		
		v[a][b] = 0;
		
		q.add(new Point(a,b));
		
		while(!q.isEmpty()) {
			Point p = q.pollLast();
			for(int i= 0;i<4;i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				
				if(inRange(n,m,x,y)&&g[x][y] == g[a][b]) {
					if(v[x][y]==n*m+1) {
						v[x][y] = v[p.x][p.y]+1;
						q.add(new Point(x,y));
					}
					else if(v[x][y] != v[p.x][p.y]-1) {
						return true;
					}
				}	
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] v = new int[n][m];
		char[][] map = new char[n][m];
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(v[i], n*m+1);
		}
		boolean exist = false;
		end:for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(v[i][j]==n*m+1) {
					if(dfs(map,v,i,j)) {
						exist=true;
						break end;
					}
				}
			}
		}		
		if(exist)
			System.out.println("Yes");
		else
			System.out.println("No");		
	}
}