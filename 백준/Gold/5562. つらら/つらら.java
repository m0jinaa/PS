import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		// time[i] => i+1번째 고드름이 부러지는데까지 걸리는 시간
		int[] time = new int[n];

		// 고드름 길이 저장
		int[] icicle = new int[n];

		LinkedList<Integer> order = new LinkedList<>();
		int a;

		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(br.readLine());
			icicle[i] = a;
			order.add(i);
		}

		// ind를 고드름 길이 내림차순으로 정렬
		Collections.sort(order, new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return icicle[y] - icicle[x];
			}

		});

		int answer = 0;

		int left, right;

		// 길이가 긴 순으로 살펴보면서 현재 위치의 고드름이 부러지는데 걸리는 시간 구하기
		for (int ind : order) {
			left = 0;
			right = 0;

			// 왼쪽에 고드름이 있고, 현재 위치의 고드름보다 긴 경우에만 살펴보기
			if (ind > 0 && icicle[ind - 1] > icicle[ind]) {
				left = time[ind - 1];
			}

			// 오른쪽에 고드름이 있고, 현재 위치의 고드름보다 긴 경우에만 살펴보기
			if (ind < n - 1 && icicle[ind + 1] > icicle[ind]) {
				right = time[ind + 1];
			}

			time[ind] = Math.max(left, right) + (l - icicle[ind]);

			answer = Math.max(time[ind], answer);
		}

		System.out.println(answer);
	}
}