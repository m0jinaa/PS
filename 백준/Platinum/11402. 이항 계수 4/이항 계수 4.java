import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static long N,K;
	static int M;
	public static long power(long x, int p) {
		if(p==0)
			return 1;
		else if(p==1)
			return x%M;
		else if(p%2==0) {
			long v = power(x,p/2);
			return (v*v)%M;
		}
		else {
			return (power(x,p-1)*x)%M;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long[] fact = new long[M+1];
		fact[0] = fact[1] = 1;
		for(int i = 2;i<=M;i++) {
			fact[i] = (fact[i-1]*i)%M;
		}
		
		long answer = 1;
		int n,k;
		while(N!=0 || K!=0) {
			n = (int)(N%M);
			k = (int)(K%M);
			if(n<k) {
				answer = 0;
				break;
			}
			
			answer*=(fact[n]*power((fact[n-k]*fact[k])%M,M-2))%M;
			answer%=M;
			N/=M;
			K/=M;
		}
		System.out.println(answer%M);	
	}
}