import java.util.Scanner;
import java.lang.*;

class Source
{ 
    static void sumClosestToZero(int arr[], int n) 
    { 
        //Write code here
        sortArr(arr, 0, n-1);
        /*for(int i: arr){
            System.out.print(i+ " ");
        }*/
        if(n<2){
            System.out.println("not possible");
        }
        int sum1=0, min1=0, min2=0, l=0, r=n-1, minsum=0;
        int sum=arr[l]+ arr[r];
        while(l<r)
        {
            if(sum>0)
            {
                r--;
            }
            else if(sum<0)
            {
                l++;
            }
            sum1=arr[l]+arr[r];
            //System.out.print(arr[l]+" "+ arr[r]);
            if(Math.abs(sum1)<Math.abs(sum)){
                sum=sum1;
                min1=l;
                min2=r;
                continue;
            }
            else{
                break;
            }
        }
        System.out.println(arr[min1]+" "+ arr[min2]);
    } 
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    static void sortArr(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sortArr(arr, l, m);
            sortArr(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
       
    public static void main (String[] args)  
    {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();
            
        sumClosestToZero(arr, n); 
    }
} 
