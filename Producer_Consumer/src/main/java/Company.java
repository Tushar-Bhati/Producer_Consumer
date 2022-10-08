public class Company {

    int n;
    boolean f=false;
    //f:False, chance:Producer
    //f:true, chance:Consumer

    //"synchronized" keyword is used 1) so no other would run other than them. 2)they won't run as parallels

    synchronized public void produce_item(int n){
        if (f){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.n = n;
        f=true;
        notify();
        System.out.println("PRODUCED : "+ this.n);
    }
    synchronized public int consume_item(){
        if(!f){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("CONSUMED : "+ this.n);
        f=false;
        notify();
        return this.n;
    }
}
