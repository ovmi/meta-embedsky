require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot for Embedsky E9 board"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=8ff0837b355cf37b6b956f316d010d0c"

PROVIDES += "u-boot"

SRC_URI = "git://github.com/ovmi/u-boot-embedsky.git;protocol=http;branch=${SRCBRANCH}"

SRCREV = "a05e22e9499f47aa41887d877396f062b8532ea9"
SRCBRANCH = "embedsky_e9_support"

PV = "2018.03+git${SRCPV}"

S = "${WORKDIR}/git"
