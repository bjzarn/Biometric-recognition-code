/* Java Code for Facial Tracking */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class FacialDetection {
    
    public static void main (String[] args) {
      
        System.loadLibrary(Core.Native_Library_Name);
        System.ou.println("\nRunning FacialDetection");
        
        CascadeClassifier facialDetection = new
        
        CascadeClassifier(FacialDetection.class.getResource("haarcascade_frontalface_alt.xml").gerPath());
        Mat image = Highgui.imread(FacialDetection.class.getResource("image name").getPath());
        
        MatOfRect facialDetections = new MatOfRect();
        
        facialDetection.detectMultiScale(image, facialDetections);
        
        System.out.println(String.format("Detected %s faces", facialDetections.toArray().length));
        
        for (Rect rect : facialDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar (0, 255, 0));
        }(
        
        String filename = "output.png";
        System.out.println(String.format)"Writing %s", filename));
        Highgui.imwrite(filename, image);
        
    }    
  }
