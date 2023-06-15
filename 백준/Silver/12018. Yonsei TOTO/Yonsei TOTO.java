import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int p, l;

		int[] need = new int[n];
		int[] mileages;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			mileages = new int[p];
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < p; j++) {
				mileages[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(mileages);
			if(p<l) {
				need[i] = 1;
			}
			else {
				need[i] = mileages[p - l];
			}
		}

		Arrays.sort(need);

		int answer = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += need[i];
			if (sum <= m) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}