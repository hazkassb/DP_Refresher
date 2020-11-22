package dp_course;


public class DynamicProgramming {
	
	
	//Recursive implementation of the Fibonacci sequence
	/*
	 *  - too many repetitive computations, resulting in large time complexity
	 *  - Time complexity: O(2^n)
	 *  - Space Complexity: O(n) --> n calls of the recursion stack at any given time.
	 */
	static int fib(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	
	//Fibonacci sequence using memoization to reduce time complexity
	/*
	 *  - Cache/memoize solutions to subproblems in order to reduce number of computations
	 *  - Trade-off ==> space for speed.
	 */
	static int fib_memo(int n) {
		int[] cache = new int[n+1];
		for(int i = 0; i <= n; i++) {
			cache[i] = -1;
		}

		
		return fib_memo(n, cache);
	}
	
	static int fib_memo(int n, int[] cache) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		if(cache[n] != -1) {
			return cache[n];
		}
		
		int result = fib(n-1) + fib(n-2);
		cache[n] = result;
				
		return result;
	}

	
	
	
	
	
	//Main Method
	public static void main(String[] args) {
		//Recursive fibonaci sequence
		long start = System.currentTimeMillis();
		System.out.println(fib(35));
		
		System.out.print("Recursive time in milliseconds = ");
	    System.out.println(System.currentTimeMillis() - start);
	    
	    System.out.println("\n\n");
	    
	    //Fibonacci sequence with Memoization
	    long strt = System.currentTimeMillis();
		System.out.println(fib_memo(35));
		
		System.out.print("Recursive time in milliseconds = ");
	    System.out.println(System.currentTimeMillis() - strt);
	    
	}

}
