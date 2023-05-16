import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String signal = br.readLine();
		
		if(signal.matches("(100+1+|01)+")) {
			System.out.println("SUBMARINE");
		}
		else {
			System.out.println("NOISE");
		}				
	}
}