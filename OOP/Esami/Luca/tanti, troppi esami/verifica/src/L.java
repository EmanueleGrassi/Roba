/* obiettivo: verificare comprensione polimorfismo e overloading
    - cosa stampa il seguente programma?
	- perche' ?
	- compilare ed eseguire il programma per verificare la propria risposta

*/
class  C {
     void dim(C c)
     {
    	 System.out.println("C.dim(C) ");
     }
     public void dim(L l)
     {
    	 System.out.println("C.dim(L) ");
     }
     public void dim(K k){
    	 System.out.println("C.dim(K) ");
     }
}

class K extends C {
     public void dim(C c) {
    	System.out.println("K.dim(C) ");
     }
     public void dim(L l) {
		System.out.println("K.dim(L) ");
     }
     public void dim(K k) {
		System.out.println("K.dim(K) ");
     }
}

public class L extends C {
     public void dim(C c) {
		System.out.println("L.dim(C) ");
     }
     public void dim(L l) {
		System.out.println("L.dim(L) ");
     }
     public void dim(K k) {
		System.out.println("L.dim(K) ");
     }

     public static void main(String args[]) {
		C a = new K();
        C b = new L();
        a.dim(b);
        L a1 = new L();
        a1.dim(a);
     }
}
