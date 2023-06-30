import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int dough = Integer.parseInt(br.readLine());
		int price = a;

		int[] toppings = new int[n];

		for (int i = 0; i < n; i++) {
			toppings[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(toppings);

		int calory = dough;
		int max_calory = calory/price;


		int val;

		for (int i = n - 1; i >= 0; i--) {
			calory += toppings[i];
			price += b;
			val = calory / price;
			if (val > max_calory) {
				max_calory = val;
			}
		}

		System.out.println(max_calory);
	}
}