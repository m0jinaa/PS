import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] numbers = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		int[] sum = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + numbers[i];
		}
		
		int l,r;
		
		while(q-->0) {
			st = new StringTokenizer(br.readLine()," ");
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			sb.append(sum[r]-sum[l-1]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}