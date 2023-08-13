import java.io.File;
import java.io.FileNotFoundException;
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