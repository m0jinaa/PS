import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input;
		int total = 0;
		String[] work = new String[] {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};
		int[] count = new int[7];
		HashMap<String,Integer> index = new HashMap<>();
		index.put("Re", 0);
		index.put("Pt", 1);
		index.put("Cc", 2);
		index.put("Ea", 3);
		index.put("Tb", 4);
		index.put("Cm", 5);
		index.put("Ex", 6);
		String w;
		int ind;
		while((input = br.readLine())!=null && !input.isEmpty()) {
			st = new StringTokenizer(input," \n");
			
			while(st.hasMoreTokens()) {
				w = st.nextToken();
				ind = index.getOrDefault(w, -1);
				if(ind!=-1) {
					count[index.get(w)]++;
				}
				total++;
			}
		}

    	for(int i = 0;i<7;i++){
	    	sb.append(work[i]).append(" ").append(count[i]).append(" ").append(String.format("%.02f\n", 1.0 * count[i] / total));
    	}
	
	    sb.append("Total ").append(total).append(" ").append(String.format("%.02f\n",1.0*total/total));
	    System.out.println(sb.toString());
    }
}