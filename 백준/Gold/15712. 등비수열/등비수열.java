import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n = 2;
	static final long[][] E = {{1,0},{0,1}};
	static long[][] V;
	static int mod;
	static long[][] mult(long[][] a, long[][] b) {
		long[][] c = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
					c[i][j] %= mod;
				}
			}
		}
		return c;
	}

	static long[][] pow(long d) {
		if(d==0) {
			return E;
		}
		if (d == 1)
			return V;
		else {
			long[][] nx = pow(d / 2);
			long[][] ans = mult(nx, nx);

			if (d % 2 == 0) {
				return ans;
			} else {
				return mult(ans, V);
			}

		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());
		
		V = new long[][]{{r,0},{a%mod,1}};
		
		long[][] answer = pow(n);
		
		System.out.println(answer[1][0]);
		
	}
}