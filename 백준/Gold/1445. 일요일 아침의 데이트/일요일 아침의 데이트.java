import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static char[][] map;
	static Node[][] v;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Node{
		int x,y;
		int trash,near;
		
		public Node(int x, int y, int trash, int near) {
			super();
			this.x = x;
			this.y = y;
			this.trash = trash;
			this.near = near;
		}

		public Node(int trash, int near) {
			super();
			this.trash = trash;
			this.near = near;
		}
		
	}
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	static int checkAround(int a, int b) {
		int x, y;
		for(int i = 0;i<4;i++) {
			x = a+dx[i];
			y = b+dy[i];
			if(inRange(x,y)&&map[x][y]=='g') {
				return 1;
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Node end = new Node(0,0,0,0);
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)-> {
			if(n1.trash==n2.trash) {
				return n1.near-n2.near;
			}
			else {
				return n1.trash-n2.trash;
			}
				
		});
		map = new char[n][];
		v = new Node[n][m];
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(map[i][j] == 'S') {
					q.add(new Node(i,j,0,0));
					v[i][j] = new Node(0,0);
				}
				else if(map[i][j] =='F') {
					end = new Node(i,j,0,0);
				}
			}
		}
		Node now;
		int nx,ny,nt,nn;
		int answerT=-1,answerN=-1;
		while(!q.isEmpty()) {
			now = q.poll();
			if(now.x==end.x&&now.y==end.y) {
				answerT = now.trash;
				answerN = now.near;
			}
			if(v[now.x][now.y].trash<now.trash||v[now.x][now.y].trash==now.trash&&v[now.x][now.y].near<now.near)
				continue;
			
			for(int i = 0;i<4;i++) {
				nx = now.x+dx[i];
				ny = now.y+dy[i];
				if(!inRange(nx,ny))
					continue;
				nt = now.trash+(map[nx][ny]=='g'?1:0);
				nn = now.near+(map[nx][ny]=='.'?checkAround(nx,ny):0);
				if(v[nx][ny]==null || v[nx][ny].trash>nt||v[nx][ny].trash==nt&&v[nx][ny].near>nn) {
					v[nx][ny] = new Node(nx,ny,nt,nn);
					q.offer(v[nx][ny]);
				}
			}
		}
		System.out.println(answerT+" "+answerN);
	}
}
