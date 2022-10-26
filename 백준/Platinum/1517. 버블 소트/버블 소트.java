import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] nums;
	static long cnt;

	static int[] mergeSort(int s, int e) {
		if(s==e)
			return new int[] {nums[s]};
		else {
			int[] ans = new int[e-s+1];
			int m = (s+e)/2;
			int[] left = mergeSort(s,m);
			int[] right = mergeSort(m+1,e);
			int ind = 0;
			int i = 0;
			int j = 0;
			int lsize = left.length;
			int rsize = right.length;
			while(i<lsize && j<rsize) {
				if(left[i]>right[j]) {
					ans[ind++] = right[j++];
					cnt+=lsize-i;
				}
				else
					ans[ind++] = left[i++];
			}
			while(i<lsize) {
				ans[ind++] = left[i++];
			}
			while(j<rsize)
				ans[ind++] = right[j++];
			return ans;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0,n-1);
		
		System.out.println(cnt);

	}

}
