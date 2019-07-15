package com.wcd.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/***
 * 电影的类型类
 * 描述当前，有哪些类型的电影，采用黎世东说的无限分级
 * @author 王朝冬
 * @date 2019 6 30
 */
@Entity
@Table(name = "movice_movieType")
public class MoviceType {

    /***
     * 开发控制区--------------------------------

     * 类型ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /***
     * 物理化的 路径，比如说 bilbil/guichu/
     * 通过link 关键，就可以找到，这棵树节点的所有子节点
     */
    private String url;

    /**----------真正实体区-------------*/
    /**
     * 这个区的名字
     */
    private String name;

    /***
     * 这个区的介绍
     */
    private String conext;

    /***
     * 这个板块下的 子类型是有哪些
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "superType")
    private List<MoviceType> childType;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getConext() {
        return conext;
    }

    public void setConext(String conext) {
        this.conext = conext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MoviceType> getChildType() {
        return childType;
    }

    public void setChildType(List<MoviceType> childType) {
        this.childType = childType;
    }

    @Override
    public String toString() {
        return "MoviceType{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", conext='" + conext + '\'' +
                ", childType=" + childType +
                '}';
    }


}
