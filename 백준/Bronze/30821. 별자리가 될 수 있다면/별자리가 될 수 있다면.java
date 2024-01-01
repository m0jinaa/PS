import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[][] combi = new long[101][101];

		combi[0][0] = 1;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j <= i; j++) {
				combi[i + 1][j] += combi[i][j];
				combi[i + 1][j + 1] += combi[i][j];
			}
		}

		int n = Integer.parseInt(br.readLine());

		System.out.println(combi[n][5]);
	}
}