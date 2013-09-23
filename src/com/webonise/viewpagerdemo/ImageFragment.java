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
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
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
