import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] original = new int[n];

		int[] sorted = new int[n];

		for (int i = 0; i < n; i++) {
			original[i] = Integer.parseInt(br.readLine());
			sorted[i] = original[i];
		}

		Arrays.sort(sorted);

		int t;

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (original[i] == sorted[i])
				continue;
			for (int j = i + 1; j < n; j++) {
				if (sorted[i] == original[j] && original[j] != sorted[j]) {
					t = original[i];
					original[i] = original[j];
					original[j] = t;
					answer++;
					break;
				}
			}
		}

		System.out.println(answer);
	}
}