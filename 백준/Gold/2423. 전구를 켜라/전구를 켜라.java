import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,1,-1};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken())+1;
		m = Integer.parseInt(st.nextToken())+1;
		int[][] map = new int[n][m];
		char[] arr;
		for(int i = 0;i<n-1;i++) {
			Arrays.fill(map[i], -1);
			arr = br.readLine().toCharArray();
			for(int j = 0;j<m-1;j++) {
				if(arr[j]=='\\')
					map[i][j] = 1;
				else
					map[i][j] = 0;
			}
		}
		Arrays.fill(map[n-1], -1);
		int[][] v = new int[n][m];
		for(int i = 0;i<n;i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		q.add(new int[] {0,0,0});
		int[] now;
		int x,y,c;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			c = now[2];
			if(x==n-1&&y==m-1)
				break;
			if(v[x][y]<c)
				continue;
			if(map[x][y]==1&&v[x+1][y+1]>c) {//남동쪽
				v[x+1][y+1] = c;
				q.offer(new int[] {x+1,y+1,c});
			}
			else if(map[x][y]==0&&v[x+1][y+1]>c+1) {
				v[x+1][y+1] = c+1;
				q.offer(new int[] {x+1,y+1,c+1});				
			}
			if(inRange(x-1,y)) {//북동쪽방향
				if(map[x-1][y]==0&&v[x-1][y+1]>c) {//남동쪽
					v[x-1][y+1] = c;
					q.offer(new int[] {x-1,y+1,c});
				}
				else if(map[x-1][y]==1&&v[x-1][y+1]>c+1) {
					v[x-1][y+1] = c+1;
					q.offer(new int[] {x-1,y+1,c+1});				
				}
			}
			if(inRange(x,y-1)) {
				if(map[x][y-1]==0&&v[x+1][y-1]>c) {//남서쪽
					v[x+1][y-1] = c;
					q.offer(new int[] {x+1,y-1,c});
				}
				else if(map[x][y-1]==1&&v[x+1][y-1]>c+1) {
					v[x+1][y-1] = c+1;
					q.offer(new int[] {x+1,y-1,c+1});
				}
			}
			if(inRange(x-1,y-1)) {
				if(map[x-1][y-1]==1&&v[x-1][y-1]>c) {//북서쪽
					v[x-1][y-1] = c;
					q.offer(new int[] {x-1,y-1,c});
				}
				else if(map[x-1][y-1]==1&&v[x-1][y-1]>c+1) {
					v[x-1][y-1] = c+1;
					q.offer(new int[] {x-1,y-1,c+1});
				}
			}
		}
		if(v[n-1][m-1]==Integer.MAX_VALUE)
			System.out.println("NO SOLUTION");
		else
			System.out.println(v[n-1][m-1]);
	}
}