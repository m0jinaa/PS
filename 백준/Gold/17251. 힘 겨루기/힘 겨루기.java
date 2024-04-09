import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] str = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			str[i] = Integer.parseInt(st.nextToken());
			if (i != 0) {
				left[i] = Math.max(str[i], left[i - 1]);
			} else {
				left[i] = str[i];
			}
		}

		right[n - 1] = str[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(str[i], right[i + 1]);
		}

		int red = 0;
		int blue = 0;

		for (int i = 0; i < n - 1; i++) {
			if (left[i] < right[i + 1])
				blue++;
			else if (left[i] > right[i + 1])
				red++;
		}

		String answer = "X";

		if (red < blue) {
			answer = "B";
		} else if (red > blue) {
			answer = "R";
		}

		System.out.println(answer);
	}
}