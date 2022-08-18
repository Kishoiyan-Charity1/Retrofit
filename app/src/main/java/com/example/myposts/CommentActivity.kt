package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myposts.databinding.ActivityCommentBinding
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId= 0
    var commentId= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
        fetchComments()

    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun obtainCommentId(){
        commentId=intent.extras?.getInt("COMMENT_ID")?:0
    }

    fun fetchPost(){
        var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        var request= apiClient.getPostById(postId)

        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>){
                var post = response.body()
                if (post!=null){
                    binding.tvPostTitle.text=post.title
                    binding.tvPostBody.text=post.body

                }
            }
            override fun onFailure(call: Call<Post>, t:Throwable){

            }
        })
    }
    fun fetchComments(){
        var apiClient= ApiClient.buildApiClient((ApiInterface::class.java))
        var request= apiClient.getCommentById(commentId)

        request.enqueue(object: Callback<Comment>) {
            override fun onResponse(call: Call<Post>, response: Response<Comment>){
                var comment=response.body()
                if (comment!=null){
                    binding.tvId.text=comment.id
                }
            }
        }
    }
}