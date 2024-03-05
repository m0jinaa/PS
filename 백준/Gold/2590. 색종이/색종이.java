import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());
		int three = Integer.parseInt(br.readLine());
		int four = Integer.parseInt(br.readLine());
		int five = Integer.parseInt(br.readLine());
		int six = Integer.parseInt(br.readLine());

		int t = 0, o = 0;
		int answer = 0;

		// 6칸짜리는 한판
		if (six > 0) {
			answer += six;
			six = 0;
		}

		// 5칸+1칸 11개
		if (five > 0) {
			answer += five;
			one = Math.max(0, one - five * 11);
			five = 0;
		}

		// 4칸+2칸5개 또는 1칸 20개
		if (four > 0) {
			answer += four;
			t = four * 5;
			four = 0;

			if (two >= t) {
				two -= t;
				t = 0;
			} else {
				t -= two;
				two = 0;
				o = t * 4;
			}

			if (o > 0) {
				if (one >= o) {
					one -= o;
					o = 0;
				} else {
					o -= one;
					one = 0;
				}
			}
		}

		// 3칸짜리 4개 또는 3칸1개 2칸 5개 1칸 7개
		if (three > 0) {
			answer += (int) Math.ceil(three / 4.0);

			if (three % 4 == 1) {
				t = 5;
				o = 7;
			} else if (three % 4 == 2) {
				t = 3;
				o = 6;
			} else if (three % 4 == 3) {
				t = 1;
				o = 5;
			} else {
				t = 0;
				o = 0;
			}
			three = 0;

			if (two >= t) {
				two -= t;
				t = 0;
			} else {
				t -= two;
				two = 0;
				o += t * 4;
			}

			if (one >= o) {
				one -= o;
				o = 0;
			} else {
				o -= 0;
				one = 0;
			}
		}

		// 2칸짜리 9개

		if (two > 0) {
			answer += (int) Math.ceil(two / 9.0);
			if (two % 9 == 0)
				o = 0;
			else
				o = (9 - two % 9) * 4;

			if (one >= o) {
				one -= o;
				o = 0;
			} else {
				o -= one;
				one = 0;
			}
		}

		// 1칸짜리 36개
		answer += (int) Math.ceil(one / 36.0);

		System.out.println(answer);
	}
}