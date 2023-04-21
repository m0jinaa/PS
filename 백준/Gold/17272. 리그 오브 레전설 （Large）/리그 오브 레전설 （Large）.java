import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] E;
	static long[][] V;
	static int m;
	static void init() {
		E = new long[m][m];
		V = new long[m][m];
		for(int i = 0;i<m;i++) {
			E[i][i] = 1;
			if(i>=1)
				V[i][i-1] = 1;
		}
		V[0][0] = V[0][m-1] = 1;
	}
	static final int MOD = 1_000_000_007;
	static long[][] mult(long[][] a, long[][] b){
		long[][] c = new long[m][m];
		
		for(int k = 0;k<m;k++) {
			for(int i = 0;i<m;i++) {
				for(int j = 0;j<m;j++) {
					c[i][j] = (c[i][j] + a[i][k]*b[k][j])%MOD;
				}
			}
		}
		return c;
	}
	
	static long getCombi(long n) {
		long[][] answer = E;
		long[][] v = V;
		
		long i = 1L;
		
		while(i<=n) {
			if((i&n)>0) {
				answer = mult(answer,v);
			}
			v = mult(v,v);
			i<<=1;
		}

		return answer[0][0];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long n = Long.parseLong(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		long answer = getCombi(n);
		
		System.out.println(answer);
	}
}