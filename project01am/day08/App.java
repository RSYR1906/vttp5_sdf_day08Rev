package project01am.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        ArrayList<product> productList = new ArrayList<>();

        LocalDate ldCreated = LocalDate.of(2024, 10, 21);
        Date createDt =
        Date.from(ldCreated.atStartOfDay(ZoneId.systemDefault()).toInstant()); //
       // allows for changing of
        // the dates

        productList.add(new product(01, "Mouse", "For click UI on screen",
        "Computer", createDt, 99.0f));
        productList
        .add(new product(02, "keyboard", "device that allows alpha numeric inputs",
        "Computer", createDt,
        235.5f));
        productList.add(new product(03, "15.6 inch monitor", "Extended display panel", "Computer", createDt, 157.5f));
        productList.add(new product(04, "Huawei Pura 70 Ultra", "Huawei phone",
        "mobile", createDt, 900.0f));
        productList.add(new product(05, "Huawei Mate 50 Pr", "Huawei phone",
        "mobile", createDt, 99.0f));
        productList.add(new product(06, "iphone 16 pro", "Apple phone", "mobile",
        createDt, 2000f));
        productList.add(new product(07, "iphone 14 pro", "Apple phone", "mobile",
        createDt, 1800f));

        List<product> mobilePhonesAbove1500 = productList.stream()
        .filter(p -> p.getProdCategory().equals("mobile") && p.getPrice() > 1500f)
        .collect(Collectors.toList());

        System.out.println(mobilePhonesAbove1500.toString());

       // Write the list of filtered objects to a file

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < productList.size(); i++) {
        bw.write(productList.get(i).toString());
        bw.newLine();
        }

        bw.flush();
        bw.close();

        // // using Comparator to perform sorting
        Comparator<product> comparator = Comparator.comparing(p -> p.getProdName());
        productList.sort(comparator);
        productList.forEach(System.out::println);

        productList.sort(comparator.reversed());
        productList.forEach(System.out::println);

        // sort an array to string
        // "Bernard","Zachary","Alpha","Theopilia","Sammy","Christopher"
        // sort ascending and print
        // sort descending and print

        String arr[] = { "Bernard", "Zachary", "Alpha", "Theopilia", "Sammy", "Christopher" };
        Arrays.sort(arr);
        System.out.println("Ascending order: ");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println("Descending order: ");
        System.out.println(Arrays.toString(arr));

    }

}
