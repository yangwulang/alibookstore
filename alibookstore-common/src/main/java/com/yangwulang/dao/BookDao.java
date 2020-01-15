package com.yangwulang.dao;

import com.yangwulang.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author yangwulang
 */
@Mapper
public interface BookDao {
    /**
     * 查询所有书籍信息
     *
     * @return 所有书籍信息
     */
    List<Book> selectAllBook();

    /**
     * 根据id查询书籍信息
     *
     * @param id 书籍id
     * @return 书籍信息
     */
    Book getBookById(@Param("id") long id);

    /**
     * 插入书籍
     *
     * @param book 书籍对象
     * @return 影响的行数
     */
    int insertBook(@Param("book") Book book);

    /**
     * 根据书名查询书籍信息
     *
     * @param name 书名
     * @return 返回书籍信息
     */
    List<Book> selectBookByName(@Param("bookname") String name);

    /**
     * 模糊查询书籍信息
     *
     * @param bookCount 模糊书名
     * @return 书籍列表
     */

    List<Book> selectBookByCount(@Param("bookCount") String bookCount);

    /**
     * 根据Cetegtory查找书籍
     *
     * @param cet 分类方式
     * @return 书籍
     */
    List<Book> selectBookByCetegtory(@Param("cet") String cet);

    /**
     * 根据id删除书籍
     *
     * @param id 书籍id
     * @return 影响行数
     */
    int deleteBookById(@Param("id") long id);

    /**
     * 查询书的所有数量
     *
     * @return 书的所有数量
     */
    int selectBookCount();
}
