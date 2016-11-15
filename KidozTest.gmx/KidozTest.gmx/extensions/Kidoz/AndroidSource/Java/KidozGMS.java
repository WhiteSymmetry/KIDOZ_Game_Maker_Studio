package ${YYAndroidPackageName};

import android.util.Log;
import android.app.Activity;
import android.view.ViewGroup;
import com.kidoz.sdk.api.KidozSDK;
import android.widget.AbsoluteLayout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.kidoz.sdk.api.platforms.YoYoGmsBridge;

import ${YYAndroidPackageName}.R;
import ${YYAndroidPackageName}.RunnerActivity;
import com.yoyogames.runner.RunnerJNILib;


/**
 * Created by KIDOZ LTD
 */
public class KidozGMS implements YoYoGmsBridge.IOnGmsEventListener{
	
	private static final int EVENT_OTHER_SOCIAL = 70;
	
	// Panel properties
	public static final int PANEL_TYPE_BOTTOM = 0;
    public static final int PANEL_TYPE_TOP = 1;
    public static final int PANEL_TYPE_LEFT = 2;
    public static final int PANEL_TYPE_RIGHT = 3;
	
	// Handle properties
	public static final int HANDLE_POSITION_START = 0;
    public static final int HANDLE_POSITION_CENTER = 1;
    public static final int HANDLE_POSITION_END = 2;

	// Flexi View position type
    public static final int FLEXI_VIEW_POSITION_TOP_START = 0;
    public static final int FLEXI_VIEW_POSITION_TOP_CENTER = 1;
    public static final int FLEXI_VIEW_POSITION_TOP_END = 2;
    public static final int FLEXI_VIEW_POSITION_MID_START = 3;
    public static final int FLEXI_VIEW_POSITION_MID_CENTER = 4;
    public static final int FLEXI_VIEW_POSITION_MID_END = 5;
    public static final int FLEXI_VIEW_POSITION_BOTTOM_START = 6;
    public static final int FLEXI_VIEW_POSITION_BOTTOM_CENTER = 7;
    public static final int FLEXI_VIEW_POSITION_BOTTOM_END = 8;
	
	
	public static final double ON_FEED_DISMISS_EVENT = 1;
	public static final double ON_FEED_READY_TO_SHOW_EVENT = 2;
	public static final double ON_FEED_READY_EVENT = 3;
	public static final double ON_PANEL_EXPAND_EVENT = 4;
	public static final double ON_PANEL_COLLAPSE_EVENT = 5;
	public static final double ON_PANEL_READY_EVENT = 6;
	public static final double ON_FLEXI_VIEW_READY_EVENT = 7;
	public static final double ON_FLEXI_VIEW_HIDE_EVENT = 8;
	public static final double ON_FLEXI_VIEW_VISIBLE_EVENT = 9;
	public static final double ON_PLAYER_OPEN_EVENT = 10;
	public static final double ON_PLAYER_CLOSE_EVENT = 11;
	public static final double ON_INTERSTITIAL_OPEN_EVENT = 12;
	public static final double ON_INTERSTITIAL_CLOSE_EVENT = 13;
	public static final double ON_INTERSTITIAL_READY_EVENT = 14;
	public static final double ON_INTERSTITIAL_LOAD_FAILED_EVENT = 15;
	public static final double ON_REWARDED_EVENT = 16;
	public static final double ON_REWARDED_VIDEO_STARTED_EVENT = 17;
	
	
	public static final double ON_VIDEO_UNIT_READY_EVENT = 18;
	public static final double ON_VIDEO_UNIT_OPEN_EVENT = 19;
	public static final double ON_VIDEO_UNIT_CLOSE_EVENT = 20;
	
    private YoYoGmsBridge mYoyoBridge;

	/** Initiate sdk and bridge controller*/
    public String initKidoz() {
	 
		if (KidozSDK.isInitialised() == false) {
			KidozSDK.setLoggingEnabled(true);
			// Put your publisher id and security token provided
			String publisherID = RunnerActivity.mYYPrefs.getString("KIDOZ_SDK_PUBLISHER_ID");
			String securityToken = RunnerActivity.mYYPrefs.getString("KIDOZ_SDK_SECURITY_TOKEN");
			
			KidozSDK.initialize(RunnerActivity.CurrentActivity, publisherID,securityToken);
		}
 
	    if(mYoyoBridge == null) {
		   mYoyoBridge = new YoYoGmsBridge(RunnerActivity.CurrentActivity,this);
	    }  	
        return "";
    }
	
