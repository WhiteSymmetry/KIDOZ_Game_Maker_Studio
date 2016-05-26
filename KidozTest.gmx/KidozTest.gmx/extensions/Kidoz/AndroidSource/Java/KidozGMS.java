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


/**
 * Created by Gameover on 21.12.2015.
 */
public class KidozGMS {
	
	// Panel properties
	public static final int PANEL_TYPE_BOTTOM = 0;
    public static final int PANEL_TYPE_TOP = 1;
    public static final int PANEL_TYPE_LEFT = 2;
    public static final int PANEL_TYPE_RIGHT = 3;
	
	// Handle properties
	public static final int HANDLE_POSITION_START = 0;
    public static final int HANDLE_POSITION_CENTER = 1;
    public static final int HANDLE_POSITION_END = 2;

	// Banner properties
    public static final int BANNER_POSITION_TOP = 0;
    public static final int BANNER_POSITION_BOTTOM = 1;
    public static final int BANNER_POSITION_TOP_LEFT = 2;
    public static final int BANNER_POSITION_TOP_RIGHT = 3;
    public static final int BANNER_POSITION_BOTTOM_LEFT = 4;
    public static final int BANNER_POSITION_BOTTOM_RIGHT = 5;
	
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
	
    private YoYoGmsBridge mYoyoBridge;

	/** Initiate sdk and bridge controller*/
    public String initKidoz() {
	 
		if (KidozSDK.isInitialised() == false) {
			KidozSDK.setLoggingEnabled(true);
			// Put your publisher id and security token provided
			// ( publisher id - 8 IS FOR TESTING PURPOSES ONLY )
			KidozSDK.initialize(RunnerActivity.CurrentActivity, "8","QVBIh5K3tr1AxO4A1d4ZWx1YAe5567os");
		}
 
	    if(mYoyoBridge == null) {
		   mYoyoBridge = new YoYoGmsBridge(RunnerActivity.CurrentActivity);
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
	
	/** Add Panel to view with additional parameters
	*
	*@param panelType the panel type (PANEL_TYPE_BOTTOM , PANEL_TYPE_TOP ...)
	*@param handlePosition the handle position (HANDLE_POSITION_START , HANDLE_POSITION_CENTER ...)
	*@param startDelay      delay in seconds before automatic invocation of panel expand , pass -1 to  disable
    *@param showPeriod      period in seconds to show the panel before closing it, pass -1 to  disable
	*/
	public String addPanelToViewExtended(double panelType,double handlePosition,double isAutoShow,double startDelay,double showPeriod) {
		if(mYoyoBridge != null) {
			boolean autoShow = false;
			if((int)isAutoShow > 0) {
				autoShow = true;
			}	
		   mYoyoBridge.addPanelToView((int)panelType,(int)handlePosition,autoShow,(float)startDelay,(float)showPeriod);	
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
	* Set / Change panel view color 
	*
	* @param colorHex color in hexa (#ffffff)
	*/
	public String setPanelViewColor(String colorHex) {
		if(mYoyoBridge != null) {
			mYoyoBridge.setPanelViewColor(colorHex);		
	    }					 		 			 
		return "";
	}
	 
	
	/** 
	* Add banner to view 
	*
	* @param bannerPosition the banner position (BANNER_POSITION_TOP , BANNER_POSITION_BOTTOM ...)
	*/
	public String addBannerToView(double bannerPosition,double isAutoShow) {
		if(mYoyoBridge != null) {
			boolean autoShow = false;
			if((int)isAutoShow > 0) {
				autoShow = true;
			}	
			mYoyoBridge.addBannerToView((int)bannerPosition,autoShow);	
	    }						 
		return "";
	}
	
	/** 
	* Change banner position
	*
	* @param bannerPosition the banner position (BANNER_POSITION_TOP , BANNER_POSITION_BOTTOM ...)
	*/
	public String changeBannerPosition(double bannerPosition) {
		if(mYoyoBridge != null) {
		  mYoyoBridge.changeBannerPosition((int)bannerPosition);	
	    }						 
		return "";
	}
	
	
	/** 
	* Show Banner
	*/
	public String showBanner() {
		if(mYoyoBridge != null) {
			mYoyoBridge.showBanner();	
	    }						 
		return "";
	}
	
	
	/** 
	* Hide Banner
	*/
	public String hideBanner() {
		if(mYoyoBridge != null) {
		   mYoyoBridge.hideBanner();			
	    }				 
		return "";
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
	* Set flexi view can be dragabale by user
	*
	* @param isDraggable
	*/
	public String setFlexiViewDraggable(double isDraggable) {
		if(mYoyoBridge != null) {	 
            boolean draggable = false;
			if((int)isDraggable > 0) {
				draggable = true;
			}			
			mYoyoBridge.setFlexiViewDraggable(draggable);			  
	    }							 
		return "";
	}
	
	/** 
	* Set flexi view can be closed by user
	*
	* @param isClosable
	*/
	public String setFlexiViewClosable(double isClosable) {
		if(mYoyoBridge != null) {	 
            boolean closable = false;
			if((int)isClosable > 0) {
				closable = true;
			}				
			mYoyoBridge.setFlexiViewClosable(closable);			  
	    }							 
		return "";
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
	* Show interstitial view Ad
	*/
	public String showInterstitial() {
		if(mYoyoBridge != null) {	         			
			mYoyoBridge.showInterstitial();			  
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
}  
