package fileupload.util.filesave;

import java.io.IOException;
import java.io.InputStream;

/***
 * 文件保存，策略的接口
 */
public interface SaveFile {

    /***
     * 文件保存策略，根据保存的策略，只有文件的 二进制流
     * @param inputStream
     * @return
     */
    public  String  save(InputStream inputStream,String oldFileName) throws IOException;
}
