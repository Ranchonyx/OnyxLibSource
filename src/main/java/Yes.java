import com.onyxlib.ImageProcessing.OpenCV_Modules.VideoWorker.VideoWorker;
import java.io.File;
import java.io.IOException;

class Yes {
    public static void main(String[] args) throws IOException {

        VideoWorker vw = new VideoWorker();

        vw.extractFrames(new File("D:\\meh\\video\\vid.mkv"));
        vw.writeFrames("D:\\meh\\video\\", "frameCap");

    }
}