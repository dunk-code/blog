package school.xauat.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/1 16:39
 * @description：博客类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;


    //包含多个blog
    @OneToMany(mappedBy = "type")
    private List<Blog>  blogs = new ArrayList<>();
}
