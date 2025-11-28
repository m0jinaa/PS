import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, l;
	static int[] icicle;
	static int[] time;

	static int getTime(int i) {
		if (time[i] != 0)
			return time[i];

		int t = 0;
		int left = 0, right = 0;
        
        //왼쪽 고드름이 현재 위치의 고드름보다 긴 경우
		if (i > 0 && icicle[i - 1] > icicle[i]) {
			left = getTime(i - 1);
		}
        
        // 오른쪽 고드름이 현재 위치의 고드름보다 긴 경우
		if (i < n - 1 && icicle[i + 1] > icicle[i]) {
			right = getTime(i + 1);
		}
        
        // 현재위치의 고드름이 부러지는데 걸리는 시간
		t = Math.max(left, right) + (l - icicle[i]);

		return time[i] = t;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		// time[i] => i+1번째 고드름이 부러지는데까지 걸리는 시간
		time = new int[n];

		// 고드름 길이 저장
		icicle = new int[n];

		int a;

		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(br.readLine());
			icicle[i] = a;
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, getTime(i));
		}

		System.out.println(answer);
	}
}