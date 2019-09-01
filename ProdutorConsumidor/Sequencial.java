package ProdutorConsumidor;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Sequencial {
    private LinkedBlockingQueue<Pedido> fila;
    private int quantidade;

    public Sequencial(LinkedBlockingQueue<Pedido> fila, int quantidade) {
        this.fila = fila;
        this.quantidade = quantidade;
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

        while (!fila.isEmpty()){
            Pedido p = fila.poll();
            if(p.getSabor()==1){
                System.out.println("Usando máquina baunilha");
            }else if(p.getSabor()==2){
                System.out.println("Usando máquina chocolate");
            }else if(p.getSabor()==3){
                System.out.println("Usando máquina misto");
            }
        }
    }
}
