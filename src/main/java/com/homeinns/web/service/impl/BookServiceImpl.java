package com.homeinns.web.service.impl;

import com.homeinns.web.dao.impl.BaseDaoImpl;
import com.homeinns.web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2014/7/23.
 */
@Service
public class BookServiceImpl {

    @Autowired
    public BaseDaoImpl baseDao;

    /*保存数据对象 */
    public void save(Book books) {
        if(books.getBookId()== null){
            baseDao.save("booksMapper.insert", books);
        }
        else{
            baseDao.save("booksMapper.update", books);
        }
    }


    /*根据主键删除对象 */
    public void delete(Serializable id){
        baseDao.delete("booksMapper.deleteByPrimaryKey", id);
    }



    public List<Book> getBooks(){
        return baseDao.getList("booksMapper.selectByEntity");
    }


    /*根据条件查询获取数据对象列表 */
    public List<Book> queryResult(Book books){
        return baseDao.getList("booksMapper.selectByQuery",books);
    }


    /*根据主键获取对象 */
    public Book getBooks(Serializable id) {
        return (Book) baseDao.get("booksMapper.selectByPrimaryKey", id);
    }
}