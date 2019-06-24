package com.ping.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.privatee.wjtbaseapp.Bean.User.TestStudentListBeanConverter;
import java.util.List;

import com.privatee.wjtbaseapp.Bean.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Void> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Age = new Property(0, String.class, "age", false, "AGE");
        public final static Property Listbean = new Property(1, String.class, "listbean", false, "LISTBEAN");
    }

    private final TestStudentListBeanConverter listbeanConverter = new TestStudentListBeanConverter();

    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"AGE\" TEXT," + // 0: age
                "\"LISTBEAN\" TEXT);"); // 1: listbean
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(1, age);
        }
 
        List listbean = entity.getListbean();
        if (listbean != null) {
            stmt.bindString(2, listbeanConverter.convertToDatabaseValue(listbean));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(1, age);
        }
 
        List listbean = entity.getListbean();
        if (listbean != null) {
            stmt.bindString(2, listbeanConverter.convertToDatabaseValue(listbean));
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // age
            cursor.isNull(offset + 1) ? null : listbeanConverter.convertToEntityProperty(cursor.getString(offset + 1)) // listbean
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setAge(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setListbean(cursor.isNull(offset + 1) ? null : listbeanConverter.convertToEntityProperty(cursor.getString(offset + 1)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(User entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(User entity) {
        return null;
    }

    @Override
    public boolean hasKey(User entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
