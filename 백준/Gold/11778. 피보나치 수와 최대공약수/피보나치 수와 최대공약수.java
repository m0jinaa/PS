import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	static final long[][] E = new long[][] {{1,0},{0,1}};
	static final long[][] V = new long[][] {{1,1},{1,0}};
	
	public static long gcd(long a, long b) {
		long t;
		if(a<b) {
			t = a;
			a = b;
			b = t;
		}
		
		while(b!=0) {
			t = a%b;
			a = b;
			b = t;
		}
		
		return a;
	}
	
	public static long[][] mult(long[][] a, long[][] b){
		long[][] c = new long[2][2];
		
		for(int k = 0;k<2;k++) {
			for(int i = 0;i<2;i++) {
				for(int j = 0;j<2;j++) {
					c[i][j] = (c[i][j]+a[i][k]*b[k][j])%MOD;
				}
			}
		}
		
		return c;
	}
	
	public static long fibo(long x){
		long[][] answer = E;
		long[][] v = V;
		long i = 1;
		
		while(i<=x) {
			if((x&i)>0) {
				answer = mult(answer,v);
			}
			v = mult(v,v);
			i<<=1;
		}
		
		return answer[0][1];

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long answer = fibo(gcd(n,m));
		
		System.out.println(answer);
		
	}

}
