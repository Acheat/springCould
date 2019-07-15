package fileUpLocad.util.fileSave;



import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class SaveFileLocal implements SaveFile {

    @Value("${fileUpUrl}")
    private  String fileUrl;

    @Override
    public String save(InputStream inputStream,String oldFileName) throws IOException {

        String fileType = oldFileName.substring(oldFileName.lastIndexOf("."),oldFileName.length());
        //生成新的名字
         String fileName = fileUrl + "/"+System.currentTimeMillis()+fileType;

         File file = new File(fileName);
        //将当前的文件，拷贝到新的地方
        FileUtils.copyInputStreamToFile(inputStream,file);

        return fileName;
    }
}
