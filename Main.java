import java.util.Map;
import java.util.HashMap;

class Main {  
  public static void main(String args[]) { 
    System.out.println(fib_loop(210)); 
    System.out.println(bottomUp(210)); 
    System.out.println(fib(210)); 
    // System.out.println(map); 
  } 
  
  
  static Map<Integer, Integer> map = new HashMap<>();
  
  //Recursive fibonacci function with memoization
  static int fib(int n){
      if(map.containsKey(n)){
          return map.get(n);
      }
      
      if(n <= 2){
          return 1;
      }
      
      int x = fib(n-1) + fib(n-2);
      
      map.put(n, x);
      
      return x;
  }
  
  //Iterative (bottom-up) fibonacci function
  
  static int fib_loop(int n){
      int temp = 0;
      for(int i = 1; i <= n; i++){
          if(i <= 2){
              temp = 1;
          } else{
              temp = map.get(i-1) + map.get(i-2);
          }
          
          map.put(i, temp);
      }
      
      return map.get(n);
  }
  
  static int bottomUp(int n){
      int[] dp = new int[n+1];
      
      dp[0] = 0; dp[1] = 1;
      
      for(int i = 2; i <= n; i++){
          dp[i] = dp[i-1] + dp[i-2];
      }
      
      return dp[n];
  }
}