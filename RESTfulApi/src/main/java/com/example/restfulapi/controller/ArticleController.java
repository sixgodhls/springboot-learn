package com.example.restfulapi.controller;

import com.example.restfulapi.model.Artical;
import com.example.restfulapi.result.BaseResult;
import com.example.restfulapi.result.DataResult;
import com.example.restfulapi.util.HttpStatusMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@SuppressWarnings("all")
@RestController
@RequestMapping("/articles")
@Api(tags = "文章接口")
public class ArticleController {
    static List<Artical> articals=new ArrayList<>();
    static {
        articals.add(new Artical(1,"spring"));
        articals.add(new Artical(2,"java"));
        articals.add(new Artical(3,"javaEE"));
    }
    @PostMapping
    @ApiOperation("save new")
    @ApiResponse(code = 200,message = "save ok")
    public ResponseEntity<BaseResult> saveArticle(@RequestBody Artical artical){
        articals.add(artical);
        System.out.println(artical);
        BaseResult baseResult=new BaseResult(HttpStatusMap.get(HttpStatus.OK),"保存成功");
        return ResponseEntity.ok(baseResult);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BaseResult> getArticle(@PathVariable Integer id){
        Optional<Artical> opArt=articals.stream().filter(artical -> artical.getId() ==id).findFirst();
        try{
            Artical artical=opArt.get();
            DataResult result=new DataResult();
            result.setCode(HttpStatusMap.get(HttpStatus.OK));
            result.setData(artical);
            result.setMsg("Ok");
            return ResponseEntity.ok(result);
        }catch (NoSuchElementException e){
            BaseResult result=new BaseResult(HttpStatusMap.get(HttpStatus.BAD_REQUEST),"参数不合法");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping
    public ResponseEntity<DataResult<List<Artical>>> getArticles(){
        DataResult result = new DataResult();
        result.setMsg("OK");
        result.setCode(HttpStatusMap.get(HttpStatus.OK));
        result.setData(articals);
        return ResponseEntity.ok(result);
    }
}
