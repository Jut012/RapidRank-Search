// import static org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest {

	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		assertEquals(8, heap.entries.size());
	}
	    @Test
    public void testPoll() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        heap.add(19, "");
        heap.add(50, "10");
        heap.add(30, "10");
        assertEquals(50, (int) heap.poll().getKey());
        assertEquals(30, (int) heap.poll().getKey());
        assertEquals(19, (int) heap.poll().getKey());
        assertTrue(heap.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPollEmptyHeap() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        heap.poll(); 
    }

    @Test
    public void testPeek() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        heap.add(19, "");
        heap.add(50, "10");
        assertEquals(50, (int) heap.peek().getKey());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyHeap() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        heap.peek();
    }

    @Test
    public void testToArray() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        heap.add(19, "");
        heap.add(50, "10");
        List<Entry<Integer, String>> entries = heap.toArray();
        assertEquals(2, entries.size());
        assertEquals(50, (int) entries.get(0).getKey());
        assertEquals(19, (int) entries.get(1).getKey());
    }

    @Test
    public void testIsEmpty() {
        Comparator<Integer> maxHeapComparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(maxHeapComparator);
        assertTrue(heap.isEmpty());
        heap.add(19, "");
        assertFalse(heap.isEmpty());
    }
}
