package school.xauat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import school.xauat.po.Type;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 18:14
 * @description：Type类
 */
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
