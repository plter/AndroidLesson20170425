# 数据库版本描述


# v2数据库结构

## v2结构

```sql
CREATE TABLE IF NOT EXISTS group (
    _id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL DEFAULT \"default group\"
)

CREATE TABLE IF NOT EXISTS user(
    _id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL DEFAULT NONE,
    age INTEGER DEFAULT 1,
    group_id INTEGER DEFAULT 1
)
```
## v2初始化数据

```java
ContentValues cvs = new ContentValues();
cvs.put(COLUMN_NAME_ID, 1);
cvs.put(COLUMN_NAME_NAME, "default group");
db.insert(TABLE_NAME_GROUP, null, cvs);
```
## upgrade user table from 1 to 2

```sql
ALTER TABLE user ADD COLUMN group_id INTEGER DEFAULT 1
```


# v1数据库结构

```sql
CREATE TABLE IF NOT EXISTS user(
    _id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL DEFAULT NONE,
    age INTEGER DEFAULT 1
)
```