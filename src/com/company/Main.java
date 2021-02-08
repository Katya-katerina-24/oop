package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main obj=new Main();
        /*EX 2*/
        int[][] number1;
        int[][] number2;

        System.out.println("Кол-во строк первого массива");
        Scanner input = new Scanner(System.in);
        int size1 = input.nextInt();
        System.out.println("Кол-во столбцов первого массива");
        int size1_1 = input.nextInt();
        number1 = new int[size1][size1_1];
        System.out.println("Введите элементы первого массива");
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size1_1; j++) {
                number1[i][j] = input.nextInt();
            }
        }

        System.out.println("Размер второго массива");
        int size2 = input.nextInt();
        System.out.println("Кол-во столбцов второго массива");
        int size2_2 = input.nextInt();
        number2 = new int[size2][size2_2];
        System.out.println("Введите элементы второго массива");
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size2_2; j++) {
                number2[i][j] = input.nextInt();
            }
        }

        Ex2(number1, number2);
        System.out.println(Arrays.toString(obj.Ex10(new int[]{1, 7, 4}, new int[]{55, 3, 4})));
        System.out.println(obj.Ex14("SdDshHkK"));
        System.out.println(obj.Ex18("lol","llool"));
        System.out.println(Arrays.toString(obj.Ex30(new int[]{1, 7, 4}, new int[]{55, 3, 4})));
    }
    /* EX 2
    Розробіть метод, який виводить на екран спільні елементи
    будь яких двох 2-вимірних масивів int[][]. Результат роботи
     методу не повинен залежати від того чи є масив регулярним. */
    public static void Ex2(int[][] number1, int[][] number2) {
        for (int i = 0; i < number1.length; i++) {
            for (int j = 0; j < number1[i].length; j++) {
                int a = number1[i][j];
                for (int m = 0; m < number2.length; m++) {
                    for (int n = 0; n < number2[m].length; n++) {

                        if (a == number2[m][n]) {
                            System.out.println("Общие элементы двух массивов");
                            System.out.println(a);
                            break;
                        }
                    }
                }
            }
        }
    }

    /*Створіть метод, який дозволяє поєднати між собою будь яку кількість
     масивів int[] та повернути результуючий масив,
     який буде складатися виключно з простих чисел, які були у складі масивів.*/
    int[] Ex10(int[] ...arrays){

        Set<Integer> set = new HashSet<>();
        Set<Integer> result= new HashSet<>();
        for (int[] item : arrays) {
            for (int item1 :item) {
                set.add(item1);
            }
        }
        for(int num: set)
        {
            if(isPrime(num)){
                result.add(num);
            };
        }
        return result.stream().mapToInt(Integer::intValue).toArray();


    }
    boolean isPrime(int n) {
        int temp;
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            temp = n % i;
            if (temp == 0) return false;
        }
        return true;
    }

/*Створіть метод, який повертає найбільший збалансований підрядок у
складі параметру String, який передається у метод.
 Збалансованим вважається рядок у якому всі літери представлені у двох регістрах.
 Приклад: "wdDdddWd"- збалансований рядок,  "wzW"- незбалансований.*/

    String Ex14(String str) {
        String result ="";
        int tmp;
        int tmpLength;
        int size = str.length();
        String tmpString;
        for (int i = 2; i <= size; i++) {

            tmpString = str.substring(0, i);

            tmpLength = tmpString.length();

            tmp = upperCaseLettersCount(tmpString);

            if(tmp == tmpLength - tmp && tmpLength > result.length())
                result = tmpString;
        }
        return result;
    }
    int upperCaseLettersCount(String str) {
        int result = 0;
        int size = str.length();
        for(int i =0; i < size ; i++)
        {
            if(Character.isUpperCase(str.charAt(i))) {
                result++;
            }
        }
        return result;
    }


/*Створіть метод, який  приймає два параметри типу String
// та повертає кількість повних повторів одного слова літерами другого.*/

    int Ex18(String str1, String str2)
    {
        String tmp2=str2;
        int numOfReplacing;
        int result = 0;
        int length = tmp2.length();

        while(true){
            numOfReplacing = str1.length();
            for(int i = 0,i2 = 0;i2 < length;)
            {
                if(str1.charAt(i) == tmp2.charAt(i2))
                {
                    tmp2 = tmp2.substring(0,i2) + tmp2.substring(i2+1);
                    --length;
                    i2 = 0;
                    if(--numOfReplacing == 0) break;
                    ++i;
                    continue;
                }
                ++i2;
            }
            if(numOfReplacing != 0) break;
            ++result;
        }
        return result;
    }


/*Створіть метод, який приймає будь яку кількість елементів int[] та повертає масив,
який складається тільки з елементів, які є в одному екземплярі серед усіх масивів.*/

    int[] Ex30(int[] ...arrays){
        Set<Integer> set = new HashSet<>();
        for (int[] item : arrays) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(item.length);
            for (int item1 :item) {
                tmp.add(item1);
            }
            set.addAll(tmp);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}