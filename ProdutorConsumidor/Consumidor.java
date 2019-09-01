package ProdutorConsumidor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Consumidor extends Thread{
    private LinkedBlockingQueue<Pedido> fila;
    private Semaphore semBaunilha;
    private Semaphore semChocolate;

    public Consumidor(LinkedBlockingQueue<Pedido> fila, Semaphore semBaunilha, Semaphore semChocolate) {
        this.fila = fila;
        this.semBaunilha=semBaunilha;
        this.semChocolate=semChocolate;
    }

    public void run(){


            while (!fila.isEmpty()){
                Pedido p = null;
                try {
                    p = fila.poll(1, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(p.getSabor()==1){

                    try {
                        semBaunilha.acquire();

                        System.out.println("Usando máquina baunilha");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semBaunilha.release();
                    }

                }else if(p.getSabor()==2){
                    try {
                        semChocolate.acquire();
                        System.out.println("Usando máquina chocolate");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semChocolate.release();
                    }

                }else if(p.getSabor()==3){
                    try {
                        semBaunilha.acquire();
                        semChocolate.acquire();
                        System.out.println("Usando máquina misto");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semBaunilha.release();
                        semChocolate.release();
                    }
                }
            }

    }
}
