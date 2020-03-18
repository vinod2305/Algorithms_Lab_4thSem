import java.util.*;

public class countingInversions{
        
        public int  sort_count(int low,int high,int[] A){
                int ra=0;
                int rb=0;
                int r=0;
                if(low<high){
                        int mid=(low+high)/2;
                        ra=sort_count(low,mid,A);
                        rb=sort_count(mid+1,high,A);
                        r=merge_count(low,mid,high,A);
                }
                r=r+ra+rb;
                return r;

        }

	public int merge_count(int low,int mid,int high,int[] A){

	        int count=0;
                int n1=mid-low+1;
                int n2=high-mid;
                int arr1[]=new int[n1];
                int arr2[]=new int[n2];

                for(int i=0;i<n1;i++)
                        arr1[i]=A[low+i];
                for(int j=0;j<n2;j++)
                        arr2[j]=A[mid+1+j];

                int i=0;
                int j=0;
                int k=low;
             
               	while(i<n1 && j<n2){
      			if(arr1[i]<arr2[j]){
                                A[k]=arr1[i];
  	                        i++;
                        }
                        else{
                                A[k]=arr2[j];
                                j++;
                                count=count+(n1-i);
                      	}
		      	k++;
                }
                while(j<n2){
                	A[k]=arr2[j];
                        j++;
                        k++;
                }
                while(i<n1){
                        A[k]=arr1[i];    
			i++;                 
		     	k++;
                }
		return count;
        }

        public static void main(String args[]){
		int count=0;
                Scanner in=new Scanner(System.in);

                System.out.println("Enter the size of the array: ");
                int N=in.nextInt();

                int A[]=new int[N];

                System.out.println("Enter the array elements: ");
                for(int i=0;i<N;i++)
                        A[i]=in.nextInt();
                
                countingInversions obj=new countingInversions();
                count=obj.sort_count(0,N-1,A);
		System.out.println("Total number of inversions: "+count);
                System.out.println("\nSorted array:");
                for(int i=0;i<N;i++)
                        System.out.println(A[i]);

        }
}
