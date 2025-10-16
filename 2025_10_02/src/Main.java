import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int ilosc = 0;
        int punkty = 0;
        int rand = 0;
        Scanner sc = new Scanner(System.in);
        while (ilosc < 3 || ilosc > 10)
        {
            System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
            ilosc = sc.nextInt();
            sc.nextLine();
        }
        punkt2(ilosc);
    }
    public static void punkt2(int ilosc)
    {
        int[] tab = new int[ilosc];
        int rand = 0;
        int punkty = 0;
        for (int i = 0; i < ilosc; i++)
        {
            rand = ((int)(Math.random() * 6) + 1);
            System.out.println("Kostka " + (int)(i+1) + ": " + rand);
            tab[i] = rand;
        }
        punkty = liczpunkty(tab, tab);
        System.out.println("Liczba uzyskanych punktów: " + punkty);

        Scanner sc = new Scanner(System.in);
        System.out.println("Jeszcze raz? (t/n)");
        String wybor = sc.nextLine();
        switch (wybor)
        {
            case "t":
                punkt2(ilosc);
                break;
            case "n":
                return;
        }
    }

    public static int liczpunkty(int[] tab, int[] tabH)
    {
        int punkty = 0;
        for (int i = 0; i < tab.length; i++)
        {
            for (int j = 0; j < tabH.length; j++)
            {
                if(i != j && tab[i] == tabH[j])
                {
                    punkty += tab[i];
                }
            }
        }
        return punkty;
    }
}
