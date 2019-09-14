package oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.platform.commons.util.StringUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;



public class Oblig1 {

    // En main hvor vi kan teste underveis
    public static void main(String[] args) {



        // Oppgave 4
        System.out.println("\nOppgave4");
        int[] values4 = {-4, -1, 3, 0, 2, -3, -2, 4, 1};
        System.out.println("{-4, -1, 3, 0, 2, -3, -2, 4, 1}");
        delsortering(values4);
        System.out.println(Arrays.toString(values4));

        int[] b = {9, 5, 3,2, 1, 7};
        delsortering(b);
        System.out.println(Arrays.toString(b));


        //Oppgave 10
        //System.out.println(Oblig1.inneholdt("ØÅÅØ", "ØØÅØØ"));

    }

    public static void quickSort(int a[], int fra, int til) {
        if (fra < til) {
            int partitionIndex = partition(a, fra, til);

            quickSort(a, fra, partitionIndex-1);
            quickSort(a, partitionIndex+1, til);
        }
    }

    private static int partition(int a[], int fra, int til) {
        int pivot = a[til];
        int i = (fra-1);

        for (int j = fra; j < til; j++) {
            if (a[j] <= pivot) {
                i++;

                int swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;
            }
        }

        int swapTemp = a[i+1];
        a[i+1] = a[til];
        a[til] = swapTemp;

        return i+1;
    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) throws NoSuchElementException {

        // Skjekker om tabellen er tom
        if (a.length < 1){
            throw new NoSuchElementException("Tabellen er tom");
        }
        // Kjører gjennom arrayet
        for (int i= 1; i < a.length; i++){

            if (a[i-1]>a[i]){  // Skjekker to og to tall om det første er størst

                int storst = a[i-1]; // Hjelpevariabel for aa huske a[i-1] som blir overskrevet i folgende linje
                a[i-1] = a[i];
                a[i] = storst;
            }
        }
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
                antall++; // Eneste forskjellen fra forrige metode er denne variabelen som teller antall ombyttinger.
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

        for (int i = 0; i<a.length; i++){

            boolean unik = true; //

            for (int j = i+1; j < a.length; j++) {

                if (a[i] == a[j]) {     // Skjekker om tallet forekommer senere i listen.
                    unik = false;       // Setter false om tallet forekommer.
                    break;              // hopper ut ettersom unodvendig aa fortsette
                }
            }

            if (unik){  // unik vil kun vaere true for siste gang et tall forekommer.
                antall++;  // Teller kun tall siste gang det forekommer.
            }
        }
        return antall;
    }

    ///// Oppgave 4 //////////////////////////////////////  {1,4,2,6,5,8,3,7,9}
    //                                                      {1,2,3,4,5,6,7,8,9}




