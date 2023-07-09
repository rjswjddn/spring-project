package hellospring.hello.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "user_test")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long seq;

    private String user_id;

    private String user_name;

    private String memo;

}

