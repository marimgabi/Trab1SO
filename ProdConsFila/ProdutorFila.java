package ProdConsFila;

import ProdutorConsumidor.Pedido;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdutorFila{

    private LinkedBlockingQueue<Pedido> fila;
    private int quantidade;

    public ProdutorFila(LinkedBlockingQueue<Pedido> fila, int quantidade) {
        this.fila = fila;
        this.quantidade=quantidade;
    }

    public void run(){
        Random gerador = new Random();

        for(int i=0;i<quantidade;i++){
            try {
                fila.put(new Pedido(gerador.nextInt(3)+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
