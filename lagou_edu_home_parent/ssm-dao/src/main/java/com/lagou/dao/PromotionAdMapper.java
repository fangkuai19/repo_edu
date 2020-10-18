package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    /**
     * 分页获取所有的广告列表
     */
    public List<PromotionAd> findAllAdByPage();

    /**
     * 新建广告
     *
     * @param promotionAd
     */
    void savePromotionAd(PromotionAd promotionAd);

    /**
     * 修改广告
     *
     * @param promotionAd
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /*** 根据id查询广告信息 * */
    PromotionAd findPromotionAdById(Integer id);

    /**
     * 广告状态上下线
     * @param promotionAd
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);

}
