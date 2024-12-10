import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] politics = new int[n];

		for (int i = 0; i < n; i++) {
			politics[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(politics);

		int ind = 1;

		long answer = 0L;

		for (int p : politics) {
			if (p >= ind) {
				answer += (p - ind);
				ind++;
			}
		}

		System.out.println(answer);
	}
}