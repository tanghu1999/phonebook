package com.th.service.impl;

import com.th.entity.TPhonebook;
import com.th.service.TPhonebookService;
import com.th.utils.PinYinUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TPhonebookServiceImpl extends BaseServiceImpl<TPhonebook> implements TPhonebookService {

    //重写添加方法
    public String save(TPhonebook tPhonebook) throws Exception{
        //设置名字的拼音首字母
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(word.indexOf(PinYinUtil.getFirstByName(tPhonebook.getName()))!=-1){
            tPhonebook.setInitial(PinYinUtil.getFirstByName(tPhonebook.getName()));
        }else{
            tPhonebook.setInitial("#");
        }
        //执行父类中的添加方法
        return super.save(tPhonebook);

    }

    //重写修改方法
    public String upd(TPhonebook tPhonebook) throws Exception {
        //设置名字的拼音首字母
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(word.contains(PinYinUtil.getFirstByName(tPhonebook.getName()))){
            tPhonebook.setInitial(PinYinUtil.getFirstByName(tPhonebook.getName()));
        }else{
            tPhonebook.setInitial("#");
        }
            System.out.println(tPhonebook);
        //执行父类中的修改方法
        return super.upd(tPhonebook);
    }



}
