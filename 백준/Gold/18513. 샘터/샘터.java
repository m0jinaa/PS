import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Place{
        int x,d;

        public Place(int x, int d) {
            super();
            this.x = x;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Set<Integer> set = new HashSet<Integer>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Place> q = new LinkedList<Place>();

        int x;

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0;i<n;i++) {
            x = Integer.parseInt(st.nextToken());
            set.add(x);
            q.add(new Place(x,0));
        }

        int cnt = 0;
        long dist = 0;
        Place p;

        while(cnt<k) {
            p = q.pollFirst();

            if(!set.contains(p.x+1)){
                dist+=p.d+1;
                set.add(p.x+1);
                q.add(new Place(p.x+1,p.d+1));
                cnt++;
            }

            if(cnt<k && !set.contains(p.x-1)){
                dist+=p.d+1;
                set.add(p.x-1);
                q.add(new Place(p.x-1,p.d+1));
                cnt++;
            }

        }

        System.out.println(dist);
    }

}