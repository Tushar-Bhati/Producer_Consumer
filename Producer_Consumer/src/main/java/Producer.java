public class Producer extends Thread{
    Company c;

    //Here, we just made object"c" of class company. So, that the Produce_Item method could be called

    Producer(Company c){
        this.c = c;
    }
    public void run(){
       int i=1;

       while(true){
           this.c.produce_item(i);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           i++;
       }
    }
}
