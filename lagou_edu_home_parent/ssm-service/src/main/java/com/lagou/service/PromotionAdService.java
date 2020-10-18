package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

public interface PromotionAdService {

    /**
     *  分页获取所有的广告列表
     *  */
    public PageInfo findAllAdByPage(PromotionAdVo adVo);

    /**
     * 增加广告
     *
     * @param promotionAd
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 修改广告
     *
     * @param promotionAd
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /**
     *  回显广告信息
     *  */
    public PromotionAd findPromotionAdById(Integer id);

    /**
     * 根据id修改状态信息
     * @param id
     * @param status
     */
    void updatePromotionAdStatus(int id, int status);

}
