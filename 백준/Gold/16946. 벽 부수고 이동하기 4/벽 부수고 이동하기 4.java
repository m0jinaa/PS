import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int bfs(int[][] g, boolean[][] v,int a, int b) {
		int cnt = 1;
		LinkedList<Point> q = new LinkedList<Point>();
		q.add(new Point(a,b));
		int n = g.length;
		int m = g[0].length;
		
		v[a][b] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0;i<4;i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				if(0>x||x>=n||0>y||y>=m||g[x][y]==1||v[x][y])
					continue;
				if(g[x][y]==0) {
					v[x][y] = true;
					g[x][y] = g[a][b];
					cnt++;
					q.add(new Point(x,y));
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i = 0;i<n;i++) {
			String s = br.readLine();
			for(int j = 0;j<m;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		boolean[][] v = new boolean[n][m];
		int number = 2;
		ArrayList<Integer> count = new ArrayList<Integer>();
		count.add(0);
		count.add(0);
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(map[i][j] == 0&&!v[i][j]) {
					v[i][j] = true;
					map[i][j] = number;
					count.add(bfs(map,v,i,j));
					number++;
				}
			}
		}
		sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(map[i][j] == 1) {
					int c = 1;
					boolean[] visited = new boolean[count.size()];
					for(int k = 0;k<4;k++) {
						int x = i+dx[k];
						int y = j+dy[k];
						if(0>x||x>=n||0>y||y>=m||visited[map[x][y]])
							continue;
						c+=count.get(map[x][y]);
						visited[map[x][y]]=true;
						
					}
					sb.append(Integer.toString(c%10));
				}
				else
					sb.append("0");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
