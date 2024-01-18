import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] u, d, f, b, l, r;

	static void up(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];
		temp[0] = f[0][0];
		temp[1] = f[0][1];
		temp[2] = f[0][2];

		if (dir == '-') {
			f[0][0] = l[0][0];
			f[0][1] = l[0][1];
			f[0][2] = l[0][2];

			l[0][0] = b[0][0];
			l[0][1] = b[0][1];
			l[0][2] = b[0][2];

			b[0][0] = r[0][0];
			b[0][1] = r[0][1];
			b[0][2] = r[0][2];

			r[0][0] = temp[0];
			r[0][1] = temp[1];
			r[0][2] = temp[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = u[i][j];
				}
			}
		} else {
			f[0][0] = r[0][0];
			f[0][1] = r[0][1];
			f[0][2] = r[0][2];

			r[0][0] = b[0][0];
			r[0][1] = b[0][1];
			r[0][2] = b[0][2];

			b[0][0] = l[0][0];
			b[0][1] = l[0][1];
			b[0][2] = l[0][2];

			l[0][0] = temp[0];
			l[0][1] = temp[1];
			l[0][2] = temp[2];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = u[i][j];
				}
			}
		}

		u = side;

	}

	static void down(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];
		temp[0] = f[2][0];
		temp[1] = f[2][1];
		temp[2] = f[2][2];
		if (dir == '+') {
			f[2][0] = l[2][0];
			f[2][1] = l[2][1];
			f[2][2] = l[2][2];

			l[2][0] = b[2][0];
			l[2][1] = b[2][1];
			l[2][2] = b[2][2];

			b[2][0] = r[2][0];
			b[2][1] = r[2][1];
			b[2][2] = r[2][2];

			r[2][0] = temp[0];
			r[2][1] = temp[1];
			r[2][2] = temp[2];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = d[i][j];
				}
			}
		} else {
			f[2][0] = r[2][0];
			f[2][1] = r[2][1];
			f[2][2] = r[2][2];

			r[2][0] = b[2][0];
			r[2][1] = b[2][1];
			r[2][2] = b[2][2];

			b[2][0] = l[2][0];
			b[2][1] = l[2][1];
			b[2][2] = l[2][2];

			l[2][0] = temp[0];
			l[2][1] = temp[1];
			l[2][2] = temp[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = d[i][j];
				}
			}
		}

		d = side;
	}

	static void front(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];

		temp[0] = u[2][0];
		temp[1] = u[2][1];
		temp[2] = u[2][2];

		if (dir == '+') {

			u[2][0] = l[2][2];
			u[2][1] = l[1][2];
			u[2][2] = l[0][2];

			l[0][2] = d[0][0];
			l[1][2] = d[0][1];
			l[2][2] = d[0][2];

			d[0][0] = r[2][0];
			d[0][1] = r[1][0];
			d[0][2] = r[0][0];

			r[0][0] = temp[0];
			r[1][0] = temp[1];
			r[2][0] = temp[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = f[i][j];
				}
			}
		} else {

			u[2][0] = r[0][0];
			u[2][1] = r[1][0];
			u[2][2] = r[2][0];

			r[0][0] = d[0][2];
			r[1][0] = d[0][1];
			r[2][0] = d[0][0];

			d[0][0] = l[0][2];
			d[0][1] = l[1][2];
			d[0][2] = l[2][2];

			l[0][2] = temp[2];
			l[1][2] = temp[1];
			l[2][2] = temp[0];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = f[i][j];
				}
			}
		}

		f = side;
	}

	static void back(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];

		temp[0] = u[0][0];
		temp[1] = u[0][1];
		temp[2] = u[0][2];
		if (dir == '+') {

			u[0][0] = r[0][2];
			u[0][1] = r[1][2];
			u[0][2] = r[2][2];

			r[0][2] = d[2][2];
			r[1][2] = d[2][1];
			r[2][2] = d[2][0];

			d[2][0] = l[0][0];
			d[2][1] = l[1][0];
			d[2][2] = l[2][0];

			l[0][0] = temp[2];
			l[1][0] = temp[1];
			l[2][0] = temp[0];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = b[i][j];
				}
			}
		} else {
			u[0][0] = l[2][0];
			u[0][1] = l[1][0];
			u[0][2] = l[0][0];

			l[0][0] = d[2][0];
			l[1][0] = d[2][1];
			l[2][0] = d[2][2];

			d[2][0] = r[2][2];
			d[2][1] = r[1][2];
			d[2][2] = r[0][2];

			r[0][2] = temp[0];
			r[1][2] = temp[1];
			r[2][2] = temp[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = b[i][j];
				}
			}
		}
		b = side;
	}

	static void left(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];

		temp[0] = u[0][0];
		temp[1] = u[1][0];
		temp[2] = u[2][0];
		if (dir == '+') {

			u[0][0] = b[2][2];
			u[1][0] = b[1][2];
			u[2][0] = b[0][2];

			b[0][2] = d[2][0];
			b[1][2] = d[1][0];
			b[2][2] = d[0][0];

			d[0][0] = f[0][0];
			d[1][0] = f[1][0];
			d[2][0] = f[2][0];

			f[0][0] = temp[0];
			f[1][0] = temp[1];
			f[2][0] = temp[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = l[i][j];
				}
			}
		} else {

			u[0][0] = f[0][0];
			u[1][0] = f[1][0];
			u[2][0] = f[2][0];

			f[0][0] = d[0][0];
			f[1][0] = d[1][0];
			f[2][0] = d[2][0];

			d[0][0] = b[2][2];
			d[1][0] = b[1][2];
			d[2][0] = b[0][2];

			b[0][2] = temp[2];
			b[1][2] = temp[1];
			b[2][2] = temp[0];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = l[i][j];
				}
			}
		}

		l = side;
	}

	static void right(char dir) {
		char[] temp = new char[3];
		char[][] side = new char[3][3];

		temp[0] = u[0][2];
		temp[1] = u[1][2];
		temp[2] = u[2][2];
		if (dir == '+') {

			u[0][2] = f[0][2];
			u[1][2] = f[1][2];
			u[2][2] = f[2][2];

			f[0][2] = d[0][2];
			f[1][2] = d[1][2];
			f[2][2] = d[2][2];

			d[0][2] = b[2][0];
			d[1][2] = b[1][0];
			d[2][2] = b[0][0];

			b[0][0] = temp[2];
			b[1][0] = temp[1];
			b[2][0] = temp[0];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[j][2 - i] = r[i][j];
				}
			}
		} else {

			u[0][2] = b[2][0];
			u[1][2] = b[1][0];
			u[2][2] = b[0][0];

			b[0][0] = d[2][2];
			b[1][0] = d[1][2];
			b[2][0] = d[0][2];

			d[0][2] = f[0][2];
			d[1][2] = f[1][2];
			d[2][2] = f[2][2];

			f[0][2] = temp[0];
			f[1][2] = temp[1];
			f[2][2] = temp[2];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[2 - j][i] = r[i][j];
				}
			}
		}

		r = side;
	}

	public static void init() {
		f = new char[][] { { 'r', 'r', 'r' }, { 'r', 'r', 'r' }, { 'r', 'r', 'r' } };
		b = new char[][] { { 'o', 'o', 'o' }, { 'o', 'o', 'o' }, { 'o', 'o', 'o' } };
		u = new char[][] { { 'w', 'w', 'w' }, { 'w', 'w', 'w' }, { 'w', 'w', 'w' } };
		d = new char[][] { { 'y', 'y', 'y' }, { 'y', 'y', 'y' }, { 'y', 'y', 'y' } };
		l = new char[][] { { 'g', 'g', 'g' }, { 'g', 'g', 'g' }, { 'g', 'g', 'g' } };
		r = new char[][] { { 'b', 'b', 'b' }, { 'b', 'b', 'b' }, { 'b', 'b', 'b' } };
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int n;
		char[] order;
		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			init();
			st = new StringTokenizer(br.readLine(), " ");
			while (n-- > 0) {
				order = st.nextToken().toCharArray();
				switch (order[0]) {
				case 'F':
					front(order[1]);
					break;
				case 'B':
					back(order[1]);
					break;
				case 'U':
					up(order[1]);
					break;
				case 'D':
					down(order[1]);
					break;
				case 'L':
					left(order[1]);
					break;
				case 'R':
					right(order[1]);
					break;
				}
			}

			for (char[] row : u) {
				sb.append(String.valueOf(row)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}