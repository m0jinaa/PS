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

		int c = n + m;

		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();

		int i = 0;
		int j = 0;

		long diff;

		long answer = 0;

		long cnt = 0;

		while (i < c && j < c) {
			while (i < c && S[i] == '0')
				i++;
			while (i < c && T[j] == '0')
				j++;

			if (i >= c || j >= c)
				break;

			diff = Math.abs(i - j);

			cnt += diff;

			i++;
			j++;
		}

		if (cnt % 2 == 0) {
			answer = (cnt / 2) * (cnt / 2) * 2;
		} else {
			answer = (cnt / 2) * (cnt / 2) + ((cnt / 2) + 1) * ((cnt / 2) + 1);
		}
		System.out.println(answer);
	}
}