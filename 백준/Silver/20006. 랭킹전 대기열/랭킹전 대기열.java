import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int m;

	static class Player implements Comparable<Player> {
		int level;
		String name;

		public Player(int level, String name) {
			super();
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player p) {
			return this.name.compareTo(p.name);
		}
	}

	static class Room {
		boolean started;
		ArrayList<Player> players;
		int min;
		int max;

		public Room(Player p) {
			super();
			this.started = false;
			this.players = new ArrayList<>();
			this.min = p.level - 10;
			this.max = p.level + 10;

			this.addPlayer(p);
		}

		public void addPlayer(Player p) {
			this.players.add(p);
			if (players.size() == m)
				this.started = true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		LinkedList<Room> rooms = new LinkedList<>();

		int l;
		String n;
		boolean done;

		Player pl;

		while (p-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			n = st.nextToken();

			pl = new Player(l, n);

			done = false;

			for (Room r : rooms) {
				if (r.started)
					continue;
				else if (r.min > l || r.max < l)
					continue;

				r.addPlayer(pl);
				done = true;
				break;
			}

			if (!done) {
				rooms.add(new Room(pl));
			}
		}

		for (Room r : rooms) {
			sb.append(r.started ? "Started!\n" : "Waiting!\n");

			Collections.sort(r.players);

			for (Player player : r.players) {
				sb.append(player.level).append(" ").append(player.name).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}