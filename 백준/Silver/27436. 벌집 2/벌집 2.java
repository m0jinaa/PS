import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long s = 1;
		long e = 2_000_000_000L;
		long m;
		long ans = 0;
		while(s<=e) {
			m = (s+e)/2;
			if(m*(m-1)*3+1>=n) {
				ans = m;
				e = m-1;
			}
			else
				s = m+1;
		}
		
		System.out.println(ans);

	}

}
