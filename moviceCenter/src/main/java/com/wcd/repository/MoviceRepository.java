package com.wcd.repository;

import com.wcd.entity.Movice;
import com.wcd.entity.MoviceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.Date;
import java.util.List;

/***
 * 电影的数据库层，打交道
 * 声明式接口，
 * 继承自 org.springframework.data.repository.JpaRepository<T, ID>
 * 具备非常，分页属性，与简单的增删还差属性。
 * 根据此接口已经提供一些基础的方法了
 * 只需要在这些基础上提供一个新的方法，即可
 * @author wcd
 * @date   2019 6 30
 */
@Repository
public interface MoviceRepository extends JpaRepository<Movice,Integer> {

    /***
     * 根据 电影的类别去找
     * @param
     * @return
     */
    @Query("")
    Page<Movice> findMovicesByMoviceTypeIsIn(Collection<MoviceType> moviceTypes, PageRequest pageRequest);

    /***
     * 根据 电影的类别去找
     * @param moviceType
     * @return
     */
    @Query(name = "select * from Movice where Movice.moviceType = ?1 Ordery by ?#{#pageRequest}",
           countName = "select count(*) from Movice where Movice.moviceType = ?1  " )
    Page<Movice> findMovicesByMoviceType(MoviceType moviceType, Pageable pageRequest);


    Page<Movice> findMovicesByMoviceTypeIsInAndTimeBetween(List<MoviceType> movieType, Date form, Date to, Pageable pageable);




}
