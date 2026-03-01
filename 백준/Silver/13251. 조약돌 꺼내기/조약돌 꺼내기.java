import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());

		int n = 0;
		int[] stones = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
			n += stones[i];
		}

		BigInteger[][] combi = new BigInteger[n + 1][n + 1];

		combi[0][0] = BigInteger.ONE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (combi[i + 1][j] == null)
					combi[i + 1][j] = BigInteger.ZERO;
				combi[i + 1][j] = combi[i + 1][j].add(combi[i][j]);
				if (combi[i + 1][j + 1] == null)
					combi[i + 1][j + 1] = BigInteger.ZERO;
				combi[i + 1][j + 1] = combi[i + 1][j + 1].add(combi[i][j]);
			}
		}

		int k = Integer.parseInt(br.readLine());
		BigInteger cases = BigInteger.ZERO;

		for (int stone : stones) {
			if (stone < k)
				continue;
			cases = cases.add(combi[stone][k]);
		}

		BigInteger total = combi[n][k];

		BigDecimal answer = new BigDecimal(cases).divide(new BigDecimal(total), 20, 1);

		System.out.println(answer.toPlainString());
	}
}