import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	static int n;
	static int[][] map;
	static int[][] v;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	static Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
	static int[] dx = {0,0,1,-1},dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String s;
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new int[n][n];
			for(int i = 0;i<n;i++) {
				s = br.readLine();
				Arrays.fill(v[i], Integer.MAX_VALUE);
				for(int j = 0;j<n;j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			int[] now;
			q.clear();
			q.add(new int[] {0,0,0});
            v[0][0] = 0;
			int x,y,d,nx,ny,nd;
			int answer = 0;
			while(!q.isEmpty()) {
				now = q.poll();
				x = now[0];
				y = now[1];
				d = now[2];
				if(v[x][y]<d)
					continue;
				if(x==n-1 && y==n-1) {
					answer = d;
					break;
				}
				for(int i = 0;i<4;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(!inRange(nx,ny))
						continue;
					nd = d+map[nx][ny];
					if(v[nx][ny]<=nd)
						continue;
					v[nx][ny] = nd;
					q.add(new int[] {nx,ny,nd});
				}
			}		
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}