import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int l = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int ml = Integer.parseInt(st.nextToken());
		int mk = Integer.parseInt(st.nextToken());

		int mine = Integer.parseInt(br.readLine());

		long[] zombi = new long[l + 1];

		int z;

		for (int i = 1; i <= l; i++) {
			z = Integer.parseInt(br.readLine());
			zombi[i] = z;
		}

		boolean possible = true;

		long[] damage = new long[l + 1];

		long d;

		for (int i = 1; i <= l; i++) {

			d = damage[i - 1] - damage[i - ml < 0 ? 0 : i - ml] + mk;

			if (zombi[i] <= d) {
				damage[i] = damage[i - 1] + mk;
			} else if (mine > 0) {
				mine--;
				damage[i] = damage[i - 1];
			} else {
				possible = false;
				break;
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}