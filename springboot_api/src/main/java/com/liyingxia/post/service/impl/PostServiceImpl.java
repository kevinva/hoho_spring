package com.liyingxia.post.service.impl;

import com.liyingxia.post.dao.PostDao;
import com.liyingxia.post.entity.Post;
import com.liyingxia.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service  // hoho_todo
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getPostList() {
        return postDao.queryPost();
    }

    @Override
    public Post getPostById(int postId) {
        return postDao.queryPostById(postId);
    }

    @Override
    public boolean addPost(Post post) {
        if ((post.getPostTitle() != null &&
                !"".equals(post.getPostTitle())) &&
                post.getPostContent() != null &&
                !"".equals(post.getPostContent()) &&
                post.getPriority() != null &&
                !"".equals(post.getPriority()) &&
                post.getPostType() != null &&
                !"".equals(post.getPostType())
        ) {
            // 设置创建时间
            post.setCreateTime(new Date());
            post .setLastTime(new Date());
            try{
                int effectedNum = postDao.insertPost(post);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加失败" + e.toString());
            }
        } else {
            throw new RuntimeException("请填写正确的信息");
        }
    }

    @Override
    public boolean modifyPost(Post post) {
        if (post.getPostId() !=null && post.getPostId() > 0) {
            //设置修改时间
            post.setLastTime(new Date());
            try{
                int effectedNum = postDao.updatePost(post);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新信息失败！");
                }
            }catch (Exception e) {
                throw new RuntimeException("更新信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("请填写正确的信息");
        }
    }

    @Override
    public boolean deletePost(int postId) {
        if (postId > 0) {
            try {
                // 删除帖子信息
                int effectedNum = postDao.deletePost(postId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("id不能为空！");
        }
    }
}
