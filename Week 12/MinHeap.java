package Day_1;

public class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    public MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    public int extractMin() {
        if (heap_size == 0)
            return -1;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }
        int k = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);
        return k;
    }

    public void insertKey(int k) {
        if (heap_size < capacity) {
            harr[heap_size] = k;
            int j = heap_size++;
            while (j > 0 && harr[j] < harr[parent(j)]) {
                int r = harr[j];
                harr[j] = harr[parent(j)];
                harr[parent(j)] = r;
                j = parent(j);
            }
        }
    }

    void deleteKey(int i) {
        if (heap_size <= 0 || heap_size <= i)
            return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) {
            smallest = l;
        }
        if (r < heap_size && harr[r] < harr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

