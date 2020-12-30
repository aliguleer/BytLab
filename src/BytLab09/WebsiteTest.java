package BytLab09;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import static org.mockito.Mockito.*;
public class WebsiteTest {

    @Mock
    Website web;
    Memento memento;
    ConcreteObserver observer;
    Subject subject;
    Observer observerz;
    URL address;
    Date modfiedDate =new Date(System.currentTimeMillis());
    Website ws;

    @Before
    public void before() {
        web = mock(Website.class);
        memento = mock(Memento.class);
        observer = mock(ConcreteObserver.class);

    }
    public void setup(){
        MockitoAnnotations.initMocks(this);


    }


    @Test
    public void Test() throws IOException {
        ConcreteObserver o1 = new ConcreteObserver("observer1");
        ConcreteObserver o2 = new ConcreteObserver("observer2");
        ws = new Website("http://www.pja.edu.pl/");
        ws.add(o1);
        ws.add(o2);
        ws.updateModifiedDate();
        System.out.println(ws.getAddress());

        Assert.assertEquals(ws.getAddress(),  "http://www.pja.edu.pl/");

        }


    @Test
    public void TestMemento() throws IOException {

        when(memento.getObserver()).thenReturn("observer1");

        Assert.assertEquals(memento.getObserver(),  "observer1");

        when(memento.getState()).thenReturn(modfiedDate);

        Assert.assertEquals(memento.getState(), modfiedDate);

    }

    @Test
    public void TestsaveStateToMemento() throws IOException {


        when(web.saveStateToMemento(modfiedDate,observer)).thenReturn(memento);

        Assert.assertEquals( memento.getObserver(),  null);

        Assert.assertEquals( memento.getObserver(),  null);

    }

    @Test
    public void TestUpdateModifiedDate() throws IOException {
        doAnswer((i) -> {

            web.modifiedDate = new Date(System.currentTimeMillis());

            verify(web).modifiedDate.equals(System.currentTimeMillis());
            return null;
        }).when(web).updateModifiedDate();
    }





}
