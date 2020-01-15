package com.yangwulang.dao;

import com.yangwulang.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangwulang
 */
@Mapper
public interface NoticeDao {
    /**
     * 获取最新的公告
     *
     * @return 公告信息
     */
    Notice selectNoticeNew();
}
