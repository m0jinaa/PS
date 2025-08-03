import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, G;
	static long S, W;
	static Land[] board;
	static Ticket[] tickets;
	static boolean[] bought;
	static boolean pass = true;
	static int lock = 0;
	static int now = 0;
	static int fund = 0;
	static int ind = 0;
	static boolean win = true;
	static Ticket ticket;

	static class Ticket {
		int type, x;

		public Ticket(int type, int x) {
			super();
			this.type = type;
			this.x = x;
		}
	}

	static class Land {
		char type;
		long x;

		public Land(char type, long x) {
			super();
			this.type = type;
			this.x = x;
		}
	}

	public static void move(int d1, int d2) {

		// 시작칸을 지나는지 체크용
		int r;

		if (board[now].type == 'J' && !pass) { // 무인도

			lock++;

			// 두 주사위가 같은 수가 나오거나, 3번 턴을 쉬었을 때
			if (d1 == d2 || lock == 3) {
				pass = true;
			}
		} else {

			r = (now + d1 + d2) / N;

			now = (now + d1 + d2) % N;

			// 시작 칸 지나면 월급 받기
			S += W * r;

			switch (board[now].type) {

			case 'L': // 일반 칸
				// 구매 안한 칸이고 돈이 충분히 있을 때
				if (!bought[now] && S >= board[now].x) {
					S -= board[now].x;
					bought[now] = true;
				}
				break;

			case 'F': // 사회복지기금 칸
				// 모인 기금 받고 기부금 0으로 만들기
				S += fund;
				fund = 0;
				break;

			case 'Z': // 우주여행 칸
				// 시작 칸으로 이동하고 월급 받기
				now = 0;
				S += W;
				break;

			case 'J': // 무인도 칸
				pass = false;
				lock = 0;
				break;

			case 'G': // 황금열쇠 칸
				ticket = tickets[ind];
				ind = (ind + 1) % G;

				if (ticket.type == 1) { // 은행에서 돈 받기
					S += ticket.x;
				} else if (ticket.type == 2) { // 은행에 돈 주기
					S -= ticket.x;
					if (S < 0) {
						win = false;
					}
				} else if (ticket.type == 3) { // 사회복지기금에 기부하기
					if (S < ticket.x) {
						win = false;
					} else {
						fund += ticket.x;
						S -= ticket.x;
					}
				} else { // 앞으로 이동하기
					move(ticket.x, 0);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		N = 4 * n - 4;
		S = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		board = new Land[N];
		bought = new boolean[N];
		tickets = new Ticket[G];

		// 황금열쇠
		int t, x;

		for (int i = 0; i < G; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			tickets[i] = new Ticket(t, x);
		}

		// 일반칸 채우기

		char type;
		int amount;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < n - 1; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				type = st.nextToken().charAt(0);
				amount = 0;
				if (type != 'G')
					amount = Integer.parseInt(st.nextToken());
				else { // 황금열쇠 칸
					bought[i * n - i + j] = true;
				}
				board[i * n - i + j] = new Land(type, amount);
			}
		}

		// 특수 칸 채우기

		board[0] = new Land('S', W);
		board[n - 1] = new Land('J', 0);
		board[2 * (n - 1)] = new Land('F', 0);
		board[3 * (n - 1)] = new Land('Z', 0);
		bought[0] = true;
		bought[n - 1] = true;
		bought[2 * (n - 1)] = true;
		bought[3 * (n - 1)] = true;

		// 주사위 굴리기

		int I = Integer.parseInt(br.readLine());

		int d1, d2;

		while (I-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			d1 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());

			move(d1, d2);

			if (!win)
				break;
		}

		for (boolean b : bought) {
			win &= b;
		}

		System.out.println(win ? "WIN" : "LOSE");
	}
}