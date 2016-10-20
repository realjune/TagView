package com.niceapp.lib.tagview;

import java.util.ArrayList;
import java.util.List;
import com.niceapp.lib.tagview.widget.Tag;
import com.niceapp.lib.tagview.widget.TagListView;
import com.niceapp.lib.tagview.widget.TagView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private TagListView mTagListView;
	private final List<Tag> mTags = new ArrayList<Tag>();
	private final String[] titles = { "��ȫ�ر�", "����asdasddsss��", "��ĸѧ", "�ϰ���ر�", 
			"360�ֻ���ʿ", "QQ","���뷨", "΢��", "����Ӧ��", "AndevUI", "Ģ����" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_tag_activity);

		mTagListView = (TagListView) findViewById(R.id.tagview);
		setUpData();
		mTagListView.setTags(mTags,true);
		
		mTagListView.setOnTagCheckedChangedListener(new TagListView.OnTagCheckedChangedListener() {
			
			@Override
			public void onTagCheckedChanged(TagView tagView, Tag tag) {
				tag.isChecked();
				tagView.isChecked();
				Log.e("dddd", "onTagCheckedChanged tag "+tag.isChecked()+"����view "+tagView.isChecked());
			}
		});
		mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
			
			@Override
			public void onTagClick(TagView tagView, Tag tag) {
				// TODO Auto-generated method stub
				tag.isChecked();
				tagView.isChecked();
				Log.e("dddd", "onTagClick tag "+tag.isChecked()+"����view "+tagView.isChecked());
			}
		});
	}

	private void setUpData() {
		for (int i = 0; i < 10; i++) {
			Tag tag = new Tag();
			tag.setId(i);
			tag.setChecked(i<5);
			tag.setTitle(titles[i]);
			mTags.add(tag);
		}
	}
}
