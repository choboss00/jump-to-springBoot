package com.example.sbb.user;

import com.example.sbb.config.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE USER SET deleted_at = CURRENT_TIMESTAMP, is_deleted = TRUE where id = ?")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String nickName;

    @Column(length = 20, nullable = false)
    private String role;

    @Builder
    public User(String name, String password, String email, String nickName, String role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
    }
}
