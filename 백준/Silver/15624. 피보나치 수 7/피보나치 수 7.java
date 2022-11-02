import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==0)
			System.out.println(0);
		else if(n<=2)
			System.out.println(1);
		else {
			long[] fibo = new long[n+1];
			fibo[1] = fibo[2] = 1;
			for(int i = 3;i<=n;i++) {
				fibo[i] = (fibo[i-1]+fibo[i-2])%MOD;
			}
			System.out.println(fibo[n]);
		}
	}
}