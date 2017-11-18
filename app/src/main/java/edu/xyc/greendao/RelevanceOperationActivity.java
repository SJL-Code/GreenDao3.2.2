package edu.xyc.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;

import edu.xyc.greendao.bean.Student;
import edu.xyc.greendao.bean.Teacher;
import edu.xyc.greendao.database.DaoSession;
import edu.xyc.greendao.utils.GreenDaoManager;

/**
 * http://www.jianshu.com/p/d61983df2341
 */
public class RelevanceOperationActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "RelevanceOperationActivity";

    private Button addTeacher;
    private Button addStudent;
    private Button query;

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relevance_operation);

        initView();
        initEvent();
    }

    private void initView() {
        addTeacher = (Button) findViewById(R.id.addTeacher);
        addStudent = (Button) findViewById(R.id.addStudent);
        query = (Button) findViewById(R.id.query);
    }

    private void initEvent() {
        addTeacher.setOnClickListener(this);
        addStudent.setOnClickListener(this);
        query.setOnClickListener(this);

        daoSession = GreenDaoManager.getInstance().getDaoSession();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // 添加老师
        if (id == R.id.addTeacher) {
            Teacher teacher = new Teacher(100L, "王芳");
            daoSession.getTeacherDao().insertOrReplace(teacher);
        }

        // 添加学生
        if (id == R.id.addStudent) {
            List<Teacher> teacherList = daoSession.getTeacherDao().loadAll();
            if (teacherList != null && teacherList.size() > 0) {
                Student student = new Student();
                student.setStuName("小明");
                student.setForeignKey(teacherList.get(0).getTeaId());

                daoSession.getStudentDao().insert(student);
            }
        }

        if (id == R.id.query) {
            // 所以如果entities更新过,需要去调用daoSession.clear()方法清除缓存后才能查到最新值,否则查询到的将还是保存在内存中的值。
            daoSession.clear();
            List<Teacher> teacherList = daoSession.getTeacherDao().loadAll();
            if (teacherList != null && teacherList.size() > 0) {
                List<Student> studentList = teacherList.get(0).getStudentList();
                Log.e(TAG, "老师列表: " + new Gson().toJson(teacherList));
                Log.e(TAG, "学生列表: " + new Gson().toJson(studentList));
            } else {
                Log.e(TAG, "查询老师数据为空");
            }
        }
    }
}
