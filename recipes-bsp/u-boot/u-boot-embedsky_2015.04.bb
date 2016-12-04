require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot for Embedsky E9 board."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(mx6|vf|imx6q-embedsky)"

DEPENDS_mxs += "elftosb-native openssl-native"

PROVIDES += "u-boot"

PV = "v2015.04+git${SRCPV}"

SRCREV = "3a3330d13b01afd58e823ef9066b9942995db346"
SRCBRANCH ??= "master"
SRC_URI = "git://git@github.com/ovmi/imx6qembedsky-uboot-2015.04.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
