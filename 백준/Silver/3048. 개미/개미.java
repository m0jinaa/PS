import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] direction;
	static char[] ant;
	static int N;

	static void swap(int x, int y) {
		direction[x] = !direction[x];
		direction[y] = !direction[y];

		char c = ant[x];
		ant[x] = ant[y];
		ant[y] = c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		N = n1 + n2;

		ant = new char[N];
		direction = new boolean[N];

		char[] row;

		row = br.readLine().toCharArray();

		for (int i = 0; i < n1; i++) {
			ant[n1 - 1 - i] = row[i];
			direction[n1 - 1 - i] = true;
		}

		row = br.readLine().toCharArray();

		for (int i = 0; i < n2; i++) {
			ant[n1 + i] = row[i];
		}

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			for (int i = 0; i + 1 < N;) {
				if (direction[i] == true && direction[i + 1] == false) {
					swap(i, i + 1);
					i += 2;
				} else {
					i++;
				}
			}
		}

		System.out.println(String.valueOf(ant));
	}
}