import ProdutorConsumidor.Pedido;
import ProdutorConsumidor.Sequencial;

import java.util.concurrent.LinkedBlockingQueue;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        long inicio,fim;

        LinkedBlockingQueue<Pedido> fila= new LinkedBlockingQueue<Pedido>();
        inicio = System.currentTimeMillis();
        Sequencial sequencial = new Sequencial(fila,10000);
        sequencial.run();
        fim = System.currentTimeMillis();
        System.out.println( "-----Tempo sequencial: "+(fim - inicio) );

    }
}
