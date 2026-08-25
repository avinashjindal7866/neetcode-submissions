class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<double[]> pq =
    new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));


        for(int i=0;i<points.length;i++){
            double a = Math.pow(points[i][0], 2);
            double b = Math.pow(points[i][1], 2);
            double result = Math.sqrt(a+b);
            pq.add(new double[]{result, (double)i});
        }

        int[][] result = new int[k][];

        for (int i = 0; i < k; i++) {
            double[] val = pq.poll();
            int index = (int)val[1]; 
            result[i] = points[index];
        }

        return result;
    }
}
