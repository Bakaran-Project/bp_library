package com.bp.library.ui.pages.onboard.component

import com.bp.library.R

sealed class ItemOnboard(
    var image:Int,
    var title:String,
    var subtitle:String
){
    object Onboard1:ItemOnboard(
        image = R.drawable.onboard1,
        title = "Pinjam buku perpustakaan lebih mudaj dan fleksibel",
        subtitle = "Lorem ipsum dolor sit amet, consectus adipsting eit. Cros nisl nunc mouris sed fementum figikal dul."
    )

    object Onboard2:ItemOnboard(
        image = R.drawable.onboard2,
        title = "Masuk perpustkaan dengan beberapa klik",
        subtitle = "Lorem ipsum dolor sit amet, consectus adipsting eit. Cros nisl nunc mouris sed fementum figikal dul."
    )

    object Onboard3:ItemOnboard(
        image = R.drawable.onboard3,
        title = "Akses buku-buku perpustakaan sekarang!",
        subtitle = ""
    )
}