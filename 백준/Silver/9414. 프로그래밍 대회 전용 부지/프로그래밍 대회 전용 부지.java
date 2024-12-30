import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		BigInteger money = new BigInteger("5000000");
		BigInteger need;
		ArrayList<BigInteger> q = new ArrayList<>();

		String x;
		int ind;
		BigInteger two = new BigInteger("2");

		while (t-- > 0) {
			need = BigInteger.ZERO;
			q.clear();

			while (!"0".equals((x = br.readLine()))) {
				q.add(new BigInteger(x));
			}

			Collections.sort(q, Collections.reverseOrder());
			;

			ind = 1;

			for (BigInteger b : q) {
				need = need.add(b.pow(ind++).multiply(two));
			}

			if (need.compareTo(money) <= 0) {
				sb.append(need.toString()).append("\n");
			} else {
				sb.append("Too expensive\n");
			}
		}

		System.out.print(sb.toString());
	}
}