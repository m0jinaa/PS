import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] quality = new int[n];

		for (int i = 0; i < n; i++) {
			quality[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(quality);

		int s = 0;
		int e = n - 1;

		int answer = 0;

		while (s <= e) {
			if (s == e) {
				answer += quality[e];
				break;
			} else {
				answer += (quality[e] * 2);
			}
			s++;
			e--;
		}

		System.out.println(answer);
	}
}