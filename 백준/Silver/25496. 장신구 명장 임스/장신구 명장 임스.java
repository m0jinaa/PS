import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int p = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (p < 200) {
				p += a[i];
				answer++;
			} else
				break;
		}

		System.out.println(answer);
	}
}