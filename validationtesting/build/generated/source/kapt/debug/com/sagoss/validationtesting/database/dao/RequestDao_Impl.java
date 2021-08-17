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
import com.sagoss.validationtesting.database.models.Request;
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
public final class RequestDao_Impl implements RequestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Request> __insertionAdapterOfRequest;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldRecords;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSuccessfulRequest;

  public RequestDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRequest = new EntityInsertionAdapter<Request>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `requests` (`id`,`plate`,`request_token`,`date_from`,`date_to`,`date_saved`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Request value) {
        stmt.bindLong(1, value.getId());
        if (value.getPlate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPlate());
        }
        if (value.getToken() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getToken());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateFrom());
        }
        if (value.getDateTo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateTo());
        }
        if (value.getDateSaved() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDateSaved());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from requests";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldRecords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM requests WHERE date_saved <= DATETIME('now', '-15 days')";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSuccessfulRequest = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM requests WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Request request) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRequest.insert(request);
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
  public Object deleteOldRecords(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldRecords.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteOldRecords.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteSuccessfulRequest(final int id,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSuccessfulRequest.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteSuccessfulRequest.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<Request>> continuation) {
    final String _sql = "SELECT * from requests";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Request>>() {
      @Override
      public List<Request> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPlate = CursorUtil.getColumnIndexOrThrow(_cursor, "plate");
          final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "request_token");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "date_from");
          final int _cursorIndexOfDateTo = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to");
          final int _cursorIndexOfDateSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "date_saved");
          final List<Request> _result = new ArrayList<Request>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Request _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPlate;
            _tmpPlate = _cursor.getString(_cursorIndexOfPlate);
            final String _tmpToken;
            _tmpToken = _cursor.getString(_cursorIndexOfToken);
            final String _tmpDateFrom;
            _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            final String _tmpDateTo;
            _tmpDateTo = _cursor.getString(_cursorIndexOfDateTo);
            final String _tmpDateSaved;
            _tmpDateSaved = _cursor.getString(_cursorIndexOfDateSaved);
            _item = new Request(_tmpId,_tmpPlate,_tmpToken,_tmpDateFrom,_tmpDateTo,_tmpDateSaved);
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
  public Object getRequest(final long id, final Continuation<? super Request> continuation) {
    final String _sql = "SELECT * FROM requests WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.execute(__db, false, new Callable<Request>() {
      @Override
      public Request call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPlate = CursorUtil.getColumnIndexOrThrow(_cursor, "plate");
          final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "request_token");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "date_from");
          final int _cursorIndexOfDateTo = CursorUtil.getColumnIndexOrThrow(_cursor, "date_to");
          final int _cursorIndexOfDateSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "date_saved");
          final Request _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPlate;
            _tmpPlate = _cursor.getString(_cursorIndexOfPlate);
            final String _tmpToken;
            _tmpToken = _cursor.getString(_cursorIndexOfToken);
            final String _tmpDateFrom;
            _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            final String _tmpDateTo;
            _tmpDateTo = _cursor.getString(_cursorIndexOfDateTo);
            final String _tmpDateSaved;
            _tmpDateSaved = _cursor.getString(_cursorIndexOfDateSaved);
            _result = new Request(_tmpId,_tmpPlate,_tmpToken,_tmpDateFrom,_tmpDateTo,_tmpDateSaved);
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
  public Object getCount(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT count(*) FROM requests";
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
