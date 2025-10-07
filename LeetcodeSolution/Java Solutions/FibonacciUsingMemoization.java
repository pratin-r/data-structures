import java.util.HashMap;

public class FibonacciUsingMemoization {
    HashMap<Integer, Integer> fibonacciMemo = new HashMap<>();

    public static void main(String[] args) {
        FibonacciUsingMemoization obj = new FibonacciUsingMemoization();
        System.out.println(obj.fibonacci(10));
        System.out.println(obj.fibonacciMemo.keySet());
        obj.fibonacciMemo.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fibonacciMemo.containsKey(n)) {
            return fibonacciMemo.get(n);
        }
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciMemo.put(n, result);
        return result;
    }
}
