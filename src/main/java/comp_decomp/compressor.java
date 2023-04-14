/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author shlok
 */
public class compressor {
    
    public static void method(File file) throws IOException{
        String fileDirectory=file.getParent();
        //this will help in reading the data
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/compressedFile.gz");
        // will help me writing out the compressed data
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        
        // with the help of buffer we will read the data and then
        // write it inside my output file which is gzip(here i'm going to write the compressed data
        byte[] buffer=new byte[1024];
        int len;
        
        // fis.read-> reads upto buffer.length bytes of data
        // from InputStream into anarray of bytes
        while((len=fis.read(buffer))!=-1){
            // buffer-> the data,  0->offset data, len-> number of bytes to write
            // so it will start from starting index and it will go till the ending index till the 
            // write will helps us to write down len bytes
            // from the buffer arrray starting with the offset vale to the output stream
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        File path=new File("/Users/shlok/Downloads/compressor/compressordecompressor/TestFile");
        method(path);
    }
    
}
