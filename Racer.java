import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.io.File;
import java.io.FileFilter;

public class Racer
   implements ActionListener
{
   private FileToucher mMoniter;
   
   public Racer()
   {
      mMoniter = new OutputtingFileToucher();
      mMoniter.setArgs(new String[] {"."});
      mMoniter.setFileFilter(
         new FileFilter()
         {
            public boolean accept(File pFile)
            {
               return (pFile.getName().startsWith("file."));
            }
         });
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      mMoniter.run();
      System.out.println("--------------------");
   }
   
   public static void main(String args[])
   {
      new Racer().run();
   }
   
   public void run()
   {
      Thread create = new Creator();
      create.start();
      try
      {
         Thread.sleep(2000);//How come I can call this here?
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      Thread dest = new Destroyer();
      dest.start();
      Timer timer = new Timer(1000, this);
      timer.start();
   }
}