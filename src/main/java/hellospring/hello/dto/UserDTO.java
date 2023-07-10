package hellospring.hello.dto;


import hellospring.hello.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private long seq;

    private String user_id;

    private String user_name;

    private String memo;

    private LocalDateTime register_date;

    public UserDTO(UserEntity userEntity){
        this.seq = userEntity.getSeq();
        this.user_id = userEntity.getUser_id();
        this.user_name = userEntity.getUser_name();
        this.memo = userEntity.getMemo();
        this.register_date = userEntity.getRegister_date();
    }
    public UserEntity toEntity() {
        return UserEntity.builder()
                .seq(this.seq)
                .user_id(this.user_id)
                .user_name(this.user_name)
                .memo(this.memo)
                .build();
    }


}
