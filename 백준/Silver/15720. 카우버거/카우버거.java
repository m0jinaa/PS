import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] burger = new int[b];
		int[] side = new int[c];
		int[] drink = new int[d];

		st = new StringTokenizer(br.readLine(), " ");
		int original = 0;
		for (int i = 0; i < b; i++) {
			burger[i] = Integer.parseInt(st.nextToken());
			original += burger[i];
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < c; i++) {
			side[i] = Integer.parseInt(st.nextToken());
			original += side[i];
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < d; i++) {
			drink[i] = Integer.parseInt(st.nextToken());
			original += drink[i];
		}

		int n = Math.min(b, Math.min(c, d));

		Arrays.sort(burger);
		Arrays.sort(side);
		Arrays.sort(drink);

		int discount = original;

		for (int i = 0; i < n; i++) {
			discount -= burger[b - 1 - i] / 10;
			discount -= side[c - 1 - i] / 10;
			discount -= drink[d - 1 - i] / 10;
		}

		System.out.println(original + "\n" + discount);
	}
}