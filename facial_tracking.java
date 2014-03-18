/* Java Code for Facial Tracking */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FacialTracking {
 
    private static String facial_tracking_cascade = "haarcascade_frontalface_alt.xml";
    private static String eye_tracking_cascade = "haarcascade_eye_tree_eyeglasses.xml";
    private static CascadeClassifier facial_Tracking_cascade_classifier = new CascadeClassifier();
    private static CascadeClassifier eye_tracking_cascade_classifier = new CascadeClassifier();
    private static String displayWindow = "Capturing Facial Detection";
    
    public static void FacialRecognitionFacialTracking (Mat frame)
    {
        Mat fram_gray = new Mat ();
        MatOfRect face = new MatofRect();
        
        Rect[] faceArray = face.toArray();
        
        Imgproc.cvtColor(frame, frame_gray, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.equalizeHist(frame_gray, frame_gray);
        
        //Code used for Facial Detection
        facial_tracking_cascade.detectMultiScale(frame_gray, face, 1.1, 2, 0, new Size(30, 30), new Size() );
        
        for (int i=0; i < faceArray.length; i++)
        {
             Point center_point = new Point(faceArray[i].x + faceArray[i].width * 0.5, faceArray[i].y + faceArray[i].height * 0.5);
             Core.ellipse(frame, center_point, new Size(faceArray[i].width * 0.5, faceArray[i].height * 0.5), 0, 0, 360, new Scalar(255, 0, 255), 4, 8, 0);

             Mat faceROI = frame_gray.submat(faceArray[i]);
             MatOfRect eye = new MatOfRect();

             Rect[] eyeArray = eye.toArray();

            //Detect the eyes for the face
            eye_tracking_cascade_classifier.detectMultiScale(faceROI, eye, 1.1, 2, 0,new Size(30, 30), new Size());

            for (int j = 0; j < eyeArray.length; j++)
            {
            Point new_center_point = new Point(faceArray[i].x + eyeArray[i].x + eyeArray[i].width * 0.5, faceArray[i].y + eyeArray[i].y + eyeArray[i].height * 0.5);
            int radius = (int) Math.round((eyeArray[i].width + eyeArray[i].height) * 0.25);
            Core.circle(frame, new_center_point, radius, new Scalar(255, 0, 0), 4, 8, 0);
            }
         }
            //Display what you currently are tracking
            Highgui.imwrite(displayWindow, frame);
    }


     public static void Main(String args[])
     {
       VideoCapture capture;
       Mat frame = new Mat();

       //Code to load the Cascades
       if (!facial_tracking_cascade_classifier.load(facial_tracking_cascade))
       {
           System.out.print("An error has occurred, please try again!\n");
           return;
       }
       if (!eye_tracking_cascade_classifier.load(eye_tracking_cascade))
       {
           System.out.print("An error has occurred, please try again!\n");
           return;
       }

       //Code to capture from Video
       capture = new VideoCapture(0);
       if(!capture.isOpened())
       {
           System.out.println("Did not connect to camera, unable to attempt facial tracking.");
       }
       else
       {
           capture.retrieve(frame);
           FacialTracking(frame);
           capture.release();
       }
       }
}
