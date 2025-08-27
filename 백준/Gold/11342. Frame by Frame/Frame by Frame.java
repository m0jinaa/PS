import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		char[] input;
		int ind;
		int a, b, c;
		int total;
		int frame;

		// strike -> 10 + number of pins hit in the next two rolls
		// spare -> 10 + number of pins hit in the next roll
		// other -> number of pins hit in this frame
		// be careful that frame is not the same as roll
		// frame consist of one or two roll
		while (t-- > 0) {

			total = 0;
			a = 0;
			b = 0;
			c = 0;
			ind = 0;
			frame = 1;

			input = br.readLine().toCharArray();

			// 1st ~ 9th frame
			while (frame < 10) {
				if (input[ind] == 'X') { // strike
					a = input[ind + 2] == 'X' ? 10 : (input[ind + 2] - '0');
					b = input[ind + 4] == 'X' ? 10 : (input[ind + 4] == '/') ? (10 - a) : (input[ind + 4] - '0');

					total += (10 + a + b);

					ind += 2;
				} else if (input[ind + 2] == '/') { // spare
					a = input[ind + 4] == 'X' ? 10 : (input[ind + 4] - '0');

					total += (10 + a);

					ind += 4;
				} else {// other
					a = input[ind] - '0';
					b = input[ind + 2] - '0';

					total += (a + b);

					ind += 4;
				}

				frame++;
			}

			// 10th frame
			a = input[ind] == 'X' ? 10 : (input[ind] - '0');
			ind += 2;

			b = input[ind] == 'X' ? 10 : (input[ind] == '/') ? (10 - a) : (input[ind] - '0');
			ind += 2;

			// check if third roll can be made
			if (a + b >= 10) {
				c = input[ind] == 'X' ? 10 : (input[ind] == '/') ? (10 - b) : (input[ind] - '0');
			}

			total += (a + b + c);

			sb.append(total).append("\n");
		}

		System.out.print(sb.toString());
	}
}