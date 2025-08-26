import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int max = 0;

		int[] woods = new int[n];

		for (int i = 0; i < n; i++) {
			woods[i] = Integer.parseInt(br.readLine());
			max = Math.max(woods[i], max);
		}

		// 몇 번 잘라야하는지
		long cut;

		// 일정 크기의 나무가 몇개 나오는지
		long cnt;

		long answer = 0;
		long profit;

		for (int size = 1; size <= max; size++) {
			cut = 0L;
			cnt = 0L;
			profit = 0L;
			for (int wood : woods) {
				if (wood < size)
					continue;

				cnt = (wood / size);
				cut = (wood / size);

				if (wood % size == 0)
					cut--;

				profit += Math.max(0, cnt * w * size - cut * c);
			}

			answer = Math.max(answer, profit);
		}

		System.out.println(answer);
	}
}