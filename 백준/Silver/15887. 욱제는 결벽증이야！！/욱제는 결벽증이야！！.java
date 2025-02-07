import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] original, sorted, loc;

	static void flip(int s, int e) {
		int tempVal, tempLoc;

		while (s < e) {
			tempVal = original[s];
			tempLoc = loc[original[s]];
			loc[original[s]] = loc[original[e]];
			loc[original[e]] = tempLoc;
			original[s++] = original[e];
			original[e--] = tempVal;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		original = new int[n];
		sorted = new int[n];
		loc = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			original[i] = Integer.parseInt(st.nextToken());
			sorted[i] = original[i];
			loc[original[i]] = i;
		}

		Arrays.sort(sorted);

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (original[i] == i + 1)
				continue;
			cnt++;
			sb.append(i + 1).append(" ").append(loc[i + 1] + 1).append("\n");
			flip(i, loc[i + 1]);
		}

		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}