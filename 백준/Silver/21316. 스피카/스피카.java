import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 12;
		ArrayList<Integer>[] connected = new ArrayList[n + 1];
		int[] cnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			connected[i] = new ArrayList<>();
		}
		int x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			connected[x].add(y);
			connected[y].add(x);
			cnt[x]++;
			cnt[y]++;
		}

		boolean[] check = new boolean[4];

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(check, false);
			for (int t : connected[i]) {
				check[cnt[t]] = true;
			}

			if (cnt[i] == 3 && check[1] && check[2] && check[3]) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);

	}
}