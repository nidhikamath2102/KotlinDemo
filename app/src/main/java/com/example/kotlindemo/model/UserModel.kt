package com.example.kotlindemo.model

class UserModel(var username: String? = "no name", var contact: String?){
    //?->while Data parsing null pointer exception handling
    //?? = "no name" - to set value by default
}


/*
class UserModel(var name_of_song: String?, var artist_name: String?, var image_url: String?, var song_url: String?){
    //?->while Data parsing null pointer exception handling
    //?? = "5" - to set value by default
}*/
