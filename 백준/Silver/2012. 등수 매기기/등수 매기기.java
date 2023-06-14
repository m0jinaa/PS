import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] rank = new int[n];

		for (int i = 0; i < n; i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rank);

		long answer = 0;
		
		for (int i = 0; i < n; i++) {
			answer += Math.abs((i + 1) - rank[i]);
		}

		System.out.println(answer);
	}
}
