//Blake Hershberger
// CS 110, CWU

// Import Statements
//
// Do not modify these imports; they are needed by the methods that
// you are being given
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class ManipulateImage {

    // Do NOT modify this method; it is being given to you completed.
    // A method that takes as input a filename of type String, and returns an
    // object of type BufferedImage
    public static BufferedImage loadImage(String filename) {
        BufferedImage b1 = null;
        try {
            b1 = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("An error loading the image: " + filename + ": " + e);
        }
        return b1;
    }

    // Do NOT modify this method; it is being given to you completed.
    //
    // The first input paramter to the method is img, which is of type BufferedImage
    //
    // If the second parameter passed to the method is the String "w",
    // then the method changes all pixels in the image to white, and returns the manipulated image
    //
    // If the second parameter passed to the method is the String "b",
    // then the method changes all pixes in the image to black, and returns the manipulated image
    //
    // The method returns a BufferedImage
    public static BufferedImage blackoutWhiteoutImage(BufferedImage img, String action) {

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rGB = img.getRGB(x, y);

                int r, g, b;
                r = 0;
                g = 0;
                b = 0;

                // Sets all rgb values to 255, which generates white
                if (action.equals("w")) {
                    r = 255;
                    g = 255;
                    b = 255;
                } else if (action.equals("b")) {
                    r = 0;
                    g = 0;
                    b = 0;
                }

                // transform back to pixel value and set it
                img.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
        return img;
    }

    // Do NOT modify this method; it is being given to you completed.
    //
    // A method that makes all white pixels in an image ALMOST black, so that they are
    // almost not visible, in essence "hiding" the image
    public static BufferedImage hideImage(BufferedImage img) {

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {

                int rGB = img.getRGB(x, y);

                // if r + g + b > 765
                int r = ((rGB >> 16) & 0xFF);  // red inverted
                int g = ((rGB >> 8) & 0xFF);   // green inverted
                int b = (rGB & 0xFF); 			 // blue inverted

                if (r + g + b > 750) {
                    r = 10;
                    g = 10;
                    b = 10;
                }
                // transform back to pixel value and set it
                img.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
        return img;
    }

    // Do NOT modify this method; it is being given to you completed.
    //
    // A method that receives a BufferedImage, and changes all very dim pixels to white,
    // in essence "unhiding" the image
    public static BufferedImage unHideImage(BufferedImage img) {

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {

                int rGB = img.getRGB(x, y);

                // subtract 250 from each value
                int r = ((rGB >> 16) & 0xFF);  // red inverted
                int g = ((rGB >> 8) & 0xFF);   // green inverted
                int b = (rGB & 0xFF); 			 // blue inverted

                if ((r + g + b) > 20) {
                    r = 255;
                    g = 255;
                    b = 255;
                }

                // transform back to pixel value and set it
                img.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
        return img;
    }

    // Do NOT modify this method; it is being given to you completed.
    //
    // This method make all white pixels black, and all black pixels white, in an image
    public static BufferedImage invertImage(BufferedImage img) {

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rGB = img.getRGB(x, y);

                //ivnerst/swap RGB values
                int r = Math.abs(((rGB >>> 16) & 0xFF) - 255);  // red inverted
                int g = Math.abs(((rGB >>> 8) & 0xFF) - 255); 	// green inverted
                int b = Math.abs((rGB & 0xFF) - 255); 				// blue inverted

                // transform back to pixel value and set it
                img.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
        return img;
    }

    // Do NOT modify this method; it is being given to you completed.
    //
    // A method that saves an image inside of a BufferedImage object to an image file
    // of type jpg
    public static void saveImage(BufferedImage buff, String dest) {

        try {
            File outputfile = new File(dest);
            ImageIO.write(buff, "jpg", outputfile);
        } catch (IOException e) {
            System.out.print("error saving the image: " + dest + ": " + e);
        }
    }

    // A method that prints information about an image; it takes as input the
    // bufferedImage, and the name of the original image
    //
    // You NEED to write the body of this method. To do this, use the three
    // methods of the BufferedImage class (listed below), to find the height,
    // width, and type of the BufferedImage, and invoke them on the input
    // BufferedImage buff, and output the results.
    //
    //  int getHeight() // returns the heighth of the BufferedImage file
    //  int getType()   // returns the type of the image
    //  int getWidth()  // returns the width of the BufferedImage
    //
    // For example, to get the width of the BufferedImage that is passed
    // as an argument to this method, you would write:
    //
    // int imageHeight = buff.getWidth();
    // System.out.println("The image " + imageFilename + " has a height of " + imageHeight + " pixels.");
    public static void printImageInfo(BufferedImage buff, String imageFilename) {
      System.out.println("Image Type: " + buff.getType());
      System.out.println("Image Height: " + buff.getHeight());
      System.out.println("Image Wifth: " + buff.getWidth());
    }

    // The main method/routine
    // You NEED to complete this method
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        while (true) {

            System.out.print("What image do you want to edit? Type q to quit: ");
            String fileName = keyboard.nextLine();

            // COMPLETE IF CONDITIONAL
            //
            // write code that checks if a user has entered the letter q, in
            // which case issue a break statement, which will cause the while
            // loop to terminate and hence the program to end.
            if (fileName.equalsIgnoreCase("q")) {
              break;
            }

            BufferedImage inputImage = loadImage(fileName);
            BufferedImage outputImage = null;

            System.out.print("What action? Invert (v), blackout (b), hide (h), unhide (u), "
                    + "whiteout (w), information (i): ");
            String action = keyboard.nextLine();

            String fileNameOutput = "";
            if (!action.equals("i")) {
                System.out.print("What is the name of the output image? ");
                fileNameOutput = keyboard.nextLine();
            }

            // METHOD INVOCATION SECTION
            if (action.equals("v")) {
                // Assign outputImage to be the return value of the method invertImage; you'll need to
                // provide invertImage the proper paramter that it is expecting. Read the assignment
                // carefully. The solution to this is given in the writeup.
                outputImage = invertImage(inputImage);

                saveImage(outputImage, fileNameOutput);
                System.out.println("The image " + fileName + " has been invereted, and saved to " + fileNameOutput);
            } else if (action.equals("b")) {
                // Assign outputImage to be the return value of the method blackoutWhiteoutImage; you'll need to
                // provide blackoutWhiteoutImage the proper paramters (two of them) that it expects
                outputImage = blackoutWhiteoutImage(inputImage,"b");

                saveImage(outputImage, fileNameOutput);
                System.out.println("The image " + fileName + " has been blackened, and saved to " + fileNameOutput);
            } else if (action.equals("h")) {
                // Assign outputImage to be the return value of the method hideImage; you'll need to
                // provide hideImage the two parameters that it expecta
                outputImage = hideImage(inputImage);

                saveImage(outputImage, fileNameOutput);
                System.out.println("The image " + fileName + " has been 'hidden', and saved to " + fileNameOutput);
            } else if (action.equals("u")) {
                // Assign outputImage to be the return value of the method unHideImage; you'll need to
                // provide unHideImage the parameter that it expects
                outputImage = unHideImage(inputImage);

                saveImage(outputImage, fileNameOutput);
                System.out.println("The image " + fileName + " has been 'un-hidden', and saved to " + fileNameOutput);
            } else if (action.equals("w")) {
                // Assign outputImage to be the return value of the method blackoutWhiteoutImage; you'll need to
                // provide blackoutWhiteoutImage the proper paramters (it expects two of them) that it expects
                outputImage = blackoutWhiteoutImage(inputImage,"w");

                saveImage(outputImage, fileNameOutput);
                System.out.println("The image " + fileName + " has been whited, and saved to " + fileNameOutput);
            } else if (action.equals("i")) {
                // Invoke the method printImageInfo, which expects two paramters, and returns nothing
                printImageInfo(inputImage, fileName);
            } else {
                System.out.println("An incorrect choice has been entered. Try again");
            }
        }
    }
}
