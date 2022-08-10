import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static char[][] map;
	static ArrayList<Point> dirt;
	static int[] order;
	static int k;
	static int x,y;
	static int[][] visited;
	static int[][][] distance;
	static boolean[] isSelected;
	static int answer;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	static void bfs(Point p) {
		visited[p.x][p.y] = 0;
		int x,y,nx,ny;
		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		while(!q.isEmpty()) {
			Point now = q.poll();
			x = now.x;
			y = now.y;
			
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(inRange(nx,ny) && map[nx][ny]!='x'&&visited[nx][ny] == -1) {
					visited[nx][ny] = visited[x][y]+1;
					q.offer(new Point(nx,ny));
				}
			}
		}
	}
	
	static void getMoveCount() {
		int cnt = 0;
		int o;
		for(int i = 0;i<k;i++) {
			Point p = dirt.get(order[i+1]);
			o = order[i];
			if(distance[o]==null) {
				for(int j = 0;j<n;j++) {
					Arrays.fill(visited[j], -1);
				}
				bfs(dirt.get(o));
				distance[o] = new int[n][m];
				for(int j = 0;j<n;j++) {
					distance[o][j] = Arrays.copyOf(visited[j], m);
				}
			}
				
			int val = distance[o][p.x][p.y];
			if (val==-1) {
				answer = -1;
				return;
			}
			cnt+=val;	
		}
		if(cnt<answer)
			answer = cnt;		
	}
	static void permutation(int i) {
		if(answer == -1)
			return;
		if(i==k+1) {
			getMoveCount();
		}
		else {
			for(int j = 0;j<k;j++) {
				if(isSelected[j])
					continue;
				isSelected[j] = true;
				order[i] = j;
				permutation(i+1);
				isSelected[j] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(n==0&&m==0)break;
			dirt = new ArrayList<Point>();
			map = new char[n][];
			for(int i = 0;i<n;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0;j<m;j++) {
					if(map[i][j] == '*') {
						dirt.add(new Point(i,j));
					}
					else if(map[i][j] == 'o') {
						map[i][j] = '.';
						x = i;
						y = j;
					}
				}
			}
			k = dirt.size();
			dirt.add(new Point(x,y));
			distance = new int[k+1][][];
			answer = 0;
			visited = new int[n][m];
			isSelected = new boolean[k];
			order = new int[k+1];
			order[0] = k;
			answer = Integer.MAX_VALUE;
			permutation(1);
			
			System.out.println(answer);
		}
	}
}