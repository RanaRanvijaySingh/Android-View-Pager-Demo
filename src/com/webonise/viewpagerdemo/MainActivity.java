package com.webonise.viewpagerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {
	private MyAdapter mAdapter;
	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager supportFragmentManager) {
			super(supportFragmentManager);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new DetailFragment();
			case 1:
				return new ImageFragment(R.drawable.ic_launcher);
			case 2:
				return new ImageFragment(R.drawable.ic_launcher);
			default:
				return null;
			}
		}

		@Override
		public int getCount() {
			return 3;
		}

	}
}