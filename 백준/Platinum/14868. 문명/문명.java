import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[] dx = new int[] {0,0,1,-1}
				,dy = new int[] {1,-1,0,0};
	static int[][] map;
	static int[] root;
	static int find(int x) {
		if(x!=root[x])
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return;
		else if(a<b)
			root[b] = a;
		else
			root[a] = b;
	}
	
	public static boolean inRange(int a, int b) {
		if(a<0 || a>=n || b<0 || b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		root = new int[k+1];
		
		int x,y,nx,ny;
		
		Queue<Integer> uxq = new LinkedList<Integer>();
		Queue<Integer> uyq = new LinkedList<Integer>();
		Queue<Integer> bxq = new LinkedList<Integer>();
		Queue<Integer> byq = new LinkedList<Integer>();
		
		for(int i = 1;i<=k;i++) {
			root[i] = i;
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			map[x][y] = i;
			
			uxq.add(x);
			uyq.add(y);
		}
		
		int time = 0;
		while(k>1) {
			while(!uxq.isEmpty()) {
				x = uxq.poll();
				y = uyq.poll();
				bxq.add(x);
				byq.add(y);
				
				for(int i = 0;i<4;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(!inRange(nx,ny) || 
							map[nx][ny]==0 || 
							find(map[nx][ny])==find(map[x][y]))
						continue;
					union(map[x][y],map[nx][ny]);
					k--;
				}				
			}
			if(k==1)
				break;
			while(!bxq.isEmpty()) {
				x = bxq.poll();
				y = byq.poll();
				
				for(int i = 0;i<4;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					
					if(!inRange(nx,ny)||map[nx][ny]!=0)
						continue;
					map[nx][ny] = map[x][y];
					uxq.add(nx);
					uyq.add(ny);
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
}