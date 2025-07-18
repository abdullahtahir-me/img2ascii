import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Img2ascii {
    File f = null;
    BufferedImage img = null;
    public void imageReader(String filepath){
        try{
            f = new File(filepath);
            System.out.println("Trying to load: " + f.getAbsolutePath()); // Add this!
            img = ImageIO.read(f);
            if (img==null) System.out.println("ImageIO.read() returned null — file not readable or not found.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void printGray(int grey){
        if(grey<25) System.out.print("@");
        else if(grey<50) System.out.print("#");
        else if(grey<75) System.out.print("s");
        else if(grey<100) System.out.print("%");
        else if(grey<125) System.out.print("?");
        else if(grey<150) System.out.print("*");
        else if(grey<175) System.out.print("+");
        else if(grey<200) System.out.print(";");
        else if(grey<225) System.out.print(";");
        else if(grey<255) System.out.print(".");
    }
    public void imgDisplay(){
        int rgb;
        int red;
        int blue;
        int green;
        int alpha;
        int grey;
        int width=img.getWidth();
        int height=img.getHeight();

        for (int i=0;i<height;i+=3){
            for (int j = 0; j < width; j++) {
                rgb=img.getRGB(j,i);
                blue=rgb & 0xff;
                green=(rgb>>8) & 0xff;
                red= (rgb>>16) & 0xff;
                alpha= (rgb>>24) & 0xff;
                grey= (red+green+blue)/3;
                printGray(grey);
            }
            System.out.println("");
        }
    }
}
