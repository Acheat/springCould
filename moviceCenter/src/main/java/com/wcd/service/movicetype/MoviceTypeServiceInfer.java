package com.wcd.service.movicetype;

import com.wcd.entity.MoviceType;

import java.util.List;

/***
 * 向上层提供服务的服务类，
 * 电影类的操作，无非是增删改查，
 * 唯一的特点，在查的地方多了点东西
 */
public interface MoviceTypeServiceInfer {

    /***
     * 增加一个电影类型
     * @param moviceType
     * @return
     */
    public boolean addMoviceType(MoviceType moviceType);


    /***
     * 传入一个ID，我返回，这个对象给你
     * @param id
     * @return
     */
    public MoviceType findMoviceTypesById(Integer id);

    /***
     * 根据物理路径，查找 当前的子类
     * @param urlName
     * @return
     */
    public List<MoviceType> findMoviceTypeAndChild(String urlName);


    /***
     * 根据物理路径，查找 当前的子类
     * @param urlName
     * @return
     */
    public List<MoviceType> findMoviceTypeByUrl(String urlName);

    /***
     * 查找所有根目录的，类型
     * @return
     */
    public List<MoviceType> findAllRootMoviceType();

    /***
     * 删除一个板块
     * @param id
     * @return
     */
    public boolean delectMoviceType(Integer id);

}
