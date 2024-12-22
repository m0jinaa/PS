import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] size = new int[n];

		for (int i = 0; i < n; i++) {
			size[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(size);

		int s = 0;
		int e = 0;

		int answer = 0;

		while (e < n) {
			while (size[e] - size[s] > k) {
				s++;
			}

			answer = Math.max(answer, e - s + 1);
			e++;
		}

		System.out.println(answer);
	}
}