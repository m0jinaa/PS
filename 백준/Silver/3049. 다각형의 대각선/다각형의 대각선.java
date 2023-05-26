import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		long answer = (1L*n*(n-1)*(n-2)*(n-3))/(2*3*4);
		
		System.out.println(answer);
	}
}