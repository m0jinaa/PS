import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int[] size;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return false;
		else if(size[x]<size[y]) {
			size[y] +=size[x];
			root[x] = y;
		}
		else {
			size[x]+=size[y];
			root[y] = x;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		size = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			root[i] = i;
			size[i] = 1;
		}
		
		int x,y;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		
		int c,h,k;
		
		st = new StringTokenizer(br.readLine()," ");
		
		c = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		c = find(c);
		h = find(h);
		ArrayList<Integer> teams = new ArrayList<Integer>();
		int t;
		for(int i = 1;i<=n;i++) {
			t = find(i);
			if(t!=c && t!=h && t==i)
				teams.add(t);
		}
		
		Collections.sort(teams, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return size[o2]-size[o1];
			}
		});
		
		int sum = size[c];
		
		for(int i:teams) {
			if(k==0)
				break;
			sum+=size[i];
			k--;
		}
		System.out.println(sum);
				
	}
}