import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        cztery1();
        System.out.println();
        cztery2();
        System.out.println();
        cztery22();
    }

    public static void cztery1() throws FileNotFoundException {
        int ilosc = 0;
        Boolean firstOne = true;
        String first = "";
        File plik = new File("C:\\Users\\student\\Desktop\\liczby.txt");
        Scanner sc = new Scanner(plik);
        while (sc.hasNextLine()) {
            char[] liczba = sc.nextLine().toCharArray();
            if (liczba[0] == liczba[liczba.length - 1]) {
                if (firstOne) {
                    firstOne = false;
                    for (int i = 0; i < liczba.length; i++) {
                        first += liczba[i];
                    }
                }
                ilosc++;
            }
        }
        sc.close();
        System.out.println(ilosc);
        System.out.println(first);
    }

    public static void cztery2() throws FileNotFoundException
    {
        File plik = new File("C:\\Users\\student\\Desktop\\przyklad.txt");
        Scanner sc = new Scanner(plik);
        int najwiecejdzielniki = 0;
        int dzielniki = 0;
        int ogliczba = 0;
        int najliczba = 0;
        while (sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            ogliczba = liczba;

            for (int i = 2; liczba > 2; i++)
            {
                if(liczba%i == 0 || liczba == i)
                {
                    dzielniki++;
                    liczba = liczba/i;
                    i = 1;
                }

                if(dzielniki > najwiecejdzielniki)
                {
                    najwiecejdzielniki = dzielniki;
                    najliczba = ogliczba;
                }

                //System.out.println(liczba);
            }
            dzielniki = 0;
        }
        System.out.println(najliczba);
        System.out.println(najwiecejdzielniki);
    }

    public static void cztery22() throws FileNotFoundException
    {
        File plik = new File("C:\\Users\\student\\Desktop\\przyklad.txt");
        Scanner sc = new Scanner(plik);
        int najwiecejdzielniki = 0;
        int dzielniki = 0;
        int ogliczba = 0;
        int najliczba = 0;
        ArrayList roznedzielniki = new ArrayList();
        while (sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            ogliczba = liczba;

            for (int i = 2; liczba > 2; i++)
            {
                if(liczba%i == 0 || liczba == i)
                {
                    if(roznedzielniki.contains(liczba))
                    {
                        break;
                    }
                    roznedzielniki.add(i);
                    dzielniki++;
                    liczba = liczba/i;
                    i = 1;
                }

                if(dzielniki > najwiecejdzielniki)
                {
                    najwiecejdzielniki = dzielniki;
                    najliczba = ogliczba;
                }

                //System.out.println(liczba);
            }
            dzielniki = 0;
            roznedzielniki.clear();
        }
        System.out.println(najliczba);
        System.out.println(najwiecejdzielniki);
    }


}