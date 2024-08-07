// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
  public static void fizzBuzz(int n) {
    for (int i = 1; i <= n; i++) {
        if ((i % 3 == 0) && (i % 5 == 0)){
            System.out.println("FizzBuzz");
        } else if (i % 5 == 0) {
            System.out.println("Buzz");
        }else if (i % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(i);
        }
    }
  }

  public static void main(String[] args) {
    fizzBuzz(243);
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}


