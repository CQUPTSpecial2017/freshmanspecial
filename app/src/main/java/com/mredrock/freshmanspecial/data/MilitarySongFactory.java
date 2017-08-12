package com.mredrock.freshmanspecial.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 700-15isk on 2017/8/12.
 */

public class MilitarySongFactory {
   private  List<String>songName=new ArrayList<>();
   private   List<String>songAuthor=new ArrayList<>();

    public List<String> getSongAuthor() {
        songAuthor.add("阎维文");
        songAuthor.add("刘斌" );
        songAuthor.add("霍勇");
        songAuthor.add("小曾");
        songAuthor.add("小曾");
        songAuthor.add("阎维文");
        songAuthor.add("小曾");
        songAuthor.add("阎维文");
        songAuthor.add("屠洪刚");
        songAuthor.add("小曾");
        songAuthor.add("瞿弦和");
        songAuthor.add("张穆庭");
        return songAuthor;
    }



    public List<String> getSongName() {
        songName.add("强军战歌");
        songName.add("咱当兵的人" );
        songName.add("团结就是力量");
        songName.add("军中绿花");
        songName.add("战友还记得吗");
        songName.add("一二三四歌");
        songName.add("75厘米");
        songName.add("打靶归来");
        songName.add("精忠报国");
        songName.add("我的老班长");
        songName.add("保卫黄河");
        songName.add("国际歌");
        return songName;
    }


}

