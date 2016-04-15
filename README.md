# Sorting
**Sorting Problem** is to arrange the records into any order s such that records r1,r2, .. rn have keys obeying the property k1<k2<…<kn

A sorting algorithms is said to be stable if does not change the relative ordering of records with identical key values.

When analyzing sorting algorithms, it is traditional to measure the cost by counting the number of comparisons made between keys.

##Three O(n2) sorting 
**1.Insert Sort:** like human card game.
```java
for(int i=1; i< A.length, i++)
  for( int j=i;i>0 && A[j].compareTo(A[i])<0;j--)
        swap(A,j,j-1);
```
**2.Bubble Sort**
```java
for(int i =1;i< A.length-1,i++)
   for( int j=A.length-1; j>i;j--)
     if(A[j].compareTo(A[j-1]<0))
          swap(A,j,j-1)
```
**3.Selection Sort**
```java
for(i=0;i<A.length;i++)
  int loc = i;
  for(j=i+1;j<A.length;j++)
   if(A[j].compareTo(A[j-1])<0) loc=j;
  swap(A,i,loc);
```
### Analysis
Comparison of the asymptotic complexities for three simple sorting

|            |Insertion|Bubble  |	Selection|
|:-----------|:-------:|:------:|:--------:|
|Comparisons:|         |        |          |			
|Best Case   |	Ο(n)   |	Ο(n^2)|	Ο(n^2)   |
|Average Case|	Ο(n^2) |	Ο(n^2)|	Ο(n^2)   |
|Worst Case  |	Ο(n^2) |	Ο(n^2)|	Ο(n^2)   |
|Swaps:   	 |	    	 |        |          |
|Best Case   |	0      |	0     |	Ο(n)     |
|Average Case|	Ο(n^2) |	Ο(n^2)|	Ο(n)     |
|Worst Case  |	Ο(n^2) |	Ο(n^2)|	Ο(n      |

## Advanced Sorting Method
**1.Shell Sort**

It is also sometimes called the diminishing increment sort.

Shellsort breaks the list into disjoint sublist, where a sublist defined as “Increment”.
```java
void shellsort(int[] A){
for( int i= A.length/2 ; i>=2; i/=2)
   for(int j=0; j < i ; j++)
       insertSort(A, j, i);
insertSort(A,0,1);
}

void insertSort(int[] A, int st, int incr){
   for(int i = st+incr ; i < A.length/icr ; i+=incr)
      for(int j = i; j>0 && A[j].compareTo(A[j-incr])<0 ; j-=incr)
            swap(A,j,j-incr);
}
```
**2.Merge Sort**

A natural approach to problem solving is divide and conquer.

A simple way to do this would be to split the list in half, sort the halves, and then merge the sorted halves together. This is the idea behind MergeSort.

```java
void mergeSort(int[] A, int[] tmp, int left, int right){
  int i,j,k,mid = (left+right)/2;
  if(left == right) return;
  mergeSort(A,tmp,left,mid);
  mergeSort(A,tmp,mid+1,right);
  // copy value to temp
  for(i=left;i<=mid;i++) tmp[i] = A[i];
  for(j=right;j>mid;j--) tmp[i++] = A[j];
  // starting merge
  for(i=left,j=right,k=left;k<=right;k++)
     if(tmp[i]<tmp[j])
          A[k]=tmp[i++];
     else
         A[k] = tmp[j--];
}
```
**3. Quick Sort**

Quicksort is the fasted known general-purpose in-memory sorting algorithm in the average case.

It does not require the extra array needed by Mergesort, so it is space efficient as well.

Quicksort first selects a value called the pivot. (This is conceptually like the root node’s value in the BST)

Assume that the input array contains k records with key values less than the pivot. The records are then rearranged in such a way that the k values less than the pivot are placed in the first, or leftmost, k positions in the array, and the values greater than or equal to the pivot are placed in the last, or rightmost, n−k positions. This is called a partition of the array.

```java
void Quicksort( int[] A, int l, int r ){
 int pivot = findpivot(A,I,r);
 Swap(A,pivot,r);
 int k = partition(A,l,r-1,A[r]);
 if(k-l>1) quicksort(A,l,k-1);
 if(r-k>1) quicksort(A,k+1,r);
}

int partition(int[] A, int left, int right, int key){
   while(left<=right){
   while(A[left] <key) left++;
   while(A[right]>= key && right>= left) right--;
   if(right>left) swap(A,left,right);
   return left;
   }
}
```

**4.Heap Sort**

A good sorting algorithm can be devised based on a tree structure more suited to the purpose In particular, we would like the tree to be balanced, space efficient, and fast.

Heapsort is based on the heap data structure. Heapsort has all of the advantages just listed. The complete binary tree is balanced, its array representation is space efficient, and we can load all values into the tree at once, taking advantage of the efficient buildheap function

```java
void buildheap() {
 For( int i= n/2-1; i>=0 ; i--) siftdown(i);}
} 

void siftdown(int pos) {
  If(pos <0 || pos >=n) return;
  While(!isLeaf(pos)){
      Int j = lefchild(pos);
      If( j < n-1 && H[j] < H[j+1] )
          j++;
      if( H[pos] >= H[j] ) return;
      swap(Heap,pos,j);
      pos = j;
  }
}

int Removemax(){
   If(n==0) return -1;
   Swap(H,0,--n);
   If(n !=0)
      Siftdown(0);
   Return H[n];
}

void heapSort(){
    	MaxHeap h = new MaxHeap(input,input.length,input.length);
    	h.buildheap();
    	for(int i=input.length-1;i>=0;i--)
    		result[i]=h.removeMax();
    }
```


