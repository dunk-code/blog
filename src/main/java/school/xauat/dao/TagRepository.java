package school.xauat.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.xauat.po.Tag;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 22:01
 * @description：标签
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
