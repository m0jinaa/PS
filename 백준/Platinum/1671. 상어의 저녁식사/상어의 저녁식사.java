import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] sharks;
	static boolean[] used;
	static int[] eaten;
	static ArrayList<Integer>[] canEat;

	static void checkPrey() {
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (sharks[i][0] >= sharks[j][0] && sharks[i][1] >= sharks[j][1] && sharks[i][2] >= sharks[j][2] &&!(sharks[i][0] == sharks[j][0] && sharks[i][1] == sharks[j][1] && sharks[i][2] == sharks[j][2])) {
					canEat[i].add(j);
					canEat[n+i].add(j);					
				}
				if (sharks[i][0] <= sharks[j][0] && sharks[i][1] <= sharks[j][1] && sharks[i][2] <= sharks[j][2]) {
					canEat[j].add(i);
					canEat[n+j].add(i);
				}
			}
		}
	}

	static boolean dfs(int x) {
		for(int y : canEat[x]) {
			if(used[y])
				continue;
			used[y] = true;
			if(eaten[y]==0 || dfs(eaten[y])) {
				eaten[y] = x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		canEat = new ArrayList[2*n+1];
		eaten = new int[n+1];
		used = new boolean[n+1];
		//상어 정보 저장
		sharks = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sharks[i][0] = Integer.parseInt(st.nextToken());
			sharks[i][1] = Integer.parseInt(st.nextToken());
			sharks[i][2] = Integer.parseInt(st.nextToken());
			
			canEat[i] = new ArrayList<>();
			canEat[n+i] = new ArrayList<>();
			
		}
		
		//먹이 사슬 관계 정립
		checkPrey();
		int cnt = n;
		for(int i = 1;i<=2*n;i++) {
			Arrays.fill(used, false);
			if(dfs(i)) {
				cnt--;
			}
		}
		
		System.out.println(cnt);
	}
}