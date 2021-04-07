package pratice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GetImage {


    public static void main(String[] args){
 
        GetImage getImage = new GetImage();
 
        String strUrl = "https://books.google.co.kr/books/publisher/content?id=2EHoDwAAQBAJ&hl=ko&pg=PA17&img=1&zoom=3&sig=ACfU3U0fURghFfG-J4b8JCZfinfgfUhYyw&w=1280"; //불러올 URL
 
        try {
 
            getImage.saveImage(strUrl, "filename2.png");
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        }
 
    }
 
    private void saveImage(String strUrl, String filename) throws IOException {
 
        URL url = null;
        InputStream in = null;
        OutputStream out = null;
 
        try {
 
            url = new URL(strUrl);
 
            in = url.openStream();
 
            out = new FileOutputStream("C:\\Users\\USER\\Desktop\\local\\" + filename); //저장경로
 
            while(true){
                //이미지를 읽어온다.
                int data = in.read();
                if(data == -1){
                    break;
                }
                //이미지를 쓴다.
                out.write(data);
 
            }
 
            in.close();
            out.close();
 
        } catch (Exception e) {
 
            e.printStackTrace();
 
        }finally{
 
            if(in != null){in.close();}
            if(out != null){out.close();}
 
        }
    }
}
