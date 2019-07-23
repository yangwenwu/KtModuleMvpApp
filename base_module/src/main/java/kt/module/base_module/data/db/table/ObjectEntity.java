package kt.module.base_module.data.db.table;

import android.os.Parcel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import org.greenrobot.greendao.annotation.*;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import kt.module.base_module.data.db.dao.DaoSession;
import kt.module.base_module.data.db.dao.ChildEntityDao;
import kt.module.base_module.data.db.dao.ObjectEntityDao;

@Entity
public class ObjectEntity implements MultiItemEntity {

    @Id
    private Long objectId;

    private String title;
    private int show_template;
    private int type;

    @ToMany(referencedJoinProperty = "objectId")
    private List<ChildEntity> child;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1262937627)
    private transient ObjectEntityDao myDao;


    public Long getId() {
        return objectId;
    }

    public void setId(Long id) {
        this.objectId = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    @Generated(hash = 1484296871)
    public ObjectEntity() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getShow_template() {
        return show_template;
    }

    public void setShow_template(int show_template) {
        this.show_template = show_template;
    }


    @Override
    public String toString() {
        return "ObjectEntity{" +
                "title='" + title + '\'' +
                ", show_template=" + show_template +
                ", child=" + child +
                '}';
    }

    protected ObjectEntity(Parcel in) {
        title = in.readString();
        show_template = in.readInt();
    }

    @Generated(hash = 1473062710)
    public ObjectEntity(Long objectId, String title, int show_template, int type) {
        this.objectId = objectId;
        this.title = title;
        this.show_template = show_template;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public Long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 421354534)
    public List<ChildEntity> getChild() {
        if (child == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChildEntityDao targetDao = daoSession.getChildEntityDao();
            List<ChildEntity> childNew = targetDao
                    ._queryObjectEntity_Child(objectId);
            synchronized (this) {
                if (child == null) {
                    child = childNew;
                }
            }
        }
        return child;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1024800465)
    public synchronized void resetChild() {
        child = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 608657933)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getObjectEntityDao() : null;
    }

}
