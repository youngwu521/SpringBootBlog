package com.young.blog.Service;

import com.young.blog.DAO.TypeRepositroy;
import com.young.blog.Entity.Type;
import com.young.blog.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/17 0017 19:56
 * You can't be killed, it will only make you stronger
 */
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepositroy typeRepositroy;



    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepositroy.save(type);
    }


    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepositroy.findById(id).get();
    }


    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepositroy.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepositroy.findById(id).get();
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepositroy.save(t);
    }


    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepositroy.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepositroy.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeRepositroy.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort.Order sort = new Sort.Order(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size);
        return typeRepositroy.findTop(pageable);
    }
}
