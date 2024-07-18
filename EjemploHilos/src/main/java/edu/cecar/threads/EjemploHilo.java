/*
 * Clase: SimpleHilo
 *
 * Versi�n: 1.0
 * 
 * 05 - 06- 2000
 *
 * Copyright: Libre
 */
 
 /*
  * Esta clase ejemplifica el uso de Thread heredando de la
  * clase Thread 
  */

package edu.cecar.threads;

class SimpleHilo extends Thread {
    
    public SimpleHilo(String str) {
        super(str);
    }
    
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("Terminado: " + getName());
    }

}


class EjemploHilo {
    public static void main (String[] args) {
        new SimpleHilo("Sincelejo").start();
        new SimpleHilo("Monteria").start();
    }
}
