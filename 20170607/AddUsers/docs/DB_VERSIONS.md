# 数据库版本描述


# v2数据库结构

## v2结构

```sql
CREATE TABLE IF NOT EXISTS user_group (
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
## v2初始化用户组数据

```java
ContentValues cvs = new ContentValues();
cvs.put("_id", 1);
cvs.put("name", "default group");
db.insert("user_group", null, cvs);
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