<a href="url"><img src="https://github.com/Kidoz-SDK/Kidoz_Android_SDK_Example/blob/master/graphics/App%20icon.png" align="left" height="72" width="72" ></a><br>
[<img src="https://kidoz-cdn.s3.amazonaws.com/wordpress/kidoz_small.gif" width="533px" height="300px">](https://www.youtube.com/watch?v=-ljFjRn7jeM)

# KIDOZ GMS Android Extension + Example
=================================
**KIDOZ SDK Android Extension For Game Maker Studio, compatible with Android 4.0 (API level 14) and above.** 

*Updated to KIDOZ SDK version 0.5.9*
 
Inludes GMS KIDOZ SDK Android Extension library + Sample project and example of the [KIDOZ](http://www.kidoz.net) SDK integration for Game Maker Studio android extension.

The example application contains the following creative tools:
* KIDOZ Feed view (+Family) content tool - the `FeedView`
* KIDOZ Panel view (+Family) content tool - the `PanelView`
* KIDOZ Flexi Point view content tool - the `FlexiView`
* KIDOZ Interstitial View content tool - the `KidozInterstitial`

### Setup
When initializing the KIDOZ SDK Extension, please make sure to use your given `publisherID` and `securityToken`. To receive the credentials please sign up [HERE](http://accounts.kidoz.net/publishers/register?utm_source=&utm_content=&utm_campaign=&utm_medium=).
</br>
 
Change the values of `KIDOZ_SDK_PUBLISHER_ID` and `KIDOZ_SDK_SECURITY_TOKEN` Constants in the Kidoz/KidozGMS extension to your `publisherID` and `securityToken`. ( The default value of `publisherId = 8` is for debug purposes only!)
<img src="https://s3.amazonaws.com/kidoz-cdn/sdk/GitHub_Tutorial_Img/gms_tutorial_1.JPG" width="230px" height="260px">


### Important !
To avoid compilation errors, the folowing lines need to be added to GMS runner project build.gradle file (via ...\runner\ProjectFiles\build.gradle)

```groovy
android {
  ...

  lintOptions {
        abortOnError false
        warning 'InvalidPackage'
  }
    
  ...
    
 }
``` 
