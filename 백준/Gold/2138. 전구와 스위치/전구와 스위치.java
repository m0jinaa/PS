import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] bulb;
	static int[] target;

	static void toggle(int x) {
		if (x - 1 >= 0) {
			bulb[x - 1] = 1 - bulb[x - 1];
		}

		bulb[x] = 1 - bulb[x];

		if (x + 1 < n) {
			bulb[x + 1] = 1 - bulb[x + 1];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		bulb = new int[n];
		target = new int[n];

		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			bulb[i] = input[i] - '0';
		}

		input = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			target[i] = input[i] - '0';
		}

		int answer = n + 1;

		int[] temp = new int[n];
		System.arraycopy(bulb, 0, temp, 0, n);
		// 맨 처음 자리 안바꿈
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			if (target[i - 1] != bulb[i - 1]) {
				toggle(i);
				cnt++;
			}
		}
		if (bulb[n - 1] == target[n - 1]) {
			answer = Math.min(answer, cnt);
		}

		// 맨 처음 자리 바꿈
		System.arraycopy(temp, 0, bulb, 0, n);
		cnt = 0;
		toggle(0);
		cnt++;
		for (int i = 1; i < n; i++) {
			if (target[i - 1] != bulb[i - 1]) {
				toggle(i);
				cnt++;
			}
		}
		if (bulb[n - 1] == target[n - 1]) {
			answer = Math.min(answer, cnt);
		}

		System.out.println(answer == n + 1 ? -1 : answer);
	}
}