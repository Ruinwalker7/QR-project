package com.chen.qrcode.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.DeliveryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeliveryDao extends BaseMapper<DeliveryEntity> {
    @Select("select delivery.* ,deliveryman.username from delivery "+
            "inner join deliveryman on delivery.deliveryman_id = deliveryman.id ${ew.customSqlSegment}"
    )
    IPage<DeliveryDto> selectAllotedDto(Page<DeliveryDto> page,@Param(Constants.WRAPPER) Wrapper<DeliveryDto> userWrapper);

    @Select("select delivery.* ,deliveryman.username from delivery "+
            "left join deliveryman on delivery.deliveryman_id = deliveryman.id ${ew.customSqlSegment}"
    )
    IPage<DeliveryDto> selectUnAllotedDto(Page<DeliveryDto> page,@Param(Constants.WRAPPER) Wrapper<DeliveryDto> userWrapper);


    @Select("select delivery.* ,deliveryman.username from delivery "+
            "left join deliveryman on delivery.deliveryman_id = deliveryman.id ${ew.customSqlSegment}"
    )
    IPage<DeliveryDto> selectAllDto(Page<DeliveryDto> page, @Param(Constants.WRAPPER) Wrapper<DeliveryDto> userWrapper);
//    @Select("SELECT * FROM delivery WHERE id = #{Id}")
//    DeliveryEntity selectByAreaId(int Id);
}
