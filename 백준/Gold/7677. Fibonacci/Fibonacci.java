import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n = 2;
	static final int[][] E = {{1,0},{0,1}};
	static final int[][] V = {{1,1},{1,0}};
	static final int MOD = 10000;
	static int[][] mult(int[][] a, int[][] b) {
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
					c[i][j] %= MOD;
				}
			}
		}
		return c;
	}

	static int[][] pow(long d) {
		if(d==0) {
			return E;
		}
		if (d == 1)
			return V;
		else {
			int[][] nx = pow(d / 2);
			int[][] ans = mult(nx, nx);

			if (d % 2 == 0) {
				return ans;
			} else {
				return mult(ans, V);
			}

		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==-1) {
				break;
			}
			else if(n==0) {
				sb.append(0).append("\n");
			}
			else {
				int[][] answer = pow(n);
				sb.append(answer[0][1]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}