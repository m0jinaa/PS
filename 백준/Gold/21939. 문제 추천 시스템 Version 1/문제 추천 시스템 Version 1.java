import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem implements Comparable<Problem> {
        int p, l;

        public Problem(int p, int l) {
            super();
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Problem o) {
            return (this.l != o.l) ? (this.l - o.l) : (this.p - o.p);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> problems = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        int p, l;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            problems.add(new Problem(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());

        String o;
        int x;
        while(m-->0) {
            st = new StringTokenizer(br.readLine()," ");
            o = st.nextToken();

            switch(o) {
            case "add":
                p = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                problems.add(new Problem(p,l));
                map.put(p, l);
                break;
            case "recommend":
                x = Integer.parseInt(st.nextToken());
                if(x==-1) {
                    sb.append(problems.first().p).append("\n");
                }
                else {
                    sb.append(problems.last().p).append("\n");
                }
                break;
            case "solved":
                p = Integer.parseInt(st.nextToken());
                problems.remove(new Problem(p,map.get(p)));
                map.remove(p);
                break;
            }
        }

        System.out.println(sb.toString());
    }
}