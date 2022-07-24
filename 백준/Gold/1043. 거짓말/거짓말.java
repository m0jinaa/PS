import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] root = new int[n+1];
		
		for(int i = 0;i<n+1;i++)
			root[i] = i;
		
		boolean[] party = new boolean[m];
		
		ArrayList<Integer>[] peopleList = new ArrayList[n+1];
		ArrayList<Integer>[] partyList = new ArrayList[m];
		LinkedList<Integer> q = new LinkedList<Integer>();
		LinkedList<Integer> qq = new LinkedList<Integer>();
		
		for(int i = 0;i<n+1;i++)
			peopleList[i] = new ArrayList<Integer>();
		for(int i = 0;i<m;i++)
			partyList[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int k = 0;k<t;k++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			for(int j = 0;j<p;j++) {
				int v = Integer.parseInt(st.nextToken());
				peopleList[v].add(i);
				partyList[i].add(v);
			}
		}
		int answer = m;
		boolean[] visited = new boolean[n+1];
		while(q.size()>0) {
			int qsize = q.size();
			while(qsize>0) {
				qsize--;
				int p = q.pollFirst();
				for(int pn:peopleList[p]) {
					if(!party[pn]) {
						party[pn]=true;
						answer--;
						qq.add(pn);
						for(int person:partyList[pn]) {
							if(!visited[person])
								q.add(person);
						}
					}
				}
			}
		}
		System.out.println(answer);	
	}
}
