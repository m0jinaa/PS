import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] E;
	static long[][] V;
	static int d;
	static void init() {
		E = new long[d][d];
		V = new long[d][d];
		for(int i = 0;i<d;i++) {
			E[i][i] = 1;
			V[0][i] = 1;
			if(i>=1)
				V[i][i-1] = 1;
		}
		
	}
	static final int MOD = 31991;
	static long[][] mult(long[][] a, long[][] b){
		long[][] c = new long[d][d];
		
		for(int k = 0;k<d;k++) {
			for(int i = 0;i<d;i++) {
				for(int j = 0;j<d;j++) {
					c[i][j] = (c[i][j] + a[i][k]*b[k][j])%MOD;
				}
			}
		}
		return c;
	}
	
	static long fibo(int n) {
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
		
		d = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		init();
		
		long answer = fibo(t);		
		
		System.out.println(answer);

	}
}
