package com.sagoss.validationtesting.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.sagoss.validationtesting.database.dao.RequestDao;
import com.sagoss.validationtesting.database.dao.RequestDao_Impl;
import com.sagoss.validationtesting.database.dao.VoucherDao;
import com.sagoss.validationtesting.database.dao.VoucherDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ValidationDatabase_Impl extends ValidationDatabase {
  private volatile VoucherDao _voucherDao;

  private volatile RequestDao _requestDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `plate` TEXT NOT NULL, `request_token` TEXT NOT NULL, `date_from` TEXT NOT NULL, `date_to` TEXT NOT NULL, `date_saved` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `vouchers` (`voucher_name` TEXT NOT NULL, `voucher_id` INTEGER NOT NULL, `voucher_server_id` INTEGER NOT NULL, `key` TEXT NOT NULL, `date_from` INTEGER NOT NULL, `date_to` INTEGER NOT NULL, `date_to_unit` TEXT, `date_to_limit` INTEGER, `work_offline` INTEGER NOT NULL, `date_to_fixed` TEXT, PRIMARY KEY(`voucher_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '81a8bebf5a4d8d096f63bb462e2e2e8d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `requests`");
        _db.execSQL("DROP TABLE IF EXISTS `vouchers`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRequests = new HashMap<String, TableInfo.Column>(6);
        _columnsRequests.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRequests.put("plate", new TableInfo.Column("plate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRequests.put("request_token", new TableInfo.Column("request_token", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRequests.put("date_from", new TableInfo.Column("date_from", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRequests.put("date_to", new TableInfo.Column("date_to", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRequests.put("date_saved", new TableInfo.Column("date_saved", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRequests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRequests = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRequests = new TableInfo("requests", _columnsRequests, _foreignKeysRequests, _indicesRequests);
        final TableInfo _existingRequests = TableInfo.read(_db, "requests");
        if (! _infoRequests.equals(_existingRequests)) {
          return new RoomOpenHelper.ValidationResult(false, "requests(com.sagoss.validationtesting.database.models.Request).\n"
                  + " Expected:\n" + _infoRequests + "\n"
                  + " Found:\n" + _existingRequests);
        }
        final HashMap<String, TableInfo.Column> _columnsVouchers = new HashMap<String, TableInfo.Column>(10);
        _columnsVouchers.put("voucher_name", new TableInfo.Column("voucher_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("voucher_id", new TableInfo.Column("voucher_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("voucher_server_id", new TableInfo.Column("voucher_server_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("date_from", new TableInfo.Column("date_from", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("date_to", new TableInfo.Column("date_to", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("date_to_unit", new TableInfo.Column("date_to_unit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("date_to_limit", new TableInfo.Column("date_to_limit", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("work_offline", new TableInfo.Column("work_offline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVouchers.put("date_to_fixed", new TableInfo.Column("date_to_fixed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVouchers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVouchers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVouchers = new TableInfo("vouchers", _columnsVouchers, _foreignKeysVouchers, _indicesVouchers);
        final TableInfo _existingVouchers = TableInfo.read(_db, "vouchers");
        if (! _infoVouchers.equals(_existingVouchers)) {
          return new RoomOpenHelper.ValidationResult(false, "vouchers(com.sagoss.validationtesting.database.models.Voucher).\n"
                  + " Expected:\n" + _infoVouchers + "\n"
                  + " Found:\n" + _existingVouchers);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "81a8bebf5a4d8d096f63bb462e2e2e8d", "3ef892b0b76b7e9fc2bfa118aa694af5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "requests","vouchers");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `requests`");
      _db.execSQL("DELETE FROM `vouchers`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public VoucherDao voucherDao() {
    if (_voucherDao != null) {
      return _voucherDao;
    } else {
      synchronized(this) {
        if(_voucherDao == null) {
          _voucherDao = new VoucherDao_Impl(this);
        }
        return _voucherDao;
      }
    }
  }

  @Override
  public RequestDao requestDao() {
    if (_requestDao != null) {
      return _requestDao;
    } else {
      synchronized(this) {
        if(_requestDao == null) {
          _requestDao = new RequestDao_Impl(this);
        }
        return _requestDao;
      }
    }
  }
}
