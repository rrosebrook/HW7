package hw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/*Rachel Rosebrook
**Comp Sci 2
**HW 7 - Create a hash table to divvy up text
*/

public class HW7 {
    
    static String file="";
    static String file2="";
    static ArrayList<String> text = new ArrayList<>();
    static String[] arr;
    static int buckets;
    static int size;
    String[] theArray;
    private LinkedList[] myTable;
    
    
    
    public static void main(String[] args) {
        getBucketSize();
        //displayTheStack();
        getFile();
        getTextArray();
        removeDuplicates();
        HW7 theFunc = new HW7(buckets);
        theFunc.hashFunction1(arr, theFunc.theArray);
        
        
    }
    
    public void hashFunction1(String[] arr, String[] theArray) {
        myTable = new LinkedList[buckets];
        for(int k=0; k<buckets; k++) {
            myTable[k] = new LinkedList();
        }
        for(int i=0; i < arr.length; i++) {
            String newElementVal = arr[i];
            //String toBeConverted = arr[i];
            //char c = arr[i].charAt(i)
            
            char[] chars = arr[i].toCharArray();
            int intOfString = 0;

            //StringBuilder hex = new StringBuilder();
            for (int j=0; j < newElementVal.length() - 1; j++) {
                char c = newElementVal.charAt(j);
                int ascii = c;
                intOfString = intOfString + ascii;
            }
            
            int arrayIndex = intOfString % buckets;
            
            System.out.println("Mod= " + arrayIndex + " for word " + newElementVal);
            //LinkedList hashList = new LinkedList();
            theArray[arrayIndex] = newElementVal;
            
            
            for(arrayIndex = 0; arrayIndex < buckets; arrayIndex++) {
                System.out.println("Bucket " + arrayIndex + ": " + theArray[arrayIndex]);
            }
            //hashList.add(newElementVal);
            
            
            /*while (theArray[arrayIndex] != "0") {
                ++arrayIndex;
                System.out.println("Collision Try " + arrayIndex + " Indead");
                
                arrayIndex %= buckets;
            }*/
            
            //theArray[arrayIndex] = newElementVal;
        }
        //System.out.println(java.util.Arrays.toString(theArray));

    }
    
    public void insert(String[] arr, int arrayIndex) {
        
    }
    
    HW7(int buckets) {
        theArray = new String[buckets];
        //Arrays.fill(theArray, "0");
    }
    
    public static void fillHash() {
        for(int i=0; i<arr.length; i++); {
        
    }
    }
    
    public static void removeDuplicates() {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        arr = set.toArray(new String[set.size()]);
        
        size = set.size();
        
        Arrays.sort(arr);

        
        System.out.println(java.util.Arrays.toString(arr));

    }
  
    public static void getTextArray()  {
        try (
                Scanner sc = new Scanner(new File(file))) {

                    while (sc.hasNext()) {
                        text.add(sc.next());
                    }
                }

        catch (FileNotFoundException file) {
            System.err.println("File not found.");
            getFile();
            getTextArray();
        }
        arr = text.toArray(new String[0]);
        //System.out.println(java.util.Arrays.toString(arr));

        //Remove non-alpha characters from the array
        for(int i=0; i<text.size(); i++) {
            arr[i] = arr[i].replaceAll("[^a-zA-Z']", "");
        }
        
        Arrays.sort(arr);
  
        System.out.println(java.util.Arrays.toString(arr));
        
    }
    
    public static void getFile() {
        System.out.println("What is the location of the file?");
        Scanner fileloc = new Scanner(System.in);
        file = fileloc.nextLine();
    }
    
    public static void displayTheStack() {
        for (int i = 1; i < buckets + 1; i++) {
            System.out.println("Bucket " + i + ":");
        }
    }
    public static boolean isPrime(int n)//Function to check if a number is Prime.
    {
        int c=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
                c++;
        }
        if(c==2)//Prime no.has 2 factors-1 and number itself.
            return true;
        else
            return false;
    }
    
    public static void getBucketSize() {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number whose nearest prime is to be found.");
        int num=ob.nextInt();
        int diff1=0,diff2=0;
        int num1=0,num2=0;
        for(int i=num;;i++)//No end limit as when prime will be found we will break the loop.
        {
            if(isPrime(i))
            {
                diff1=i-num;
                num1=i;
                break;
            }
        }
        for(int i=num;;i--)//No end limit as when prime will be found we will break the loop.
        {
            if(isPrime(i))
            {
                diff2=num-i;
                num2=i;
                break;
            }
        }
        if(diff1<diff2) {//Nearest Prime number will have least difference from given number.
            System.out.println("Nearest Prime Number from "+num+" is "+num1);
                buckets = num1;
        }
        else if(diff2<diff1) {
            System.out.println("Nearest Prime Number from "+num+" is "+num2);
                buckets = num2;
        }
        else {//There can be more than 1 nearest prime like for 6 we have 5 and 7 as nearest prime.
            System.out.println("Nearest Prime Number from "+num+" is "+num2+" and "+num1);
                buckets = num2;
        }
    }

}