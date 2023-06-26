import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int x;
		int price = 0;
		int profit = 0;
		int p;
		int[] customers = new int[m];
		for (int i = 0; i < m; i++) {
			customers[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(customers);

		for (int i = 0; i < m; i++) {
			x = customers[i];

			p = x * (int) (Math.min(m - i, n));

			if (p > profit) {
				profit = p;
				price = x;
			}
		}

		System.out.println(price + " " + profit);
	}
}