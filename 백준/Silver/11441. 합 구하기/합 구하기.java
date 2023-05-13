import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] preSum = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		int i, j;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append(preSum[j]-preSum[i-1]).append("\n");
		}
		
		System.out.print(sb.toString());

	}
}