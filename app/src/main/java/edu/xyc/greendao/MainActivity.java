package edu.xyc.greendao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 单条数据
 * .insert( )
 * .insertOrReplace( );
 * <p>
 * 多条数据
 * .insertInTx( );
 * .insertOrReplaceInTx( );
 * <p>
 * 查询
 * 单个条件
 * where()
 * whereOr()
 * 多个条件
 * where(,,)
 * whereOr(,,)
 * 降序 orderDesc()
 * 升序 orderAsc()
 * 当页限制个数 limit()
 * 根据key查询 .load(key)
 * 全部 .loadAll() 或者.queryBuilder().list()
 * <p>
 * 修改
 * 单条 .update( )
 * 多条 .updateInTx( )
 * <p>
 * 删除
 * 单条 .delete( )
 * 多条 .deleteInTx( )
 * 全部 .deleteAll()
 */

/**
 * http://blog.csdn.net/xh870189248/article/details/78004479
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button baseOperation;
    private Button relevanceOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        baseOperation = (Button) findViewById(R.id.baseOperation);
        relevanceOperation = (Button) findViewById(R.id.relevanceOperation);
    }

    private void initEvent() {
        baseOperation.setOnClickListener(this);
        relevanceOperation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.baseOperation) {
            Intent intent = new Intent(this, BaseOperationActivity.class);
            startActivity(intent);
        }

        if (id == R.id.relevanceOperation) {
            Intent intent = new Intent(this, RelevanceOperationActivity.class);
            startActivity(intent);
        }
    }
}
