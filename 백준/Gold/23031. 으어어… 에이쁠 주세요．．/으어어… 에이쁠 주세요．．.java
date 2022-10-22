import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[] A;
	static char[][] map;
	static boolean[][] light;
	static int[][] loc;
	
	static int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
	static int[] dsx = {0,1,0,-1,0,1,1,-1,-1}, dsy = {0,0,-1,0,1,1,-1,1,-1};
	
	static boolean inRange(int a, int b) {
		if(a<0||a>=N||b<0||b>=N)
			return false;
		return true;
	}
	static class Student{
		int x,y,d;

		public Student(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		A = br.readLine().toCharArray();
		
		map = new char[N][];
		light = new boolean[N][N];
		loc = new int[N][N];
		ArrayList<Student> zombies = new ArrayList<Student>();
		Student ari = new Student(0,0,0);
		loc[0][0] = 1;
		for(int i = 0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<N;j++) {
				if(map[i][j] == 'Z') {
					zombies.add(new Student(i,j,0));
					map[i][j] = 'O';
					loc[i][j] = 2;
				}
			}
		}
		int nx,ny,nd;
		String answer = "Phew...";
		for(char arg:A) {
			//아리 이동

			switch(arg) {
			case 'F':
				nx = ari.x+dx[ari.d];
				ny = ari.y+dy[ari.d];
				if(inRange(nx,ny)) {
					loc[ari.x][ari.y]-=1;
					ari.x = nx;
					ari.y = ny;
					loc[ari.x][ari.y]+=1;
					if(map[ari.x][ari.y]=='S') {
						for(int i = 0;i<9;i++) {
							nx = ari.x+dsx[i];
							ny = ari.y+dsy[i];
							if(!inRange(nx,ny))
								continue;
							light[nx][ny] = true;
						}
						map[ari.x][ari.y] = 'O';
					}
				}
				break;
			case 'L':
				ari.d = (ari.d+3)%4;
				break;
			case 'R':
				ari.d = (ari.d+1)%4;
			}
			if(loc[ari.x][ari.y]>=3 && !light[ari.x][ari.y]) {
				answer = "Aaaaaah!";
				break;
			}			
			
			//좀비 이동
			for(Student zombi:zombies) {
				nx = zombi.x+dx[zombi.d];
				ny = zombi.y+dy[zombi.d];
				if(!inRange(nx,ny)) {
					zombi.d = (zombi.d+2)%4;
				}
				else {
					loc[zombi.x][zombi.y]-=2;
					loc[nx][ny]+=2;
					zombi.x = nx;
					zombi.y = ny;
				}
			}
			
			if(loc[ari.x][ari.y]>=3 && !light[ari.x][ari.y]) {
				answer = "Aaaaaah!";
				break;
			}
		}
		
		System.out.println(answer);
	}

}
