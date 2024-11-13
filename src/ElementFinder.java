import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class ElementFinder {

	public static int Kth_finder(String filename, int K, String operation) {
		
		// Create a comparator depending upon the type of operation
		// Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		/** TODO **/
        Comparator<Integer> comparator;
        if (operation.equals("largest")) {
            comparator = Collections.reverseOrder();
        } else if (operation.equals("smallest")) {
            comparator = Integer::compare;
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        Heap<Integer, Integer> heap = new Heap<>(comparator);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                for (String numStr : numbers) {
                    if (!numStr.isEmpty()) {
                        int num = Integer.parseInt(numStr);
                        if (heap.size() < K) {
                            heap.add(num, num);
                        } else if (comparator.compare(num, heap.peek().getKey()) < 0) {
                            heap.poll();
                            heap.add(num, num);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        return heap.isEmpty() ? -1 : heap.peek().getKey();
    }
	/* Add any helper methods you find useful */
		
}
