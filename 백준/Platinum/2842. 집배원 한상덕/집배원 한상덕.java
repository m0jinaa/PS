import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static char[][] map;
	static int[][] height;
	static boolean[][] v;
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	public static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new char[n][];
		height = new int[n][n];
		Set<Integer> set = new TreeSet<Integer>();
		int startx=0,starty=0;
		int kcnt = 0;
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<n;j++) {
				if(map[i][j] == 'P') {
					startx = i;
					starty = j;
				}
				else if(map[i][j] == 'K') {
					kcnt++;
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0;j<n;j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				set.add(height[i][j]);
			}
		}
		
		int[] range = set.stream().mapToInt(Integer::intValue).toArray();
		
		int left,right;
		left = 0;
		right = 0;
		int answer = Integer.MAX_VALUE;
		Queue<Point> q;
		int x,y,nx,ny,cnt;
		int size = range.length;
		while(left<=right &&right<size) {
			q = new LinkedList<Point>();
			v = new boolean[n][n];
			cnt = 0;
			if(height[startx][starty]>=range[left]&&height[startx][starty]<=range[right]) {
				q.offer(new Point(startx,starty));
				v[startx][starty] = true;
			}
			while(!q.isEmpty()) {
				Point p = q.poll();
				x = p.x;
				y = p.y;
				
				for(int i = 0;i<8;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(!inRange(nx,ny)||v[nx][ny])
						continue;
					if(height[nx][ny]<range[left]||height[nx][ny]>range[right])
						continue;
					if(map[nx][ny] == 'K')
						cnt++;
					v[nx][ny] = true;
					q.offer(new Point(nx,ny));
				}
				
			}
			if(cnt==kcnt) {
				answer = Math.min(answer, range[right]-range[left]);
				left++;
			}
			else {
				right++;
			}
		}
		System.out.println(answer);		
	}
}
