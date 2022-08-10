import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static void flipVertical() {
		int temp = 0;
		for(int j = 0;j<m;j++) {
			for(int i = 0;i<n/2;i++) {
				temp = map[i][j];
				map[i][j] = map[n-i-1][j];
				map[n-i-1][j] = temp;
			}
		}
	}
	static void flipHorizontal() {
		int temp = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m/2;j++) {
				temp = map[i][j];
				map[i][j] = map[i][m-j-1];
				map[i][m-j-1] = temp;
			}
		}
	}
	static void rotateRight() {
		int[][] nMap = new int[m][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				nMap[j][n-1-i] = map[i][j];
			}
		}
		int temp = n;
		n = m;
		m = temp;
		map = nMap;
	}
	static void rotateLeft() {
		int[][] nMap = new int[m][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				nMap[m-j-1][i] = map[i][j];
			}
		}
		int temp = n;
		n = m;
		m = temp;
		map = nMap;
	}
	static void moveRight() {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int x,y,nx,ny,k;
		for(int i = 0;i<n/2;i++) {
			for(int j = 0;j<m/2;j++) {
				//시작점 (i,j)
				int temp = map[i][j];
				x = i;
				y = j;
				for(k = 0;k<3;k++) {
					nx = x+dx[k]*n/2;
					ny = y+dy[k]*m/2;
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				map[x][y] = temp;
			}
		}
	}
	static void moveLeft() {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int x,y,nx,ny,k;
		for(int i = 0;i<n/2;i++) {
			for(int j = 0;j<m/2;j++) {
				//시작점 (i,j)
				int temp = map[i][j];
				x = i;
				y = j;
				for(k = 0;k<3;k++) {
					nx = x+dx[k]*n/2;
					ny = y+dy[k]*m/2;
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				map[x][y] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[r];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<r;i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int o:order) {
			switch(o) {
			case 1:
				flipVertical();
				break;
			case 2:
				flipHorizontal();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				moveRight();
				break;
			case 6:
				moveLeft();
				break;	
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
