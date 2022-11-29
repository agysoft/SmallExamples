/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author laszlo.nagy
 */
public class TimerTaskProba {

    private static Timer timer = new Timer();

    public static void main(String...args){
        System.out.println("Start: "+new Date());
           timer.schedule (new MyTask(),1000*10,1000*10);
    }
}
    class MyTask extends TimerTask {
        public void run() {
            System.out.println("hello: "+new Date());
        }
    }    


