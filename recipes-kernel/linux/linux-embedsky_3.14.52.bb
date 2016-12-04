# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Embedsky E9 Mini PC board"

DEPENDS += "lzop-native bc-native"

KERNEL_SRC ?= "git://git.freescale.com/imx/linux-2.6-imx.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
           file://imx6q-embedsky.dts \
"

LOCALVERSION = "-1.1.0_ga+yocto"
SRCBRANCH = "imx_3.14.52_1.1.0_ga"
SRCREV = "5f6f0a50e6039370078369ddf380179d59024789"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-embedsky)"
