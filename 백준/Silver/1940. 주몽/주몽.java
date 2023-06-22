import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] ingredients = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ingredients);

		int s = 0;
		int e = n - 1;
		int sum;
		int cnt = 0;
		while (s < e) {
			sum = ingredients[s] + ingredients[e];
			if (sum == m) {
				cnt++;
				s++;
				e--;
			} else if (sum < m) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(cnt);

	}
}