	/** Show feed view */
	public String showFeedView() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.showFeedView();	
	    }				 
		return "";
	}
	
	
	/** Dismiss feed view */
	public String dismissFeedView() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.dismissFeedView();		
	    }		 
		return "";
	}
	
	/** Add feed button to view 
	*
	*@param x the x coordinate
	*@param y the y coordinate
	*/
	public String addFeedButtonToView(double x,double y,double isAutoShow) {
		if(mYoyoBridge != null) {
			boolean autoShow = false;
			if((int)isAutoShow > 0) {
				autoShow = true;
			}			
		   mYoyoBridge.addFeedButton((int)x,(int)y,-1,autoShow);				 
	    }			
		return "";
	}
	
	/** Change feed button visibility
	*
	*@param visibility 0 - not visible , > 0 visible
	*/
	public String changeFeedButtonVisibility(double visibility) {
		if(mYoyoBridge != null) {
		    if((int)visibility == 0) {
				mYoyoBridge.changeFeedButtonVisibility(false);	
			}else {
				mYoyoBridge.changeFeedButtonVisibility(true);	
			}
	    }							 
		return "";
	}
	
	
   /** Add Panel to view 
	*
	*@param panelType the panel type (PANEL_TYPE_BOTTOM , PANEL_TYPE_TOP ...)
	*@param handlePosition the handle position (HANDLE_POSITION_START , HANDLE_POSITION_CENTER ...)
	*/
	public String addPanelToView(double panelType,double handlePosition,double isAutoShow) {
		if(mYoyoBridge != null) {
			boolean autoShow = false;
			if((int)isAutoShow > 0) {
				autoShow = true;
			}	
		   mYoyoBridge.addPanelToView((int)panelType,(int)handlePosition,autoShow);	
	    }						 
		return "";
	}

		
	/** 
	* Change Panel visibility
	*
	*@param visibility 0 - not visible , > 0 visible
	*/
	public String changePanelVisibility(double visibility) {
		if(mYoyoBridge != null) {
		    if((int)visibility == 0) {
				mYoyoBridge.changePanelVisibility(false);	
			}else {
				mYoyoBridge.changePanelVisibility(true);	
			}
	    }							 
		return "";
	}
	
	
   /** 
	* Expand panel view
	*/
	public String expandPanel() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.expandPanelView();
	    }					 				 			 
		return "";
	}
	
	/** 
	* Collapse panel view
	*/
	public String collapsePanel() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.collapsePanelView();	
	    }					 			 			 
		return "";
	}
	
	/** 
	* Get is panel expanded
	*
	* @return 0 if panel collpased or 1 otherwise
	*/
	public Double getIsPanelExpanded() {
		double val = 0f;
		if(mYoyoBridge != null) {
		   if(mYoyoBridge.getIsPanelExpanded()) {
			   val = 1f;
		   }else {
			   val = 0f;
		   }
	    }					 			 			 
		return val;
	}

	
	/** 
	* Add Flexi Point View to the screen
	*
	*@param isAutoShow set 1 - for auto show flexi on view initiated , 0 - otherwise
	*@param flexi view inital anchor position(FLEXI_VIEW_POSITION_TOP_START , FLEXI_VIEW_POSITION_TOP_CENTER ...)
	*/
	public String addFlexiView(double isAutoShow,double flexiInitialPosition) {
		if(mYoyoBridge != null) {	 
            boolean autoShow = false;
			if((int)isAutoShow > 0) {
				autoShow = true;
			}			
			mYoyoBridge.addFlexiView(autoShow,(int)flexiInitialPosition);			  
	    }							 
		return "";
	}
	
	/** 
	* Show flexi view
	*/
	public String showFlexiView() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.showFlexiView();			
	    }				 
		return "";
	}
	
	/** 
	* Hide flexi view
	*/
	public String hideFlexiView() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.hideFlexiView();			
	    }				 
		return "";
	}
	
	/** 
	* Hide flexi view
	*
	* @return 1 - for visible and 0 for invisible
	*/
	public Double getIsFlexiViewVisible() {
		double isVisible = 0f;
		if(mYoyoBridge != null) {
		  boolean visible = mYoyoBridge.getIsFlexiViewVisible();		
			if(visible == true) {
				isVisible = 1f;
			}else {
				isVisible = 0f;
			}	  
	    }				 
		return isVisible;
	}
	
	/** 
	* Load interstitial view Ad
	*
	* @param autoShowOnLoad
	*/
	public String loadInterstitialView(double autoShowOnLoad) {
		if(mYoyoBridge != null) {	 
            boolean autoshow = false;
			if((int)autoShowOnLoad > 0) {
				autoshow = true;
			}				
			mYoyoBridge.loadInterstitialAd(autoshow);			  
	    }							 
		return "";
	}
	
	
	/** 
	* Load interstitial view Ad
	*
	* @param autoShowOnLoad
	*/
	public String loadRewardedVideoView(double autoShowOnLoad) {
		if(mYoyoBridge != null) {	 
            boolean autoshow = false;
			if((int)autoShowOnLoad > 0) {
				autoshow = true;
			}				
			mYoyoBridge.loadRewardedAd(autoshow);			  
	    }							 
		return "";
	}
	
	/** 
	* Show interstitial view Ad
	*/
	public String showInterstitial() {
		if(mYoyoBridge != null) {	         			
			mYoyoBridge.showInterstitial();			  
	    }							 
		return "";
	}
	
	/** 
	* Show rewarded vudei add if ready
	*/
	public String showRewardedVideoAd() {
		if(mYoyoBridge != null) {	         			
			mYoyoBridge.showInterstitial();			  
	    }							 
		return "";
	}
	
	
	/** 
	* Show video unit
	*/
	public String showVideoUnit() {
		if(mYoyoBridge != null) {	         			
			mYoyoBridge.showVideoUnit();			  
	    }							 
		return "";
	}
	
	/** 
	* Get is interstitial ad loaded
	*
	* @return 1 - for loaded and 0 for not
	*/
	public Double getIsInterstitialLoaded() {
		double isLoaded = 0f;
		if(mYoyoBridge != null) {
		  boolean loaded = mYoyoBridge.getIsInterstitialLoaded();		
			if(loaded == true) {
				isLoaded = 1f;
			}else {
				isLoaded = 0f;
			}	  
	    }				 
		return isLoaded;
	}
 
	/** 
	* Print toast log 
	*
	@ param text to print
	*/
	public String printToastLog(String text) {
		if(mYoyoBridge != null) {
		   mYoyoBridge.printToastLog(text);
	    }								 
		return "";
	}
	
	
	@Override
    public void onFeedDismissEvent()
    {
        sendAsyncEvent(ON_FEED_DISMISS_EVENT);
    }

    @Override
    public void onFeedReadyToShowEvent()
    {
		sendAsyncEvent(ON_FEED_READY_TO_SHOW_EVENT);
    }

    @Override
    public void onFeedReadyEvent()
    {
		sendAsyncEvent(ON_FEED_READY_EVENT);
    }

    @Override
    public void onPanelCollapseEvent()
    {
		sendAsyncEvent(ON_PANEL_COLLAPSE_EVENT);
    }

    @Override
    public void onPanelExpandEvent()
    {
		sendAsyncEvent(ON_PANEL_EXPAND_EVENT);
    }

    @Override
    public void onPanelReadyEvent()
    {
		sendAsyncEvent(ON_PANEL_READY_EVENT);
    }

    @Override
    public void onFlexiViewReadyEvent()
    {
		sendAsyncEvent(ON_FLEXI_VIEW_READY_EVENT);
    }

    @Override
    public void onFlexiViewHideEvent()
    {
		sendAsyncEvent(ON_FLEXI_VIEW_HIDE_EVENT);
    }

    @Override
    public void onFlexiViewVisibleEvent()
    {
		sendAsyncEvent(ON_FLEXI_VIEW_VISIBLE_EVENT);
    }

    @Override
    public void onPlayerOpenEvent()
    {
		sendAsyncEvent(ON_PLAYER_OPEN_EVENT);
    }

    @Override
    public void onPlayerCloseEvent()
    {
		sendAsyncEvent(ON_PLAYER_CLOSE_EVENT);
    }

    @Override
    public void onInterstitialOpenEvent()
    {
		sendAsyncEvent(ON_INTERSTITIAL_OPEN_EVENT);
    }

    @Override
    public void onInterstitialCloseEvent()
    {
		sendAsyncEvent(ON_INTERSTITIAL_CLOSE_EVENT);
    }

    @Override
    public void onInterstitialReadyEvent()
    {
		sendAsyncEvent(ON_INTERSTITIAL_READY_EVENT);
    }

    @Override
    public void onInterstitialLoadFailedEvent()
    {
		sendAsyncEvent(ON_INTERSTITIAL_LOAD_FAILED_EVENT);
    }

    @Override
    public void onRewardedEvent()
    {
		sendAsyncEvent(ON_REWARDED_EVENT);
    }

    @Override
    public void onRewardedVideoStartedEvent()
    {
		sendAsyncEvent(ON_REWARDED_VIDEO_STARTED_EVENT);
    }

    @Override
    public void onVideoUnitReadyEvent()
    {
		sendAsyncEvent(ON_VIDEO_UNIT_READY_EVENT);
    }

    @Override
    public void onVideoUnitOpenEvent()
    {
		sendAsyncEvent(ON_VIDEO_UNIT_OPEN_EVENT);
    }

    @Override
    public void onVideoUnitCloseEvent()
    {
		sendAsyncEvent(ON_VIDEO_UNIT_CLOSE_EVENT);
    }
	
	/** 
	* Send asynchrinus event to GMS event system 
	*
	@ param text to print
	*/
	private void sendAsyncEvent(double event_type) {
		int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString( dsMapIndex, "type", "kidoz_sdk" );
		RunnerJNILib.DsMapAddDouble( dsMapIndex, "event_type", event_type);
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
	}
}  
