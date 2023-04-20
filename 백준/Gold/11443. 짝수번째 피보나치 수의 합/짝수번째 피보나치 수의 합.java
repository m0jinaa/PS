import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	static final long[][] E = new long[][] {{1,0},{0,1}};
	static long[][] V = new long[][] {{1,1},{1,0}};
	static long[][] mult(long[][] a, long[][] b){
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
	static long[][] fibo(long n){
		long[][] answer = E;
		long[][] v = V;
		
		long i = 1;
		while(i<=n) {
			if((i&n)>0) {
				answer = mult(answer,v);
			}
			v = mult(v,v);
			i<<=1;
		}
		
		return answer;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		
		if(n%2==0)
			n+=1;
		long[][] answer = fibo(n);
		
		System.out.println((answer[0][1]-1+MOD)%MOD);

	}
}