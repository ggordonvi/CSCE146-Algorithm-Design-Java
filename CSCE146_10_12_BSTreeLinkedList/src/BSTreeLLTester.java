import java.util.*;

public class BSTreeLLTester {
  public static void main(String[] args) {
    Random r = new Random(100);
    BSTreeLL<Integer> tree = new BSTreeLL<Integer>();
    for(int i = 0; i < 10; i++) {
      tree.insert(r.nextInt());
    }
    tree.printInOrder();
  }
}