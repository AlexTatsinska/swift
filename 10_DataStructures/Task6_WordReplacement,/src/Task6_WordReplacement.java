
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 Напишете задача Task6_WordReplacement, която чете от стандартния вход текст на един ред, след което число N.
След това чете N на брой редове, всеки от които с 2 думи. Програмата да замести в текста всяка дума от текста, 
която се среща на първа позиция в някой от N-те реда с думата на втора позиция. На стандартния изход програмата 
трябва да отпечата въведения текст с направените заменки. За дума приемаме всяка последователност от латински букви, 
като пренебрегваме главни и малки букви.
Пренебрегвайте малки и големи букви за всички сравнения в програмата.
 */
/**
 *
 * @author AlexT
 */
public class Task6_WordReplacement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        int counter = 1;
        List<String> listInput = new LinkedList<>();
        String[] split = input.split(" ");

        for (int i = 0; i < split.length; i++) {
            listInput.add(split[i].toLowerCase());
            //System.out.println(listInput.get(i)+" ");
        }
        do {
            String replace = sc.nextLine();
            String[] split1 = replace.split(" ");
            if (listInput.contains(split1[0])) {
                int index = listInput.lastIndexOf(split1[0]);
                listInput.set(index, split1[1]);
                counter++;
            }
        } while (counter <= n);
        printList(listInput);
    }

    private static void printList(List<String> list) {
        for (String i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
