import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static void move(int from, int to, int mid, int c) {
		if (c == 0)
			return;

		move(from, mid, to, c - 1);

		sb.append(from).append(" ").append(to).append("\n");

		move(mid, to, from, c - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger answer = new BigInteger("2").pow(n).subtract(BigInteger.ONE);

		sb.append(answer.toString()).append("\n");

		if (n <= 20)
			move(1, 3, 2, n);
		System.out.print(sb.toString());
	}
}