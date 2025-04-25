import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] bullets;
	static int[] arr;

	static int getLoc(int x, int ind) {
		int s = 0;
		int e = ind - 1;

		int ret = ind;
		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (arr[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	static int getMax(int x, int s) {

		Arrays.fill(arr, 0);
		int ind = 0;
		arr[ind++] = bullets[x][s];

		int loc;

		for (int i = s + 1; i < s + n; i++) {
			if (bullets[x][i % n] > arr[ind - 1]) {
				arr[ind++] = bullets[x][i % n];
			} else {
				loc = getLoc(bullets[x][i % n], ind);

				arr[loc] = bullets[x][i % n];
			}
		}

		return ind;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		bullets = new int[2][n];
		arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			bullets[0][i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			bullets[1][i] = Integer.parseInt(st.nextToken());
		}

		int Amax = 0;
		int Bmax = 0;
        
        //A와B 각각 i번째 약실부터 시작했을때의 최대증가수열의 길이 구하기
		for (int i = 0; i < n; i++) {
			Amax = Math.max(Amax, getMax(0, i));
			Bmax = Math.max(Bmax, getMax(1, i));
		}

		System.out.println(Amax < Bmax ? "HG Win!" : Amax > Bmax ? "YJ Win!" : "Both Win!");
	}
}