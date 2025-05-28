import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int b, n, m;
	static boolean[][] presents;
	static Employee[] employees;

	static class Employee {
		int r, c, t;
		int timeLeft = 0;

		public Employee(int x, int y, int r) {
			super();
			this.r = x;
			this.c = y;
			this.t = r;
		}

		public int check() {
			if (this.timeLeft > 1) {
				this.timeLeft = this.timeLeft - 1;
				return 0;
			}

			int c = 0;

			if (presents[this.r + 1][this.c]) {
				presents[this.r + 1][this.c] = false;
				c = 1;
				this.timeLeft = this.t;
			} else if (presents[this.r][this.c + 1]) {
				presents[this.r][this.c + 1] = false;
				c = 1;
				this.timeLeft = this.t;
			} else if (presents[this.r - 1][this.c]) {
				presents[this.r - 1][this.c] = false;
				c = 1;
				this.timeLeft = this.t;
			}

			return c;
		}
	}

	// 컨베이어벨트 움직이고 선물을 놓을 수 있다면 놓고, 컨베이어벨트에 선물이 남았는지 리턴하기
	static boolean move(int t) {

		int x = b - 1;
		int y = 0;

		boolean exists = false;

		while (y != b - 1) {
			presents[x][y] = presents[x][y + 1];
			exists |= presents[x][y];
			y++;
		}

		while (x != 0) {
			presents[x][y] = presents[x - 1][y];
			exists |= presents[x][y];
			x--;
		}

		while (y != 0) {
			presents[x][y] = presents[x][y - 1];
			exists |= presents[x][y];
			y--;
		}

		presents[0][0] = false;

		if (t < m) {
			presents[0][0] = true;
			exists = true;
		}

		return exists;
	}

	// 직원들이 선물 만들 수 있는지 체크하고 새롭게 만들어지는 선물 수 리턴
	static int checkEmployee() {
		int cnt = 0;

		for (Employee e : employees) {
			cnt += e.check();
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 직원들을 컨베이어벨트에 서있는 순서대로 정렬하기

		st = new StringTokenizer(br.readLine(), " ");

		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		presents = new boolean[b][b];

		employees = new Employee[n];

		int r, c, t;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			employees[i] = new Employee(r, c, t);
		}

		int time = 0;
		int answer = 0;

		while (move(time)) {
			answer += checkEmployee();
			time++;
		}

		System.out.println(answer);
	}
}