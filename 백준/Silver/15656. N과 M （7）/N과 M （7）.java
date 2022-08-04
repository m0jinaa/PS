import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	static int[] input;
	static int n;
	static int m;
	static StringBuilder sb;
	static void permutation(int cnt) {
		if(cnt==m) {
			for(int num:numbers) {
				sb.append(num+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = 0;i<n;i++) {
				numbers[cnt] = input[i];
				permutation(cnt+1);				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		numbers = new int[m];
		sb = new StringBuilder();
		permutation(0);
		System.out.print(sb);
		
	}
}
