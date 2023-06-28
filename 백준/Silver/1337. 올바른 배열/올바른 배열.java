import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		int answer = 5;
		int cnt;
		for(int i = 0;i<n;i++) {
			cnt = 4;
			for(int j = 1;j<5 && i+j<n;j++) {
				if(nums[i+j]<nums[i]+5)
					cnt--;
				else
					break;
			}
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
	}
}