# meta-embedsky
Yocto Project for iMX6 Embedsky E9 Mini PC board
 
# How to compile & use software for embedsky 
 
Here you will find some basic info about how to start with YOCTO and Embedsky board. If you follow the steps below, you should be able to compile the source code. 
 
 
### 1) Install the repo utility
    mkdir ~/bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
    chmod a+x ~/bin/repo
 
### 2) Get the YOCTO project
    cd
    mkdir fsl-community-bsp
    cd fsl-community-bsp
    PATH=${PATH}:~/bin
    repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b jethro
 
### 3) Add embedsky support - create manifest 
    cd ~/fsl-community-bsp/
    mkdir -pv .repo/local_manifests/
 
Copy and paste this into your Linux host machine 
 
    cat > .repo/local_manifests/imx6embedsky.xml << EOF
    <?xml version="1.0" encoding="UTF-8"?>
    <manifest>
     
      <remote fetch="git://github.com/ovmi" name="tbd"/>
     
      <project remote="embedded" revision="jethro" name="meta-embedsky" path="sources/meta-embedsky">
        <copyfile src="setup-embedsky.sh" dest="setup-embedsky.sh"/>
      </project>
    </manifest>
    EOF
 
### 4) Sync repositories
    repo sync
 
### 5) Add embedsky meta layer into BSP
    source setup-embedsky.sh
 
# Building images
    cd ~/fsl-community-bsp/
 
### Currently Supported machines <machine name>
Here is a list of 'machine names' which you can use to build embedsky images. Use the 'machine name' based on the board you have:
 
 
    imx6q-embedsky
     
### Setup and Build Console image
    MACHINE=<machine name> source setup-environment build-embedsky
    MACHINE=<machine name> bitbake core-image-base
 
Example:
 
 
    MACHINE=imx6q-embedsky source setup-environment build-embedsky
    MACHINE=imx6q-embedsky bitbake core-image-base
 
### Setup and Build Toolchain    
    MACHINE=<machine name> bitbake core-image-base -c populate_sdk
     
### Setup and Build FSL GUI image
    MACHINE=<machine name> source fsl-setup-release.sh -b build-x11 -e x11
    MACHINE=<machine name> bitbake fsl-image-gui
 
# Creating SD card
Output directories and file names depend on what you build. Following example is based on running 'bitbake core-image-base':
 
 
    umount /dev/sdb?
    gunzip -c ~/fsl-community-bsp/build-embedsky/tmp/deploy/images/imx6q-embedsky/core-image-base-imx6q-embedsky.sdcard.gz > ~/fsl-community-bsp/build-embedsky/tmp/deploy/images/imx6q-embedsky/core-image-base-imx6q-embedsky.sdcard
    sudo dd if=~/fsl-community-bsp/build-embedsky/tmp/deploy/images/imx6q-embedsky/core-image-base-imx6q-embedsky.sdcard of=/dev/sdb
    umount /dev/sdb?
     
