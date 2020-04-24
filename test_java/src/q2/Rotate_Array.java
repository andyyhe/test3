package q2;

import java.util.Arrays;

public class Rotate_Array {

	public Rotate_Array() {
	}
	
	public int[] solution(int[] A, int K) {
	    int N = A.length;
	    if (N == 0) {
	    	return A;
	    }
	    
	    int mod = K % N;
	    if (mod == 0) {
	    	return A;
	    }
	    
	    int[] result = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
	    	if (i + mod <= N-1) {
	    		result[i + mod] = A[i];
	    	} else {
	    		result[i + mod - N] = A[i];
	    	}
	    }
	    
	    return result;
	}

	public static void main(String[] args) {

		int[] entry = new int[] {3, 8, 9, 7, 6} ;
		int[] result = new Rotate_Array().solution(entry, 3);
		
		Arrays.stream(result).forEach(
			(s) -> System.out.print(s + " ")
		);
		
		System.out.println();
	}

}