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
 * @date ：Created 2021/4/1 16:48
 * @description：用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    //头像
    private String avatar;

    //类型
    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;


    //一个用户有许多博客
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

}
