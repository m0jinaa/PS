import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] sum = new long[n + 1];

		long a;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			a = Long.parseLong(st.nextToken());

			sum[i] = sum[i - 1] + a;
		}

		int now = 1;

		long cnt = 0;
		long immune = 0;
		long maxIncreasement = 0;
		long c;

		while (now <= n) {

			// x번째에서 1번으로 돌아간다고 했을 때 x에서 얻는 면역력- x까지오기위해 써야하는 면역력이 가장 큰 곳에서 1번으로 돌아가기위해 계산
			maxIncreasement = Math.max(maxIncreasement, sum[now] - sum[now - 1] * 2);

			// 현재의 면역력으로는 현재 위치를 통과할 수 없을 때
			// 충분한 면역력을 위해 1번으로 돌아가야하는 횟수 계산
			if (immune < sum[now] - sum[now - 1]) {
				c = (long) Math.ceil((sum[now] - sum[now - 1] - immune) * 1.0 / maxIncreasement);
				cnt += c;
				immune += c * maxIncreasement;
			}

			immune -= (sum[now] - sum[now - 1]);
			now++;
		}

		System.out.println(cnt);
	}
}