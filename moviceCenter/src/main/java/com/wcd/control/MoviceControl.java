package com.wcd.control;


import com.wcd.entity.HtmlJson;
import com.wcd.entity.Movice;
import com.wcd.service.movice.MoviceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController()
@RequestMapping("/movice")
public class MoviceControl {

    @Autowired
    MoviceServiceInterface moviceService;

    @Autowired
    HtmlJson htmlJson;

    /**这是添加一个视频*/
    @RequestMapping("addMovice")
   public HtmlJson addMovice(@RequestBody Movice movice,@RequestParam("tid") Integer tid) throws IOException {

       moviceService.addMovice(movice,tid);
       return  htmlJson;

   }

    /***
     * 根据 视频的分配查找视频
     * @param moviceType
     * @param page 其实页
     * @return
     */
    @RequestMapping("findMoviceByType")
   public HtmlJson findMoviceByType( Integer moviceType,Integer page,String order){

       Page<Movice> datePage = moviceService.findMoviceByMoviceType(moviceType,page, order);

       htmlJson.setPageSize(datePage.getTotalPages());
       htmlJson.setHtmlBody(datePage.getContent());
       htmlJson.setTotoleSize(datePage.getTotalElements());

       return htmlJson;
   }

   /**高级查询
    * @param form 从什么时间开始
    * @param to    从什么时间结束
    * @param type  是那个板块的
    * @param ordery  怎么排序
    *
    * */
   @RequestMapping("findMovices")
   public HtmlJson findMovices(Integer type, Date form,Date to,String ordery){

       Page<Movice> datePage = moviceService.findMovice(type,form,to, ordery);
       htmlJson.setPageSize(datePage.getTotalPages());
       htmlJson.setHtmlBody(datePage.getContent());
       htmlJson.setTotoleSize(datePage.getTotalElements());
       return htmlJson;
   }


    /***
     * 增加视频的播放次数,没调用一次，视频的播放增加一
     * @param mid 视频的播放Id
     * @return
     */
    @RequestMapping("addMoviePlayerNum")
    public HtmlJson addMovicePlayerNum(Integer mid){
        moviceService.addMovicePlayerNum(mid);
        return htmlJson;
    }

    /***
     * 增加视频的点赞次数
     * @param mid
     * @return
     */
    @RequestMapping("addMovieZanNum")
    public HtmlJson addMoviceZanNum(Integer mid){
        moviceService.addMoviceZanNum(mid);
        return htmlJson;
    }



    /***
     * 根据视频的ID 去查找ID
     * @param id
     * @return
     */
    @RequestMapping("findMoviceById")
   public HtmlJson findMoviceById(Integer id){
       Movice movice =  moviceService.findMoviceById(id);
       htmlJson.setHtmlBody(movice);
       return  htmlJson;
   }


}
