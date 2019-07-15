package com.wcd.service.movicetype;

import com.wcd.entity.MoviceType;
import com.wcd.repository.MoviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviceTypeServiceImpl implements MoviceTypeServiceInfer {

    @Autowired
    MoviceTypeRepository moviceTypeRepository;

    @Override
    public boolean addMoviceType(MoviceType moviceType) {
         moviceTypeRepository.save(moviceType);
         return true;
    }



    @Override
    public MoviceType findMoviceTypesById(Integer id) {
        return moviceTypeRepository.getOne(id);
    }

    @Override
    public List<MoviceType> findMoviceTypeAndChild(String urlName) {
        return moviceTypeRepository.getMoviceTypesByUrlLike(urlName +"%");
    }

    @Override
    public List<MoviceType> findMoviceTypeByUrl(String urlName) {
        return moviceTypeRepository.getMoviceTypesByUrlLike(urlName);
    }

    @Override
    public List<MoviceType> findAllRootMoviceType() {
        return moviceTypeRepository.findAll();
    }

    @Override
    public boolean delectMoviceType(Integer id) {
        return false;
    }
}
