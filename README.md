<a href="url"><img src="https://github.com/Kidoz-SDK/Kidoz_Android_SDK_Example/blob/master/graphics/App%20icon.png" align="left" height="72" width="72" ></a><br>
[<img src="https://kidoz-cdn.s3.amazonaws.com/wordpress/kidoz_small.gif" width="533px" height="300px">](https://www.youtube.com/watch?v=-ljFjRn7jeM)

# KIDOZ GMS Android Extension + Example
=================================
**IMPORTANT!!! KIDOZ SDK Android Extension For Game Maker Studio, compatible with Android 4.0 (API level 14) and above.** 

*Updated to KIDOZ SDK version 0.6.0*
 
Inludes GMS KIDOZ SDK Android Extension library + Sample project and example of the [KIDOZ](http://www.kidoz.net) SDK integration for Game Maker Studio android extension.

The example application contains the following creative tools:
* KIDOZ Feed Button content tool - the `FeedView`
* KIDOZ Feed View content tool - the `FeedView`
* KIDOZ Panel View content tool - the `PanelView`
* KIDOZ Flexi Point content tool - the `FlexiView`
* KIDOZ Interstitial/Rewarded Video content tool - the `KidozInterstitial`

## Setup
When initializing the KIDOZ SDK Extension, please make sure to use your given `publisherID` and `securityToken`. To receive the credentials please sign up [HERE](http://accounts.kidoz.net/publishers/register?utm_source=&utm_content=&utm_campaign=&utm_medium=).
</br>
 
Change the values of `KIDOZ_SDK_PUBLISHER_ID` and `KIDOZ_SDK_SECURITY_TOKEN` Constants in the Kidoz/KidozGMS extension to your `publisherID` and `securityToken`. ( The default value of `publisherId = 8` is for debug purposes only!)
<img src="https://s3.amazonaws.com/kidoz-cdn/sdk/GitHub_Tutorial_Img/gms_tutorial_1.JPG" width="230px" height="260px">

## Add Kidoz SDK event listener
To add kidoz sdk event listener use the `The Asynchronous Event` system of Game Maker Studio  [TUTORIAL](https://docs.yoyogames.com/source/dadiospice/000_using%20gamemaker/events/async%20event.html).

Add `Social Event`  [TUTORIAL](https://docs.yoyogames.com/source/dadiospice/001_advanced%20use/more%20about%20async%20events/social.html)  to your object, the KIDOZ SDK event will return value `"kidoz_sdk"` in the parameter `type` of `the async_load`.

 - Following events are available:
 
ON_FEED_DISMISS_EVENT<br>
ON_FEED_READY_TO_SHOW_EVENT<br>
ON_FEED_READY_EVENT<br>
ON_PANEL_EXPAND_EVENT<br>
ON_PANEL_COLLAPSE_EVENT<br>
ON_PANEL_READY_EVENT<br>
ON_FLEXI_VIEW_READY_EVENT<br>
ON_FLEXI_VIEW_HIDE_EVENT<br>
ON_FLEXI_VIEW_VISIBLE_EVENT<br>
ON_PLAYER_OPEN_EVENT<br>
ON_PLAYER_CLOSE_EVENT<br>
ON_INTERSTITIAL_OPEN_EVENT<br>
ON_INTERSTITIAL_CLOSE_EVENT<br>
ON_INTERSTITIAL_READY_EVENT<br>
ON_INTERSTITIAL_LOAD_FAILED_EVENT<br>
ON_REWARDED_EVENT<br>
ON_REWARDED_VIDEO_STARTED_EVENT<br>

## Example of usage
Add this code to your object

```groovy
var type = async_load[? "type"];
if (type == "kidoz_sdk")
{
  var eventType = async_load[? "event_type"];
  
  if(eventType == ON_PANEL_EXPAND_EVENT) 
  {
        Kidoz_print_toast_log("Panel EXPANDED Event");
  }
  else if(eventType == ON_PANEL_COLLAPSE_EVENT)
  {
        Kidoz_print_toast_log("Panel COLLAPSED Event");
  }
  else if(eventType == ON_PANEL_READY_EVENT)
  {
        Kidoz_print_toast_log("PANEL READY Event");
  }
  else if(eventType == ON_PLAYER_OPEN_EVENT)
  {
        Kidoz_print_toast_log("PLAER OPEN Event");
  }
  else if(eventType == ON_PLAYER_CLOSE_EVENT)
  {
        Kidoz_print_toast_log("PLAER CLOSE Event");
  }
  //Additional events can be added to control the sdk actions
  //else if(eventType == ON_FLEXI_VIEW_READY_EVENT)
  //{
  //      
  //}
}
``` 

For any question or assistance, please contact us at SDK@kidoz.net.
</br>

License
--------

    Copyright 2015 KIDOZ, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 
