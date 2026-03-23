import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] stack = new int[4];

		int x;
		int ind;
		int min;

		boolean possible = true;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			min = -1;
			ind = -1;

			for (int j = 0; j < 4; j++) {
				if (stack[j] > x)
					continue;
				else if (min < stack[j]) {
					min = stack[j];
					ind = j;
				}
			}

			if (ind == -1) {
				possible = false;
				break;
			} else {
				stack[ind] = x;
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}