package com.liyingxia.post.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.liyingxia.post.entity.Post;
import com.liyingxia.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

@RestController
@RequestMapping(value = "/manager")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> listPost() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Post> list = new ArrayList<Post>();
        list = postService.getPostList();
        map.put("postList", list);
        return map;
    }

    @RequestMapping(value = "/postId", method = RequestMethod.GET)
    private Map<String, Object> getPostId(Integer postId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Post post = postService.getPostById(postId);
        map.put("post", post);
        return map;
    }

    /**
     * 新增帖子
     * @param post
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    private Map<String,Object> addPost(@RequestBody Post post) throws JsonParseException,JsonMappingException,IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        // 添加贴子信息
        map.put("success",postService.addPost(post));
        return map;

    }


    /**
     * 修改帖子
     * @param post
     * @return
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     */
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    private Map<String,Object> modifyPost(@RequestBody Post post) throws JsonMappingException,JsonParseException,IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        // 修改贴子信息
        map.put("success",postService.modifyPost(post));
        return map;
    }

    /**
     * 删除根据id帖子
     * @param postId
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
    private Map<String,Object> deletePost(Integer postId) {
        Map<String,Object> map = new HashMap<String,Object>();
        // 删除信息
        map.put("success",postService.deletePost(postId));
        return map;
    }
}
