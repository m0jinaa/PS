import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] root, candy, size;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return;
		else if(x<y) {
			root[y] = x;
			candy[x]+=candy[y];
			size[x]+=size[y];
		}
		else {
			root[x] = y;
			candy[y]+=candy[x];
			size[y]+=size[x];
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		root = new int[n+1];
		candy = new int[n+1];
		size = new int[n+1];
		for(int i = 1; i<=n;i++) {
			root[i] = i;
			size[i] = 1;
			candy[i] = Integer.parseInt(st.nextToken());
		}
		int u,v;
		
		for(int i = 0 ;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		
		ArrayList<Point> candies = new ArrayList<Point>();
		
		for(int i = 1;i<=n;i++) {
			if(find(i)==i) {
				candies.add(new Point(size[i],candy[i]));
			}
		}
		
		int h = candies.size();
		
		int[][] bag =  new int[2][k];
		int f,c;
		for(int i = 0;i<h;i++) {
			f = candies.get(i).x;
			c = candies.get(i).y;
			for(int j = 1;j<k;j++) {
				if(j<f)
					bag[1-(i%2)][j] = bag[(i%2)][j];
				else
					bag[1-(i%2)][j] = Math.max(bag[(i%2)][j],bag[(i%2)][j-f]+c);
			}
		}
		
		System.out.println(bag[h%2][k-1]);
	}
}