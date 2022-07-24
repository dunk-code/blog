package school.xauat.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Pageable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/1 15:25
 * @description：博客
 */

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {

    //id
    @Id
    @GeneratedValue
    private Long id;

    //题目
    private String title;
    //内容
    @Basic(fetch = FetchType.LAZY)//懒加载
    @Lob//大字段
    private String content;
    //首图
    private String firstPicture;
    //标记
    private String flag;
    //浏览次数
    private Integer views = 0;
    //赞赏是否开启
    private boolean appreciation;
    //转载声明是否开启
    private boolean shareStatement;
    //评论开启
    private boolean commentabled;
    //是否发布
    private boolean published;
    //是否推荐
    private boolean recommend;
    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    //博客描述
    private String description;

    @Transient
    private String tagIds;

    @Transient
    private Long typeId;

    //type类型
    @ManyToOne
    private Type type;

    //一个博客对应多个标签
    @ManyToMany(cascade = {CascadeType.PERSIST})//级联新增 新增tag 同时也会保存到数据库
    private List<Tag> tags = new ArrayList<>();

    //多个博客对应一个用户
    @ManyToOne
    private User user;

    //一个博客有多个评论
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    public void init() {
        StringBuilder builder = new StringBuilder();
        for(Tag tag : this.tags) {
            builder.append(tag.getId());
            builder.append(",");
        }
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }
        this.tagIds = builder.toString();
    }

}
