package com.wcd.service.movice;

import com.wcd.entity.Movice;
import com.wcd.entity.MoviceType;
import com.wcd.exception.ErrorEmun;
import com.wcd.exception.MyExecption;
import com.wcd.repository.MoviceRepository;
import com.wcd.repository.MoviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Repository
public class MoviceService implements  MoviceServiceInterface{

    /**
     * 通过底层的数据类型去操作
     */
    @Autowired
   private  MoviceRepository moviceRepository;

    @Autowired
   private MoviceTypeRepository moviceTypeRepository;



   private int pageSize = 10;






    @Override
    public boolean addMovice(Movice movice,Integer tid) throws IOException {

        MoviceType moviceType = new MoviceType();
        moviceType.setId(tid);
        movice.setMoviceType(moviceType);

        movice.setSeeNum(0);
        movice.setZanNum(0);
        movice.setTime(Timestamp.valueOf(System.currentTimeMillis()+""));


        //处理文件的存储
         moviceRepository.save(movice);


         return true;

    }

    @Override
    public Page findMoviceByMoviceType(Integer moviceType,Integer page,String order) {
        //Collection<MoviceType> moviceSet = moviceTypeRepository.findMoviceTypeBy(moviceType);
        Sort sort = Sort.by(order);
        PageRequest pageRequest = PageRequest.of(page -1,pageSize,sort);
        MoviceType moviceTypes = new MoviceType();
        moviceTypes.setId(moviceType);

        return  moviceRepository.findMovicesByMoviceType(moviceTypes,pageRequest);

    }

    @Override
    public Page findMoviceByMoviceTypeAndChildeType(Integer moviceTypes,Integer page,String order) throws MyExecption {

        MoviceType moviceType = moviceTypeRepository.getOne(moviceTypes);
        if(moviceType == null){
            throw  new MyExecption(ErrorEmun.MoviceTypeNotFound);
        }

        Sort sort = Sort.by(order);
        PageRequest pageRequest = PageRequest.of(page -1,pageSize,sort);

        return moviceRepository.findMovicesByMoviceType(moviceType,pageRequest);

    }

    @Override
    public Page findMovice(Integer type, Date from, Date to, String ordery) {
        return null;
    }

    @Override
    public Movice findMoviceById(Integer id) {
        return moviceRepository.getOne(id);
    }

    @Override
    public boolean addMovicePlayerNum(Integer mid) {
        Movice movice = moviceRepository.getOne(mid);
        movice.setSeeNum(movice.getSeeNum()+1);
        if(moviceRepository.save(movice) != null){
            return false;
        }

        return true;
    }

    @Override
    public boolean addMoviceZanNum(Integer mid) {
        Movice movice = moviceRepository.getOne(mid);
        movice.setZanNum(movice.getZanNum()+1);
        if(moviceRepository.save(movice) != null){
            return false;
        }

        return true;
    }

    @Override
    public boolean updateMovice(Movice movice) {

        return true;
    }

    @Override
    public boolean delectMoviceById(Integer id) {
        moviceRepository.deleteById(id);
        return true;
    }
}
