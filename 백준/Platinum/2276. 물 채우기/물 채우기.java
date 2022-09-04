import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int m,n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[][] height = new int[n][m];
		boolean[][] v = new boolean[n][m];
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				if(i==0||j==0||i==n-1||j==m-1) {
					v[i][j] = true;
					q.add(new int[] {i,j,height[i][j]});
				}
			}
		}
		
		int answer = 0;
		int[] now;
		int a,b,x,y,h,nh;
		
		while(!q.isEmpty()) {
			now = q.poll();
			a = now[0];
			b = now[1];
			h = now[2];
			for(int i = 0;i<4;i++) {
				x = a+dx[i];
				y = b+dy[i];
				if(!inRange(x,y)||v[x][y])
					continue;
				v[x][y]=true;
				if(height[x][y]>h) {
					q.add(new int[] {x,y,height[x][y]});
				}
				else {
					answer+=h-height[x][y];
					q.add(new int[] {x,y,h});
					
				}
			}
		}
		System.out.println(answer);
	}
}