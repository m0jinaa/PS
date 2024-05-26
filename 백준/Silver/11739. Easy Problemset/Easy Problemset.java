import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] problem = new LinkedList[n];

		int p;

		for (int i = 0; i < n; i++) {
			problem[i] = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());

			while (p-- > 0) {
				problem[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		int i = 0;

		int total = 0;

		while (m > 0) {

			if (problem[i].size() == 0) {
				total += 50;
				m--;
			} else if (problem[i].peek() < total)
				problem[i].poll();
			else {
				total += problem[i].poll();
				m--;
			}
			i = (i + 1) % n;
		}

		System.out.println(total);
	}
}