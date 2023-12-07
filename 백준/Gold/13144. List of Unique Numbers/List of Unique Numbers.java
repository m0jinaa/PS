import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n, k;
	static int[] a;
	static boolean[] exists = new boolean[100001];

	static long find() {
		int l = 0;
		int r = 0;

		long answer = 0;

		while (r < n) {

			if (exists[a[r]]) {
				while (exists[a[r]]) {
					exists[a[l++]] = false;
				}
			}

			exists[a[r]] = true;

			answer += (r - l + 1);

			r++;

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		a = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		long answer = find();

		System.out.println(answer);
	}
}