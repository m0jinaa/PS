import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> osExtension;

	static class File implements Comparable<File> {
		String filename;
		String extension;

		public File(String filename, String extension) {
			super();
			this.filename = filename;
			this.extension = extension;
		}

		@Override
		public int compareTo(File f) {
			if (this.filename.equals(f.filename)) {
				if (osExtension.contains(this.extension)) {
					if (osExtension.contains(f.extension))
						return this.extension.compareTo(f.extension);
					else
						return -1;
				} else if (osExtension.contains(f.extension)) {
					return 1;
				} else {
					return this.extension.compareTo(f.extension);
				}
			} else {
				return this.filename.compareTo(f.filename);
			}
		}

		@Override
		public String toString() {
			return this.filename + "." + this.extension + "\n";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		osExtension = new HashSet<>();

		File[] files = new File[n];

		String filename, extension;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");

			filename = st.nextToken();
			extension = st.nextToken();

			files[i] = new File(filename, extension);
		}

		while (m-- > 0) {
			osExtension.add(br.readLine());
		}

		Arrays.sort(files);

		for (File f : files) {
			sb.append(f.toString());
		}

		System.out.print(sb.toString());
	}
}