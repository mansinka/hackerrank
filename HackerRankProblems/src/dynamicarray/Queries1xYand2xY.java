package dynamicarray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Queries1xYand2xY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = Solution.dynamicArray(n, queries);

		System.out.println(result);
		bufferedReader.close();
	}

	class Solution {
		/*
		 * Complete the 'dynamicArray' function below.
		 *
		 * The function is expected to return an INTEGER_ARRAY. The function accepts
		 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
		 */

		public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
			System.out.println(n);
			System.out.println(queries);

			ArrayList<List<Integer>> arr = new ArrayList<List<Integer>>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			int idx = 0;
			int last = 0;
			for (int i = 0; i < n; i++) {
				arr.add(i, new ArrayList<Integer>());
			}

			for (List<Integer> list : queries) {
				System.out.println(list);
				idx = ((list.get(1) ^ last) % n);

				if (list.get(0) == 1) {
					arr.get(idx).add(list.get(2));
				} else if (list.get(0) == 2) {
					last = arr.get(idx).get(list.get(2) % arr.get(idx).size());
					result.add(last);
				}
			}
			return result;
			// Write your code here

		}

	}

}
