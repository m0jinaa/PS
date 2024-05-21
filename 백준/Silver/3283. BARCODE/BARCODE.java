import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] type = new int[n];

		char[] row;

		for (int i = 0; i < 5; i++) {
			row = br.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				switch (row[j]) {
				case 'X':
					type[j] = 1;
					break;
				case '.':
					type[j] = -1;
					break;
				}
			}
		}

		boolean changed = true;

		while (changed) {
			changed = false;

			for (int i = 0; i < n - 2; i++) {
				if (type[i + 1] * type[i + 2] == 1 && type[i] == 0) {
					type[i] = -type[i + 1];
					changed = true;
				}
				if (type[i] * type[i + 1] == 1 && type[i + 2] == 0) {
					type[i + 2] = -type[i];
					changed = true;
				}
				if (type[i] * type[i + 2] == 1 && type[i + 1] == 0) {
					type[i + 1] = -type[i];
					changed = true;
				}
			}
		}

		int i = 0;

		while (i < n) {
			if (type[i] == 0) {
				sb.setLength(0);
				sb.append("UNDETERMINABLE");
				break;
			} else if (i + 1 < n && type[i] == type[i + 1]) {
				sb.append(1);
				i += 2;
			} else {
				sb.append(0);
				i++;
			}
		}

		System.out.println(sb.toString());
	}
}