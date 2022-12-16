/*
Yakup ADIYAMAN
02215076073

Not; Kullanıcıdan virgülle ayrılmış string değeri alınıp
virgüllere bağlı olarak string dizisine konulmuştur.
Sonrasında integer türünde farklı bir dizi oluşturuldu
Dizi min heap mi değil mi kontrol edildi
değilse min heape çevrilerek ekrana yazdırıldı
*/
package heap;
import java.util.*;

public class Heap {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);  
        System.out.println("Örnek: 5,3,11,19,7,1");
        System.out.print("Girdinizi örnekteki gibi giriniz: ");  
        String numbers = sc.nextLine();       

        
        String[] arrOfNumbers = numbers.split(",");
        // "1, 2, 3, 4"
        // [1, 2, 3, 4]
        int arraySize = arrOfNumbers.length;
        int[] array = new int[arraySize];
        
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(arrOfNumbers[i].trim());  
        }
        
        boolean isMinHeap = true;
        for (int j = 0; j < arraySize/2; j++) {
            if (array[j] > array[(2*j) + 1]) {
                isMinHeap = false;
                break;
            }
            if (array[j] > array[(2*j) + 2]) {
                isMinHeap = false;
                break;
            }
        }
        
        if (isMinHeap) {
            System.out.println("Evet, min heaptir.");
        } else {
            System.out.println("Hayır, min heap değildir.");
            
            minHeap h = new minHeap(arraySize);
            
            for (int k = 0; k < arraySize; k++) {
                h.ekle(array[k]);
            }
            System.out.println("Dizinizin min heap hali şu şekildedir: ");
            h.print();
        }
    }
}