    public static void delsortering(int[] a) {

        if (a.length == 0) {return;}

        int antallPar = 0;
        int antallOdd = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i]%2==0){  antallPar++;}
            else {antallOdd++;}
        }

        int indexPar = 0;
        int indexOdd = 0;
        int minne;
        boolean nyPlass = false;

        for (int i = 0; i < a.length; i++) {        // Kjorer gjennom hele arrayet.

            if (a[i]%2!=0) {                        // Dersom tallet er et oddetall.

                minne = a[i];
                a[i] = a[indexOdd];

                /*for (int j = 0; j <= indexOdd; j++) {     // Ny loop for aa sette inn nye oddetall i sortert orden. (fra begynnelse til tallet vi flytta.)

                    nyPlass = false;

                    if (a[j]%2==0) {break;}

                    if (minne<a[j]){                        // Dersom oddetallet vi fant er mindre enn oddetallet i a[j].

                        nyPlass = true;

                        for (int k = indexOdd; k>j; k--) { // kanskje > eller =
                            a[k] = a[k-1];
                            if (k == j+1) {
                                a[j] = minne;
                            }
                        }
                        break;
                    }
                }*/
                if (!nyPlass) {a[indexOdd] = minne;}
                indexOdd++;
            }

        }

        quickSort(a,0,antallOdd-1);
        quickSort(a,antallOdd,a.length-1);

        /*
        int minste = a[indexPar];
        int temp = antallOdd;


        for (int i = antallOdd; i < a.length; i++) {

            for (int j = antallOdd; j < a.length-1; j++) {

                if (a[j+1]<a[j]) {
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }*/





        //Må ha litt hjelp på denne.
        //int tempHolder;
        //boolean jobb = false;
        //for (int i = 1; i < a.length; i++) {

            /*Går gjennom listen og utforer sorteringsoperasjoner der det trengs. Hvis ingen operasjoner utfores
            under en hel gjennomgang, er jobb false og loopen avsluttes. */

            /*if(((a[i - 1] % 2 == 0 || a[i-1]==0) && (a[i] % 2 != 0))){
                tempHolder = a[i - 1];
                a[i - 1] = a[i];
                a[i] = tempHolder;
                jobb = true;
            } else if (a[i-1]>a[i] && (Math.abs(a[i-1]%2) == Math.abs(a[i]%2))) {
                tempHolder = a[i - 1];
                a[i - 1] = a[i];
                a[i] = tempHolder;
                jobb = true;
            }
            if(i == a.length-1 && jobb){i = 0; jobb = false;}
        }
        //throw new NotImplementedException(); */
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        char[] b = Arrays.copyOf(a,a.length); // dupliserer listen a for aa lagre alle orginale verdier og posisjoner.

        if (a.length>0) {
            for (int i = 1; i < a.length; i++) {

                a[i] = b[i - 1]; // roterer alle verdiene i listen utenom den forste
            }
            a[0] = b[b.length - 1]; // roterer den forste verdien
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

        char[] b = Arrays.copyOf(a, a.length); // dupliserer listen a for aa lagre alle orginale verdier og posisjoner.
        if (a.length > 0) {
            int roter = 0;

            /*Regner ut hvordan elementene i listen må flyttes for å få riktig
            rotasjon i de spesialtilfellene der k<0 eller k>a.length*/

            if(k<0 || k>a.length) {
                for (int i = 0; i <= Math.abs(k); i++) {
                    if (((k - i) % a.length) == 0) {
                        roter = i;
                        break;
                    }
                }
            }else{roter = k;}

            //Flytter elementene i henhold til parameter.

            for (int i = 0; i < a.length; i++) {
                if (i - roter < 0) {
                    a[i] = b[(a.length) - (roter - i)];
                } else {
                    a[i] = b[i - roter];
                }
            }
            //throw new NotImplementedException();
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        StringBuilder utskrift = new StringBuilder();
        int storst = Math.max(s.length(), t.length());      // Finner storste lengden mellom s og t

        for (int i = 0; i < storst ; i++) {                 // for-lokke som tar annen hver bokstav fra s og t helt til storste er ferdig
            if (s.length()>i){
                utskrift.append(s.charAt(i));
            }
            if (t.length()>i){
                utskrift.append(t.charAt(i));
            }
        }

        return utskrift.toString();
    }

    /// 7b)
    public static String flett(String... s) {

        int max;
        int maxL = 0;
        StringBuilder utskrift = new StringBuilder();

        for (String streng : s){            // Finner lengden paa storste element i s
            max = streng.length();

            if (max > maxL){
                maxL = max;
            }
        }

        for (int i = 0; i < maxL; i++) {

            for (String streng : s) {       // looper gjennom hvert element i s

                if (streng.length()>i){     // legger til en og en bokstav fra hvert element
                    utskrift.append(streng.charAt(i));
                }
            }
        }
        return utskrift.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int tempHold;
        int tempHoldIndex;
        int[] index = new int[a.length];
        int[] help = Arrays.copyOf(a, a.length);

        //populerer index med nåværende indeksposisjoner
        for(int i = 0; i<a.length; i++){index[i] = i;}

        //sorterer help, og utfører de samme operasjonene på index
        for(int i = 1; i<a.length ; i++){
            if(help[i-1]>help[i]){
                tempHold = help[i-1];
                tempHoldIndex = index[i-1];

                help[i-1] = help[i];
                index[i-1] = index[i];

                help[i] = tempHold;
                index[i] = tempHoldIndex;
                i = 0; //Hvis en operasjon utføres, starter loopen paa nytt.
            }
        }
        return index;
        //throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        int n = a.length;     // tabellens lengde
        if (n < 3) throw      // maa ha minst tre verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til minste verdi
        int nm = 1;     // nm er posisjonen til nest minste verdi
        int nnm = 2;    // nnm er posisjonen til tredje minste verdi

        if ((a[2] < a[1]) && (a[0] < a[2])) { nm = 2; nnm = 1;}
        else if ((a[2] < a[0]) && (a[1] < a[2])) { m = 1; nm = 2; nnm = 0;}
        else if ((a[1] < a[0]) && (a[2] < a[1])) { m = 2; nm = 1; nnm = 0;}
        else if ((a[0] < a[1]) && (a[2] < a[0])) { m = 2; nm = 0; nnm = 1;}
        else if ((a[0] < a[2]) && (a[1] < a[0])) { m = 1; nm = 0; nnm = 2;}

        int minverdi = a[m];                // minste verdi
        int nestminverdi = a[nm];           // nest minste verdi
        int tredjminverdi = a[nnm];         // tredje minste verdi

        for (int i = 3; i < n; i++)
        {
            if (a[i] < tredjminverdi) {

                if (a[i] < nestminverdi) {

                    if (a[i] < minverdi) {
                        nnm = nm;
                        nm = m;
                        tredjminverdi = nestminverdi;   // ny tredje minst
                        nestminverdi = minverdi;        // ny nest minst

                        m = i;
                        minverdi = a[m];                // ny minst
                    }
                    else
                    {
                        nnm = nm;
                        nm = i;
                        tredjminverdi = nestminverdi;   // ny tredje minst
                        nestminverdi = a[nm];           // ny nest minst
                    }
                }
                else{
                    nnm = i;
                    tredjminverdi = a[nnm];             // ny tredje minst
                }

            }
        } // for

        return new int[] {m,nm,nnm};    // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2

    } // tredjeMin

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        return Character.getNumericValue(bokstav);
    }

    public static boolean inneholdt(String a, String b) {
        return true;/*
        char gjeldendeBokstav;
        int aAntall;
        int bAntall;
        if(b.isEmpty() && !a.isEmpty()){return false;}
        for(int i = 0; i < a.length(); i++){
            aAntall = 0;
            bAntall = 0;
            gjeldendeBokstav = a.charAt(i);
            for(int j = 0; j<a.length(); j++){
                if(gjeldendeBokstav == a.charAt(j)){aAntall ++;}
            }
            for(int j = 0; j<b.length(); j++){
                if(gjeldendeBokstav == b.charAt(j)){
                     bAntall++;
                }
            }
            if(bAntall<aAntall){return false;}

        }
        return true;*/
    }

}  // Oblig1
