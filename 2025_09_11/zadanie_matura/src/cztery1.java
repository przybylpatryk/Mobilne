//public class cztery1 {
//    public static void main(String[] args) throws FileNotFoundException {
//
//        int ilosc = 0;
//        Boolean firstOne = true;
//        String first = "";
//        File plik = new File("C:\\Users\\student\\Desktop\\liczby.txt");
//        Scanner sc = new Scanner(plik);
//        while (sc.hasNextLine()) {
//            char[] liczba = sc.nextLine().toCharArray();
//            if(liczba[0] == liczba[liczba.length-1]){
//                if(firstOne){
//                    firstOne = false;
//                    for(int i = 0; i < liczba.length; i++){
//                        first += liczba[i];
//                    }
//                }
//                ilosc++;
//            }
//        }
//        sc.close();
//        System.out.println(ilosc);
//        System.out.println(first);
//    }
//}
