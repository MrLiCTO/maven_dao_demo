package com.ny.mall.mapperCustom;

import java.util.List;

import com.ny.mall.pojoAndVo.UserCustom;
import com.ny.mall.pojoAndVo.UserCustomVo;

public interface UserMapperCustom {
    public List<UserCustom> findEntityList(UserCustomVo entityCustomVo); 
    public int findEntityCount(UserCustomVo entityCustomVo); 
}