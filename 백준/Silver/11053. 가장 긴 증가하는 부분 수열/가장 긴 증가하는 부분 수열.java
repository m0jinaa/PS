import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] nums;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		cnt = new int[n];
		Arrays.fill(cnt, 1);
		cnt[0] = 1;
		int answer = 1;
		for(int i = 1;i<n;i++) {
			for(int j = i-1;j>=0;j--) {
				if(nums[i]>nums[j]) {
					cnt[i] = Math.max(cnt[i], cnt[j]+1);
				}
			}
			answer = answer<cnt[i]?cnt[i]:answer;
		}
		System.out.println(answer);
	}
}