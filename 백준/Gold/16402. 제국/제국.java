import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int x, int y) {
		
		int rx = find(x);
		int ry = find(y);
		
		if(rx==ry) {
			root[ry] = y;
			root[y] = y;
			root[rx] = y;
			
		}
		else{
			root[rx] = ry;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		String[] name = new String[n+1];
		Map<String,Integer> map = new HashMap<String,Integer>();
		String nam;
		for(int i = 1; i<=n;i++) {
			nam = br.readLine();
			map.put(nam, i);
			name[i] = nam;
			root[i] = i;
		}
		
		String k1,k2;
		int w;
		for(int i = 0 ;i<m;i++) {
			st = new StringTokenizer(br.readLine(),",");
			k1 = st.nextToken();
			k2 = st.nextToken();
			w =  Integer.parseInt(st.nextToken());
			if(w==1)
				union(map.get(k2),map.get(k1));
			else
				union(map.get(k1),map.get(k2));
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> answer = new ArrayList<String>();
		for(int i = 1;i<=n;i++)
			if(find(i)==i)
				answer.add(name[i]);
		Collections.sort(answer);
		sb.append(answer.size()).append("\n");
		for(String ans:answer)
			sb.append(ans).append("\n");
		System.out.println(sb.toString());
	}
}