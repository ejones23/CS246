import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EmailParser
{
   private Scanner scanner;
   private FileWriter writer;
   private PrintWriter printer;
   private File inFile;
   private File outFile;
   
   public EmailParser()
   {
      try
      {
         inFile = new File("EmailsUnparsed.txt");
         scanner = new Scanner(inFile);
         outFile = new File("EmailsParsed.txt");
         writer = new FileWriter(outFile, false);
         printer = new PrintWriter(writer);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public static void main(String args[])
   {
      new EmailParser().run();
   }
   
   public void run()
   {
      String result = "";
      while (scanner.hasNext())
      {
         result += (scanner.next() + "; ");//All for this!
      }
      try
      {
         printer.print(result);
         printer.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}