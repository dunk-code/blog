package school.xauat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import school.xauat.po.Tag;

import java.util.List;


/**
 * @author ：zsy
 * @date ：Created 2021/4/6 21:57
 * @description：标签
 */
public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
