import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long a = Long.parseLong(br.readLine())%MOD;
		long x = Long.parseLong(br.readLine());		
		
		long answer = 1L;
		
		while(x>0) {
			if((x&1)!=0) {
				answer = (answer*a)%MOD;
			}
			x>>=1;
			a = (a*a)%MOD;
		}
		
		System.out.println(answer);
	}
}