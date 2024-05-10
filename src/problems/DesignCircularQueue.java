package problems;

public class DesignCircularQueue {
    int[] buffer;
    int headIndex;
    int count;

    public DesignCircularQueue(int k) {
        buffer = new int[k];
        headIndex = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        buffer[(headIndex + count) % buffer.length] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        headIndex = (headIndex + 1) % buffer.length;
        count--;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return buffer[headIndex];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return buffer[(headIndex + count - 1) % buffer.length];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == buffer.length;
    }
}
