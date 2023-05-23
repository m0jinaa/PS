import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int i,j,x,y;
		while(k-->0) {
			st = new StringTokenizer(br.readLine()," ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			sb.append(sum[x][y]-sum[i-1][y]-sum[x][j-1]+sum[i-1][j-1]).append("\n");
			
		}
		
		System.out.print(sb.toString());
	}
}