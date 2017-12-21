package com.darren.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.darren.recyclerview.Bean.Music;
import com.darren.recyclerview.Decoration.SpacesItemDecoration;
import com.darren.recyclerview.Listener.OnItemClickListener;
import com.darren.recyclerview.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView recyclerView;
    private static List<Music> mList;
    private GridLayoutManager gridLayoutManager;
    private MyAdapter myAdapter;

    /**
     * 模拟本地数据
     * */
    static {
        mList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.fly;
            music.title = "推荐歌单";
            mList.add(music);
        }
        for (int i = 0; i < 6; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_THREE;
            music.imageId = R.drawable.fly;
            music.title = "每天都好穷，没钱买衣服";
            mList.add(music);
        }
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.fly;
            music.title = "推荐MV";
            mList.add(music);
        }
        for (int i = 0; i < 4; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_TWO;
            music.imageId = R.drawable.fly;
            music.title = "我想要一份工作，每天都想，做梦都想";
            mList.add(music);
        }
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.fly;
            music.title = "最新歌曲";
            mList.add(music);
        }
        for (int i = 0; i < 6; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_THREE;
            music.imageId = R.drawable.fly;
            music.title = "[BGM]世界上另一个我";
            mList.add(music);
        }
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.fly;
            music.title = "精选专栏";
            mList.add(music);
        }
        for (int i = 0; i < 4; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_LIST;
            music.imageId = R.drawable.fly;
            music.title = "我是一个小android，小呀小android";
            mList.add(music);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.ry);
        gridLayoutManager = new GridLayoutManager(this, 6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mList.get(position).type;
                if (type == Music.TYPE.TYPE_GRID_THREE) {
                    return 2;
                } else if (type == Music.TYPE.TYPE_GRID_TWO) {
                    return 3;
                } else if (type == Music.TYPE.TYPE_LIST) {
                    return 6;
                } else if (type == Music.TYPE.TYPE_TITLE) {
                    return 6;
                }
                return 0;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(4));
        // 填充数据
        myAdapter = new MyAdapter(this, mList);
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void OnItemClick(int position) {
        String title = mList.get(position).title;
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }
}
