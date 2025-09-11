import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cztery2 {
    public static void main(String[] args) throws FileNotFoundException {

        int liczba = 0;
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> prelista = new ArrayList<Integer>();
        Boolean firsttime = true;
        File plik = new File("C:\\Users\\student\\Desktop\\przyklad.txt");
        Scanner sc = new Scanner(plik);
        while (sc.hasNextInt()) {
            liczba = sc.nextInt();

            while(liczba > 1) {
                for(int i = 2; i <= liczba; i++){
                    if(check(liczba, i)){
                        lista.add(i);
                        liczba = liczba/2;
                        continue;
                    }
                }
            }
            if(firsttime){
                prelista.addAll(lista);
                firsttime = false;
            }

            if(lista.size() > prelista.size()){
                prelista.clear();
                prelista.addAll(lista);
            }
            lista.clear();
        }
        System.out.println(prelista);
    }

    public static Boolean check(int liczba, int i){
        if(liczba % i == 0) {
            return true;
        }
        return false;
        }
    }