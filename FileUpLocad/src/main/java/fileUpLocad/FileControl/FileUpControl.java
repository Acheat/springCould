package fileUpLocad.FileControl;

import fileUpLocad.entity.HtmlJson;
import fileUpLocad.util.fileSave.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.IOException;

/***
 * 文件上传控制器
 * @author wcd
 * @date  2019 6 30
 */
@RequestMapping("fileUp")
@RestController
public class FileUpControl {

    @Autowired
    private HtmlJson htmlJson;

    @Autowired
    private SaveFile saveFile;


    /***
     * 视频文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upVideo")
    public HtmlJson upVideo(@RequestParam("file")  MultipartFile file) throws IOException {

        String fileName = saveFile.save(file.getInputStream(), file.getOriginalFilename());
        htmlJson.setHtmlBody(fileName);
        return  htmlJson;

    }
}
