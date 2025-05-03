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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 시간표 입력받기
		int[] timetable = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			timetable[i] = Integer.parseInt(st.nextToken());
		}

		// 선호, 비선호 과목 입력받기
		int[] preference = new int[m + 1];

		int l, h;

		st = new StringTokenizer(br.readLine(), " ");

		while (a-- > 0) {
			l = Integer.parseInt(st.nextToken());

			preference[l] = 1;
		}

		st = new StringTokenizer(br.readLine(), " ");

		while (b-- > 0) {
			h = Integer.parseInt(st.nextToken());

			preference[h] = -1;
		}

		int p = 0;

		int like = 0;
		int dislike = 0;

		for (int t : timetable) {
			// 선호도 아니고 비선호도 아님
			if (preference[t] == 0) {
				like = 0;
				dislike = 0;
			} else if (preference[t] == 1) {
				like++;
				dislike = 0;

				if (like == 3) {
					p += 3;
				} else if (like > 3) {
					p++;
				}
			} else {
				dislike++;
				like = 0;
				if (dislike == 3) {
					p -= 3;
				} else if (dislike > 3) {
					p--;
				}
			}
		}

		System.out.println(p);
	}
}