/*
Yakup ADIYAMAN
02215076073
*/

package heap;


public class minHeap {
    int[] array;
    int count;
    int size;
    
    public minHeap(int size){
        array = new int[size];
        count = -1;
    }
    
    public int parent(int i){
        if(i - 1 < 0){
            return -1;
        }
        return (i - 1) >> 1;
    }
    
    public int leftChild(int i){
        int left = i * 2 + 1;
        if(i > count || left > count){
            return -1;
        }
        return left;
    }
    
    public int rightChild(int i){
        int right = i * 2 + 2;
        if(i > count || right > count){
            return -1;
        }
        return right;
    }
    
    // [1, 15, 21, 6, 45]
    //
    //        1
    //     6     21
    //  15   45
    
    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void percolateUp(int i){
        int size = count;
        while(size > 0 && array[size] < array[parent(size)]){
            swap(size, parent(size));
            size = parent(size);
        }
    }
    
    public void heapify(int i){
        int changed = 1;
        
        while(i<=count && changed==1){
            changed = 0;
            int left = leftChild(i);
            int right = rightChild(i);
            
            if(left == -1 && right == -1){
                return ;
            }else{
                if(array[i] > array[left]){
                    changed = 1;
                    swap(i, left);
                    i = left;
                }else if(right!=-1 && array[i] > array[right]){
                    changed = 1;
                    swap(i, right);
                    i = right;
                }
            }
        }
        return ;
    }
    
    public void ekle(int i){
        array[++count] = i;
        percolateUp(count);
    }
    
    public void print(){
        for(int i = 0; i <= count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
