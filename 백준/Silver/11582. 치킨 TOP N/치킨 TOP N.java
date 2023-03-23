import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] flavor;
	static int[] sort(int s, int e) {
		int[] arr = new int[e-s+1];
		if(s==e) {
			arr[0] = flavor[s];
			return arr;
		}
		else {
			int m = (s+e)/2;
			int[] left = sort(s,m);
			int[] right = sort(m+1,e);
			
			int l = 0;
			int r = 0;
			int lsize = left.length;
			int rsize = right.length;
			int i = 0;
			while(l<lsize && r<rsize) {
				if(left[l]<right[r]) {
					arr[i++] = left[l++];
				}
				else {
					arr[i++] = right[r++];
				}
			}
			
			while(l<lsize) {
				arr[i++] = left[l++];
			}
			while(r<rsize) {
				arr[i++] = right[r++];
			}
			
			return arr;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		flavor = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			flavor[i] = Integer.parseInt(st.nextToken());
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int size = n/k;
		int[] arr;
		
		for(int i = 0;i<k;i++) {
			arr = sort(size*i,size*(i+1)-1);
			for(int x:arr) {
				sb.append(x).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}

}
