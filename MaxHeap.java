
public class MaxHeap {
       private int[] Heap;
       private int size;
       private int n;
       
       MaxHeap(int[] A, int num,int max){
    	   n=num;
    	   size=max;
    	   Heap = new int[size];
    	   for(int i=0;i<Math.min(size, A.length);i++)
    		   Heap[i]=A[i];
       }
       
       int heapsize() { return n;}
       
       int leftchild(int pos){
    	   if(pos >= n/2) return -1;
    	   return 2*pos+1;
       }
       
       int rightchild(int pos){
    	   if(pos >= n/2) return -1;
    	   return 2*pos+2;
       }
       
       int parent(int pos){
    	   if(pos<=0) return -1;
    	   return (pos-1)/2;
       }
       public boolean isLeaf(int pos){
    	   return (pos>= n/2)&& (pos<n);
       }
       
       public void buildheap(){
    	   if(n==0) return;
    	   for(int i=n/2-1;i>=0;i--){
    		   siftdown(i);
    	   }
       }
       
       protected void siftdown(int pos){
    	   if(pos>=n||pos<0) return;
    	   while(!isLeaf(pos)){
    		   int j = leftchild(pos);
    		   if((j+1)<n && Heap[j]<Heap[j+1] )
    			   j++;
    		   if(Heap[pos]>= Heap[j]) return;
    		   swap(Heap,j,pos);
    		   pos = j;
    	   }
       }
       
       protected void swap(int[] A, int i,int j){
    	   int tmp = A[i];
    	   A[i]=A[j];
    	   A[j]=tmp;
       }
       
       public int removeMax(){
    	   if(n==0) return -1;
    	   swap(Heap,0,--n);
    	   if(n!=0) siftdown(0);
    	   return Heap[n];
       }
       
       public void insert(int key){
    	   if(n>=size){
    		   System.out.println("Heap is full");
    		   return;
    	   }
    	   int curr = n++;
    	   Heap[curr]= key;
    	   while(curr != 0 && Heap[curr]>Heap[parent(curr)]){
    		   swap(Heap,curr,parent(curr));
    		   curr = parent(curr);
    	   }
       }
       
       public int remove(int pos){
    	   if(pos>=n || pos< 0) return -1;
    	   if(pos == n-1) n--;
    	   else {
    		   swap(Heap,pos,--n);
    		   while(pos>0 && Heap[pos]>Heap[parent(pos)]){
    			   swap(Heap,pos,parent(pos));
    			   pos = parent(pos);
    		   }
    		   if(n != 0) siftdown(pos);
    	   }
    	   return Heap[n];
    	   
       }
}
