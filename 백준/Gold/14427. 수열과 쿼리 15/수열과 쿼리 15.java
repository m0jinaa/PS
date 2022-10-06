import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] tree;
	static int[] nums;
	
	static int makeTree(int s, int e, int k) {
		if(s==e) {
			tree[k] = s;
		}
		else {
			int mid = (s+e)/2;
			int left = makeTree(s,mid,2*k);
			int right = makeTree(mid+1,e,2*k+1);
			if(nums[left]<=nums[right]) {
				tree[k] = left;
			}
			else
				tree[k] = right;
		}
		return tree[k];
	}
	
	static void update(int l, int r, int ind, int v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				nums[ind] = v;
			}
			if(l!=r) {
				int mid = (l+r)/2;
				update(l,mid,ind,v,2*k);
				update(mid+1,r,ind,v,2*k+1);				
				tree[k] = nums[tree[2*k]]<=nums[tree[2*k+1]]?tree[2*k]:tree[2*k+1];
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		nums = new int[n];
		tree = new int[4*n];
		
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		makeTree(0,n-1,1);
		
		int m = Integer.parseInt(br.readLine());
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			switch(a) {
			case 1:
				b = Integer.parseInt(st.nextToken())-1;
				c = Integer.parseInt(st.nextToken());
				update(0,n-1,b,c,1);
				break;
			case 2:
				sb.append(tree[1]+1).append("\n");
                break;
			}
		}
		System.out.println(sb.toString());
	}
}