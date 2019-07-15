package com.wcd.service.movice;

import com.wcd.entity.Movice;
import com.wcd.exception.MyExecption;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Date;

/***
 * 向外声明，service 可以提供什么样的方法
 * @author wcd
 * @date 2019 7 2
 */
public interface MoviceServiceInterface {

    /***
     * 可以增加一个Movice对象
     * @param movice
     * @param  tid
     * @return
     * @throws IOException
     */
    public boolean addMovice(Movice movice,Integer tid) throws IOException;


    /***
     * 可以通过一系列的，电影的类型，查询出对象，查询出对象
     * @param moviceType
     * @param pageRequest
     * @param order
     * @return
     */
    public Page findMoviceByMoviceType(Integer moviceType, Integer pageRequest,String order);


    /***
     * 查询电影对象，根据当前的对象，并且递归到 子类型,最后一位为排序方式
     * @param moviceTypes
     * @param pageRequest
     * @param order
     * @return
     */
    public Page findMoviceByMoviceTypeAndChildeType(Integer moviceTypes,Integer pageRequest,String order) throws MyExecption;

    /***
     * 超级查询，
     * @param type 那个板块
     * @param from 从那个时间段开始
     * @param to   从那里结束
     * @param ordery  按照那个字段进行排序
     * @return
     */
    public Page findMovice(Integer type, Date from, Date to, String ordery);


    /***
     * 查找对象根据电影的ID
     * @param id
     * @return
     */
    public Movice findMoviceById(Integer id);

    /***
     * 让，指定的视频的 播放数量+1
     * @param mid
     * @return
     */
    public boolean addMovicePlayerNum(Integer mid);

    /***
     * 让 指定的视频，的点赞数量+1
     * @param mid
     * @return
     */
    public boolean addMoviceZanNum(Integer mid);

    /***
     * 跟新一个电影对象
     * @param movice
     * @return
     */
    public boolean updateMovice(Movice movice);


    /***
     * 删除一个电影对象，根据Id
     * @param id
     * @return
     */
    public  boolean delectMoviceById(Integer id);
}
