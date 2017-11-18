package edu.xyc.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 对象注释的解释
 *
 * @Order 制定排序
 * @NotNull 属性不能为空
 * @Convert 制定自定义类型
 * @JoinEntity 定义表连接关系
 * @ToMany 定义多个实体对应的关系
 * @ToOne 定义与另一个实体(一个实体对象)的关系
 * @Unique 该属性值必须在数据库中是唯一值
 * @Keep 注解的代码在GreenDao下运行时保持不变
 * 1.注解实体类: 默认禁止修改此类
 * 2.注解其他代码,默认禁止修改注解的代码段
 * @Property 可以自定义字段名, 注意外键不能使用该属性
 * @Transient 使用该注释的属性不会被存入数据库的字段中
 * @Entity 告诉GreenDao该对象为实体, 只有被@Entity注释的Bean类才能被dao类操作
 * @Generated 编译后自动生成的构造函数、方法等的注释,提示构造函数、方法等不能被修改
 * @Id 对象的Id, 使用Long类型作为EntityId, 否则会报错。(autoincrement = true)表示主键会自增,如果false就会使用旧值
 */

/**
 *
 */
@Entity
public class Student {

    /**
     * 学院id(自增长)
     */
    @Id(autoincrement = true)
    private Long stuId;

    /**
     * 学员编号(唯一性)
     */
    @Index(unique = true)
    private String stuNo;

    /**
     * 学员姓名
     */
    private String stuName;

    /**
     * 学员性别
     */
    private String stuSex;

    /**
     * 学员成绩
     */
    private String stuScore;

    /**
     * 外键(关联老师的主键)
     */
    private Long foreignKey;

    @Generated(hash = 1556870573)
    public Student() {
    }

    @Generated(hash = 1403734713)
    public Student(Long stuId, String stuNo, String stuName, String stuSex, String stuScore, Long foreignKey) {
        this.stuId = stuId;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
        this.foreignKey = foreignKey;
    }

    public Long getStuId() {
        return this.stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return this.stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return this.stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuScore() {
        return this.stuScore;
    }

    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }

    public Long getForeignKey() {
        return this.foreignKey;
    }

    public void setForeignKey(Long foreignKey) {
        this.foreignKey = foreignKey;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuScore='" + stuScore + '\'' +
                ", foreignKey=" + foreignKey +
                '}';
    }
}
