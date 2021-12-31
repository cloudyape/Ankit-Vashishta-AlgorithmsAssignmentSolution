package com.stockers;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
        int totalCompanies = 0;
        int selectedValue;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the no of companies");
        totalCompanies = sc.nextInt();
        System.out.println(totalCompanies);
        int stockPrices[] = new int[totalCompanies];
		boolean raisePrices[] = new boolean[totalCompanies];
		LienearSearchAlgorithm LienearSearchAlgorithm = new LienearSearchAlgorithm();
        for(int i = 0 ; i < totalCompanies; i++) {
	        System.out.println("Enter current stock price of the company" + (i + 1));
	        stockPrices[i] = sc.nextInt();
	        System.out.print(stockPrices[i] + " ");
	        System.out.print("Whether company's stock price rose today compare to yesterday?");
	        raisePrices[i] = sc.nextBoolean();
	        System.out.print(raisePrices[i] + " ");
        }
        
        System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total  no of companies  for which stock prices rose today");
		System.out.println("4. Display the total  no of companies  for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		System.out.println("-----------------------------------------------");
		selectedValue = sc.nextInt();
		switch (selectedValue) {

		case 1: {
			AscendingOrderPrices AscendingOrderPrices = new AscendingOrderPrices();
	        AscendingOrderPrices.sort(stockPrices, 0, stockPrices.length - 1);
	        AscendingOrderPrices.printArray(stockPrices);

		}
			break;
		case 2: {
	        DescendingOrderPrices DescendingOrderPrices = new DescendingOrderPrices();
	        DescendingOrderPrices.sort(stockPrices, stockPrices.length - 1, 0);
	        DescendingOrderPrices.printArray(stockPrices);

		}
			break;
		case 3: {
			
	        LienearSearchAlgorithm.main(raisePrices , true);

		}
			break;
		case 4: {
			LienearSearchAlgorithm.main(raisePrices , false);

		}
			break;
		case 5: {
			int key;
			System.out.println("enter the key value");
			key = sc.nextInt();
			LienearSearchAlgorithm.specific(stockPrices, key);

		}

			break;
		default:
			System.out.println("enter valid option");
		}

    }
}

class AscendingOrderPrices {
	void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
  

        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  

        int i = 0, j = 0;
  
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
  
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m =l+ (r-l)/2;
  
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

class DescendingOrderPrices {
	void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
  

        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  

        int i = 0, j = 0;
  
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
  
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m =r+ (l-r)/2;
  
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=arr.length-1;i>=0;i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
}

class LienearSearchAlgorithm {
    public int search(boolean arr[], boolean x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    
    public int searchSpecific(int arr[], int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
 
    public void main(boolean arr[], boolean x)
    {
 
        int result = search(arr, x);
        int ElementNumbers = 0;
        if (result == -1) {

        }
        else {
        	ElementNumbers = ElementNumbers + 1;
            System.out.print(ElementNumbers);
        }
    }
    
    public void specific(int arr[], int x)
    {
 
        int result = searchSpecific(arr, x);
        if (result == -1)
            System.out.print(
                "Element is not present in array");
        else
            System.out.print("Stock of value" + x + "is present ");
    }
}