package EstruturasTree;

public class FenwickSegment {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        
        FenwickTree ft = new FenwickTree(arr);
        System.out.println("Soma Fenwick (0-4): " + ft.query(4));
        ft.update(2, 10);
        System.out.println("Soma Fenwick (0-4) após update: " + ft.query(4));
        
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Soma Segment (1-3): " + st.query(1, 3));
        st.update(2, 10);
        System.out.println("Soma Segment (1-3) após update: " + st.query(1, 3));
        st.updateRange(1, 4, 5);
        System.out.println("Soma Segment (1-3) após range update: " + st.query(1, 3));
    }
}

class FenwickTree {
    private int[] tree;
    
    public FenwickTree(int[] arr) {
        this.tree = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }
    
    public void update(int index, int delta) {
        index++;
        while (index < tree.length) {
            tree[index] += delta;
            index += index & -index;
        }
    }
    
    public int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}

class SegmentTree {
    private int[] tree;
    private int[] lazy;
    private int n;
    
    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }
    
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }
    
    public void update(int index, int value) {
        update(1, 0, n - 1, index, index, value);
    }
    
    public void updateRange(int l, int r, int value) {
        update(1, 0, n - 1, l, r, value);
    }
    
    private void update(int node, int start, int end, int l, int r, int value) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        
        if (start > end || start > r || end < l) return;
        
        if (start >= l && end <= r) {
            tree[node] += (end - start + 1) * value;
            if (start != end) {
                lazy[2 * node] += value;
                lazy[2 * node + 1] += value;
            }
            return;
        }
        
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r, value);
        update(2 * node + 1, mid + 1, end, l, r, value);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    
    public int query(int l, int r) {
        return query(1, 0, n - 1, l, r);
    }
    
    private int query(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l) return 0;
        
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        
        if (start >= l && end <= r) return tree[node];
        
        int mid = (start + end) / 2;
        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);
        return left + right;
    }
}