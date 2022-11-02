# autostartlib
This library is to enable autostart permission in some android phones that restrict background services of applications until enabled.


<h2>Usage</h2>

For a working implementation, please have a look at the Sample Project

1. Include the library

```
dependencies {
    implementation 'com.github.sagar-nickelfox:autostartlib:LatestVersion'
}
```



2. Add jitpack url in project level gragle

```
allprojects {
    repositories {
        maven { url 'https://www.jitpack.io' }
    }
}
```



3. Start permission activity

```
AutoStartDialog.startPowerSaverIntent(this, "Your message here...")
```
