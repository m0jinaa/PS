import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];

		for(int i = 0;i<n;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numbers);
		
		int answer = -1;
		for(int i = n-3;i>=0;i--) {
			if(numbers[i]+numbers[i+1]>numbers[i+2]) {
				answer = numbers[i]+numbers[i+1]+numbers[i+2];
				break;
			}
		}
		
		System.out.println(answer);
	}
}