
public class sort {
    private final static  int DEFALUE_SIZE = 6;
    private final static int THRESHOLD = 4;
	private int[] input;
    private int[] result;
    private int size;
    
    public sort() {
    	input = new int[DEFALUE_SIZE];
    	result = new int[DEFALUE_SIZE];
    	size = DEFALUE_SIZE;
    }
    
    public sort(int n){
    	input = new int[n];
    	result = new int[n];
    	size = n;
    }
    
    public sort(String in){
    	if(in.matches("^(\\d+,?)*") && in.length()>0){
    		System.out.println("Input array is£º "+in);
    		int count = 0;
    		for(char tmp:in.toCharArray())
    			if(tmp == ',') count++;
    		if(!in.endsWith(","))count++;
    		System.out.printf("The input size: %d\n",count);
    		size = count;
    		input = new int[count];
    		result = new int[count];
    		int st=0,ed=0;
    		for(int i=0;i< size;i++){	
    			for(int j=st;j<in.length();j++){
    				if(in.charAt(j)==',') {
    					ed=j;
    					break;
    				}
    				if(j==in.length()-1) ed=in.length();
    			}
    			input[i]=Integer.valueOf(in.substring(st, ed)).intValue();
    			st = ed+1;
    		}
    	} else{
    		System.out.println("The input string is not folloing reight format.\n Usage: \"12,2,15,5,..\"");
    	} 	
    }
    public void insertSort(){
    	init();
    	for(int i=1;i<result.length;i++)
    		for(int j=i;j>0&& result[j]<result[j-1];j--)
    			swap(result,j,j-1);
    	System.out.print("Insertion Sort Result:\n");
    	printResult();
    }
    
    public void bubbleSort(){
    	init();
    	for(int i=0;i<result.length;i++)
    		for(int j=result.length-1;j>i;j--)
    			if(result[j]<result[j-1])
    				swap(result,j,j-1);
    	System.out.print("Bubble Sort Result:\n");
    	printResult();
    }
    
    public void selectionSort(){
    	init();
    	for(int i=0;i<result.length-1;i++){
    		int loc = i;
    		for(int j= i;j<result.length;j++)
    			if(result[j]<result[loc]) loc = j;
    		swap(result,i,loc);
    	}
    	System.out.print("Selection Sort Result:\n");
    	printResult();
    }
    public void shellSort(){
    	init();
    	for(int i=result.length/2;i>2;i/=2)
    		for(int j=0;j<i;j++)
    			insert2(result,j,i);
    	insert2(result,0,1);
    	System.out.print("Shell Sort Result:\n");
    	printResult();
    }
    protected void insert2(int[] A, int st, int incr){
    	for(int i=st+incr;i<A.length;i+=incr)
    		for(int j=i;j>=incr && A[j]<A[j-incr];j-=incr)
    			swap(A,j,j-incr);
    }
    
    protected void insert2(int[] A, int l,int r,int incr){
    	for(int i=l+incr;i<r;i+=incr)
    		for(int j=i;j>l && A[j]<A[j-incr];j-=incr)
    			swap(A,j,j-incr);
    }
    public void mergeSort(){
    	init();
    	//printResult();
    	int[] tmp = new int[size];
    	mergeSort(result,tmp,0,size-1);
    	System.out.print("Merge Sort Result:\n");
    	printResult();
    }
    
    protected void mergeSort(int[] A,int[] tmp,int l,int r){
    	int i,j,k,mid = (l+r)/2;
    	if(l==r) return;
    	mergeSort(A,tmp,l,mid);
    	mergeSort(A,tmp,mid+1,r);
    	// copy to temp;
    	for(i=l;i<=mid;i++) tmp[i]=A[i];
    	for(j=r;j>mid;j--) tmp[i++]=A[j];
    	// merge
    	for(i=l,j=r,k=l;k<=r;k++){
    		if(tmp[i]<tmp[j])
    			A[k]=tmp[i++];
    		else
    			A[k]=tmp[j--];
    	}
    }
    
    
    public void quickSort(){
    	init();
    	quickSort(result,0,size-1);
    	System.out.print("Quick Sort Result:\n");
    	printResult();
    }
    
    protected void quickSort(int[] A,int l,int r){
    	int pivot = findpivot(l,r);
    	swap(A,pivot,r);
    	int k = partition(A,l,r-1,A[r]);
    	swap(A,k,r);
    	if((k-l)>1) quickSort(A,l,k-1);
    	if((r-k)>1) quickSort(A,k+1,r);
    }
    protected int partition(int[] A, int left, int right,int key){
    	while(left<=right){
    		while(A[left]<key) left++;
    		while(left<=right && A[right]>= key) right--;
    		if(right > left) swap(A,left,right);
    	}
    	return left;
    }
    protected int findpivot(int l,int r){
    	return (l+r)/2;
    }
    protected void init(){
    	for(int i=0;i<size;i++)
    		result[i]=input[i];
    }
    public void heapSort(){
    	MaxHeap h = new MaxHeap(input,input.length,input.length);
    	init();
    	h.buildheap();
    	for(int i=input.length-1;i>=0;i--)
    		result[i]=h.removeMax();
    	System.out.print("Heap Sort Result:\n");
    	printResult();
    }
    protected void swap(int[] A,int i,int j){
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
    protected void printResult(){
    	for(int elem:result)
    		System.out.printf("%d ",elem);
    	System.out.print("\n");
    }
    public void print(){
    	System.out.print("Printing:\nInput: ");
    	for(int elem: input)
    		System.out.print(String.valueOf(elem)+" ");
    	System.out.print("\n");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String demo = "20,30,44,54,55,11,78,14,13,79,12,98,12,56,1,45,6,16,77,14";
       sort Example = new sort(demo);
       Example.print();
       Example.bubbleSort();
       Example.insertSort();
       Example.selectionSort();
       Example.shellSort();
       Example.mergeSort();

       Example.quickSort();
       Example.heapSort();
	}

}
