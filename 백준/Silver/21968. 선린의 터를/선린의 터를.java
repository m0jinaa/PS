import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long pow(int x) {
		long ret = 1L;

		while (x-- > 0) {
			ret *= 3;
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		long n;
		long answer;
		int p;
		while (t-- > 0) {
			n = Long.parseLong(br.readLine());
			answer = 0;
			p = 0;

			while (n > 0) {
				if (n % 2 == 1)
					answer += pow(p);
				n /= 2;
				p++;
			}

			sb.append(answer).append("\n");

		}

		System.out.print(sb.toString());
	}
}