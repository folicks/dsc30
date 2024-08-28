// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
    // Approximate the runtime of the following code fragment, in terms of n: Write your answer in a format such as "O(N^2)" or "O(N log N)" (without the quotes).
    
    public static int fizzbuzz(int n){
        int sum = 0;
        int j = 1;
        while (j <= n) {
            sum++;
            j = j * 2;
            }
        return sum;
    }
    
   

  public static void main(String[] args) {
    fizzbuzz(1);
  }
}
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}


