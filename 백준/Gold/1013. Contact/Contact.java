import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		String signal;
		while(n-->0) {
			signal = br.readLine();
			if(signal.matches("(100+1+|01)+")) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
			
		}
		
		System.out.print(sb.toString());
    }

}
