package q3;

import java.util.HashMap;
import java.util.Map;

public class Permutation {
	private static final int MAX_LENGTH = 100000;

	public int solution(int[] A) {
		Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		long len = A.length;
		if (len > MAX_LENGTH) {
			return -1;
		}
		long actSum = 0;
		long expSum = len * (len + 1) / 2; // sum(1, 2, .. n) => n(n+1)/2
		for (int a : A) {
			actSum = actSum + a;
			Boolean isThere = hashMap.get(a);
			if (isThere == null) {
				hashMap.put(a, true);
			} else {
				return 0;
			}
		}
		return actSum == expSum ? 1 : 0;
	}

	public static void main(String[] args) {
		int[] entry = new int[] { 7, 5, 4, 2, 1 };
		int result = new Permutation().solution(entry);
		System.out.println(result);

	}

}
