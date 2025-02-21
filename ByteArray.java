import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArray {
    public static void main(String[] args) {
        String image = "./sample.jpg";
        byte[] imageBytes = image.getBytes();

        try(ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();){
                int byteData;
                while((byteData = bais.read()) != -1){
                    baos.write(byteData);
                }
                System.out.println("Original Image: " + image);
                System.out.println("Image in Byte Array: " + baos.toString());

                if(image.equals(baos.toString())){
                    System.out.println("Both are same");
                }else{
                    System.out.println("Both are different");
                }
            }catch(IOException e){
            e.printStackTrace();
        }
    }
}
