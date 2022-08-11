import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,d;
	static LinkedList<int[]> map;
	static int answer;
	static boolean[][] v;
	static boolean[][] kill;
	static int[] archer = new int[3];
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	static LinkedList<int[]> graph;//map copy
	static Queue<int[]> q;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void attack() {
		int cnt = 0;//몇명 처리했나 count
		graph = new LinkedList<int[]>();
		
		for(int i = 0;i<n;i++) {
			graph.offer(Arrays.copyOf(map.get(i),m));
		}
		int r = n;
		while(r>0) {
//			System.out.println(r);
			kill = new boolean[r][m];//처리한 적 확인위한 배열
			int[] now;
			int x,y,nx,ny,c;
			for(int a:archer) {
				q = new LinkedList<int[]>();
				v = new boolean[r][m];
				q.offer(new int[] {r-1,a,1});//거리가 1인곳부터 시작
				while(!q.isEmpty()) {
					now = q.poll();
					x = now[0];
					y = now[1];
					c = now[2];
//					System.out.println(x+" "+y+" "+c);
					if(graph.get(x)[y]==1) {
						if(kill[x][y]==false) {
							kill[x][y] = true;
							cnt++;
						}
						break;
					}
					else if(c<d){
						for(int i = 0;i<3;i++) {
							nx = x+dx[i];
							ny = y+dy[i];
							if(inRange(nx,ny)&&v[nx][ny]==false) {
								v[nx][ny] = true;
								q.offer(new int[] {nx,ny,c+1});
							}
						}
					}	
				}
			}
			for(int i = 0;i<r;i++) {
				for(int j = 0;j<m;j++) {
					if(kill[i][j]) {
						graph.get(i)[j] = 0;
					}
				}
			}
			graph.pollLast();
			r--;
			
		}
		if(cnt>answer)
			answer = cnt;
	}
	
	public static void chooseArcher(int start,int i) {//조합
		if(i==3) {//궁수 다 고르면
			attack();
			return;
		}
		for(int j = start;j<m;j++) {
			archer[i] = j;
			chooseArcher(j+1,i+1);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new LinkedList<int[]>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int[] row = new int[m];
			for(int j = 0;j<m;j++) {
				row[j] = Integer.parseInt(st.nextToken());
			}
			map.offer(row);
		}
		chooseArcher(0,0);
		System.out.println(answer);
	}
}
