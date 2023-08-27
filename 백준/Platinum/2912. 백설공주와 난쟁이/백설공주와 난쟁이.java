import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int sqrtN;
	static int[] cnt;
	static int c;
	static class Query implements Comparable<Query>{
		int ind, s, e;

		public Query(int ind, int s, int e) {
			super();
			this.ind = ind;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Query o) {
			int sn1 = this.s/sqrtN;
			int sn2 = o.s/sqrtN;
			
			if(sn1!=sn2) {
				return sn1-sn2;
			}
			else {
				return this.e-o.e;
			}
		}

		@Override
		public String toString() {
			return "Query [ind=" + ind + ", s=" + s + ", e=" + e + "]";
		}
		
	}
	
	static int check(int s, int e) {
		int limit = (e-s+1)/2;
		
		for(int i = 1;i<=c;i++) {
			if(cnt[i]>limit)
				return i;
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sqrtN = (int)Math.sqrt(n);
		
		int[] hat = new int[n+1];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1;i<=n;i++) {
			hat[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Query> query = new ArrayList<Query>();
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			query.add(new Query(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int[] ans = new int[m];
		
		Collections.sort(query);
		
		cnt = new int[c+1];
		
		int s = query.get(0).s;
		int e = query.get(0).e;
		for(int i = s;i<=e;i++) {
			cnt[hat[i]]++;
		}
		
		ans[query.get(0).ind] = check(s,e);
		
		for(int i = 1;i<m;i++) {
			while(query.get(i).s<s) cnt[hat[--s]]++;
			while(query.get(i).s>s) cnt[hat[s++]]--;
			while(query.get(i).e<e) cnt[hat[e--]]--;
			while(query.get(i).e>e) cnt[hat[++e]]++;
			ans[query.get(i).ind] = check(s,e);
		}
		
		for(int i:ans) {
			if(i==0) {
				sb.append("no\n");
			}
			else {
				sb.append("yes ").append(i).append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}