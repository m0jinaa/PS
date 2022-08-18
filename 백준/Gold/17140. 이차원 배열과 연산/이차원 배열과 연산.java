import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer,Integer> map;
	static int[][] nlist;
	static int[][] newList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());

		int n = 3;//초기 배열 크기
		int m = 3;

		nlist = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				nlist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int v=0;
		int nm = 0;
		int nn = 0;
		int ind;
		boolean pos = false;
		if(n>r&&m>c&&nlist[r][c]==k) {
			pos = true;
		}
		while(cnt<100 &&(n<=r||m<=c||nlist[r][c]!=k)) {
			//System.out.println(cnt+" "+n+" "+m+" "+nlist[r][c]);
			if(n>=m) {//행이 열보다 많은 때
				nm = 0;//새로운 배열의 열의 수
				newList = new int[n][m*2];//최대 두배까지 늘어날 수 있으니까
				
				for(int i = 0;i<n;i++) {//각 행에 대하여
					map = new HashMap<Integer,Integer>();

					for(int j = 0;j<m;j++) {//숫자하나씩 들여다 보며 map에 정리
						v = nlist[i][j];
						if(v==0)//0일 때는 패스
							continue;
						if(map.putIfAbsent(v, 1)!=null) {//값이 맵에 존재하지 않을때는 넣어주고 null을 반환하는데 null이 아니면 숫자 증가시켜서 업데이트
							map.put(v, map.get(v)+1);
						}
					}
					nm = Math.max(nm,map.size()*2);//새로운 맵의 열의 수는 map에 존재하는 수의 개수*2인데 그 최대값 찾기
					ind = 0;
					List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
					entries.sort((c1,c2)->{//map의 entry 값이 증가하는 방향으로 정렬, 값이 같으면 키가 증가하는 방향으로.
						if(c1.getValue()==c2.getValue()) {
							return c1.getKey()-c2.getKey();
						}
						else
							return c1.getValue()-c2.getValue();
					});
					for(Map.Entry<Integer, Integer> e :entries) {
						newList[i][ind++] = e.getKey();
						newList[i][ind++] = e.getValue();
					}
				}

				nm = nm<100?nm:100;
				nlist = new int[n][];
				for(int i = 0;i<n;i++) {
					nlist[i] = Arrays.copyOf(newList[i], nm);
				}
				m = nm;
			}
			else {
				nn = 0;
				ind = 0;
				newList = new int[n*2][m];
				for(int j = 0;j<m;j++) {
					map = new HashMap<Integer,Integer>();
					for(int i = 0;i<n;i++) {
						v = nlist[i][j];
						if(v==0)
							continue;
						if(map.putIfAbsent(v, 1)!=null) {
							map.put(v, map.get(v)+1);
						}
					}
					nn = Math.max(nn,map.size()*2);
					ind = 0;
					List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
					entries.sort((c1,c2)->{
						if(c1.getValue()==c2.getValue()) {
							return c1.getKey()-c2.getKey();
						}
						else
							return c1.getValue()-c2.getValue();
					});
					for(Map.Entry<Integer, Integer> e :entries) {
						newList[ind++][j] = e.getKey();
						newList[ind++][j] = e.getValue();
					}
					
				}
				nn = nn<100?nn:100;
				nlist = new int[nn][];
				for(int i = 0;i<nn;i++) {
					nlist[i] = Arrays.copyOf(newList[i], m);
				}
				n = nn;
			}
			cnt++;
			if(n>r&&m>c&&nlist[r][c]==k) {
				pos = true;
			}
		}
		if(!pos)
			System.out.println(-1);
		else
			System.out.println(cnt);		
	}
}