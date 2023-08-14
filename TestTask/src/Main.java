import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        File file4 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\out.txt");
        MergeAndWrite(file1, file2, file3, file4);

    }

    public static void MergeAndWrite(File file1, File file2, File file3, File file4) {
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
   //     System.out.println(Arrays.toString(out));
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file4);
        } catch (FileNotFoundException e) {
            System.out.println("File out not found");
        }
        pw.println(Arrays.toString(out));
        pw.close();
    }
}


