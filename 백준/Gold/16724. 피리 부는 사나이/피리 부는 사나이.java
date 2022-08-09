import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] district;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt;
	static int color;
	
	static void dfs(int a, int b) {
		district[a][b] = color;
		while(true) {
			a+=dx[map[a][b]];
			b+=dy[map[a][b]];
			if(district[a][b] == 0) {
				district[a][b] = color;
			}
			else if(district[a][b] == color) {
				cnt++;
				break;
			}
			else
				break;
		}		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0;i<n;i++) {
			char[] s = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				switch(s[j]) {
				case 'U':
					map[i][j] = 3;
					break;
				case 'D':
					map[i][j] = 2;
					break;
				case 'L':
					map[i][j] = 1;
					break;
				case 'R':
					map[i][j] = 0;
					break;
				}
			}
		}		
		cnt = 0;
		color = 1;
		district = new int[n][m];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(district[i][j]==0) {
					dfs(i,j);
					color++;					
				}					
			}
		}		
		System.out.println(cnt);		
	}
}
