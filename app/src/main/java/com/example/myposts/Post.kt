package com.example.myposts

data class Post(
    var userId: Int,
    var id:Int,
    var title:String,
    var body:String)

data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body:String,
)
//fun compareIds(post1:Post, post2: Post):Post{
//    if(post1.id >post2.id){
//        return post1
//    }
//    return post2
//}

