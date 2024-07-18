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
  * Esta clase ejemplifica el uso de Thread implementando
  * la interfaz Runnable
  */


package edu.cecar.runnables;

class SimpleHilo implements Runnable {
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        
        System.out.println("Terminado: " + Thread.currentThread().getName());
    }

}


class EjemploHilo {
    public static void main (String[] args) {
        new Thread(new SimpleHilo(),"Sincelejo").start();
        new Thread(new SimpleHilo(),"Monteria").start();
    }
    
}
