package com.wcd.control;

import com.wcd.entity.HtmlJson;
import com.wcd.entity.MoviceType;
import com.wcd.service.movicetype.MoviceTypeServiceInfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @author wcd
 * @date  2019 7 2
 */
@RestController
@RequestMapping("moviceType")
public class MoviceTypeControl {

    @Autowired
    HtmlJson htmlJson;


    @Autowired
    MoviceTypeServiceInfer moviceTypeService;

    @RequestMapping("addMoviceType")
    public HtmlJson addMoviceType(MoviceType moviceType){
        moviceTypeService.addMoviceType(moviceType);
        return htmlJson;
    }



    @RequestMapping("findMoviceTimeById")
    public HtmlJson findMoviceTimeById(Integer id){

        MoviceType moviceType = moviceTypeService.findMoviceTypesById(id);
        htmlJson.setHtmlBody(moviceType);
        return  htmlJson;
    }



    @RequestMapping("findRootMoviceType")
    public HtmlJson findRootMoviceType(){

        List<MoviceType> moviceTypeList = moviceTypeService.findAllRootMoviceType();
        htmlJson.setHtmlBody(moviceTypeList);
        return  htmlJson;

    }

    @RequestMapping("findMoviceAndChilelByUrl")
    public HtmlJson findMoviceTypeAndChiledByUrlName(String urlName){
        List<MoviceType> moviceTypeList = moviceTypeService.findMoviceTypeAndChild(urlName);
        htmlJson.setHtmlBody(moviceTypeList);
        return  htmlJson;

    }
    @RequestMapping("findMoviceByUrl")
    public HtmlJson findMoviceTypeByUrl(String urlName){
        List<MoviceType> moviceTypeList = moviceTypeService.  findMoviceTypeByUrl(urlName);
        htmlJson.setHtmlBody(moviceTypeList);
        return  htmlJson;

    }




    @RequestMapping("delectMoviceType")
   public HtmlJson delectMoviceType(Integer id){
       moviceTypeService.delectMoviceType(id);
       return htmlJson;
   }

}
