import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[][] E,V;
	static final int MOD = 1_000_000_000;
	static int l = 2;
	static void init() {
		E = new long[l][l];
		V = new long[l][l];
		
		for(int i = 0;i<l;i++) {
			E[i][i] = 1;
			V[0][i] = 1;
			if(i>0) {
				V[i][i-1] = 1;
			}
		}
	}
	static long[][] mult(long[][] a, long[][] b){
		long[][] c = new long[l][l];
		
		for(int k = 0;k<l;k++) {
			for(int i = 0;i<l;i++) {
				for(int j = 0;j<l;j++) {
					c[i][j] = (c[i][j]+a[i][k]*b[k][j])%MOD;
				}
			}
			
		}
		return c;
	}
	
	static long fibo(long x) {
		long i = 1L;
		long[][] answer = E;
		long[][] v = V;
		while(i<=x) {
			if((i&x)>0) {
				answer = mult(answer,v);
			}
			v = mult(v,v);
			i<<=1;
		}

		return answer[0][0];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		long x;
		init();
		while(t-->0) {
			x = Long.parseLong(br.readLine());
			sb.append(fibo(x-1)).append("\n");
		}
		
		System.out.println(sb.toString());

	}
}