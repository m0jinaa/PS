import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] E,V;
	static final int MOD = 1_000_000_007;
	static int l;
	static void init() {
		E = new long[l][l];
		V = new long[l][l];
		
		for(int i = 0;i<l;i++) {
			E[i][i] = 1;
			for(int j = 0;j<=i;j++) {
				V[i][j] = 1;
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
		
		long ans = 0;
		for(int j = 0;j<l;j++) {
			ans = (ans + answer[l-1][j])%MOD;
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
			l = Integer.parseInt(st.nextToken())+2;
			long x = Long.parseLong(st.nextToken());
			init();
        
			System.out.println(fibo(x-1));	
	}
}