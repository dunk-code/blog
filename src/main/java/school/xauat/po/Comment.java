package school.xauat.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/1 16:43
 * @description：博客评论
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String content;

    //头像
    private String avatar;

    private boolean adminComment;

    //创建时间
    //声明数据库中对应时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    //多个评论对应一个博客
    @ManyToOne
    private Blog blog;

    //一个父评论对应多个子评论
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    //一个子评论对应一个父评论
    @ManyToOne
    private Comment parentComment;

}
