Android-View-Pager-Demo
=======================
This is a demonstration for creating a page view in an application.<br/>
The steps to follow are very simple and easy to understand .<br/>
The sample code can be downloaded from this git id :<br/>
<br/>
______________________________________________________________________________
______________________________________________________________________________
Step 1  : In the main layout “activity_main.xml ”



 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <android.support.v4.view.ViewPager
        android:id="@+id/pager"
        android:layout_height="match_parent"
        android:layout_width="match_parent" />

</RelativeLayout>

______________________________________________________________________________
______________________________________________________________________________
Step 2: Create the next views .ie. first page , second page and third page.<br/>
In my case <br/>
first page has a text view ,<br/>
second page has image view and <br/>
third page has a image view.<br/>

Layout for first page is  “details.xml”

______________________________________________________________________________
______________________________________________________________________________


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >
    <TextView android:id="@+id/textViewDetails"
        android:layout_height="match_parent"
        android:layout_width="wrap_content"
        android:layout_gravity="center_horizontal|center_vertical"
        android:layout_marginTop="20dip"
        android:text="Large Text"
       android:textAppearance="?android:attr/textAppearanceLarge"
       android:textSize="25dip"/>

</LinearLayout>

______________________________________________________________________________
______________________________________________________________________________

The layout for the second and third page is same so it is : “image_layout.xml”
______________________________________________________________________________
______________________________________________________________________________

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/ic_launcher" >
    </ImageView>

</LinearLayout>


______________________________________________________________________________
______________________________________________________________________________

Step 3: Creating the fragments for the pages: <br/>
<br/>
Since we have two kind of pages so we have to create two different java files :
First file is  “DetialFragment.java”<br/>

______________________________________________________________________________
______________________________________________________________________________
package com.webonise.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
	private static final String TAG = "DetailFragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Detail Fragment activity");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.details, container, false);
		TextView textView = (TextView) view.findViewById(R.id.textViewDetails);
		textView.setText("Sample Project");
		return view;
	}

}


______________________________________________________________________________
______________________________________________________________________________

Second one is “ImageFragment.java”
______________________________________________________________________________
______________________________________________________________________________

package com.webonise.viewpagerdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

@SuppressLint("ValidFragment")
public class ImageFragment extends Fragment {

	private int imageResourceId = 0;

	public ImageFragment(int imageResourceId) {
		this.imageResourceId = imageResourceId;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.image_layout, container, false);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
		imageView.setImageResource(imageResourceId);
		return view;
	}

}

______________________________________________________________________________
______________________________________________________________________________

The main class will be  : “MainActivity.java”
______________________________________________________________________________
______________________________________________________________________________
package com.webonise.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.webonise.viewpagerdemo.adapter.MyAdapter;

public class MainActivity extends FragmentActivity {
	public MyAdapter mAdapter;
	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
	}
}

______________________________________________________________________________
______________________________________________________________________________

The last is creating the adapter for the fragments : “MyAdapter.java”
______________________________________________________________________________
______________________________________________________________________________

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

DONE.


