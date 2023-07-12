import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] size = new int[n];

		for (int i = 0; i < n; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(size);

		int s = 0;
		int cnt = 0;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (size[i] == s) {
				cnt++;
			} else {
				answer = Math.max(answer, cnt);
				cnt = 1;
				s = size[i];
			}
		}

		answer = Math.max(answer, cnt);

		System.out.println(answer);
	}
}