package com.com.sky.downloader.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.hellocat.bean.Breed;

import com.com.sky.downloader.greendao.BreedDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig breedDaoConfig;

    private final BreedDao breedDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        breedDaoConfig = daoConfigMap.get(BreedDao.class).clone();
        breedDaoConfig.initIdentityScope(type);

        breedDao = new BreedDao(breedDaoConfig, this);

        registerDao(Breed.class, breedDao);
    }
    
    public void clear() {
        breedDaoConfig.clearIdentityScope();
    }

    public BreedDao getBreedDao() {
        return breedDao;
    }

}