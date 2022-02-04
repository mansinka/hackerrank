package twodimensionalarray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class HourglassSum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		int result = Solution.hourglassSum(arr);

		System.out.println("Input:" + arr);
		System.out.println("Output:" + String.valueOf(result));

		bufferedReader.close();
	}

	class Solution {

		/*
		 * Complete the 'hourglassSum' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts
		 * 2D_INTEGER_ARRAY arr as parameter.
		 */

		public static int hourglassSum(List<List<Integer>> arr) {

			int numElemsHrgGls = 7;

			ArrayList<List<Integer>> hrgls = new ArrayList<List<Integer>>();
			hrgls.add(Arrays.asList(0, 1, 2));
			hrgls.add(Arrays.asList(1));
			hrgls.add(Arrays.asList(0, 1, 2));
			

			Integer max = null;
			
			int numCols = 0;
			int numRows = 0;
			int curr = 0;
			int counter = 0;

			numCols = arr.size();
			if (numCols > 0)
				numRows = arr.get(0).size();

			if (numCols > 0 && numRows > 0) {

				for (int col = 0; col < numCols; col++) {
					for (int row = 0; row < numRows; row++) {
						counter = 0;
						curr = 0;
						for (int i = 0; i < hrgls.size(); i++) {
							for (int j = 0; j < hrgls.get(i).size(); j++) {
								if (numCols > col + i && numRows > row + hrgls.get(i).get(j)) {
									System.out.println(String.valueOf(col + i) + ","
											+ String.valueOf(row + hrgls.get(i).get(j)) + "="
											+ String.valueOf(arr.get(col + i).get(row + hrgls.get(i).get(j))));
									curr += arr.get(col + i).get(row + hrgls.get(i).get(j));
									counter++;
								}
							}
						}
						if (counter == numElemsHrgGls) {
							System.out.println("curr=" + curr);
							if (max == null) {
								max = curr;
							} else {
								if (curr > max)
									max = curr;
							}

							System.out.println("max=" + max);
						}
					}

				}
			}
			return max.intValue();

		}

	}
}
