import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static class Group{
		String a, b, c;

		public Group(String a, String b, String c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Group other = (Group) obj;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			return true;
		}	
	}
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] names;
		Map<Group, Integer> count = new HashMap<>();
		Group g;
		
		int answer = 0;
		
		while(n-->0) {
			names = br.readLine().split(" ");
			Arrays.sort(names);
			
			g = new Group(names[0], names[1], names[2]);
			
			count.put(g, count.getOrDefault(g,0)+1);
			
			answer = Math.max(answer, count.get(g));
		}
		
		System.out.println(answer);
	}
}