package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Liked {
    // プロパティ
    @EmbeddedId
    private PK pk;

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
    }

}