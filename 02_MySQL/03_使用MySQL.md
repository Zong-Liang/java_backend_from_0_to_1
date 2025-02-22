# 03_使用MySQL

默认端口3306。

关键字（key word）：作为MySQL语言组成部分的一个保留字。决不要用关键字命名一个表或列。

> 记住，必须先使用`USE`打开数据库，才能读取其中的数据。

```sql
#使用crashcourse数据库
USE crashcourse;
```

```sql
#返回可用数据库的一个列表
SHOW DATABASES;
```

```sql
#返回当前选择的数据库内可用表的列表
SHOW TABLES;
```

```sql
#显示表列
SHOW COLUMNS FROM customers;
```

![](assets\imgs\Snipaste_2024-12-18_20-43-26.png)

`SHOW COLUMNS`要求给出一个表名（这个例子中的`FROM customers`），它对每个字段返回一行，行中包含字段名、数据类型、是否允许`NULL`、键信息、默认值以及其他信息（如字段`cust_id`的`auto_increment`）。

什么是自动增量？
某些表列需要唯一值。例如，订单编号、雇员ID或（如上面例子中所示的）顾客ID。在每个行添加到表中时，MySQL可以自动地为每个行分配下一个可用编号，不用在添加一行时手动分配唯一值（这样做必须记住最后一次使用的值）。这个功能就是所谓的自动增量。如果需要它，则必须在用`CREATE`语句创建表时把它作为表定义的组成部分。

MySQL支持用`DESCRIBE`作为`SHOW COLUMNS FROM`的一种快捷方式。

```sql
DESCRIBE customers;
```

```sql
#用于显示广泛的服务器状态信息
SHOW STATUS;
```

```sql
#用来显示创建特定数据库
SHOW CREATE DATA BASE;
#用来显示创建特定表
SHOW CREATE TABLE;
```

```sql
#用来显示授予用户（所有用户或特定用户）的安全权限
SHOW GRANTS;
```

```sql
#用来显示服务器错误
SHOW ERRORS
#用来显示警告消息
SHOW WARNINGS
```

