import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] bigMan = new int[n];
		int[] smallMan = new int[n];
		int[] bigWoman = new int[n];
		int[] smallWoman = new int[n];

		int bm = 0;
		int sm = 0;
		int bw = 0;
		int sw = 0;

		int x;

		st = new StringTokenizer(br.readLine(), " ");
		// 남자 선호 키
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			if (x < 0) {
				smallMan[sm++] = -x;
			} else {
				bigMan[bm++] = x;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		// 여자 선호 키
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			if (x < 0) {
				smallWoman[sw++] = -x;
			} else {
				bigWoman[bw++] = x;
			}
		}

		Arrays.sort(bigMan, 0, bm);
		Arrays.sort(smallMan, 0, sm);
		Arrays.sort(bigWoman, 0, bw);
		Arrays.sort(smallWoman, 0, sw);

		int i = 0;
		int j = 0;

		int answer = 0;

		// SmallMan & BigWoman
		while (i < sm && j < bw) {
			if (smallMan[i] > bigWoman[j]) {
				answer++;
				i++;
				j++;
			} else {
				i++;
			}
		}

		i = 0;
		j = 0;

		// SmallWoman & BigMan
		while (i < sw && j < bm) {
			if (smallWoman[i] > bigMan[j]) {
				answer++;
				i++;
				j++;
			} else {
				i++;
			}
		}

		System.out.println(answer);
	}
}