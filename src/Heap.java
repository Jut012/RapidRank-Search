import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

public class Heap<K, V> implements PriorityQueue<K, V> {
    public List<Entry<K, V>> entries;
    public Comparator<K> comparator;

    public Heap(Comparator<K> comparator) {
        this.entries = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public void add(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        entries.add(entry);
        bubbleUp(entries.size() - 1);
    }

    @Override
    public Entry<K, V> poll() {
        if (isEmpty()) throw new NoSuchElementException();
        Entry<K, V> root = entries.get(0);
        if (entries.size() == 1) {
            entries.remove(0);
        } else {
            entries.set(0, entries.remove(entries.size() - 1));
            bubbleDown(0);
        }
        return root;
    }

    @Override
    public Entry<K, V> peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return entries.get(0);
    }

    @Override
    public List<Entry<K, V>> toArray() {
        return new ArrayList<>(entries);
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    public int size() {
        return entries.size();
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * index + 2;
    }

    public void swap(int i1, int i2) {
        Entry<K, V> temp = entries.get(i1);
        entries.set(i1, entries.get(i2));
        entries.set(i2, temp);
    }

    public void bubbleUp(int index) {
        int parentIndex = parent(index);
        while (index > 0 && comparator.compare(entries.get(index).getKey(), entries.get(parentIndex).getKey()) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    public void bubbleDown(int index) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int largest = index;

        if (leftIndex < entries.size() && comparator.compare(entries.get(leftIndex).getKey(), entries.get(largest).getKey()) > 0) {
            largest = leftIndex;
        }

        if (rightIndex < entries.size() && comparator.compare(entries.get(rightIndex).getKey(), entries.get(largest).getKey()) > 0) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(index, largest);
            bubbleDown(largest);
        }
    }

    public boolean existsAndGreater(int index1, int index2) {
        if (index1 < 0 || index1 >= entries.size() || index2 < 0 || index2 >= entries.size()) {
            return false;
        }
        return comparator.compare(entries.get(index1).getKey(), entries.get(index2).getKey()) > 0;
    }

    @Override
    public String toString() {
        return entries.toString();
    }
}
