import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long flip(long x) {
		long ret = 0;

		int t;

		end: while (x != 0) {
			t = (int) (x % 10);

			switch (t) {
			case 0:
			case 1:
			case 2:
			case 5:
			case 8:
				ret = ret * 10 + t;
				break;
			case 3:
			case 4:
			case 7:
				ret = 1;
				break end;
			case 6:
				ret = ret * 10 + 9;
				break;
			case 9:
				ret = ret * 10 + 6;
				break;
			}

			x /= 10;
		}

		return ret;
	}

	static boolean isPrime(long x) {
		if (x < 2)
			return false;

		int limit = (int) Math.floor(Math.sqrt(x));

		for (int i = 2; i <= limit; i++) {
			if (x % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long x = Long.parseLong(br.readLine());

		if (isPrime(x) && isPrime(flip(x)))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}