import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] nums,temp;
	static int cnt;
	static int k;
	static int ans = -1;
	static void merge_sort(int s, int e) {
		if(s<e) {
			int m = (s+e)/2;
			merge_sort(s,m);
			merge_sort(m+1,e);
			merge(s,m,e);
		}
	}
	
	static void merge(int s, int m ,int e) {
		int i = s;
		int j = m+1;
		int t = 0;
		
		while(i<=m && j<=e) {
			if(nums[i]<=nums[j])
				temp[t++] = nums[i++];
			else
				temp[t++] = nums[j++];
		}
		while(i<=m) {
			temp[t++] = nums[i++];
		}
		while(j<=e) {
			temp[t++] = nums[j++];
		}
		
		i = s;
		t = 0;
		while(i<=e) {
			cnt++;
			if(cnt==k) {
				ans = temp[t];
			}
			nums[i++] = temp[t++];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		temp = new int[n];
		st = new StringTokenizer(br.readLine()," ");

		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}		
		merge_sort(0,n-1);
		System.out.println(ans);
	}
}