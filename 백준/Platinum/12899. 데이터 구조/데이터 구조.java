import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] nums;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	
	static int update(int l, int r, int num, int k) {
		if(l<=num && num<=r) {
			if(l==r) {
				nums[k] = num;
				return cnt[k]+=1;
			}
			else {
				int m = (l+r)/2;
				return cnt[k] = update(l,m,num,2*k)+update(m+1,r,num,2*k+1);
			}
		}
		else
			return cnt[k];
	}
	
	static int get(int l, int r, int o, int k) {
		if(l==r) {
			sb.append(nums[k]).append("\n");
			return cnt[k]-=1;
		}
		else {
			int m = (l+r)/2;
			if(cnt[2*k]<o) {
				return cnt[k] = get(m+1,r,o-cnt[2*k],2*k+1)+cnt[2*k];
			}
			else
				return cnt[k] = get(l,m,o,2*k)+cnt[2*k+1];
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 2000000;
		int n = Integer.parseInt(br.readLine());
		nums = new int[4*N];
		cnt = new int[4*N];
		int t,x;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			if(t==1) {
				update(0,N-1,x,1);
			}
			else {
				get(0,N-1,x,1);
			}
		}
		
		System.out.println(sb.toString());

	}

}
