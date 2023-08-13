import java.io.File;
import java.io.FileNotFoundException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Создаем файлы с данными и указываем путь
        File file1 = new File("C:\\JavaProjects\\TestTask\\TestTask\\src\\Resources\\in1.txt");
        File file2 = new File("C:\\JavaProjects\\TestTask\\TestTask\\src\\Resources\\in2.txt");
        File file3 = new File("C:\\JavaProjects\\TestTask\\TestTask\\src\\Resources\\in3.txt");
        File file4 = new File("C:\\JavaProjects\\TestTask\\TestTask\\src\\Resources\\out.txt");
        merge(file1, file2, file3, file4);
    }

    public static void merge(File file1, File file2, File file3, File file4) {
        List<Integer> numbers = new ArrayList<>();

        Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(file1);
        } catch (FileNotFoundException e) {
            System.out.println("File1 not found");
        }
        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(file2);
        } catch (FileNotFoundException e) {
            System.out.println("file2 not found");
        }
        Scanner scanner3 = null;
        try {
            scanner3 = new Scanner(file3);
        } catch (FileNotFoundException e) {
            System.out.println("file3 not found");
        }

        while (scanner1.hasNext() || scanner2.hasNext() || scanner3.hasNext()) {
            numbers.add(scanner1.nextInt());
            numbers.add(scanner2.nextInt());
            numbers.add(scanner3.nextInt());

        }
        System.out.println(numbers);
    }

    public void divide(int startIndex,int endIndex){

        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);

            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);
        }
    }
}
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.arraycopy;

public class Main {
    public static void main(String[] args) {
// Создаем файлы с данными и указываем путь
        File file1 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in1.txt");
        File file2 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in2.txt");
        File file3 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in3.txt");
        File file4 = new File("C:C:\\Projects\\TestTask\\TestTask\\src\\Resources\\out.txt");
        readFiles(file1, file2, file3);

    }

    public static void readFiles(File file1, File file2, File file3) {
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        List<Integer> numbers3 = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file1);
        } catch (FileNotFoundException e) {
            System.out.println("File1 not found");
        }
        while (scanner.hasNext())
            numbers1.add(scanner.nextInt());
        scanner.close();
        Integer[] in1 = numbers1.toArray(new Integer[numbers1.size()]);
        System.out.println(Arrays.toString(in1));
        scanner.close();

        try {
            scanner = new Scanner(file2);
        } catch (FileNotFoundException e) {
            System.out.println("File1 not found");
        }
        while (scanner.hasNext())
            numbers2.add(scanner.nextInt());
        scanner.close();
        Integer[] in2 = numbers2.toArray(new Integer[numbers2.size()]);
        System.out.println(Arrays.toString(in2));
        scanner.close();

        try {
            scanner = new Scanner(file3);
        } catch (FileNotFoundException e) {
            System.out.println("File1 not found");
        }
        while (scanner.hasNext())
            numbers3.add(scanner.nextInt());
        scanner.close();
        Integer[] in3 = numbers3.toArray(new Integer[numbers3.size()]);
        System.out.println(Arrays.toString(in3));
        scanner.close();

        Integer[] out = new Integer[in1.length + in2.length + in3.length];
        int i = 0, j = 0, k = 0;
        for (int l = 0; l < out.length; l++) {
            out[l] = i < in1.length && (j >= in2.length || in1[i] < in2[j])
                    ? (k >= in3.length || in1[i] < in3[k]
                    ? in1[i++]
                    : in3[k++])
                    : (j < in2.length && (k >= in3.length || in2[j] < in3[k])
                    ? in2[j++]
                    : in3[k++]);
        }
        System.out.println(Arrays.toString(out));
    }
}


>>>>>>> 3e3dcaf (Initial commit)
