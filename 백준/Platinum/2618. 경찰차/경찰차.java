import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, w;
	static int[][] A, B;
	static int[][] dp;
	static StringBuilder sb;

	static int getAnswer(int a, int b) {
		if (a == w || b == w)
			return 0;
		if (dp[a][b] != -1)
			return dp[a][b];

		int next = Math.max(a, b) + 1;

		int distA = Math.abs(A[next][0] - A[a][0]) + Math.abs(A[next][1] - A[a][1]);
		int distB = Math.abs(B[next][0] - B[b][0]) + Math.abs(B[next][1] - B[b][1]);

		int caseA = getAnswer(next, b) + distA;
		int caseB = getAnswer(a, next) + distB;

		return dp[a][b] = Math.min(caseA, caseB);

	}

	static void getPath(int a, int b) {
		if (a == w || b == w)
			return;
		
		int next = Math.max(a, b) + 1;

		int distA = Math.abs(A[next][0] - A[a][0]) + Math.abs(A[next][1] - A[a][1]);
		int distB = Math.abs(B[next][0] - B[b][0]) + Math.abs(B[next][1] - B[b][1]);

		int caseA = getAnswer(next, b) + distA;
		int caseB = getAnswer(a, next) + distB;

		if(caseA>caseB) {
			sb.append(2).append("\n");
			getPath(a,next);
		}
		else {
			sb.append(1).append("\n");
			getPath(next,b);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());

		dp = new int[w + 1][w + 1];

		A = new int[w + 1][2];
		B = new int[w + 1][2];
		
		A[0][0] = A[0][1] = 1;
		B[0][0] = B[0][1] = n;
        
		Arrays.fill(dp[0], -1);
        
		for (int i = 1; i <= w; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i][0] = B[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = B[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		
		sb.append(getAnswer(0,0)).append("\n");
		
		getPath(0,0);
		
		System.out.println(sb.toString());
	}
}