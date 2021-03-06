package io.modernfamily;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*************************************************
 * Created by sameenislam on 23/07/2016.         *
 * Uses library: http://webcam-capture.sarxos.pl *
 * to store image from webcam                  *
 *************************************************/

public class CaptureFacial {

    public static void store(String filename) throws IOException {
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();
//        ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png")); // (DEPRECATED)

        // get default webcam and open it
        Webcam webcam = Webcam.getDefault();
        webcam.open();

        // get image
        BufferedImage image = webcam.getImage();

        // save image to PNG file
        ImageIO.write(image, "PNG", new File(filename));
    }

    public static BufferedImage open(String filename) {

        // Load image file
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("[System exception] could not open image!");
        }
        return img;
    }


    public static void main(String[] args) {
        try {
            store("face.png"); System.out.println("[Success] Image saved as 'face.png' in root dir.");}
        catch (IOException e) {System.out.println("[System exception] Failed to store image from webcam!");}
    }

}
