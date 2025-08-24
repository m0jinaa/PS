import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;

	static class Suggestion {
		int price;
		int shipping;

		public Suggestion(int price, int shipping) {
			super();
			this.price = price;
			this.shipping = shipping;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Suggestion[] suggestions = new Suggestion[n];

		int p, s;

		int[] price = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			suggestions[i] = new Suggestion(p, s);
			price[i] = p;
		}

		int answer = 0;
		int profit = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			profit = 0;

			for (int j = 0; j < n; j++) {
				if (suggestions[j].price < price[i] || price[i] <= suggestions[j].shipping)
					continue;
				profit += price[i] - suggestions[j].shipping;
			}
			if (max < profit) {
				max = profit;
				answer = price[i];
			} else if (max == profit) {
				answer = Math.min(answer, price[i]);
			}
		}

		System.out.println(answer);
	}
}