import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception{
		int[] fibo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fibo = new int[n+1];
		fibo[1] = fibo[2] = 1;
		for(int i = 3;i<=n;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}	
		System.out.println(fibo[n]+" "+(n-2));
	}
}
