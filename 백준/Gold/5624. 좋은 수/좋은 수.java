import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX_SUM = 400_000;
		final int ADJUSTMENT = 200_000;
		int n = Integer.parseInt(br.readLine());

		boolean[] canMake = new boolean[MAX_SUM + 1];

		int[] A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
        
        //x+y+z = target => x+y = target-z 활용
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (!canMake[A[i] - A[j] + ADJUSTMENT])
					continue;
				answer++;
				break;
			}

			for (int j = 0; j <= i; j++) {
				canMake[A[i] + A[j] + ADJUSTMENT] = true;
			}
		}

		System.out.println(answer);
	}
}