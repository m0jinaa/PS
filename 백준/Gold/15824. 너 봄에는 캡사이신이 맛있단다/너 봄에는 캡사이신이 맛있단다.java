import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	static long pow(int x) {
		if(x==0) {
			return 1;
		}
		else if(x==1) {
			return 2;
		}
		else {
			long nx = pow(x/2);
			if(x%2==0) {
				return (nx*nx)%MOD;
			}
			else {
				return (2*(nx*nx)%MOD)%MOD;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		long[] menu = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			menu[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(menu);
		
		long answer = 0;
		
		for(int i = 0;i<n;i++) {
			answer = (answer+(((pow(i)-pow(n-i-1)+MOD)%MOD)*menu[i])%MOD)%MOD;
		}
		
		System.out.println(answer);
	}
}