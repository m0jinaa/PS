import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n  =Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		for(int x : nums) {
			sb.append(x).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}