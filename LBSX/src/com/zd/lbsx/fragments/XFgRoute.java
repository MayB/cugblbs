package com.zd.lbsx.fragments;

import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.zd.application.MyApplication;
import com.zd.lbsx.R;

public class XFgRoute extends XFgBase {
	private static BMapManager bMapManager;
	private MapView mapView;
	private MKSearch mkSearch;

	@Override
	protected int setFragmentView() {
		return R.layout.fg_route;
	}

	@Override
	protected void initView(View v) {

	}

	@Override
	protected void initListener() {

	}

	@Override
	protected void initData() {
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		bMapManager = new BMapManager(getActivity().getApplicationContext());
		bMapManager.init(MyApplication.getAK(), null);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mapView = (MapView) getActivity().findViewById(R.id.bmapsView);
		mapView.setBuiltInZoomControls(false);
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		MapController mMapController = mapView.getController();
		// �ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢�� (�� * 1E6)
		GeoPoint point = new GeoPoint((int) (39.997161 * 1E6),
				(int) (116.354123 * 1E6));
		// ���õ�ͼ���ĵ�
		mMapController.setCenter(point);
		// ���õ�ͼzoom����
		mMapController.setZoom(20);
		// ��ʼ��MkSearch
		mkSearch = new MKSearch();
	}
	
	@Override
	public void onDestroy() {
		mapView.destroy();  
        if(bMapManager!=null){  
        	bMapManager.destroy();  
        	bMapManager=null;  
        }  
		super.onDestroy();
	}
	
	@Override
	public void onPause(){  
		mapView.onPause();  
	        if(bMapManager!=null){  
	        	bMapManager.stop();  
	        }  
	        super.onPause();  
	}  
	
	@Override
	public void onResume(){  
		mapView.onResume();  
	        if(bMapManager!=null){  
	        	bMapManager.start();  
	        }  
	       super.onResume();  
	} 

}
