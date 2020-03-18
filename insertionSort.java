import java.util.*;

public class insertionSort{
        
        public void  sort(int[] A,int n){
                int i,key,j;
                for(i=1;i<n;i++){
                    key=A[i];
                    j=i-1;

                    while(j>=0 && A[j]>key){
                        A[j+1]=A[j];
                        j=j-1;
                    }
                    A[j+1]=key;
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
                
                insertionSort obj=new insertionSort();
                obj.sort(A,N);
		
                System.out.println("\nSorted array:");
                for(int i=0;i<N;i++)
                        System.out.println(A[i]);

        }
}
