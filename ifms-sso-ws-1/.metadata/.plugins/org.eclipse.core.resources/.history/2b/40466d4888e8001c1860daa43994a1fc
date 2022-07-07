package Quicksort;

public abstract class Quicksort {
	int partiton(int arr[],int low,int high) {
		int pivot=arr[high];
		int i= low-1;
		
		for(int j=low;j<high;j++)
		{
			if(arr[j]<pivot) {
				i++;
				int temp= arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		i++;
		int temp=arr[i];
		arr[i]=pivot;
		arr[high]=temp;
		return i;
				}
	
  public static void sort Quicksort(int arr[], int low, int high) {
	   if(low<high) {
		   int pivot=partition(arr, low, high);
		   
		   Quicksort(arr,low,pivot-1);
		   Quicksort(arr,pivot+1,high);
		 
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,5,11,1,17,3,19,9};
		int n= arr.length;
		
		Quicksort qc=new Quicksort();
		qc.sort=(arr,0,n-1);
		for(int i=0;i<n;i++) {
		System.out.println("sorted array");
		}
	}

}
