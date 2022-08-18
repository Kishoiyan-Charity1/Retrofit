package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentListItemBinding
import com.example.myposts.databinding.RetrofitPostsListsBinding

class CommentsRvAdapter(var commentList: List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var bindingView = CommentListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(bindingView)
    }


    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentItem = commentList.get(position)
        with(holder.bindingView) {
            holder.binding.tvPostId.text= currentItem.postId
            holder.binding.tvId.text= currentItem.id
            holder.binding.tvName2.text=currentItem.name
            holder.binding.tvEmail.text=currentItem.email
            holder.binding.tvBody2.text= currentItem.body


//            userId.text = currentItem.userId.toString()
//            tvTittle.text = currentItem.title
//            tvBody.text = currentItem.body
//            val context=holder.itemView.context
//            holder.bindingView.cvCons.setOnClickListener(){
//                val intent = Intent(context, CommentActivity::class.java)
//                intent.putExtra("POST_ID", currentItem.id)
//                context.startActivity(intent)
            }
        }

    override fun getItemCount(): Int {
     return commentList.size
    }

}


class CommentsViewHolder(var bindingView: CommentListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root) {


}






