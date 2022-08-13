import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, String> parent;
	static Map<String, Integer> friends;
	public static String find(String s) {
		if(!parent.get(s).equals(s))
			parent.put(s,find(parent.get(s)));
		return parent.get(s);
	}
	public static void union(String a, String b) {
		a = find(a);
		b = find(b);
		if(a.compareTo(b)<0) {//a갸 사전순으로 더 앞서면
			parent.put(b, a);
			friends.put(a, friends.get(a)+friends.get(b));
		}
		else {
			parent.put(a, b);
			friends.put(b, friends.get(a)+friends.get(b));
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			int n = Integer.parseInt(br.readLine());
			parent = new HashMap<String,String>();
			friends = new HashMap<String, Integer>();
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!parent.containsKey(name1)) {
					parent.put(name1, name1);
					friends.put(name1, 1);
				}
				
				if(!parent.containsKey(name2)) {
					parent.put(name2, name2);
					friends.put(name2, 1);
				}
				
				if(!find(name1).equals(find(name2)))
					union(name1,name2);
//				System.out.println(Arrays.toString(parent.entrySet().toArray()));
//				System.out.println(Arrays.toString(friends.entrySet().toArray()));
				System.out.println(friends.get(find(name1)));
			}			
		}
	}
}
