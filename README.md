# Amazfit Springboard Music
A better music control for your phone on the Amazfit Pace

Whilst the Pace comes with a built in music control option, it's cramped and buggy (and appears as a notification). This custom homescreen page aims to solve that by providing a cleaner control interface

## Screenshots
<img src="https://github.com/KieronQuinn/AmazfitSpringboardMusic/raw/master/Images/screen_1.png" width="250"/><img src="https://github.com/KieronQuinn/AmazfitSpringboardMusic/raw/master/Images/screen_2.png" width="250"/>

**Left**: Music playing, progress is shown around the outside. Long press on the pause button opens volume control

**Right**: Volume control, volume level is shown around the outside. Either waiting 5 seconds or long pressing the pause button returns to the normal control screen

## Download
Download the latest release from the [releases page](https://github.com/KieronQuinn/AmazfitSpringboardMusic/releases) or the XDA page

## Installation
Install it via ADB:

`adb install -r SpringboardMusic-1.0.apk`

Reboot your watch

## Uninstallation
`adb uninstall com.kieronquinn.app.springboardmusic`

## Note
Whilst the app tries to get the playing music as effectively as possible, it sometimes take pausing/playing a few times to pick it up. I'm investigating why this is

## Moving the page/Disabling the page
Want to move the page or disable it from the launcher and have it appear as app in the drawer instead? Use [Springboard Settings](https://github.com/KieronQuinn/AmazfitSpringboardSettings)

## How it's done
In terms of the method for adding a custom home screen (springboard) page, it's all detailed [here](https://github.com/KieronQuinn/AmazfitSpringboardPluginExample). The method for listening for and controlling music is in the code, but basically it uses imported code from the Launcher JAR (extracted code from the launcher), to attach to and use the launcher service in the same way the stock notification system uses
