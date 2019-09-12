package oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;



public class Oblig1 {

    // En main hvor vi kan teste underveis
    public static void main(String[] args) {

        // Oppgave 1
        int[] values = {9, 17, 11, 4, 8};
        //System.out.println(maks(values));
        System.out.println(ombyttinger(values));
        System.out.println(Arrays.toString(values));


    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        for (int i= 1; i < a.length; i++){

            if (a[i-1]>a[i]){

                int storst = a[i-1];
                a[i-1] = a[i];
                a[i] = storst;
            }

        }


        //throw new NotImplementedException();

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        //throw new NotImplementedException();
        int antall = 0;

        for (int i= 1; i < a.length; i++){

            if (a[i-1]>a[i]){

                int storst = a[i-1];
                a[i-1] = a[i];
                a[i] = storst;
                antall++;
            }

        }
        return antall;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
