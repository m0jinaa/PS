import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int ADJUSTMENT = 100_000;
		final int MAX_SUM = 200_000 + ADJUSTMENT;

		int[] minInd = new int[MAX_SUM + 1];
		int[] maxInd = new int[MAX_SUM + 1];

		char[] S = (" " + br.readLine()).toCharArray();

		int n = S.length;

		int[] sCnt = new int[n];
		int[] kCnt = new int[n];

		Arrays.fill(minInd, n + 1);
		Arrays.fill(maxInd, -1);

		minInd[ADJUSTMENT] = 0;
		maxInd[ADJUSTMENT] = 0;

		int sum = 0;

		for (int i = 1; i < n; i++) {
			sCnt[i] = sCnt[i - 1] + (S[i] == 'S' ? 1 : 0);
			kCnt[i] = kCnt[i - 1] + (S[i] == 'K' ? 1 : 0);

			sum += (S[i] == 'S' ? 2 : (S[i] == 'K' ? -1 : 0));

			minInd[sum + ADJUSTMENT] = Math.min(minInd[sum + ADJUSTMENT], i);
			maxInd[sum + ADJUSTMENT] = Math.max(maxInd[sum + ADJUSTMENT], i);
		}

		int s, k;

		int answer = -1;

		for (int i = 0; i <= MAX_SUM; i++) {
			if (maxInd[i] == -1)
				continue;

			s = sCnt[maxInd[i]] - sCnt[minInd[i]];
			k = kCnt[maxInd[i]] - kCnt[minInd[i]];

			if (s == 0 || k == 0)
				continue;

			answer = Math.max(answer, maxInd[i] - minInd[i]);
		}

		System.out.println(answer);
	}
}