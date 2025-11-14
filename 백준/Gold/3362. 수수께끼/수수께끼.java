import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Coin implements Comparable<Coin> {
		int a, ind;

		public Coin(int a, int ind) {
			super();
			this.a = a;
			this.ind = ind;
		}

		@Override
		public int compareTo(Coin c) {
			return this.a - c.a;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int n, k, a;
		Coin[] coins;

		int l, r, m, answer;

		long sum;
		boolean possible;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");

			coins = new Coin[n];

			for (int i = 0; i < n; i++) {
				a = Integer.parseInt(st.nextToken());
				coins[i] = new Coin(a, i + 1);
			}

			Arrays.sort(coins);

			l = 1;
			r = n;
			answer = -1;
            
            //m 인덱스까지의 동전을 가지고 1~k까지 전부 만들 수 있는지 체크 
			while (l <= r) {
				m = (l + r) / 2;
				possible = true;
				sum = 0L;

				for (Coin c : coins) {
                    // 인덱스 범위 넘어가면 패스
					if (c.ind > m)
						continue;
                    
                    //현재 동전 값 > 합산 값+1이면 만들지 못하는 값이 생기므로 불가능 표시
					if (c.a > sum + 1) {
						possible = false;
						break;
					} else {
						sum += c.a;
					}
                    
                    // 목표 수치 넘기면 탈출
					if (sum >= k)
						break;
				}

				if (possible && sum >= k) {
					answer = m;
					r = m - 1;
				} else {
					l = m + 1;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}