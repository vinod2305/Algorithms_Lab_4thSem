import java.util.*;
public class bucketSort{

    public int[] bucketsort(int A[], int n,int max){

        int[] Bucket = new int[max + 1];
        int[] sorted_list = new int[A.length];
 
        for (int i = 0; i < A.length; i++)
            Bucket[A[i]]++;
 
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_list[outPos++] = i;

        return sorted_list;
    }

    public int maxValue(int A[]) 
    {
        int maxValue = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] > maxValue)
                maxValue = A[i];
        return maxValue;
    }

    public void printSequence(int[] sorted_sequence) 
    {
        System.out.println("Sorted Array:");
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int N=in.nextInt();

        int A[]=new int[N];

        System.out.println("Enter the array elements: ");
        for(int i=0;i<N;i++)
                A[i]=in.nextInt();

        bucketSort obj=new bucketSort();
        int maxValue=obj.maxValue(A);
        obj.printSequence(obj.bucketsort(A,N,maxValue));
    }
}