import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] combi = new int[n+1][n+1];

		combi[0][0] = 1;
		int[] answer = new int[n+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				combi[i + 1][j] += combi[i][j];
				combi[i + 1][j + 1] += combi[i][j];
				answer[i + 1] += 2 * combi[i][j];
			}
		}

		System.out.println(answer[n]);
	}
}