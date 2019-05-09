package com.com.sky.downloader.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.hellocat.bean.Breed;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BREED".
*/
public class BreedDao extends AbstractDao<Breed, Void> {

    public static final String TABLENAME = "BREED";

    /**
     * Properties of entity Breed.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "name", false, "NAME");
        public final static Property Description = new Property(1, String.class, "description", false, "DESCRIPTION");
        public final static Property Id = new Property(2, String.class, "id", false, "ID");
        public final static Property Wikipedia_url = new Property(3, String.class, "wikipedia_url", false, "WIKIPEDIA_URL");
        public final static Property Img_url = new Property(4, String.class, "img_url", false, "IMG_URL");
    }


    public BreedDao(DaoConfig config) {
        super(config);
    }
    
    public BreedDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BREED\" (" + //
                "\"NAME\" TEXT," + // 0: name
                "\"DESCRIPTION\" TEXT," + // 1: description
                "\"ID\" TEXT," + // 2: id
                "\"WIKIPEDIA_URL\" TEXT," + // 3: wikipedia_url
                "\"IMG_URL\" TEXT);"); // 4: img_url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BREED\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Breed entity) {
        stmt.clearBindings();
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(1, name);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(2, description);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(3, id);
        }
 
        String wikipedia_url = entity.getWikipedia_url();
        if (wikipedia_url != null) {
            stmt.bindString(4, wikipedia_url);
        }
 
        String img_url = entity.getImg_url();
        if (img_url != null) {
            stmt.bindString(5, img_url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Breed entity) {
        stmt.clearBindings();
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(1, name);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(2, description);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(3, id);
        }
 
        String wikipedia_url = entity.getWikipedia_url();
        if (wikipedia_url != null) {
            stmt.bindString(4, wikipedia_url);
        }
 
        String img_url = entity.getImg_url();
        if (img_url != null) {
            stmt.bindString(5, img_url);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Breed readEntity(Cursor cursor, int offset) {
        Breed entity = new Breed( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // name
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // description
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // wikipedia_url
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // img_url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Breed entity, int offset) {
        entity.setName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDescription(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWikipedia_url(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImg_url(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Breed entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Breed entity) {
        return null;
    }

    @Override
    public boolean hasKey(Breed entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
