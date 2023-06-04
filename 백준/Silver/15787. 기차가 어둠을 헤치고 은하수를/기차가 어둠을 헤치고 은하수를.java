import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<Integer> canCross = new HashSet<>();

		int[] train = new int[n + 1];
		int o, i, x;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			o = Integer.parseInt(st.nextToken());
			switch (o) {
			case 1:
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken()) - 1;
				train[i] |= (1 << x);
				break;
			case 2:
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken()) - 1;
				if ((train[i] & (1 << x)) != 0)
					train[i] ^= (1 << x);
				break;
			case 3:
				i = Integer.parseInt(st.nextToken());
				train[i] <<= 1;
				train[i] %= (1 << 20);
				break;
			case 4:
				i = Integer.parseInt(st.nextToken());
				train[i] >>= 1;
				break;
			}
		}

		for (int j = 1; j <= n; j++) {
			canCross.add(train[j]);
		}

		System.out.println(canCross.size());
	}
}