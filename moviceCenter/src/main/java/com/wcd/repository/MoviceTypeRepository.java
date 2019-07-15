package com.wcd.repository;

import com.wcd.entity.MoviceType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/***
 * 声明式接口，
 * 继承自 org.springframework.data.repository.Repository<T, ID>
 * 根据此接口已经提供一些基础的方法了
 * 只需要在这些基础上提供一个新的方法，即可
 * @author wcd
 * @date   2019 6 30
 */
@Repository
public interface MoviceTypeRepository extends JpaRepository<MoviceType,Integer> {

    /***
     * 根据物理化的路径查找，它的所有子节点
     */
    List<MoviceType> getMoviceTypesByUrlLike(String url);
}
