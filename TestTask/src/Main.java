import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
// Создаем файлы с данными и указываем путь
        File file1 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in1.txt");
        File file2 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in2.txt");
        File file3 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\in3.txt");
        File file4 = new File("C:\\Projects\\TestTask\\TestTask\\src\\Resources\\out.txt");
        File fileSt1 = new File("FileStrings1");
        File fileSt2 = new File("FileStrings2");
        File fileSt3 = new File("FileStrings3");

// Ввод клавиатуры в консоль
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип данных для сортировки (s - строчный, i - целочисленный)");
        String x = null;
        x = scanner.nextLine();
        while (!Objects.equals(x, "s") && !Objects.equals(x, "i")) {
            System.out.println("Вы ввели недопустимый символ, необходимо ввести s или i");
            System.out.println("Введите тип данных для сортировки (s - строчный, i - целочисленный)");
            x = scanner.nextLine();
        }
            if (x.equals("s"))
                MergeAndWriteStrings(fileSt1, fileSt2, fileSt3, file4);
            else if (x.equals("i"))
                MergeAndWriteInt(file1, file2, file3, file4);
        System.out.println("Отсортированные данные находятся в файле out.txt");
    }
    // Метод объединяет и сортирует целочисленные значения
    public static void MergeAndWriteInt(File file1, File file2, File file3, File file4) {
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
        scanner.close();

        try {
            scanner = new Scanner(file2);
        } catch (FileNotFoundException e) {
            System.out.println("File2 not found");
        }
        while (scanner.hasNext())
            numbers2.add(scanner.nextInt());
        scanner.close();
        Integer[] in2 = numbers2.toArray(new Integer[numbers2.size()]);
        scanner.close();

        try {
            scanner = new Scanner(file3);
        } catch (FileNotFoundException e) {
            System.out.println("File3 not found");
        }
        while (scanner.hasNext())
            numbers3.add(scanner.nextInt());
        scanner.close();
        Integer[] in3 = numbers3.toArray(new Integer[numbers3.size()]);
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
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file4);
        } catch (FileNotFoundException e) {
            System.out.println("File out not found");
        }
        pw.println(Arrays.toString(out));
        pw.close();
    }


// Метод объединяет и сортирует строчные значения
    public static void MergeAndWriteStrings(File fileSt1, File fileSt2, File fileSt3, File out){
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new ArrayList<>();
        List<String> strings3 = new ArrayList<>();
        List<String> outStrings = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(fileSt1);
        } catch (FileNotFoundException e) {
            System.out.println("FileStrings1 not found");
        }
        while (scanner.hasNext())
            strings1.add(scanner.nextLine());
        scanner.close();

        try {
            scanner = new Scanner(fileSt2);
        } catch (FileNotFoundException e) {
            System.out.println("FileStrings2 not found");
        }
        while (scanner.hasNext())
            strings2.add(scanner.nextLine());
        scanner.close();


        try {
            scanner = new Scanner(fileSt3);
        } catch (FileNotFoundException e) {
            System.out.println("FileStrings3 not found");
        }
        while (scanner.hasNext())
            strings3.add(scanner.nextLine());
        scanner.close();

        outStrings.addAll(strings1);
        outStrings.addAll(strings2);
        outStrings.addAll(strings3);
        Collections.sort(outStrings);


        PrintWriter pw = null;
        try {
            pw = new PrintWriter(out);
        } catch (FileNotFoundException e) {
            System.out.println("File out not found");
        }
        for(String str: outStrings)
        pw.println(str + System.lineSeparator());
        System.out.println(outStrings);
        pw.close();
    }
}


