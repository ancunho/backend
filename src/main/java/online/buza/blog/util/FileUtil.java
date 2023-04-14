package online.buza.blog.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        InputStream is = multipartFile.getInputStream();
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = is.read(buffer, 0, buffer.length)) != -1) {
            fos.write(buffer, 0, read);
        }
        fos.flush();
        fos.close();
        return file;
    }

}
