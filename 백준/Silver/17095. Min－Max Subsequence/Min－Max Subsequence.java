import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		int maxDiff = -1;

		int max = -1;
		int min = Integer.MAX_VALUE;
		int maxInd = -1;
		int minInd = -1;

		for (int i = 0; i < n; i++) {
			if (max <= A[i]) {
				max = A[i];
				maxInd = i;
			}
			if (min >= A[i]) {
				min = A[i];
				minInd = i;
			}

			if (max - min == maxDiff) {
				answer = Math.min(answer, Math.abs(maxInd - minInd) + 1);
			} else if (max - min > maxDiff) {
				maxDiff = max - min;
				answer = Math.abs(maxInd - minInd) + 1;
			}
		}

		System.out.println(answer);
	}
}