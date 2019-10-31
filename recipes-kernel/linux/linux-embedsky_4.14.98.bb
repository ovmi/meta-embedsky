SUMMARY = "Linux kernel for Embedsky E9 board"

include recipes-kernel/linux/linux-imx.inc
DEPENDS += "lzop-native bc-native"

#PV_append = "+git${SRCPV}"

SRCBRANCH = "embedsky_e9_support"
SRCREV = "7e0120fc4f8bc52cabf568b678cc4188a04a91e2"
SRC_URI = "git://github.com/ovmi/linux-embedsky.git;protocol=git;branch=${SRCBRANCH} \
	   file://defconfig \
	  "

#COMPATIBLE_MACHINE = "mx6"
