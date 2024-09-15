import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int eaten = n - s;

		int c = 0;

		int m = Integer.parseInt(br.readLine());

		int[] time = new int[m + 1];

		for (int i = 0; i < m; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;

		end: for (int t = 0; t < 100000000; t++) {
			for (int i = 0; i < m; i++) {
				if (t % time[i] != 0)
					continue;
				c++;
				if (c == eaten) {
					answer = i + 1;
					break end;
				}
			}
		}

		System.out.println(answer);
	}
}