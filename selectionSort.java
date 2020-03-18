import java.util.*;

public class selectionSort{
        
        public void  sort(int[] A,int n){

                for(int i=0;i<n-1;i++){
                    int min_indx=i;
                    for(int j=i+1;j<n;j++){
                        if(A[j]<A[min_indx]){
                            min_indx=j;
                        }
                    }
                    int temp=A[min_indx];
                    A[min_indx]=A[i];
                    A[i]=temp;
                }

        }

        public static void main(String args[]){
		
                Scanner in=new Scanner(System.in);

                System.out.println("Enter the size of the array: ");
                int N=in.nextInt();

                int A[]=new int[N];

                System.out.println("Enter the array elements: ");
                for(int i=0;i<N;i++)
                        A[i]=in.nextInt();
                
                selectionSort obj=new selectionSort();
                obj.sort(A,N);
		
                System.out.println("\nSorted array:");
                for(int i=0;i<N;i++)
                        System.out.println(A[i]);

        }
}
