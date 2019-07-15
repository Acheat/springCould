package com.wcd.repository;

import com.wcd.CustermApplication;
import com.wcd.entity.Movice;
import com.wcd.entity.MoviceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustermApplication.class)
public class MoviceRepositoryTest {
    @Autowired
    MoviceRepository moviceRepository;


    public void findMovicesByMoviceTypeInOrderByTime() {
        //moviceRepository.findMovicesByMoviceTypeInOrderByTime(null);
    }


    /**
     * 添加10w条数据
     */
    @Test
    public void addmovice(){
        int len = 100000;
        Random random = new Random();
        Random type  = new Random(2);
        for(int i = 100000; i < len*10 ; i++ ) {
            Movice movice = new Movice();
            MoviceType moviceType = new MoviceType();
            moviceType.setId(1+type.nextInt(3));

            movice.setZanNum(i);
            movice.setSeeNum(i);
            movice.setTime( new Timestamp(System.currentTimeMillis() + (long)random.nextInt()));
            movice.setUrl("bilbil"+random.nextInt());
            movice.setImgUrl("url"+random.nextInt());
            movice.setTitile("titile"+random.nextInt());
            movice.setMoviceType(moviceType);

            moviceRepository.save(movice);
        }
    }





    public void findMovicesByMoviceTypeIsInAndTimeBetween() throws ParseException {
        List<MoviceType> type = new ArrayList<>() ;
        MoviceType moviceType = new MoviceType();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        moviceType.setId(1);
        type.add(moviceType);



        Date date = dateFormat.parse("2019-07-01");
        Date date1 = dateFormat.parse("2019-07-03");


        Sort sort =  Sort.by("time");
        PageRequest pageRequest = PageRequest.of(0,10,sort);
        Page<Movice> page = moviceRepository.findMovicesByMoviceTypeIsInAndTimeBetween(type,date,date1,pageRequest);
       List<Movice> movices = page.getContent();
       for (Movice movice : movices){
           System.out.println(movice);
       }
    }



}