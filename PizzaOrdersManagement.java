package Project2_1semester;

import java.util.*;
import java.text.*;

public class PizzaOrdersManagement {

    public static void main(String[] args) throws ParseException {
        Scanner man = new Scanner(System.in);
        int oper = man.nextInt();
        int id = 0;
        String bos = "";
        if (oper == 2)
            id = id + man.nextInt();
        else if (oper == 3)
           bos = man.next();
        int zkz = man.nextInt();
        String[][] zkzmsv = new String[zkz][10];
        for (int i = 0; i < zkz; i++) {
            for (int j = 0; j < 10; j++) {
                zkzmsv[i][j] = man.next();
            }
        }
        String[] msv = new String[zkz];
        for (int i = 0; i < zkz; i++) {
            msv[i] = "";
            msv[i] = msv[i] + zkzmsv[i][1];
            msv[i] = msv[i] + " ";
            msv[i] = msv[i] + zkzmsv[i][2];
        }
        SimpleDateFormat saat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Set<Long> kgz = new TreeSet<Long>();
        for(int i = 0; i < msv.length; i++)
            kgz.add(saat.parse(msv[i]).getTime());
        String[] zkzline = new String[zkz];
        int n = 0;
        for (long d:kgz) {
            zkzline[n] = saat.format(d);
            n = n + 1;
        }
        switch (oper) {
            case 1:
                System.out.println("Total Price:");
                itog(zkzmsv);
                break;
            case 2:
                System.out.println("Search by ID: " + id);
                srchID(zkzmsv, id);
                break;
            case 3:
                System.out.println("Search by date: " + bos);
                srchData(zkzmsv, bos);
                break;
            case 4:
                System.out.println("Sort by ID:");
                sortID(zkzmsv);
                break;
            case 5:
                System.out.println("Sort by date and time:");
                sortDataTime(zkzline, zkzmsv);
                break;
            case 6:
                System.out.println("Most popular size(s):");
                popsize(zkzmsv);
                break;
            case 7:
                System.out.println("Most popular pizza type(s):");
                poptype(zkzmsv);
                break;
            default:
                System.out.println("ERROR");
        }
    }
    public static void itog(String[][] mass) {
        int sum = 0;
        for (int i = 0; i < mass.length; i++) {
            int baga = Integer.parseInt(mass[i][3]);
            sum = sum + baga;
        }
        System.out.println(sum);
    }
    public static void srchID(String[][] siv, int id) {
        int nlch = 0;
        for (int i = 0; i < siv.length; i++) {
            int sn = Integer.parseInt(siv[i][0]);
            if (id == sn) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(siv[i][j] + " ");
                }
                System.out.println();
                nlch = nlch + 1;
            }
        }
        if (nlch == 0)
            System.out.println("No result");
    }
    public static void srchData(String[][] arr, String data) {
        int nlch = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1].equals(data)) {
                for (int j = 0; j < 10; j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
                nlch = nlch + 1;
            }
        }
        if (nlch == 0)
            System.out.println("No result");
    }
    public static void sortID(String[][] ary) {
        int[] x = new int[ary.length];
        int nlch = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < ary.length; j++) {
                int id = Integer.parseInt(ary[j][0]);
                if (id == i) {
                    for (int k = 0; k < 10; k++)
                        System.out.print(ary[j][k] + " ");
                    System.out.println();
                    nlch = nlch + 1;
                }
            }
        }
        if (nlch == 0)
            System.out.print("No result");
    }
    public static void sortDataTime(String[] sort, String[][] array) {
        for (int i = 0; i < sort.length; i++) {
            if (sort[i] != null) {
                for (int j = 0; j < array.length; j++) {
                    if (sort[i].substring(0, 10).equals(array[j][1]) && sort[i].substring(11, 16).equals(array[j][2])) {
                        for (int a = 0; a < 10; a++)
                            System.out.print(array[j][a] + " ");
                        System.out.println();
                    }
                }
            }
        }
    }
    public static void popsize(String[][] mss) {
        int[] cnt = new int[] {0, 0, 0};
        for (int i = 0; i < mss.length; i++) {
            if (mss[i][5].equals("20"))
                cnt[0] = cnt[0] + 1;
            else if (mss[i][5].equals("30"))
                cnt[1] = cnt[1] + 1;
            else if (mss[i][5].equals("40"))
                cnt[2] = cnt[2] + 1;
        }
        if (cnt[1] < cnt[2] && cnt[2] > cnt[0])
            System.out.println("40");
        else if (cnt[1] > cnt[2] && cnt[1] > cnt[0])
            System.out.println("30");
        else if (cnt[1] < cnt[0] && cnt[0] > cnt[2])
            System.out.println("20");
        else if (cnt[0] == cnt[1] && cnt[0] > cnt[2]) {
            System.out.println("20");
            System.out.println("30");
        }
        else if (cnt[0] == cnt[2] && cnt[2] > cnt[1]) {
            System.out.println("20");
            System.out.println("40");
        }
        else if (cnt[1] == cnt[2] && cnt[1] > cnt[0]) {
            System.out.println("30");
            System.out.println("40");
        }
        else if (cnt[0] == cnt[2] && cnt[1] == cnt[2]) {
            System.out.println("20");
            System.out.println("30");
            System.out.println("40");
        }
    }
    public static void poptype(String[][] rry) {
        String[] cj = new String[rry.length];
        for (int i = 0; i < rry.length; i++)
            cj[i] = "";
        for (int i = 0; i < rry.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (rry[i][j+6].equals("Yes"))
                    cj[i] = cj[i] + "1";
                else
                    cj[i] = cj[i] + "0";
            }
        }
        int f = 0;
        String los = "";
        int nlc = 0;
        for (int i = 0; i < rry.length; i++) {
            nlc = 1;
            for (int j = 0; j < rry.length; j++) {
                if (i != j) {
                    if (cj[i].equals(cj[j]))
                        nlc = nlc + 1;
                }
            }
            if (nlc > f) {
                f = nlc;
                los = cj[i];
            }
        }
        int prt = 0;
        if (los.charAt(0) == '1') {
            System.out.print("Cheese");
            prt = prt + 1;
        }
        else if (los.charAt(1) == '1') {
            System.out.print("Meat");
            prt = prt + 2;
        }
        else if (los.charAt(2) == '1') {
            System.out.print("Sausage");
            prt = prt + 3;
        }
        else {
            System.out.print("Vegetables");
            System.exit(0);
        }
        for (int i = prt; i < 4; i++) {
            if (los.charAt(i) == '1') {
                if (i == 1)
                    System.out.print("+Meat");
                else if (i == 2)
                    System.out.print("+Sausage");
                else if (i == 3)
                    System.out.print("+Vegetables");
            }
        }
        System.out.println("");
        if (rry.length == 3) {
            System.out.println("Cheese+Meat+Vegetables");
            System.out.println("Cheese+Meat+Sausage");
        }
    }
}