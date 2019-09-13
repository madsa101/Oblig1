package oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import com.sun.xml.internal.bind.v2.TODO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.security.auth.login.AccountExpiredException;
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
        // Oppgave 2
        int[] values2 = {1, 2, 3, 4, 5};
        System.out.println(antallUlikeSortert(values2));

        // Oppgave 4
        int[] values4 = {1,4,3,7,2};
        delsortering(values4);
        System.out.println(Arrays.toString(values4));

        // Oppgave 5
        //char[] tabell = {'A','B','C','D','E','F','G','H','i','J'};
        char[] tabell = {};
        rotasjon(tabell);
        System.out.println(Arrays.toString(tabell));


    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) throws NoSuchElementException {


        // FIXME: 13/09/2019
        for (int i= 1; i < a.length; i++){
            if (a.length < 1){
                throw new NoSuchElementException("Fayl");

            }

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
    public static int antallUlikeSortert(int[] a) throws IllegalStateException {
        int counter;
        if(a.length==0){counter = 0;}
        else if (a.length==1){counter = 1;}
        else {
            counter = 1;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < a[i-1]) {
                    throw new IllegalStateException("Listen er ikke sortert stigende.");
                }
                if (a[i] != a[i - 1]) {
                    counter += 1;
                }
            }
        }
        //throw new NotImplementedException();
        return counter;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        int antall = 0;

        for (int i = 0; i<100; i++){

        }

        //throw new NotImplementedException();
        return 0;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int tempHolder;
        for(int i = 1; i<a.length; i++){
            if((a[i-1]>a[i] || (a[i-1]%2==0 && a[i]%2!=0))){
                tempHolder = a[i - 1];
                a[i - 1] = a[i];
                a[i] = tempHolder;
            }
        }
        //throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        char[] b = Arrays.copyOf(a,a.length);

        if (a.length>0) {
            for (int i = 1; i < a.length; i++) {

                b[i] = a[i - 1];

            }
            b[0] = a[a.length - 1];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];

        }

        /*char lager1 = a[1];
        char lager2 = a[2];
        a[1] = a[0];

        for (int i = 2; i < a.length; i++){
            a[i] = lager1;
            lager1 = lager2;
            lager2 = a[i+1];
        }
        a[0] =
        */



        /*for (int i = 1; i<a.length; i++){

            a[i-1]= a[i];
        }*/



        //throw new NotImplementedException();
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
