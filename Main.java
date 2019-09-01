
import ProdConsFila.ProdutorFila;
import ProdutorConsumidor.Consumidor;
import ProdutorConsumidor.Pedido;
import ProdutorConsumidor.Sequencial;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

        long inicio,fim;

        LinkedBlockingQueue<Pedido> fila= new LinkedBlockingQueue<Pedido>();

        ProdutorFila produtor = new ProdutorFila(fila,10000);
        produtor.run();

        Consumidor c1,c2,c3,c4,c5,c6,c7,c8;
        c1= new Consumidor(fila,sem1,sem2);
        c2= new Consumidor(fila,sem1,sem2);
        c3= new Consumidor(fila,sem1,sem2);
        c4= new Consumidor(fila,sem1,sem2);
        c5= new Consumidor(fila,sem1,sem2);
        c6= new Consumidor(fila,sem1,sem2);
        c7= new Consumidor(fila,sem1,sem2);
        c8= new Consumidor(fila,sem1,sem2);

        inicio = System.currentTimeMillis();
        c1.run();
        c2.run();
        c3.run();
        c4.run();
        c5.run();
        c6.run();
        c7.run();
        c8.run();

        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        c6.join();
        c7.join();
        c8.join();

        fim = System.currentTimeMillis();
        System.out.println( "-----Tempo Threads: "+(fim - inicio) );

    }
}
