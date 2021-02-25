package com.young.blog.Service;

import com.young.blog.Entity.Tag;
import com.young.blog.Entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/17 0017 19:50
 * You can't be killed, it will only make you stronger
 */
@Service
public interface TypeService {
    // 保存
    Type saveType(Type type);

    // 查询
    Type getType(Long id);

    // 分页
    Page<Type> listType(Pageable pageable);

    // 更新
    Type updateType(Long id,Type type);

    // 删除
    void deleteType(Long id);

    // 通过名称查询Name
    Type getTypeByName(String name);

    // blogs加的

    List<Type> listType();

    // index页面type

    List<Type> listTypeTop(Integer size);

}
