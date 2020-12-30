package BytLab09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Website implements Subject {

   // public ConcreteObserver observer;
    private List<ConcreteObserver> observers = new ArrayList<>();
    private String address;
    public Date modifiedDate;

    CareTaker careTaker = new CareTaker();


    public Website(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void updateModifiedDate() throws IOException{
        URL address = new URL(this.address);
        URLConnection connect = address.openConnection();
        long time = connect.getLastModified();
        modifiedDate = new Date(time);
        Memento memento = careTaker.getLastMemento();
        if(memento==null || modifiedDate.before(memento.getState()))
            notifyUpdate();
    }

    public Date getModifiedDate(){
        return modifiedDate;
    }


    public Memento saveStateToMemento(Date ModifiedDate,ConcreteObserver observer ) throws IOException{

            Memento nMemento = new Memento(ModifiedDate,observer.toString());

            String nState = nMemento.getObserver()+" "+nMemento.getState().toString();

            String directory=System.getProperty("user.dir");
            String sample=directory+ File.separator+"dates.txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(sample));
            writer.append(nState);
            writer.close();

            return nMemento;


    }

    @Override
    public void add(ConcreteObserver observer) {

        observers.add(observer);
    }

    @Override
    public void remove(ConcreteObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyUpdate() throws IOException {
        for(ConcreteObserver o:observers){

            o.update(getModifiedDate()) ;

            careTaker.add(saveStateToMemento( getModifiedDate(),o));

        }
    }

}
