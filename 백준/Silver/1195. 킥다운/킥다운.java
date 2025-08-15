import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] size;
	static char[][] gear;

	static int getMin(int a, int b) {
		boolean possible;

		int min = size[a] + size[b];

		for (int i = 0; i < size[a]; i++) {
			possible = true;
			for (int j = 0; j < size[b] && i + j < size[a]; j++) {
				if (gear[a][i + j] - '0' + gear[b][j] - '0' <= 3)
					continue;
				possible = false;
				break;
			}

			if (possible) {
				min = Math.min(min, Math.max(i + size[b], size[a]));
				break;
			}
		}

		return min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gear = new char[2][];
		size = new int[2];

		gear[0] = br.readLine().toCharArray();
		size[0] = gear[0].length;

		gear[1] = br.readLine().toCharArray();
		size[1] = gear[1].length;

		int answer = Math.min(getMin(0, 1), getMin(1, 0));

		System.out.println(answer);
	}
}