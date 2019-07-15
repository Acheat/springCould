package com.wcd.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/***
 * 电影类
 * @author wcd
 * @date 2019 6 30
 */
@Entity
@Table( name = "movice_movice")
public class Movice {
    /**开发控制区-----------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**自身属性区*/

    /***
     * 电影的标题
     */
    private String titile;

    /***
     * 封面存放路径
     */
    private String imgUrl;

    /***
     * 电影的存放路径
     */
    private String url;


    /***
     * 电影的上传时间
     */
    private Timestamp time;

    /***
     * 电影的观看数量
     */
    private int seeNum;

    /***
     * 点赞数
     */
    private int zanNum;


    /***
     * 电影的类别，与电影一对多关联，这个配置数据库的时候再说
     */
    @ManyToOne
    @JoinColumn
    private MoviceType moviceType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(int seeNum) {
        this.seeNum = seeNum;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public MoviceType getMoviceType() {
        return moviceType;
    }

    public void setMoviceType(MoviceType moviceType) {
        this.moviceType = moviceType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Movice{" +
                "id=" + id +
                ", titile='" + titile + '\'' +
                ", url='" + url + '\'' +
                ", time=" + time +
                ", seeNum=" + seeNum +
                ", zanNum=" + zanNum +
                ", moviceType=" + moviceType +
                '}';
    }


}
