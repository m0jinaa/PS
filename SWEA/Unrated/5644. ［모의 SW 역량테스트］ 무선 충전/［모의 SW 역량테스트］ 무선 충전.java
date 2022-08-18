import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BC{
	int id,p;

	public BC(int id, int p) {
		super();
		this.id = id;
		this.p = p;
	}
}
public class Solution {
	static ArrayList<BC>[][]map;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int ax,ay,bx,by;
	static int answer;
	static boolean[][] v;
	static boolean inRange(int a,int b) {
		if(a<0||a>=10||b<0|b>=10)
			return false;
		return true;
	}
	static void bfs(int a, int b, int c,BC bc) {
		v = new boolean[10][10];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {a,b,0});
		map[a][b].add(bc);
		v[a][b] = true;
		int[] now;
		int x,y,nx,ny,cnt;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			y = now[1];
			cnt = now[2];
			
			if(cnt==c)
				continue;
			else {
				for(int i = 1;i<5;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(inRange(nx,ny)&&!v[nx][ny]) {
						v[nx][ny] = true;
						map[nx][ny].add(bc);
						q.offer(new int[] {nx,ny,cnt+1});
					}
				}
			}
		}
	}
	static void check() {
		ArrayList<BC> al = map[ax][ay];
		ArrayList<BC> bl = map[bx][by];
		int max = 0;
		if(al.size()==0) {//a는 영향권 외부
			if(bl.size()!=0) {//b는 영향권
				for(BC bc:bl) {
					max = max<bc.p?bc.p:max;
				}
			}
		}
		else if(bl.size()==0) {//b는 영향권 외부, a는 영향권
			for(BC bc:al) {
				max = max<bc.p?bc.p:max;
			}
		}
		else {//둘다 영향권
			int temp = 0;
			for(BC bc1:al) {
				for(BC bc2:bl) {
					if(bc1.id==bc2.id) {
						temp = bc1.p;
					}
					else {
						temp = bc1.p+bc2.p;
					}
					max = max<temp?temp:max;
				}
			}
		}
		//System.out.println(max);
		answer+=max;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int m,a,x,y,c,p;
		int[] A,B;
		for(int t = 1;t<=tc;t++) {
			map = new ArrayList[10][10];
			for(int i = 0;i<10;i++) {
				for(int j = 0;j<10;j++) {
					map[i][j] = new ArrayList<BC>();
				}
			}
			answer = 0;
			st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			ax = 0;
			ay = 0;
			bx = 9;
			by = 9;
			
			A = new int[m];
			B = new int[m];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<m;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<m;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0;i<a;i++) {//map에 bc 표시
				st = new StringTokenizer(br.readLine()," ");
				y = Integer.parseInt(st.nextToken())-1;
				x = Integer.parseInt(st.nextToken())-1;
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				BC bc = new BC(i,p);
				bfs(x,y,c,bc);
			}
			check();
			
			for(int i = 0;i<m;i++) {
				ax+=dx[A[i]];
				ay+=dy[A[i]];
				bx+=dx[B[i]];
				by+=dy[B[i]];
				check();
				//System.out.println(answer);
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
}