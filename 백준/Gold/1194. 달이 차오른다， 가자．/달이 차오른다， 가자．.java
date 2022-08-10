import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static boolean[][][] v;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][];
		Queue<int[]> q = new LinkedList<int[]>();
		v = new boolean[64][n][m];
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(map[i][j] == '0') {
					map[i][j] = '.';
					q.offer(new int[] {0,i,j,0});
					v[0][i][j] = true;
				}
			}
		}
	
		int answer = -1;
		int key,x,y,c,nx,ny,val;
		end: while(!q.isEmpty()) {
			int[] now = q.poll();
			key = now[0];
			x = now[1];
			y = now[2];
			c = now[3];
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(inRange(nx,ny)  &&map[nx][ny]!='#'&& !v[key][nx][ny]) {
					switch(map[nx][ny]) {
					case'.':
						v[key][nx][ny] = true;
						q.offer(new int[] {key,nx,ny,c+1});
						break;
					case'a':
					case'b':
					case'c':
					case'd':
					case'e':
					case'f':
						v[key][nx][ny] = true;
						val = (int)Math.pow(2,map[nx][ny]-'a');
						q.offer(new int[] {key|val,nx,ny,c+1});
						v[key|val][nx][ny] = true;
						break;
					case'A':
					case'B':
					case'C':
					case'D':
					case'E':
					case'F':
						val = (int)Math.pow(2,map[nx][ny]-'A');
						if((val&key)==val) {
							v[key][nx][ny] = true;
							q.offer(new int[] {key,nx,ny,c+1});
						}
						break;
					case'1':
						answer = c+1;
						break end;
					}
					
				}
			}
		}
		System.out.println(answer);
	}
}
