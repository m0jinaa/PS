import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long power(int k) {
		if(k==0)
			return 1;
		else if(k%2==0) {
			long val =power(k/2); 
			return val*val%1000000007;
		}
			return 2*power(k-1)%1000000007;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int n;
		for(int t = 0;t<tc;t++) {
			n = Integer.parseInt(br.readLine());
			if(n<=2) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(power(n-2)).append("\n");				
			}
		}
		System.out.print(sb);
	}
}