import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static char[][] map;
	static boolean[][] visited;
	
	static boolean inRange(int a, int b) {
		if(a<0||a>=r||b<0||b>=c)
			return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][];
		visited = new boolean[r][c];
		Queue<Integer> waterx = new LinkedList<Integer>();
		Queue<Integer> watery = new LinkedList<Integer>();
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		for(int i = 0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<c;j++) {
				if(map[i][j]!='X') {
					waterx.offer(i);
					watery.offer(j);
				}
				if(qx.size()==0&&map[i][j]=='L') {
					qx.offer(i);
					qy.offer(j);
					visited[i][j] = true;
				}
			}
			
		}
		int time = 0;
		int x,y,nx,ny;
		end: while(true) {
			Queue<Integer> nqx = new LinkedList<Integer>();
			Queue<Integer> nqy = new LinkedList<Integer>();
			while(!qx.isEmpty()) {
				x = qx.poll();
				y = qy.poll();
				for(int i = 0;i<4;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(!inRange(nx,ny)||visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					if(map[nx][ny]=='X') {//물과 맞닿는 빙산
						nqx.offer(nx);
						nqy.offer(ny);
					}
					else if(map[nx][ny]=='L') {
						break end;
					}
					else {
						qx.offer(nx);
						qy.offer(ny);
					}
				}
			}
			
			qx = nqx;
			qy = nqy;
			
			
			int qsize = waterx.size();
			for(int i = 0;i<qsize;i++) {
				x = waterx.poll();
				y = watery.poll();
				for(int j = 0;j<4;j++) {
					nx = x+dx[j];
					ny = y+dy[j];
					if(!inRange(nx,ny)||visited[nx][ny]||map[nx][ny]!='X')
						continue;
					map[nx][ny] = '.';
					waterx.offer(nx);
					watery.offer(ny);
				}
			}
			time++;
		}
		
		System.out.println(time);	
	}
}