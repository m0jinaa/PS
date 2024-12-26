import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();

		int ind = 0;
		int n = input.length;

		// get A

		boolean minusA = false;

		if (input[ind] == '-') {
			minusA = true;
			ind++;
		}

		long a = 0;

		while (ind < n) {
			if ('0' > input[ind] || input[ind] > '9')
				break;
			a = a * 8 + (input[ind++] - '0');
		}

		// get operator
		int o = -1;
		switch (input[ind++]) {
		case '+':
			o = 1;
			break;

		case '-':
			o = 2;
			break;

		case '/':
			o = 3;
			break;

		case '*':
			o = 4;
			break;
		}

		// get B

		boolean minusB = false;

		if (input[ind] == '-') {
			minusB = true;
			ind++;
		}

		long b = 0;

		while (ind < n) {
			if ('0' > input[ind] || input[ind] > '9')
				break;
			b = b * 8 + (input[ind++] - '0');
		}

		boolean minus = minusA ^ minusB;

		long result = 0;

		if (o == 3 && b == 0) {
			sb.append("invalid");
		} else {
			switch (o) {
			case 1:
			case 2:
				if (minusA)
					a = -a;
				if (minusB)
					b = -b;

				if (o == 1)
					result = a + b;
				else
					result = a - b;

				minus = (result < 0);
				break;
			case 3:
				result = minus ? (long) Math.ceil(a * 1.0 / b) : (long) Math.floor(a * 1.0 / b);
				break;
			case 4:
				result = a * b;
				break;
			}

			result = Math.abs(result);

			sb.append((minus ? "-" : "") + Long.toOctalString(result));
		}

		System.out.println(sb.toString());
	}
}