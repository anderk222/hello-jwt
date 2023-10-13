package anderk222.hellojwt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@SQLDelete(sql = "UPDATE usuarios SET deleted='true' WHERE id=?")
@Where(clause = "deleted=false")
public class Usuario {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Expose
    @Column(length = 20, unique = true, nullable = false)
    private String userName;

    @Expose(serialize = false, deserialize = true)
    @Column(columnDefinition = "text", nullable = false)
    private String password;

    @Expose
    @Column(length = 255, unique = true)
    private String mail;

    @Expose(deserialize = false, serialize = false)
    private int intentosFallidos = 0;

    @Expose(serialize = false, deserialize = false)
    private boolean deleted = false;

}