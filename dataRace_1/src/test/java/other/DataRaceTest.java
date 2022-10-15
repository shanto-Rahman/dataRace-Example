package dataRace;

import org.junit.Test;

public class DataRaceTest {

    boolean buggy;
    private DataRace ti;
    public void DataRaceTest(){
	ti = new DataRace();
	buggy = false;
        System.out.println("Hello ");
    }


     public void run() {
	int threadsNum = 3;
	 // Threads to run the buggy method
	Thread[] ts = new Thread[threadsNum];
	for (int i = 0; i < threadsNum; i++) {
	    ts[i] = new TestThread();
	    ts[i].start();
	}	     
        for (int i = 0; i < threadsNum; i++) {
	     try {
		 ts[i].join();
	     } catch (InterruptedException e) {
		 e.printStackTrace();
	     }
     }
     }

    private class TestThread extends Thread {
           public void run() {
	       String[] rt = ti.Request3();
		   // Check if elements returned by buggy method is null.
		   // It has probability to be null at buggy version.
	       for (String s : rt) {
		   if (s == null) {
			 buggy = true;
			 System.out.println("buggy ..........");
		        //buggy = true;
			throw new NullPointerException();					
		   }
	        }
	   }
    }
						    


    @Test
    public void test1(){
	 DataRaceTest test = new  DataRaceTest(); 
         test.run();
	 if(buggy){
		 System.out.println("Bug Found .. ");
	 }
    }
}
