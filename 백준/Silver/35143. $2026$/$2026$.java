import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger palin = BigInteger.ONE;
		BigInteger open = new BigInteger("1905");

		BigInteger ten = new BigInteger("10");

		int t = n / 2;

		for (int i = 0; i < t; i++) {
			palin = palin.multiply(ten);
		}

		if (n != 1) {
			palin = palin.add(BigInteger.ONE);
		}

		BigInteger answer = palin.multiply(palin).add(open);

		System.out.println(answer);
	}
}