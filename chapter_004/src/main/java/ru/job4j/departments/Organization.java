package ru.job4j.departments;

import java.util.*;


/**
 * Class Organization
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Organization {
    /**
     * Дополненный код департамента
     */
    private String fullCode;
    /**
     * Код департамента
     */
    private String code;
    /**
     * Массив кодов департамента
     */
    private String[] depart;
    /**
     * Список департаментов
     */
    Set<String> dept;

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param depart Список департаментов
     * @param comp компаратор
     */
    public Organization(String[] depart, Comparator<String> comp) {
        this.depart = depart;
        dept = new TreeSet<>(comp);
    }

    /**
     * Метод сортирует массив кодов подразделений.
     * @return массив кодов подразделений.
     */
    public String[] sort() {
        String[] subStr;
        StringBuilder sb;
        String str = " ";
        for (int i = 0; i < depart.length; i++) {
            subStr = depart[i].split("\\\\");
            sb = new StringBuilder();
            for (int j = 0; j < subStr.length; j++) {
                sb.append(subStr[j]);
            }
            str = sb.toString();
            code = str;
            dept.add(code);
        }
        if (str.length() != 9) {
            str = check(str);
        }
        fullCode = str;
        return dept.toArray(new String[dept.size()]);
    }


    /**
     * Метод добавляет строку с кодом данного подразделения.
     * @return result строка кода подразделения.
     */
    String check(String str) {
        String s1 = "K1SK1SSK1";
        String s2 = "K2SK2SSK2";
        String result = " ";
        int index = str.length() - 1;
        if (str.indexOf('1', index) > 0) {
            result = str.concat(s1.substring(index + 1, s1.length()));
        }
        if (str.indexOf('2', index) > 0) {
            result = str.concat(s2.substring(index + 1, s2.length()));
        }
        return result;
    }

    /**
     * Метод получения значения поля fullCode
     * @return fullCode дополненная строка кода подразделения.
     */
    public String getFullCode() {
        return fullCode;
    }

    /**
     * Метод получения значения поля code
     * @return code строка кода подразделения.
     */
    public String getCode() {
        return code;
    }

    /**
     * Компаратор сравнения строк кода подразделения по
     * возрастанию
     */
    public static Comparator<String> AscenCodeComparator = new Comparator<String>() {
        @Override
        public int compare(String dep, String dep1) {
            return dep.compareTo(dep1);
        }
    };

    /**
     * Компаратор сравнения строк кода подразделения по
     * убыванию
     */
    public static Comparator<String> DescCodeComparator = new Comparator<String>() {
        @Override
        public int compare(String org1, String org2) {
            char[] charsCode1 = org1.toCharArray();
            char[] charsCode2 = org2.toCharArray();
            int compareLength = 0, compareCode = 0;
            compareLength = charsCode1.length - charsCode2.length;
            int len = Math.min(charsCode1.length, charsCode2.length);
            for (int i = 0; i < len; i++) {
                if (charsCode1[i] != charsCode2[i]) {
                    compareCode = -(charsCode1[i] - charsCode2[i]);
                    break;
                }
            }
            return compareCode == 0 ? compareLength : compareCode;
        }
    };

}