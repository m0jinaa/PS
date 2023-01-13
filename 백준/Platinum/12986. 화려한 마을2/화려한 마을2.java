import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sqrtN,ans=0;
    static int[] cnt = new int[200020];
    static int[] table = new int[100010];
	static class Query implements Comparable<Query>{
		int s,e,ind;

		public Query(int s, int e, int ind) {
			super();
			this.s = s;
			this.e = e;
			this.ind = ind;
		}

		@Override
		public int compareTo(Query o) {
			int sn1 = this.s/sqrtN;
			int sn2 = o.s/sqrtN;
			if(sn1!=sn2)
				return sn1-sn2;
			else
				return this.e-o.e;
		}		
	}
	
	static void plus(int x) {
        table[cnt[x]]--;
        if (++table[++cnt[x]]==1 && cnt[x]>ans) ans = cnt[x];
	}
	
	static void minus(int x) {
        if (--table[cnt[x]]==0 && ans==cnt[x]) ans--;
        table[--cnt[x]]++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		sqrtN = (int)Math.sqrt(n);
		
		int[] paint = new int[n+1];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1;i<=n;i++) {
			paint[i] = Integer.parseInt(st.nextToken())+100000;
		}
		
		Query[] query = new Query[q];
		
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			query[i] = new Query(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
		}
		
		Arrays.sort(query);
		
		int s = query[0].s;
		int e = query[0].e;
		
		for(int i = s;i<=e;i++) {
			plus(paint[i]);
		}
		int[] answer = new int[q];
		
		answer[query[0].ind] = ans;
		
		Query qq;
		for(int i = 1;i<q;i++) {
			qq = query[i];
            for (int x = qq.s; x < s; x++) plus(paint[x]);
            for (int x = e+1; x <= qq.e; x++) plus(paint[x]);
            for (int x = s; x < qq.s; x++) minus(paint[x]);
            for (int x = qq.e+1; x <= e; x++) minus(paint[x]);
            
            s = qq.s;
            e = qq.e;
            
            answer[qq.ind] = ans;

		}
		
		for(int i:answer) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}