import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		long[] fibo = new long[81];
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i = 2;i<=80;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		long[] surface = new long[81];
		
		surface[1] = 4;
		for(int i = 2;i<=80;i++) {
			surface[i] = surface[i-1]+2*fibo[i-1];
		}
		int n = Integer.parseInt(br.readLine());
		System.out.println(surface[n]);
	}
}