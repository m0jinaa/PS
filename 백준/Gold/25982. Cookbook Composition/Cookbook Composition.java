import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static class Recipe implements Comparable<Recipe> {
		String name;
		int steps;
		double accessibility;

		public Recipe(BufferedReader br) throws Exception {
			String[] input = br.readLine().split(" ");

			this.name = input[0];
			this.steps = Integer.parseInt(input[1]);

			HashMap<String, Integer> duration = new HashMap<>();

			int sum = 0;
			String[] line;
			String step;
			int t, ingredient, ingredientDuration;
			int max = 0;
			for (int i = 0; i < steps; i++) {
				line = br.readLine().split(" ");
				step = line[0];
				t = Integer.parseInt(line[1]);

				sum += t;

				ingredient = Integer.parseInt(line[2]);

				ingredientDuration = 0;

				for (int j = 0; j < ingredient; j++) {
					ingredientDuration = Math.max(ingredientDuration, duration.get(line[j + 3]));
				}
				duration.put(step, ingredientDuration + t);
				max = Math.max(max, ingredientDuration + t);
			}
			this.accessibility = sum * 1.0 / max;
			;
		}

		@Override
		public int compareTo(Recipe r) {
			if (this.accessibility < r.accessibility)
				return -1;
			else if (this.accessibility > r.accessibility)
				return 1;
			else
				return this.name.compareTo(r.name);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Recipe[] recipes = new Recipe[n];

		for (int i = 0; i < n; i++) {
			recipes[i] = new Recipe(br);
		}

		Arrays.sort(recipes);

		for (Recipe r : recipes) {
			sb.append(r.name).append("\n");
		}

		System.out.println(sb.toString());
	}
}