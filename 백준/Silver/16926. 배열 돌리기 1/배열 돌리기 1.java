import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int r;
	static int[][] map;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	
	static void rotate() {
		int temp1 = 0;
		int temp2 = 0;
		for(int i = 0;i<r;i++) {
			//left
			temp1 = map[x2][y1];
			for(int j = x2-1;j>=x1;j--) {
				map[j+1][y1] = map[j][y1];
			}
			//bottom
			temp2 = map[x2][y2];
			for(int j = y2-1;j>y1;j--) {
				map[x2][j+1] = map[x2][j];
			}
			map[x2][y1+1] = temp1;
			//right
			temp1 = map[x1][y2];
			for(int j = x1+1;j<x2;j++) {
				map[j-1][y2] = map[j][y2];
			}
			map[x2-1][y2] = temp2;
			//up
			for(int j = y1+1;j<y2;j++) {
				map[x1][j-1] = map[x1][j];
			}
			map[x1][y2-1] = temp1;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		x1 = 0;
		y1 = 0;
		x2 = n-1;
		y2 = m-1;
		
		while(x1<x2&&y1<y2) {
			rotate();
			x1++;
			y1++;
			x2--;
			y2--;
		}
		StringBuilder sb = new StringBuilder();
		for(int[] row:map) {
			for(int data:row) {
				sb.append(data).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
