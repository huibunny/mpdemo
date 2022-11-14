# issue

## 没有初始化h2数据脚本

* [spring boot 2.7.0+ 版本 h2 数据初始化异常解决](http://aizuda.com/article/1084664)

## 执行初始化脚本报错

Caused by: org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Invocation of init method failed; nested exception is org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #2 of class path resource [db/schema-h2.sql]: CREATE TABLE user ( id BIGINT(20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) ); nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "CREATE TABLE user ( id BIGINT[*](20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) )"; expected "ARRAY, INVISIBLE, VISIBLE, NOT NULL, NULL, AS, DEFAULT, GENERATED, ON UPDATE, NOT NULL, NULL, AUTO_INCREMENT, DEFAULT ON NULL, NULL_TO_DEFAULT, SEQUENCE, SELECTIVITY, COMMENT, CONSTRAINT, COMMENT, PRIMARY KEY, UNIQUE, NOT NULL, NULL, CHECK, REFERENCES, AUTO_INCREMENT, ,, )"; SQL statement:
CREATE TABLE user ( id BIGINT(20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) ) [42001-214]
Caused by: org.springframework.jdbc.datasource.init.ScriptStatementFailedException: 
Failed to execute SQL script statement #2 of class path resource [db/schema-h2.sql]: CREATE TABLE user ( id BIGINT(20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) ); nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "CREATE TABLE user ( id BIGINT[*](20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) )"; expected "ARRAY, INVISIBLE, VISIBLE, NOT NULL, NULL, AS, DEFAULT, GENERATED, ON UPDATE, NOT NULL, NULL, AUTO_INCREMENT, DEFAULT ON NULL, NULL_TO_DEFAULT, SEQUENCE, SELECTIVITY, COMMENT, CONSTRAINT, COMMENT, PRIMARY KEY, UNIQUE, NOT NULL, NULL, CHECK, REFERENCES, AUTO_INCREMENT, ,, )"; SQL statement:
CREATE TABLE user ( id BIGINT(20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) ) [42001-214]
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: 
Syntax error in SQL statement "CREATE TABLE user ( id BIGINT[*](20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) )"; expected "ARRAY, INVISIBLE, VISIBLE, NOT NULL, NULL, AS, DEFAULT, GENERATED, ON UPDATE, NOT NULL, NULL, AUTO_INCREMENT, DEFAULT ON NULL, NULL_TO_DEFAULT, SEQUENCE, SELECTIVITY, COMMENT, CONSTRAINT, COMMENT, PRIMARY KEY, UNIQUE, NOT NULL, NULL, CHECK, REFERENCES, AUTO_INCREMENT, ,, )"; SQL statement:
CREATE TABLE user ( id BIGINT(20) NOT NULL COMMENT '主键ID', name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', age INT(11) NULL DEFAULT NULL COMMENT '年龄', email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', PRIMARY KEY (id) ) [42001-214]


I saw your comment later and tried MySQL Compatibility Mode as below:
url: jdbc:h2:mem:testdb;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE

* [Regression: BIT(1) is not accepted in MySQL compatibility mode
#3426](https://github.com/h2database/h2database/issues/3426)