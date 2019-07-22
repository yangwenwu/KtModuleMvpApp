package kt.module.base_module.data.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import kt.module.base_module.data.db.table.RvData;
import kt.module.base_module.data.db.table.VideoHistory;

import kt.module.base_module.data.db.dao.RvDataDao;
import kt.module.base_module.data.db.dao.VideoHistoryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig rvDataDaoConfig;
    private final DaoConfig videoHistoryDaoConfig;

    private final RvDataDao rvDataDao;
    private final VideoHistoryDao videoHistoryDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        rvDataDaoConfig = daoConfigMap.get(RvDataDao.class).clone();
        rvDataDaoConfig.initIdentityScope(type);

        videoHistoryDaoConfig = daoConfigMap.get(VideoHistoryDao.class).clone();
        videoHistoryDaoConfig.initIdentityScope(type);

        rvDataDao = new RvDataDao(rvDataDaoConfig, this);
        videoHistoryDao = new VideoHistoryDao(videoHistoryDaoConfig, this);

        registerDao(RvData.class, rvDataDao);
        registerDao(VideoHistory.class, videoHistoryDao);
    }
    
    public void clear() {
        rvDataDaoConfig.clearIdentityScope();
        videoHistoryDaoConfig.clearIdentityScope();
    }

    public RvDataDao getRvDataDao() {
        return rvDataDao;
    }

    public VideoHistoryDao getVideoHistoryDao() {
        return videoHistoryDao;
    }

}
