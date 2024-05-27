import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		LinkedList<Integer> one = new LinkedList<>();

		LinkedList<Integer> two = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < a; i++) {
			one.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < b; i++) {
			two.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(one, Collections.reverseOrder());
		Collections.sort(two, Collections.reverseOrder());

		int answer = 0;

		if (n % 2 != 0) {
			answer += one.poll();
			a--;
			n--;
		}

		int A, B;

		while (n > 0) {

			if (a >= 2 && b != 0) {
				A = one.get(0) + one.get(1);
				B = two.peek();
				if (A > B) {
					answer += A;
					a -= 2;
					one.poll();
					one.poll();
				} else {
					answer += B;
					b--;
					two.poll();
				}
			} else if (a >= 2) {
				answer += one.poll();
				answer += one.poll();
				a -= 2;
			} else {
				answer += two.poll();
				b--;
			}

			n -= 2;
		}

		System.out.println(answer);
	}
}