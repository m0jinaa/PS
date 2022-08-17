import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int[][][] v;
	static int n;
	static int[] verticalx = {-1,0,1};
	static int[] verticaly = {1,1,1};
	static int[] horizontalx = {1,1,1};
	static int[] horizontaly = {-1,0,1};
	static int[] diagonalx = {-1,-1,-1,0,0,1,1,1};
	static int[] diagonaly = {-1,0,1,-1,1,-1,0,1};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		v = new int[2][n][n];
		int scnt = 0;
		int ecnt = 0;
		int startx=0,starty=0,endx=0,endy=0;
		int sdir = 0;
		int edir = 0;
		int answer = 0;
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<n;j++) {
				if(map[i][j]=='B') {
					scnt++;
					if(scnt==2) {//통나무 가운데 부분
						startx = i;
						starty = j;
						if(inRange(i-1,j)&&map[i-1][j]=='B'){//통나무가 세로로 놓여있음
							sdir = 0;
							map[i-1][j] = '0';
							map[i][j] = '0';
							map[i+1][j] = '0';
						}
						else if(inRange(i,j-1)&&map[i][j-1]=='B'){//통나무가 가로로
							sdir = 1;
							map[i][j-1] = '0';
							map[i][j] = '0';
							map[i][j+1] = '0';
						}
					}
				}
				else if(map[i][j]=='E') {
					ecnt++;
					if(ecnt==2) {
						endx = i;
						endy = j;
						if(inRange(i-1,j)&&map[i-1][j]=='E'){
							edir = 0;
							map[i-1][j] = '0';
							map[i][j] = '0';
							map[i+1][j] = '0';
						}
						else if(inRange(i,j-1)&&map[i][j-1]=='E'){
							edir = 1;
							map[i][j-1] = '0';
							map[i][j] = '0';
							map[i][j+1] = '0';
						}
					}
				}
			}
		}
		//System.out.println(startx+" "+starty);
		//System.out.println(endx+" "+endy);
		Queue<int[]>q = new LinkedList<int[]>();
		v[sdir][startx][starty] = 1;
		q.offer(new int[] {sdir,startx,starty});
		int[] now;
		int d,x,y,nx,ny;
		boolean pos = true;
		//System.out.println();
		while(!q.isEmpty()) {
			now = q.poll();
			d = now[0];
			x = now[1];
			y = now[2];
			//System.out.println(d+ " "+x+" "+y);
			if(d==edir &&x==endx&&y==endy) {
				answer = v[d][x][y]-1;//시작을 1로 했으니까 1 빼주기
				break;
			}
			//회전
			if(v[1-d][x][y]==0) {
				pos = true;
				for(int i = 0;i<8;i++) {
					nx = x+diagonalx[i];
					ny = y+diagonaly[i];
					if(!inRange(nx,ny)||map[nx][ny]=='1') {
						pos = false;
						break;
					}
				}
				if(pos) {
					v[1-d][x][y] = v[d][x][y]+1;
					q.offer(new int[] {1-d,x,y});
				}
			}
			if(d==0) {//세로
				if(inRange(x,y+1)&&v[d][x][y+1]==0) {//오른쪽
					pos = true;
					for(int i = 0;i<3;i++) {
						nx = x+verticalx[i];
						ny = y+verticaly[i];
						if(map[nx][ny]=='1') {
							pos = false;
							break;
						}
					}
					if(pos) {
						v[d][x][y+1] = v[d][x][y]+1;
						q.offer(new int[] {d,x,y+1});
					}
				}
				if(inRange(x,y-1)&&v[d][x][y-1]==0) {//왼쪽
					pos = true;
					for(int i = 0;i<3;i++) {
						nx = x-verticalx[i];
						ny = y-verticaly[i];
						if(map[nx][ny]=='1') {
							pos = false;
							break;
						}
					}
					if(pos) {
						v[d][x][y-1] = v[d][x][y]+1;
						q.offer(new int[] {d,x,y-1});
					}
				}
				if(inRange(x+2,y)&&map[x+2][y]!='1'&&v[d][x+1][y]==0) {//아래
					v[d][x+1][y] = v[d][x][y]+1;
					q.offer(new int[] {d,x+1,y});
				}
				if(inRange(x-2,y)&&map[x-2][y]!='1'&&v[d][x-1][y]==0) {//위
					v[d][x-1][y] = v[d][x][y]+1;
					q.offer(new int[] {d,x-1,y});
				}			
			}
			else {//가로
				if(inRange(x+1,y)&&v[d][x+1][y]==0) {//아래
					pos = true;
					for(int i = 0;i<3;i++) {
						nx = x+horizontalx[i];
						ny = y+horizontaly[i];
						if(map[nx][ny]=='1') {
							pos = false;
							break;
						}
					}
					if(pos) {
						v[d][x+1][y] = v[d][x][y]+1;
						q.offer(new int[] {d,x+1,y});
					}
				}
				if(inRange(x-1,y)&&v[d][x-1][y]==0) {//위
					pos = true;
					for(int i = 0;i<3;i++) {
						nx = x-horizontalx[i];
						ny = y-horizontaly[i];
						if(map[nx][ny]=='1') {
							pos = false;
							break;
						}
					}
					if(pos) {
						v[d][x-1][y] = v[d][x][y]+1;
						q.offer(new int[] {d,x-1,y});
					}
				}

				if(inRange(x,y+2)&&map[x][y+2]!='1'&&v[d][x][y+1]==0) {//오른쪽
					v[d][x][y+1] = v[d][x][y]+1;
					q.offer(new int[] {d,x,y+1});
				}
				if(inRange(x,y-2)&&map[x][y-2]!='1'&&v[d][x][y-1]==0) {//왼쪽
					v[d][x][y-1] = v[d][x][y]+1;
					q.offer(new int[] {d,x,y-1});
				}			
			}
		}
		System.out.println(answer);		
	}
}