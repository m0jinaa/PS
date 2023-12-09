import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] dist = new int[n];

		int total = 0;

		for (int i = 0; i < n; i++) {
			dist[i] = Integer.parseInt(br.readLine());
			total += dist[i];
		}
		int a = 0;
		int b = 1;

		int cw = dist[0];
		int ccw = total - dist[0];

		int answer = 0;

		while (a < n) {
			answer = Math.max(answer, Math.min(cw, ccw));
			if (cw == ccw) {
				break;
			} else if (cw > ccw) {
				cw -= dist[a];
				ccw += dist[a++];
				continue;
			}
			cw += dist[b];
			ccw -= dist[b++];
			b %= n;
		}

		System.out.println(answer);
	}
}