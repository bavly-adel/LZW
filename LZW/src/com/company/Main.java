package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ABAABABBAABAABAAAABABBBBBBBB
        //ABAABABBAABA BAA BBAB
        //ArrayList<String> dic=new ArrayList<>(); //has ascii codes

//        for (int i=0;i<128;i++){
//            dic.add(String.valueOf((char)i));
//
//        }
//
//        String text="";
//
//        int[] compressed = {65, 66, 65, 128, 128, 129, 131, 134, 130, 129, 66, 138, 139, 138};
//
//        String check="";
//        for(int i=0;i<compressed.length;i++){
//            if (compressed[i]<=dic.size()-1){
//                text+=dic.get(compressed[i]);
//
//
//
//
//            }else {
//
//            }
//        }
//
//        System.out.println(text);
//        for(int i=127;i<141;i++) {
//            System.out.println(dic.get(i));
//
//        }
//
//

        System.out.println("enter the word you want to compress it");
        String word;
        Scanner scanner = new Scanner(System.in);
        word=scanner.next();
        System.out.println(compress(word));










    }

    public static String cutLetter(String st){
        String newSt="";
        for (int i=0;i<st.length()-1;i++){
            newSt+=st.charAt(i);
        }
        return newSt;
    }

    public static ArrayList compress(String word){
        ArrayList<String> dic=new ArrayList<>();
        ArrayList<Integer> compressed=new ArrayList<>();

        for (int i=0;i<128;i++){
            dic.add(String.valueOf((char)i));               //to add ascii values to dic array

        }

        String check="";

        for (int i=0;i<word.length();i++){
            check+= String.valueOf(word.charAt(i));

            //System.out.println(word.charAt(i));
            if(dic.contains(String.valueOf(check))){
                //System.out.println("exist  "+check);
                if(i==word.length()-1){
                    //System.out.println(dic.indexOf(check));
                    compressed.add(dic.indexOf(check));

                }else {
                    continue;
                }
            }else {
                dic.add(check);
                //System.out.println(dic.indexOf(cutLetter(check)));
                compressed.add(dic.indexOf(cutLetter(check)));
                i-=1;
                check="";
            }
        }

        return compressed;
    }

//    public static String concatinate(String st){
//        return st+st.charAt(0);
//    }
}
