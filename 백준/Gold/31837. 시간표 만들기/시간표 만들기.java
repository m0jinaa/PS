import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Lecture implements Comparable<Lecture> {
		int credit;
		int group;
		int start;
		int end;

		public Lecture(int credit, int group, int start, int end) {
			super();
			this.credit = credit;
			this.group = group;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture l) {
			if (this.start != l.start) {
				return this.start - l.start;
			} else {
				return this.end - l.end;
			}
		}
	}

	static ArrayList<Lecture> lectures;
	static int size;
	static int answer = 0;
	static boolean[] filled;

	static void checkPossible(int c, int ind, int t) {
		// 현재까지 c학점 채웠고, ind번째 강의를 볼 차례이고,t시간 이후의 강의만 선택가능한 상황

		if (c == 22) {
			// 22학점을 만들 수 있을 때
			answer++;
			return;
		} else if (ind == size) {
			// 모든 수업을 다 살펴 봤을 때
			return;
		} else {
			Lecture l = lectures.get(ind);

			if (l.start >= t && c + l.credit <= 22 && !filled[l.group]) {
				// 들을 수 있는 시간이고, 학점 합이 22를 넘지 않고, 같은 그룹의 수업을 듣지 않을 때
				filled[l.group] = true;
				checkPossible(c + l.credit, ind + 1, l.end);
				filled[l.group] = false;
			}

			checkPossible(c, ind + 1, t);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		lectures = new ArrayList<>();
		filled = new boolean[n];

		int a, c, d, s, e;

		for (int g = 0; g < n; g++) {
			a = Integer.parseInt(br.readLine());

			while (a-- > 0) {
				st = new StringTokenizer(br.readLine(), " :");

				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				s = (d - 1) * 24 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
				e = (d - 1) * 24 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

				lectures.add(new Lecture(c, g, s, e));
			}
		}

		Collections.sort(lectures);
		size = lectures.size();

		checkPossible(0, 0, 0);

		System.out.println(answer);
	}
}