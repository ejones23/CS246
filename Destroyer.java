import java.io.File;

public class Destroyer
   extends Thread
{
    private int mFileNumber;

    public Destroyer()
    {
        mFileNumber = 0;
    }

    public File newFileN(int number)
    {
        return new File(String.format("file.%05d", number));
    }

   public void run()
    {
        while (true)
        {
            try
            {
                if (newFileN(mFileNumber).delete())
                {
                    mFileNumber++;
                }
                Thread.sleep(500);
            }
            catch (Exception e)
            {
            }
        }
    }

    public static void main(String[] args)
    {
        new Destroyer().start();
    }
}
