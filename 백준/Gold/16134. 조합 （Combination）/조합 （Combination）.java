import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	public static long pow(long a, long p) {
		if(p==1)
			return a;
		else if(p%2==0) {
			long v = pow(a,p/2);
			return (v*v)%MOD;
		}
		else {
			long v = pow(a,p-1);
			return (v*a)%MOD;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		long[] fact = new long[N+1];
		fact[0] = fact[1] = 1;
		for(int i = 2;i<=N;i++) {
			fact[i] = (fact[i-1]*i)%MOD;
		}
		
		long answer = (fact[N]*pow((fact[R]*fact[N-R])%MOD,MOD-2))%MOD;
		
		System.out.println(answer);
	}
}