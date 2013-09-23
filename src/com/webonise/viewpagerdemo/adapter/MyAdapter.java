package com.webonise.viewpagerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.webonise.viewpagerdemo.DetailFragment;
import com.webonise.viewpagerdemo.ImageFragment;
import com.webonise.viewpagerdemo.R;

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