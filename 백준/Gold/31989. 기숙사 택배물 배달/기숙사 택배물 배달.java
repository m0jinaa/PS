import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int N = 2 * n + 1;

		long[] parcel = new long[N + 1];
		int[] dist = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		int p, w;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			parcel[p] += w;
		}

		long answer = 0;

		// 택배 보관소 기준 왼쪽 방향

		long leftSum = 0;

		for (int i = 1; i <= n; i++) {
			leftSum += parcel[i];
		}

		int leftMost = n + 1;

		// 배달하는데 드는 시간
		for (int i = n; i > 0 && leftSum != 0; i--) {
			answer += (leftSum + 1) * (dist[i + 1] - dist[i]);

			leftSum -= parcel[i];

			if (parcel[i] != 0)
				leftMost = i;
		}

		// 돌아오는데 걸리는 시간

		answer += dist[n + 1] - dist[leftMost];

		// 택배 보관소 기준 오른쪽 방향

		long rightSum = 0;
		int rightMost = n + 1;

		for (int i = 1; i <= n; i++) {
			rightSum += parcel[n + 1 + i];
		}

		// 배달하는데 드는 시간
		for (int i = 1; i <= n && rightSum != 0; i++) {
			answer += (rightSum + 1) * (dist[n + 1 + i] - dist[n + i]);

			rightSum -= parcel[n + 1 + i];

			if (parcel[n + 1 + i] != 0)
				rightMost = n + 1 + i;
		}

		// 돌아오는데 걸리는 시간

		answer += dist[rightMost] - dist[n + 1];

		System.out.println(answer);
	}
}