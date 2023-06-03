import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public final class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int k = 1 << n;

		// 1번째 스위치 -> 0번 인덱스로 사용
		int[] v = new int[k];

		// x번째 스위치를 토글시켰을 때 영향받는 스위치의 값 저장
		int[] change = new int[k];

		Arrays.fill(v, k);

		int s = 0, x;

		st = new StringTokenizer(br.readLine(), " ");
		// 초기 상태 저장
		// 1번째 : 1, 2번째 2, 3번째 : 4 ... 더하기 -> 최대 2^20-1
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (x == 1) {
				s += 1 << i;
			}
		}

		int c, p;

		// 영향받는 스위치 저장
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());

			p = 1 << i;// 직접적으로 바꾸는 스위치 값

			while (c-- > 0) {// 영향받는 스위치 값 저장
				x = Integer.parseInt(st.nextToken());
				p += 1 << (x - 1);
			}
			change[i] = p;
		}

		LinkedList<Integer> q = new LinkedList<>();

		q.add(s);
		v[s] = 0;

		int answer = -1;
		int now, nx;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now == k - 1) {// 다 켜져있으면 탈출
				answer = v[now];
				break;
			}

			for (int i = 0; i < n; i++) {//i반째 스위치 바꿀 때 영향받는거 표시
				//켜져있는 스위치인지 확인
				if((now & (1<<i))!=0)
					continue;
				
				nx = now ^ change[i];
				
				if (v[nx] != k)
					continue;
				
				v[nx] = v[now] + 1;
				q.add(nx);
			}
		}

		System.out.println(answer);
	}
}