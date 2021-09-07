package com.example.chipaway.models

import java.io.Serializable

data class Category (
    var categoryId: Int,
    var categoryName: String,
    var imagePath: String
) : Serializable {
    companion object {
        val CATEGORIE_NAMES = arrayOf(
            "Smartphones",
            "Headphones",
            "External harddrives",
            "Laptops"
        )

        val CATEGORIE_IMAGES = arrayOf(
           "https://images2.persgroep.net/rcs/Ayq1LDbVZNtMCPrjkNY6rortkbE/diocontent/157847670/_fitwidth/763?appId=2dc96dd3f167e919913d808324cbfeb2&quality=0.8",
            "https://static.bhphoto.com/images/images1000x1000/1504613219_1360331.jpg",
            "https://s.s-bol.com/imgbase0/imagebase3/large/FC/6/6/7/4/9200000102214766.jpg",
            "https://www02.cp-static.com/objects/high_pic/5/527/1351081811_notebooks-laptops-apple-macbook-pro-16-i7-26ghz-512gb-mvvj2n-a.jpg"
        )
    }

}