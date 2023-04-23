import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int min = ((1+k)*k)/2;
		int rest = n-min;
		
		int answer = 0;
		
		if(rest<0) {
			answer = -1;
		}
		else if(rest%k==0) {
			answer = k-1;
		}
		else {
			answer = k;
		}
		
		System.out.println(answer);
	}
}