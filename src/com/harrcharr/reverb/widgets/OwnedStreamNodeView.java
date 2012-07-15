package com.harrcharr.reverb.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.harrcharr.pulse.OwnedStreamNode;
import com.harrcharr.reverb.R;

public class OwnedStreamNodeView<Node extends OwnedStreamNode> extends StreamNodeView<Node> {
	private OwnerSpinner mOwnerSelector;
	private TextView mAppName;
	
	public OwnedStreamNodeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public OwnedStreamNodeView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public OwnedStreamNodeView(Context context) {
		super(context);
	}

	protected void inflateViewFromLayout(Context context) {
		View.inflate(context, R.layout.owned_node_view, this);
		
		mOwnerSelector = (OwnerSpinner)this.findViewById(R.id.ownerSelector);
	}
	
	@Override
	protected void prepareViews() {
		super.prepareViews();
		
		mAppName = (TextView) this.findViewById(R.id.nodeApplication);
	}
	
	public void setSelectorAdapter(OwnerStreamsAdapter adapter) {
		mOwnerSelector.setAdapter(adapter);
		Log.d("OwnedStreamNodeView", "Set the selector adapter again");
	}
	
	@Override
	protected void reload() {
		super.reload();
		
		mAppName.setText(mNode.getAppName());
		mOwnerSelector.setSelectionByIndex(mNode.getOwnerIndex());
		//mOwnerName.setText(owner == null ? "Unknown" : owner.getDescriptiveName());
	}
}