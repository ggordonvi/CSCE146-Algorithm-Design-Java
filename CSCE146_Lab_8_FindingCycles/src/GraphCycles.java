import java.util.Stack;

public class GraphCycles {

   /**
   * Displays all the cycles from source
   *
   * @param matrix
   *            - adjacency matrix
   * @param startVertex
   *            - startVertex of the cycle
   * @param vStack
   *            - stack of vertices
   * @param visited
   *            - array to store whether a vertex has been visited
   */
   private static void cycle(int[][] matrix, int startVertex, Stack<Integer> vStack, boolean[] visited) {
       int currVertex = -1;
       // Check if top of stack is the startVertex
       if (!vStack.isEmpty()) {
           currVertex = vStack.peek();
           if (vStack.peek() == startVertex) {
               System.out.print((startVertex + 1) + " ");

               // Display contents of stack
               for (Integer vertex : vStack) {
                   System.out.print((vertex + 1) + " ");
               }
               System.out.println();

               // Remove top vertex on the stack and set the corresponding
               // visited to false
               visited[vStack.pop()] = false;

               return;
           }
       } else if (vStack.isEmpty())
           currVertex = startVertex;

       // Find the next vertex
       for (int i = 0; i < matrix[currVertex].length; i++) {
           if (!visited[i] && (matrix[currVertex][i] == 1)) {
               // Push vertex on the stack
               vStack.push(i);

               // Set vertex as visited
               visited[i] = true;

               cycle(matrix, startVertex, vStack, visited);
           }
       }

       // Remove top vertex on the stack and set the corresponding visited to
       // false
       if (!vStack.isEmpty())
           visited[vStack.pop()] = false;

       // Check if stack is empty
       if (!vStack.isEmpty())
           return;
   }

   public static void main(String[] args) {

       // Adjacency matrix for the graph
       int[][] matrix = { { 0, 0, 0, 0, 1, 0, 0 },
                           { 1, 0, 0, 0, 0, 0, 0 },
                           { 1, 0, 0, 0, 0, 0, 0 },
                           { 0, 1, 0, 0, 0, 0, 0 },
                           { 0, 1, 1, 0, 0, 0, 1 },
                           { 0, 0, 1, 0, 0, 0, 0 },
                           { 0, 0, 0, 1, 0, 1, 0 } };

       // Stack for vertices
       Stack<Integer> vStack = new Stack<Integer>();

       // Array to store whether a vertex is visited
       boolean[] visited = new boolean[matrix.length];

       // Print all cycles
       System.out.println("The cycles in the graph are");
       for (int i = 0; i < matrix.length; i++)
           cycle(matrix, i, vStack, visited);
   }
}