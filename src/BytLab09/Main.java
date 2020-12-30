package BytLab09;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



/*
try {

    URL address = new URL("http://www.pja.edu.pl/");
    URLConnection connect = address.openConnection();
    long time = connect.getLastModified();
    Date modifiedDate = new Date(time);
    System.out.println(modifiedDate.toString());

}
catch (IOException e){

    System.out.println(e);
}
*/
/*
       // Website web = new Website("http://www.pja.edu.pl/");
        Website web = new Website("https://sinoptik.pl/");

     //   ConcreteObserver observer = new ConcreteObserver(web);

       // CareTaker careTaker = new CareTaker();
        while(true){
            web.updateModifiedDate();
       //     careTaker.add(web.saveStateToMemento());
            // Memento newMemento = new Memento(web.modifiedDate);
             System.out.println(web.getModifiedState());

            System.out.println(web.getModifiedDate());



            Thread.sleep(2000);

        }
*/


        ConcreteObserver o1 = new ConcreteObserver("observer1");
        ConcreteObserver o2 = new ConcreteObserver("observer2");
        Website w = new Website("https://sinoptik.pl/");
        w.add(o1);
        w.add(o2);
        w.updateModifiedDate();



       // w.getModifiedState();
     //   w.notifyUpdate();   //s1 and s2 will receive the update



        //w.notifyUpdate();

    }


}
