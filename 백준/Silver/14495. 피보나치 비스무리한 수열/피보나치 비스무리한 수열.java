import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		long[] fibo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fibo = new long[n+1];
		if(n<=3)
			System.out.println(1);
		else {
			fibo[1] = fibo[2] = fibo[3]= 1;
			for(int i = 3;i<=n;i++) {
				fibo[i] = fibo[i-1]+fibo[i-3];
			}
			
			System.out.println(fibo[n]);			
		}
	}
}