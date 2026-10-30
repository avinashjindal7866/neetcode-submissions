
class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>(); // Larger half (Min Heap)
        max = new PriorityQueue<>(Collections.reverseOrder()); // Smaller half (Max Heap)
    }

    public void addNum(int num) {

        // Add to max heap first
        max.add(num);

        // Move the largest element from max to min
        min.add(max.poll());

        // Keep max heap equal in size or one element larger
        if (min.size() > max.size()) {
            max.add(min.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (max.size() > min.size()) {
            return max.peek();
        }

        // Even number of elements
        return (max.peek() + min.peek()) / 2.0;
    }
}
