package edu.xyc.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.xyc.greendao.bean.Student;
import edu.xyc.greendao.database.StudentDao;
import edu.xyc.greendao.utils.GreenDaoManager;

public class BaseOperationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BaseOperationActivity";

    private Button addButton;
    private Button delButton;
    private Button changeButton;
    private Button queryButton;

    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_operation);

        initView();
        initEvent();
    }

    private void initView() {
        addButton = (Button) findViewById(R.id.add_button);
        delButton = (Button) findViewById(R.id.del_button);
        changeButton = (Button) findViewById(R.id.change_button);
        queryButton = (Button) findViewById(R.id.query_button);
    }

    private void initEvent() {
        addButton.setOnClickListener(this);
        delButton.setOnClickListener(this);
        changeButton.setOnClickListener(this);
        queryButton.setOnClickListener(this);

        studentDao = GreenDaoManager.getInstance().getDaoSession().getStudentDao();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.add_button) {
            // 插入或替换一条数据
            studentDao.insertOrReplace(new Student(1L, "001", "贺一宝", "男", "88", 100L));
            studentDao.insertOrReplace(new Student(2L, "002", "贺二宝", "男", "89", 100L));
            studentDao.insertOrReplace(new Student(3L, "003", "贺三宝", "男", "90", 100L));
            studentDao.insertOrReplace(new Student(4L, "004", "贺四宝", "男", "91", 100L));

            // 插入或替换List集合数据
            List<Student> stuList = new ArrayList<>();
            stuList.add(new Student(5L, "005", "贺利权", "男", "88", 100L));
            stuList.add(new Student(6L, "006", "贺利权", "男", "89", 100L));
            stuList.add(new Student(7L, "007", "贺咯权", "男", "90", 100L));
            stuList.add(new Student(8L, "008", "贺来权", "男", "91", 100L));
            studentDao.insertOrReplaceInTx(stuList);
        }

        if (id == R.id.del_button) {
            // 删除指定信息 删除姓名为"贺利权"
            // studentDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权")).buildDelete().executeDeleteWithoutDetachingEntities();

            // 删除指定对象
            // studentDao.delete(new Student(1L, "001", "贺一宝", "男", "88"));

            // 删除所有
            studentDao.deleteAll();
        }

        if (id == R.id.change_button) {

        }

        if (id == R.id.query_button) {
            // 查询指定数据 查询姓名为"贺一宝"的信息
            /*List<Student> studentList1 = studentDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺一宝")).list();
            Log.e(TAG, "studentList1: " + studentList1.toString());*/

            // 查询指定数据 查询成绩为"88"的信息,并且按学员编号升序排列
            /*List<Student> studentList2 = studentDao.queryBuilder().where(StudentDao.Properties.StuScore.eq(88)).orderAsc(StudentDao.Properties.StuNo).list();
            Log.e(TAG, "studentList2: " + studentList2.toString());*/

            // 查询指定数据 查询成绩为"88"的信息,并且按学员编号降序排列
            /*List<Student> studentList3 = studentDao.queryBuilder().where(StudentDao.Properties.StuScore.eq(88)).orderDesc(StudentDao.Properties.StuNo).list();
            Log.e(TAG, "studentList3: " + studentList3.toString());*/

            // 组合查询数据 查询姓名为"贺利权" 并且成绩小于等于90
            /*List<Student> studentList4 = studentDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权"), StudentDao.Properties.StuScore.le("90")).list();
            Log.e(TAG, "studentList4: " + studentList4.toString());*/

            // 查询所有数据
            List<Student> studentList5 = studentDao.loadAll();
            Log.e(TAG, "studentList5: " + studentList5.toString());

            // 查询所有数据 但只返回前三条数据
            /*List<Student> studentList6 = studentDao.queryBuilder().limit(3).list();
            Log.e(TAG, "studentList6: " + studentList6.toString());*/

            // 查询所有数据 但只返回前三条数据 并且跳过前二条数据
            /*List<Student> studentList7 = studentDao.queryBuilder().limit(3).offset(2).list();
            Log.e(TAG, "studentList7: " + studentList7.toString());*/

            // 根据主键查询数据 查询主键为1L的数据
            /*Student student = studentDao.load(1L);
            Log.e(TAG, "student: " + student);*/

            // 查询所有信息总条数
            /*int stuSumCount = studentDao.queryBuilder().list().size();
            Log.e(TAG, "stuSumCount: " + stuSumCount);*/
        }
    }
}
