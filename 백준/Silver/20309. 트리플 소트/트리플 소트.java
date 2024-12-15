import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] numbers = new int[2][];

		numbers[0] = new int[n - n / 2];
		numbers[1] = new int[n / 2];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			numbers[i % 2][i / 2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers[0]);
		Arrays.sort(numbers[1]);

		boolean success = true;

		for (int i = 0; i < n; i++) {
			if (numbers[i % 2][i / 2] != i + 1) {
				success = false;
				break;
			}
		}

		System.out.println(success ? "YES" : "NO");
	}
}