import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{

    static HashMap<Integer,Integer> inBound;
    static HashMap<Integer,Integer> root;
    static Set<Integer> node;
    static boolean isTree = true;
    static int find(int x) {
        if(root.get(x)!=x)
            root.put(x, find(root.get(x)));
        return root.get(x);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a<b)
            root.put(b, a);
        else
            root.put(a, b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a,b;
        int t = 0;
        StringBuilder sb = new StringBuilder();
        end1: while(true) {//테스트케이스마다
            t++;
            isTree = true;
            inBound = new HashMap<Integer,Integer>();
            node = new HashSet<Integer>();
            root = new HashMap<Integer,Integer>();
            end2: while(true) {//각 테스트케이스에서 입력받기
                st = new StringTokenizer( br.readLine()," ");
                while(st.hasMoreTokens()) {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    if(a==0&&b==0)
                        break end2;
                    else if(a<0&&b<0)
                        break end1;

		            if(!root.keySet().contains(a)) {
		                root.put(a, a);
		            }
		            if(!root.keySet().contains(b))
		                root.put(b, b);
		            node.add(a);
		            node.add(b);
		
		            if(inBound.keySet().contains(b))
		                isTree = false;
		            else {
		                inBound.put(b, 1);
		                if(find(a)!=find(b)) {
		                    union(a,b);
		                }
		                else
		                    isTree = false;
		            }
                }                
            }
            if(node.size()>0) {
    		    Set<Integer> roots = new HashSet<Integer>();
    		    for(Integer i:node) {
    		//                System.out.println(i);
    		            roots.add(find(i));
    		    }
    		//            System.out.println(Arrays.toString(roots.toArray()));
    		    if(roots.size()!=1)
    		        isTree = false;
            	
            }
		    if(isTree)
		        sb.append("Case ").append(t).append(" is a tree.\n");
		    else
		        sb.append("Case ").append(t).append(" is not a tree.\n");
		}
		System.out.println(sb);
    }

}