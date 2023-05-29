import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] power;
	static int diff = 2000;
	static int[] A;
	static int[] B;

	static void check(int a, int b) {
		int expA = 0;
		
		for(int i = 0;i<a;i++) {
			for(int j = i+1;j<a;j++) {
				expA+=power[A[i]][A[j]]+power[A[j]][A[i]];
			}
		}
		
		int expB = 0;
		
		for(int i = 0;i<b;i++) {
			for(int j = i+1;j<b;j++) {
				expB+=power[B[i]][B[j]]+power[B[j]][B[i]];
			}
		}
		
		int d = Math.abs(expA-expB);
		
		diff = Math.min(diff, d);
	}
	static void combi(int ind, int a, int b) {
		if (ind == n) {
			if (a != 0 && b != 0) {
				check(a, b);
			}
		} else {
			// A팀에 ind 팀원 추가
			A[a] = ind;
			combi(ind + 1, a + 1, b);
			
			// B팀에 ind 팀원 추가
			B[b] = ind;
			combi(ind + 1, a, b + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		power = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		A = new int[n];
		B = new int[n];

		combi(0, 0, 0);

		System.out.println(diff);
	}
}