package com.sagoss.validationtesting.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sagoss.validationtesting.api.models.config.DateToFixed;
import com.sagoss.validationtesting.database.models.DateToFixedConverters;
import com.sagoss.validationtesting.database.models.Voucher;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class VoucherDao_Impl implements VoucherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Voucher> __insertionAdapterOfVoucher;

  private final DateToFixedConverters __dateToFixedConverters = new DateToFixedConverters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public VoucherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVoucher = new EntityInsertionAdapter<Voucher>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `vouchers` (`voucher_name`,`voucher_id`,`voucher_server_id`,`key`,`date_from`,`date_to`,`date_to_unit`,`date_to_limit`,`work_offline`,`date_to_fixed`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Voucher value) {
        if (value.getVoucherName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVoucherName());
        }
        stmt.bindLong(2, value.getVoucherId());
        stmt.bindLong(3, value.getVoucherServerID());
        if (value.getKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKey());
        }
        final int _tmp;
        _tmp = value.getDateFrom() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getDateTo() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getDateToUnit() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDateToUnit());
        }
        if (value.getDateToLimit() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDateToLimit());
        }
        final int _tmp_2;
        _tmp_2 = value.getWorkOffline() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        final String _tmp_3;
        _tmp_3 = __dateToFixedConverters.fromObjToJson(value.getDateToFixed());
        if (_tmp_3 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_3);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from vouchers";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Voucher voucher) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfVoucher.insert(voucher);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<Voucher> listVoucher) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfVoucher.insert(listVoucher);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<Voucher>> continuation) {
    final String _sql = "SELECT * from vouchers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Voucher>>() {
      @Override
      public List<Voucher> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfVoucherName = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_name");
          final int _cursorIndexOfVoucherId = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_id");
          final int _cursorIndexOfVoucherServerID = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_server_id");
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "date_from");
          final int _cursorIndexOfDateTo = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to");
          final int _cursorIndexOfDateToUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_unit");
          final int _cursorIndexOfDateToLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_limit");
          final int _cursorIndexOfWorkOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "work_offline");
          final int _cursorIndexOfDateToFixed = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_fixed");
          final List<Voucher> _result = new ArrayList<Voucher>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Voucher _item;
            final String _tmpVoucherName;
            _tmpVoucherName = _cursor.getString(_cursorIndexOfVoucherName);
            final int _tmpVoucherId;
            _tmpVoucherId = _cursor.getInt(_cursorIndexOfVoucherId);
            final int _tmpVoucherServerID;
            _tmpVoucherServerID = _cursor.getInt(_cursorIndexOfVoucherServerID);
            final String _tmpKey;
            _tmpKey = _cursor.getString(_cursorIndexOfKey);
            final boolean _tmpDateFrom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDateFrom);
            _tmpDateFrom = _tmp != 0;
            final boolean _tmpDateTo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDateTo);
            _tmpDateTo = _tmp_1 != 0;
            final String _tmpDateToUnit;
            _tmpDateToUnit = _cursor.getString(_cursorIndexOfDateToUnit);
            final Integer _tmpDateToLimit;
            if (_cursor.isNull(_cursorIndexOfDateToLimit)) {
              _tmpDateToLimit = null;
            } else {
              _tmpDateToLimit = _cursor.getInt(_cursorIndexOfDateToLimit);
            }
            final boolean _tmpWorkOffline;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfWorkOffline);
            _tmpWorkOffline = _tmp_2 != 0;
            final List<DateToFixed> _tmpDateToFixed;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfDateToFixed);
            _tmpDateToFixed = __dateToFixedConverters.fromJsonToObj(_tmp_3);
            _item = new Voucher(_tmpVoucherName,_tmpVoucherId,_tmpVoucherServerID,_tmpKey,_tmpDateFrom,_tmpDateTo,_tmpDateToUnit,_tmpDateToLimit,_tmpWorkOffline,_tmpDateToFixed);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getVoucher(final String name, final Continuation<? super Voucher> continuation) {
    final String _sql = "SELECT * FROM vouchers WHERE voucher_name=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<Voucher>() {
      @Override
      public Voucher call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfVoucherName = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_name");
          final int _cursorIndexOfVoucherId = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_id");
          final int _cursorIndexOfVoucherServerID = CursorUtil.getColumnIndexOrThrow(_cursor, "voucher_server_id");
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "date_from");
          final int _cursorIndexOfDateTo = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to");
          final int _cursorIndexOfDateToUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_unit");
          final int _cursorIndexOfDateToLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_limit");
          final int _cursorIndexOfWorkOffline = CursorUtil.getColumnIndexOrThrow(_cursor, "work_offline");
          final int _cursorIndexOfDateToFixed = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to_fixed");
          final Voucher _result;
          if(_cursor.moveToFirst()) {
            final String _tmpVoucherName;
            _tmpVoucherName = _cursor.getString(_cursorIndexOfVoucherName);
            final int _tmpVoucherId;
            _tmpVoucherId = _cursor.getInt(_cursorIndexOfVoucherId);
            final int _tmpVoucherServerID;
            _tmpVoucherServerID = _cursor.getInt(_cursorIndexOfVoucherServerID);
            final String _tmpKey;
            _tmpKey = _cursor.getString(_cursorIndexOfKey);
            final boolean _tmpDateFrom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDateFrom);
            _tmpDateFrom = _tmp != 0;
            final boolean _tmpDateTo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDateTo);
            _tmpDateTo = _tmp_1 != 0;
            final String _tmpDateToUnit;
            _tmpDateToUnit = _cursor.getString(_cursorIndexOfDateToUnit);
            final Integer _tmpDateToLimit;
            if (_cursor.isNull(_cursorIndexOfDateToLimit)) {
              _tmpDateToLimit = null;
            } else {
              _tmpDateToLimit = _cursor.getInt(_cursorIndexOfDateToLimit);
            }
            final boolean _tmpWorkOffline;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfWorkOffline);
            _tmpWorkOffline = _tmp_2 != 0;
            final List<DateToFixed> _tmpDateToFixed;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfDateToFixed);
            _tmpDateToFixed = __dateToFixedConverters.fromJsonToObj(_tmp_3);
            _result = new Voucher(_tmpVoucherName,_tmpVoucherId,_tmpVoucherServerID,_tmpKey,_tmpDateFrom,_tmpDateTo,_tmpDateToUnit,_tmpDateToLimit,_tmpWorkOffline,_tmpDateToFixed);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getVoucherNames(final Continuation<? super List<String>> continuation) {
    final String _sql = "SELECT voucher_name from vouchers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            _item = _cursor.getString(0);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getCount(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT count(*) FROM vouchers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }
}
