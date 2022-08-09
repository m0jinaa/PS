import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=n)
			return false;
		return true;
	}
	static int dfs(int a, int b) {
		int cnt = 1;
		int x = a;
		int y = b;
		int i = 0;
		while(true) {
			for(i = 0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(inRange(nx,ny)&&map[nx][ny] == map[x][y]+1) {
					x = nx;
					y = ny;
					cnt++;
					break;
				}
			}
			if(i==4)//4방향 다 다음으로 갈 곳이 없을 경우
				break;
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			int cnt = 0;
			
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					int val = dfs(i,j);
					if(val>cnt) {
						answer = map[i][j];
						cnt = val;
					}
					else if(val==cnt) {
						answer = Math.min(answer, map[i][j]);
					}					
				}
			}
			sb.append(String.format("#%d %d %d\n",t,answer,cnt));
		}
		System.out.println(sb);
	}
}
