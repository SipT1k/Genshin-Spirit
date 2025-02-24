package com.voc.genshin_helper.buff;/*
 * Package com.voc.genshin_helper.buff.BuffCal was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2021 Xectorda 版權所有
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.voc.genshin_helper.data.ItemRss;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * Project Genshin Spirit (原神小幫手) was
 * Created & Develop by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2022 Xectorda 版權所有
 */

public class BuffCal2 {

    /**
     * System var
     */
    private Context context;
    ItemRss itemRss;

    /**
     * FINAL METHOD
     */

    double 角色基礎生命值,角色基礎攻擊力,角色基礎防禦力,角色生命值加成,角色攻擊力加成,角色防禦力加成,角色暴擊率,角色暴擊傷害,角色元素充能,角色元素精通,角色治療加成,角色火元素傷害加成,角色水元素傷害加成,角色風元素傷害加成,角色雷元素傷害加成,角色草元素傷害加成,角色冰元素傷害加成,角色岩元素傷害加成,角色物理傷害加成;
    double 普通攻擊_一段傷害,普通攻擊_二段傷害,普通攻擊_三段傷害,普通攻擊_四段傷害,普通攻擊_五段傷害,普通攻擊_六段傷害,普通攻擊_下墜期間傷害,普通攻擊_低空墜地衝擊傷害,普通攻擊_高空墜地衝擊傷害,普通攻擊_瞄準射擊,普通攻擊_滿蓄力瞄準射擊,普通攻擊_重擊傷害,普通攻擊_重擊循環傷害,普通攻擊_重擊終結傷害;

    double 武器基礎攻擊力 = 0;
    double 武器百分比攻擊力 = 0;
    double 武器百分比防禦力 = 0;
    double 武器百分比生命值 = 0;
    double 武器百分比暴擊率 = 0;
    double 武器百分比暴擊傷害 = 0;
    double 武器百分比元素充能 = 0;
    double 武器元素精通 = 0;
    double 武器百分比物理傷害加成 = 0;

    double 聖遺物雷元素傷害加成 = 0;
    double 聖遺物火元素傷害加成 = 0;
    double 聖遺物水元素傷害加成 = 0;
    double 聖遺物草元素傷害加成 = 0;
    double 聖遺物冰元素傷害加成 = 0;
    double 聖遺物風元素傷害加成 = 0;
    double 聖遺物岩元素傷害加成 = 0;
    double 聖遺物暴擊傷害 = 0;
    double 聖遺物暴擊率 = 0;
    double 聖遺物防禦力 = 0;
    double 聖遺物元素精通 = 0;
    double 聖遺物元素充能效率 = 0;
    double 聖遺物生命值 = 0;
    double 聖遺物物理傷害 = 0;
    double 聖遺物基礎攻擊力 = 0;
    double 聖遺物基礎防禦力 = 0;
    double 聖遺物基礎生命值 = 0;
    double 聖遺物攻擊力 = 0;
    double 聖遺物治療加成 = 0;

    /**
     * Help for txt
     */

    String Pyro = "Pyro";
    String Cryo = "Cryo";
    String Hydro = "Hydro";
    String Geo = "Geo";
    String Dendro = "Dendro";
    String Anemo = "Anemo";
    String Electro = "Electro";
    String PHY = "PHY";


    // Have to wait for adding diff element's DMG
    double atk_final,hp_final,def_final,critRate_final,critDMG_final,enRech,phyDMG;

    String weaponName;
    int weaponAfterLvl, weaponAfterBreakLvl;
    boolean weaponAfterBreakUP;

    String charName;
    int charAfterLvl, charAfterBreakLvl,charSkill1AfterLvl,charSkill2AfterLvl,charSkill3AfterLvl;
    boolean charAfterBreakUP;
    String statBuff;

    String[] artifactName;
    int[] artifactAfterLvl ;

    String enemyName ;
    int LvlCharacter ;
    int LvlEnemy ;

    int tmp_break = 0;
    int weapon_tmp_break = 0;
    String otherName;
    double otherVal;

    ArrayList<String> artifactBuffMainItem = new ArrayList<>(5);
    ArrayList<Double> artifactBuffMainValue = new ArrayList<>(5);
    ArrayList<String> artifactBuffSec1Item = new ArrayList<>(5);
    ArrayList<Double> artifactBuffSec1Value = new ArrayList<>(5);
    ArrayList<String> artifactBuffSec2Item = new ArrayList<>(5);
    ArrayList<Double> artifactBuffSec2Value = new ArrayList<>(5);
    ArrayList<String> artifactBuffSec3Item = new ArrayList<>(5);
    ArrayList<Double> artifactBuffSec3Value = new ArrayList<>(5);
    ArrayList<String> artifactBuffSec4Item = new ArrayList<>(5);
    ArrayList<Double> artifactBuffSec4Value = new ArrayList<>(5);

    /**
     * General methods of Damage Formula
     * https://library.keqingmains.com/combat-mechanics/damage/damage-formula
     * https://ngabbs.com/read.php?tid=23611714&_fp=2&rand=157
     *
     */


    //============================================================================//

    public void setup (Context context){
        this.context = context;
        itemRss = new ItemRss();
        enemyName = "Hilichurl";
    }

    public void char_setup(String charName, int charAfterLvl,  int charAfterBreakLvl, boolean charAfterBreakUP, int charSkill1AfterLvl, int charSkill2AfterLvl, int charSkill3AfterLvl) {
        this.charName = charName;
        this.charAfterLvl = charAfterLvl;
        this.charAfterBreakLvl = charAfterBreakLvl;
        this.charAfterBreakUP = charAfterBreakUP;
        this.charSkill1AfterLvl = charSkill1AfterLvl;
        this.charSkill2AfterLvl = charSkill2AfterLvl;
        this.charSkill3AfterLvl = charSkill3AfterLvl;


        LvlCharacter = charAfterLvl;
        LvlEnemy = 84;
    }
    public void weapon_setup(String weaponName, int weaponAfterLvl,  int weaponAfterBreakLvl, boolean weaponAfterBreakUP) {
        this.weaponName = weaponName;
        this.weaponAfterLvl = weaponAfterLvl;
        this.weaponAfterBreakLvl = weaponAfterBreakLvl;
        this.weaponAfterBreakUP = weaponAfterBreakUP;
    }

    // Need to add their main and sub stat...
    public void artifact_setup(String[] artifactName, int[] artifactAfterLvl, ArrayList<Double> artifactBuffMainValue, ArrayList<String> artifactBuffMainItem, ArrayList<Double> artifactBuffSec1Value, ArrayList<String> artifactBuffSec1Item, ArrayList<Double> artifactBuffSec2Value, ArrayList<String> artifactBuffSec2Item, ArrayList<Double> artifactBuffSec3Value, ArrayList<String> artifactBuffSec3Item, ArrayList<Double> artifactBuffSec4Value, ArrayList<String> artifactBuffSec4Item) {
        this.artifactName = artifactName;
        this.artifactAfterLvl = artifactAfterLvl;
        this.artifactBuffMainItem = artifactBuffMainItem;
        this.artifactBuffMainValue = artifactBuffMainValue;
        this.artifactBuffSec1Item = artifactBuffSec1Item;
        this.artifactBuffSec1Value = artifactBuffSec1Value;
        this.artifactBuffSec2Item = artifactBuffSec2Item;
        this.artifactBuffSec2Value = artifactBuffSec2Value;
        this.artifactBuffSec3Item = artifactBuffSec3Item;
        this.artifactBuffSec3Value = artifactBuffSec3Value;
        this.artifactBuffSec4Item = artifactBuffSec4Item;
        this.artifactBuffSec4Value = artifactBuffSec4Value;
    }

    public void startReading (){
        /**
         * Char Part
         */
        String char_json_base = LoadData("db/char/char_list.json");
        try {
            JSONArray array = new JSONArray(char_json_base);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                if(name.equals(charName)){
                    statBuff = object.getString("statBuff");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int breakUP = 0;
        if(charAfterBreakUP){
            breakUP = 1;
        }
        if(charAfterLvl < 20){tmp_break=0;}
        else if(charAfterLvl == 20 && charAfterBreakUP == false){tmp_break=1;}
        else if(charAfterLvl >= 20 && charAfterLvl < 40 && charAfterBreakUP == true){tmp_break=2;}
        else if(charAfterLvl == 40 && charAfterBreakUP == false){tmp_break=3;}
        else if(charAfterLvl >= 40 && charAfterLvl < 50 && charAfterBreakUP == true){tmp_break=4;}
        else if(charAfterLvl == 50 && charAfterBreakUP == false){tmp_break=5;}
        else if(charAfterLvl >= 50 && charAfterLvl < 60 && charAfterBreakUP == true){tmp_break=6;}
        else if(charAfterLvl == 60 && charAfterBreakUP == false){tmp_break=7;}
        else if(charAfterLvl >= 60 && charAfterLvl < 70 && charAfterBreakUP == true){tmp_break=8;}
        else if(charAfterLvl == 70 && charAfterBreakUP == false){tmp_break=9;}
        else if(charAfterLvl >= 70 && charAfterLvl < 80 && charAfterBreakUP == true){tmp_break=10;}
        else if(charAfterLvl == 80 && charAfterBreakUP == false){tmp_break=11;}
        else if(charAfterLvl >= 80 && charAfterLvl < 90 && charAfterBreakUP == true){tmp_break=12;}
        else if(charAfterLvl == 90 && charAfterBreakUP == false){tmp_break=13;}

        if(weaponAfterLvl < 5){weapon_tmp_break=0;}
        else if(weaponAfterLvl <10){weapon_tmp_break=1;}
        else if(weaponAfterLvl <15){weapon_tmp_break=2;}
        else if(weaponAfterLvl <20){weapon_tmp_break=3;}
        else if(weaponAfterLvl == 20 && weaponAfterBreakUP == false){weapon_tmp_break=4;}
        else if(weaponAfterLvl <25){weapon_tmp_break=5;}
        else if(weaponAfterLvl <30){weapon_tmp_break=6;}
        else if(weaponAfterLvl <35){weapon_tmp_break=7;}
        else if(weaponAfterLvl <40){weapon_tmp_break=8;}
        else if(weaponAfterLvl == 40 && weaponAfterBreakUP == false){weapon_tmp_break=9;}
        else if(weaponAfterLvl <45){weapon_tmp_break=10;}
        else if(weaponAfterLvl <50){weapon_tmp_break=11;}
        else if(weaponAfterLvl == 50 && weaponAfterBreakUP == false){weapon_tmp_break=12;}
        else if(weaponAfterLvl <55){weapon_tmp_break=13;}
        else if(weaponAfterLvl <60){weapon_tmp_break=14;}
        else if(weaponAfterLvl == 60 && weaponAfterBreakUP == false){weapon_tmp_break=15;}
        else if(weaponAfterLvl <65){weapon_tmp_break=16;}
        else if(weaponAfterLvl <70){weapon_tmp_break=17;}
        else if(weaponAfterLvl == 70 && weaponAfterBreakUP == false){weapon_tmp_break=18;}
        else if(weaponAfterLvl <75){weapon_tmp_break=19;}
        else if(weaponAfterLvl <80){weapon_tmp_break=20;}
        else if(weaponAfterLvl == 80 && weaponAfterBreakUP == false){weapon_tmp_break=21;}
        else if(weaponAfterLvl <85){weapon_tmp_break=22;}
        else if(weaponAfterLvl <90){weapon_tmp_break=23;}
        else if(weaponAfterLvl == 90 && weaponAfterBreakUP == false){weapon_tmp_break=24;}


        String char_json_stat = LoadData("db/buff/char/"+charName.replace(" ","_")+".json");
        try {
            JSONObject jsonObject = new JSONObject(char_json_stat);
            JSONObject 角色突破 = jsonObject.getJSONObject("角色突破");

            JSONArray 基礎生命值 = 角色突破.getJSONArray("基礎生命值");
            角色基礎生命值 = 基礎生命值.getDouble(tmp_break);

            JSONArray 基礎攻擊力 = 角色突破.getJSONArray("基礎攻擊力");
            角色基礎攻擊力 = 基礎攻擊力.getDouble(tmp_break);

            JSONArray 基礎防禦力 = 角色突破.getJSONArray("基礎防禦力");
            角色基礎防禦力 = 基礎防禦力.getDouble(tmp_break);

            JSONArray 生命值加成 = 角色突破.getJSONArray("生命值加成");
            角色生命值加成 = 生命值加成.getDouble(tmp_break)/100;

            JSONArray 攻擊力加成 = 角色突破.getJSONArray("攻擊力加成");
            角色攻擊力加成 = 攻擊力加成.getDouble(tmp_break)/100;

            JSONArray 防禦力加成 = 角色突破.getJSONArray("防禦力加成");
            角色防禦力加成 = 防禦力加成.getDouble(tmp_break)/100;

            JSONArray 暴擊率 = 角色突破.getJSONArray("暴擊率");
            角色暴擊率 = 暴擊率.getDouble(tmp_break)/100;

            JSONArray 暴擊傷害 = 角色突破.getJSONArray("暴擊傷害");
            角色暴擊傷害 = 暴擊傷害.getDouble(tmp_break)/100;

            JSONArray 元素充能 = 角色突破.getJSONArray("元素充能");
            角色元素充能 = 元素充能.getDouble(tmp_break)/100;

            JSONArray 元素精通 = 角色突破.getJSONArray("元素精通");
            角色元素精通 = 元素精通.getDouble(tmp_break);

            JSONArray 治療加成 = 角色突破.getJSONArray("治療加成");
            角色治療加成 = 治療加成.getDouble(tmp_break)/100;

            JSONArray 火元素傷害加成 = 角色突破.getJSONArray("火元素傷害加成");
            角色火元素傷害加成 = 火元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 水元素傷害加成 = 角色突破.getJSONArray("水元素傷害加成");
            角色水元素傷害加成 = 水元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 風元素傷害加成 = 角色突破.getJSONArray("風元素傷害加成");
            角色風元素傷害加成 = 風元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 雷元素傷害加成 = 角色突破.getJSONArray("雷元素傷害加成");
            角色雷元素傷害加成 = 雷元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 草元素傷害加成 = 角色突破.getJSONArray("草元素傷害加成");
            角色草元素傷害加成 = 草元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 冰元素傷害加成 = 角色突破.getJSONArray("冰元素傷害加成");
            角色冰元素傷害加成 = 冰元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 岩元素傷害加成 = 角色突破.getJSONArray("岩元素傷害加成");
            角色岩元素傷害加成 = 岩元素傷害加成.getDouble(tmp_break)/100;

            JSONArray 物理傷害加成 = 角色突破.getJSONArray("物理傷害加成");
            角色物理傷害加成 = 物理傷害加成.getDouble(tmp_break)/100;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(char_json_stat);
            JSONObject 普通攻擊 = jsonObject.getJSONObject("普通攻擊");

            JSONArray 一段傷害 = 普通攻擊.getJSONArray("一段傷害");
            普通攻擊_一段傷害 = 一段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 二段傷害 = 普通攻擊.getJSONArray("二段傷害");
            普通攻擊_二段傷害 = 二段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 三段傷害 = 普通攻擊.getJSONArray("三段傷害");
            普通攻擊_三段傷害 = 三段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 四段傷害 = 普通攻擊.getJSONArray("四段傷害");
            普通攻擊_四段傷害 = 四段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 五段傷害 = 普通攻擊.getJSONArray("五段傷害");
            普通攻擊_五段傷害 = 五段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 六段傷害 = 普通攻擊.getJSONArray("六段傷害");
            普通攻擊_六段傷害 = 六段傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 下墜期間傷害 = 普通攻擊.getJSONArray("下墜期間傷害");
            普通攻擊_下墜期間傷害 = 下墜期間傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 低空墜地衝擊傷害 = 普通攻擊.getJSONArray("低空墜地衝擊傷害");
            普通攻擊_低空墜地衝擊傷害 = 低空墜地衝擊傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 高空墜地衝擊傷害 = 普通攻擊.getJSONArray("高空墜地衝擊傷害");
            普通攻擊_高空墜地衝擊傷害 = 高空墜地衝擊傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 瞄準射擊 = 普通攻擊.getJSONArray("瞄準射擊");
            普通攻擊_瞄準射擊 = 瞄準射擊.getDouble(charSkill1AfterLvl)/100;

            JSONArray 滿蓄力瞄準射擊 = 普通攻擊.getJSONArray("滿蓄力瞄準射擊");
            普通攻擊_滿蓄力瞄準射擊 = 滿蓄力瞄準射擊.getDouble(charSkill1AfterLvl)/100;

            JSONArray 重擊傷害 = 普通攻擊.getJSONArray("重擊傷害");
            普通攻擊_重擊傷害 = 重擊傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 重擊循環傷害 = 普通攻擊.getJSONArray("重擊循環傷害");
            普通攻擊_重擊循環傷害 = 重擊循環傷害.getDouble(charSkill1AfterLvl)/100;

            JSONArray 重擊終結傷害 = 普通攻擊.getJSONArray("重擊終結傷害");
            普通攻擊_重擊終結傷害 = 重擊終結傷害.getDouble(charSkill1AfterLvl)/100;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        /**
         * Weapon Part
         */

        String weapon_json = LoadData("db/buff/weapons/"+weaponName.replace(" ","_")+".json");
        try {
            JSONObject jsonObject = new JSONObject(weapon_json);

            JSONArray 基礎攻擊力 = jsonObject.getJSONArray("基礎攻擊力");
            武器基礎攻擊力 = 基礎攻擊力.getDouble(weapon_tmp_break);

            JSONArray 生命值加成 = jsonObject.getJSONArray("生命值加成");
            武器百分比生命值 = 生命值加成.getDouble(weapon_tmp_break)/100;

            JSONArray 攻擊力加成 = jsonObject.getJSONArray("攻擊力加成");
            武器百分比攻擊力 = 攻擊力加成.getDouble(weapon_tmp_break)/100;

            JSONArray 防禦力加成 = jsonObject.getJSONArray("防禦力加成");
            武器百分比防禦力 = 防禦力加成.getDouble(weapon_tmp_break)/100;

            JSONArray 暴擊率 = jsonObject.getJSONArray("暴擊率");
            武器百分比暴擊率 = 暴擊率.getDouble(weapon_tmp_break)/100;

            JSONArray 暴擊傷害 = jsonObject.getJSONArray("暴擊傷害");
            武器百分比暴擊傷害 = 暴擊傷害.getDouble(weapon_tmp_break)/100;

            JSONArray 元素充能 = jsonObject.getJSONArray("元素充能");
            武器百分比元素充能 = 元素充能.getDouble(weapon_tmp_break)/100;

            JSONArray 元素精通 = jsonObject.getJSONArray("元素精通");
            武器元素精通 = 元素精通.getDouble(weapon_tmp_break);

            JSONArray 物理傷害加成 = jsonObject.getJSONArray("物理傷害加成");
            武器百分比物理傷害加成 = 物理傷害加成.getDouble(weapon_tmp_break)/100;


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //====================================================//

    public ArrayList<Double> readRESData(String enemyTag){
        String enemy_res = LoadData("db/buff/enemy_res.json");
        ArrayList<Double> resArray = new ArrayList<Double>();
        try {
            JSONObject jsonObject = new JSONObject(enemy_res);

            JSONArray resData = jsonObject.getJSONArray(enemyTag);

            for (int i = 0 ; i < resData.length() ; i++){
                resArray.add(resData.getDouble(i));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resArray;
    }

    //====================================================//
    public double 生命值面板(){
        return (角色基礎生命值) * (1 + 武器百分比生命值+角色生命值加成+0+0+0+0+0) + (0+0);
    }
    public double 防禦力面板(){
        return (角色基礎防禦力) * (1 + 武器百分比防禦力+角色防禦力加成+0+0+0+0+0) + (0+0);
    }
    //攻擊力面板=基礎攻擊力(白字)+攻擊力加成(黃字)
    public double 攻擊力面板(){
        return (角色基礎攻擊力+武器基礎攻擊力)*(1+AttackP());
    }

    // 1 -> Base EnRech 100%
    public double 元素充能(){
        return 1+角色元素充能+武器百分比元素充能;
    }
    public double 元素精通附加值(){
        return 角色元素精通+0;
    }
    public double 治療加成(){
        return 角色治療加成+0;
    }
    public double 火元素傷害加成(){
        return 角色火元素傷害加成+0;
    }
    public double 水元素傷害加成(){
        return 角色水元素傷害加成+0;
    }
    public double 風元素傷害加成(){
        return 角色風元素傷害加成+0;
    }
    public double 雷元素傷害加成(){
        return 角色雷元素傷害加成+0;
    }
    public double 草元素傷害加成(){
        return 角色草元素傷害加成+0;
    }
    public double 冰元素傷害加成(){
        return 角色冰元素傷害加成+0;
    }
    public double 岩元素傷害加成(){
        return 角色岩元素傷害加成+0;
    }
    public double 物理傷害加成(){
        return 角色物理傷害加成+武器百分比物理傷害加成;
    }

    //====================================================//

    public double hpReturn(){
        return 生命值面板();
    }
    public double atkReturn(){
        return 攻擊力面板();
    }
    public double defReturn(){
        return 防禦力面板();
    }
    public double critDMGReturn(){
        return CritDamageP(true);
    }
    public double critRateReturn(){
        return CritRateP();
    }
    public double enRechReturn(){
        return 元素充能();
    }
    public double skillPReturn(String str){
        return TalentP(str);
    }

    public String[] otherReturn(){
        if(角色元素精通>0){return new String[]{"角色元素精通", String.valueOf(元素精通附加值())};}
        else if(角色治療加成>0){return new String[]{"角色治療加成", String.valueOf(治療加成())};}
        else if(角色火元素傷害加成>0){return new String[]{"角色火元素傷害加成", String.valueOf(火元素傷害加成())};}
        else if(角色水元素傷害加成>0){return new String[]{"角色水元素傷害加成", String.valueOf(水元素傷害加成())};}
        else if(角色風元素傷害加成>0){return new String[]{"角色風元素傷害加成", String.valueOf(風元素傷害加成())};}
        else if(角色雷元素傷害加成>0){return new String[]{"角色雷元素傷害加成", String.valueOf(雷元素傷害加成())};}
        else if(角色草元素傷害加成>0){return new String[]{"角色草元素傷害加成", String.valueOf(草元素傷害加成())};}
        else if(角色冰元素傷害加成>0){return new String[]{"角色冰元素傷害加成", String.valueOf(冰元素傷害加成())};}
        else if(角色岩元素傷害加成>0){return new String[]{"角色岩元素傷害加成", String.valueOf(岩元素傷害加成())};}
        else if(角色物理傷害加成>0){return new String[]{"角色物理傷害加成", String.valueOf(物理傷害加成())};}
        else {return new String[]{"NaN", String.valueOf(0)};}
    }

    public void setLvlEnemy(int lvlEnemy){
        this.LvlEnemy = lvlEnemy;
    }

    //====================================================//

    /*
    ATK=(AttackCharacter+AttackWeapon)×(1+AttackBonus)+FlatAttack
    DEF=DefenseCharacter×(1+DefenseBonus)+FlatDefense
    Max HP=HealthCharacter×(1+HealthBonus)+FlatHealth
     */

    public double Damage (String type, boolean isCritDMG, String element_used){
        Log.wtf("1", String.valueOf(TalentP(type)*((AtkCharacter()+AtkWeapon())*(1+AttackP())+FlatAttack())));
        Log.wtf("2", String.valueOf(SpecialMultiplier(0)));
        Log.wtf("3", String.valueOf(FlatDamage(type)));
        Log.wtf("4", String.valueOf((1+DamageBounsP())));
        Log.wtf("5", String.valueOf(CritDamageP(isCritDMG)));
        Log.wtf("6", String.valueOf(EnemyDefMult(type)));
        Log.wtf("7", String.valueOf(EnemyResMult(element_used)));
        Log.wtf("8", String.valueOf(AmplifyingReaction(Geo,"N/A",element_used)));
        Log.wtf("9", String.valueOf(TransformativeReaction(Geo,"N/A",element_used)));
        Log.wtf("0", String.valueOf(Proc()));

        return (TalentP(type)*((AtkCharacter()+AtkWeapon())*(1+AttackP())+FlatAttack()) // BaseDamage
                *SpecialMultiplier(0) // SpecialMultiplier -> https://library.keqingmains.com/combat-mechanics/damage/damage-formula#special-multiplier
                +FlatDamage(type)) // Flat Damage -> https://library.keqingmains.com/combat-mechanics/damage/damage-formula#flat-damage-sources
                *(1+DamageBounsP()) // Damage Bonus
                *CritDamageP(isCritDMG) // Crit
                *EnemyDefMult(type)
                *EnemyResMult(element_used)
                *AmplifyingReaction(Geo,"N/A",element_used)
                +TransformativeReaction(Geo,"N/A",element_used)
                +Proc();

        /* Old version (non-suitable for Raiden)
        return TalentP(type)
                *((AtkCharacter()+AtkWeapon())*(1+AttackP())+FlatAttack())
                *((1+CritDamageP(isCritDMG)))
                *(1+DamageBounsP())
                *((LvlCharacter+100)/((LvlCharacter + 100)+(LvlEnemy + 100)*(1-DefReductionP())*(1-DefIgnore())))
                *RES(0.171) // 210 when 0.2, 236 when 0.1 -> Not a really good way... //https://www.reddit.com/r/Genshin_Impact/comments/jq9r8g/game_mechanism_the_real_formula_for_fatui_shields/
                *((VaporizeMelt("Geo","Pyro")+ReactionBonusP()))
                *Evilsoother(0)
                +ElementReaction("Geo","Pyro")
                *MonaC1("Geo","Pyro",false)
                *ReactionRES(0);
         */
    }
    /*
    https://library.keqingmains.com/combat-mechanics/damage/damage-formula#proc
     */
    public double Proc() {
        return 0;
    }

    /*
        EnemyDefMult=(LevelCharacter+100)/(LevelCharacter+100)+(LevelEnemy+100)×(1−DefReduction)×(1−DefIgnore)
     */
    public double EnemyDefMult(String type) {
        return ((LvlCharacter+100)/((100+LvlCharacter)+(LvlEnemy + 100)*(1-DefReductionP(type))*(1-DefIgnore())));
    }
    public double AmplifyingReaction (String charEle, String enemyEle,String element_used){
        if(charEle.equals(Hydro) && enemyEle.equals(Pyro)){
            return 2*(1+(2.78*EM())/1400+EM() + ReactionBonusP());
        }else if(charEle.equals(Pyro) && enemyEle.equals(Cryo)){
            return 1.5*(1+(2.78*EM())/1400+EM() + ReactionBonusP());
        }else {
            return 1;
        }
    }
    public double TransformativeReaction (String charEle, String enemyEle,String element_used){

        Log.wtf("9.1",String.valueOf(BaseMultipler(charEle,enemyEle)));
        Log.wtf("9.2",String.valueOf((1+(16*EM())/(2000+EM()) + ReactionBonusP())));
        Log.wtf("9.3",String.valueOf(LevelMultiplier()));
        Log.wtf("9.4",String.valueOf(EnemyResMult(element_used)));

        return BaseMultipler(charEle,enemyEle)
                *(1+(16*EM())/(2000+EM()) + ReactionBonusP())
                *LevelMultiplier()
                *EnemyResMult(element_used);
    }
    public double BaseMultipler(String charEle, String enemyEle){
        if(charEle.equals(Electro) && enemyEle.equals(Hydro)){ //感電
            return 1;
        }else if(charEle.equals(Pyro) && enemyEle.equals(Electro)){ //超載
            return 4;
        }else if(charEle.equals(Cryo) && enemyEle.equals(Electro)){ //超導
            return 2.4*ElectroChargedTriggers();
        }else if(charEle.equals(Anemo) && enemyEle.equals(Electro) || charEle.equals(Anemo) && enemyEle.equals(Pyro) || charEle.equals(Anemo) && enemyEle.equals(Hydro)){ //擴散
            return 1.2;
        }else if(charEle.equals(Cryo) && enemyEle.equals(Hydro)){ //冰凍
            return 3;
        }else if(charEle.equals(PHY)){ //物理
            return 3;
        }else {
            return 0;
        }
    }
    public double LevelMultiplier(){
        if(LvlCharacter >0 && LvlCharacter<60){
            return 0.0002325*Math.pow(LvlCharacter,3)+0.05547*Math.pow(LvlCharacter,2)-0.2523*LvlCharacter+14.47;
        }else if(LvlCharacter>=60 && LvlCharacter <= 90){
            return 0.00194*Math.pow(LvlCharacter,3)-0.319*Math.pow(LvlCharacter,2)+30.7*LvlCharacter-868;
        }else {
            return 1;
        }
    }

    //====================================================//

    public double AtkCharacter(){
        return (角色基礎攻擊力);
    }
    public double AtkWeapon(){
        return (武器基礎攻擊力);
    }
    public double AttackP (){
        return 武器百分比攻擊力+聖遺物攻擊力;
    }
    public double FlatAttack (){
        return 聖遺物基礎攻擊力;
    }
    public double CritDamageP (boolean isCritDMG){
        if(isCritDMG){
            return 1+角色暴擊傷害+武器百分比暴擊傷害+聖遺物暴擊傷害;
        }
        else return 1;
    }
    public double CritRateP (){
        return 角色暴擊率+武器百分比暴擊率+聖遺物暴擊率;
    }

    /*
    Sum of all percentage damage increases from goblets, weapons, set bonuses and other buffs.
    Excludes Xingqiu's C4 effect Evilsoother and Yoimiya's Elemental Skill Niwabi Fire-Dance.
     */
    public double DamageBounsP (){
        return 0;
    }
    public double DefReductionP (String type){ // 各種防禦降低效果的總防禦%（但不包括抗性）
        //https://zhuanlan.zhihu.com/p/378611871
        /*
        Razor's Bite (C4): 15%
        Lisa's Static Electricity Field (A4): 15%
        Ayaka's Ebb and Flow (C4): 30%
        Klee's Explosive Frags (C2): 23%
         */

        // NOT END
        return 0;
    }

    public double DefIgnore (){ // 雷神的二命是 Ignore defense
        if(charName.equals("Raiden Shogun")){
            return 0.1;
        }else return 0;
    }

    public double EnemyResMult (String element_used){ // 敵人對元素攻擊的元素抗性
        double res = BaseResistance(enemyName,element_used)-ResistanceReduction();
        // Aim is -> Hilichurl
        //Resistance=BaseResistance−ResistanceReduction
        if(res < 0){
            return 1 - res/2;
        }else if (res >= 0 && res < 0.75){
            return 1 - res;
        }else if (res >= 0.75){
            return 1/(4*res+1);
        }else {
            return 1;
        }
    }

    public double ResistanceReduction() {
        // NOT END
        return 0;
    }
    public double BaseResistance(String enemyName, String element_used) {
        // READ JSON
        // -10 : Immune

        int tmp = -1;
        switch (element_used){
            case "Pyro": tmp = 0; break;
            case "Electro": tmp = 1; break;
            case "Cryo": tmp = 2; break;
            case "Hydro": tmp = 3; break;
            case "Anemo": tmp = 4; break;
            case "Geo": tmp = 5; break;
            case "PHY": tmp = 6; break;
            default:tmp = -1;break;
        }
        if(readRESData(enemyName).get(tmp) == -10){
            return 1;
        }else{
            return readRESData(enemyName).get(tmp);
        }
    }


    public double EM (){ // 元素精通
        return 角色元素精通+武器元素精通+聖遺物元素精通;
    }

    /*
    增幅類反應

    元素反應：蒸發
        水屬性（角色）與火屬性（敵人）-> x2
        火屬性（角色）與冰屬性（敵人）-> x2

    元素反應：融化
        火屬性（角色）與水屬性（敵人）-> x1.5
        冰屬性（角色）與水屬性（敵人）-> x1.5

     */
    public double VaporizeMelt (String charEle, String enemyEle){ //

        double Const = (1+0.00189266831*EM()*Math.exp(-0.000505*EM()));

        if(charEle.equals(Hydro) && enemyEle.equals(Pyro) || charEle.equals(Pyro) && enemyEle.equals(Cryo)){
            return 2*Const;
        }else if(charEle.equals(Pyro) && enemyEle.equals(Hydro) || charEle.equals(Cryo) && enemyEle.equals(Hydro)){
            return 1.5*Const;
        }else{
            return 1;
        }
    }

    public double ReactionBonusP(){ //來自 Crimson Witch 4 件獎勵（用於蒸發和融化）和 Mona 的 C1（用於蒸發）的反應傷害獎勵
        return 0;
    }

    public double SpecialMultiplier(int triggered){ //Xingqiu C4 only -> Always triggered ?
        switch (triggered){
            case 1 : return 1.5; // Evilsoother triggered
            case 2 : return 1.7060; // [MAX] Niwabi Fire-Dance activated
            case 3 : return 1.3791; // [MIN] Niwabi Fire-Dance activated
            default:return 1;
        }
    }
    public double FlatDamage(String type){
        /**
         * Zhongli deals bonus DMG based on his Max HP:
         * • Normal Attack, Charged attack, and Plunge DMG is increased by 1.39% Max HP.
         * • Dominus Lapidis’ Stone Stele, resonance, and hold DMG are increased by 1.9% Max HP.
         * • Planet Befall’s DMG is increased by 33% Max HP.
         */
        if (charName.equals("Zhongli") && charAfterBreakLvl >= 4){
            switch (type){
                //普通攻擊
                case "一段傷害" :
                case "二段傷害" :
                case "三段傷害" :
                case "四段傷害" :
                case "五段傷害" :
                case "六段傷害" :
                    return 1.0139;
                //重擊
                case "重擊傷害" :
                    return 1.0139;
                //俯衝攻擊
                case "低空墜地衝擊傷害" :
                case "高空墜地衝擊傷害" :
                    return 1.0139;

                // NOT END
            }
            // NOT END
        }
        return 0;
    }

    //是 Electro-Charged 觸發的次數，取決於施加在敵人身上的水電和電元素的元素規格強度。
    public double ElectroChargedTriggers() {
        return 1;
    }

    /*
    劇變類反應

    元素反應：超載 -> 火屬性（角色）與雷屬性（敵人）
    元素反應：超導 -> 冰屬性（角色）與雷屬性（敵人）
    元素反應：感電 -> 雷屬性（角色）與水屬性（敵人）
    元素反應：擴散 -> 風屬性（角色）與雷屬性（敵人）/ 風屬性（角色）與火屬性（敵人）/ 風屬性（角色）與水屬性（敵人）


     */
    public double ElementReaction(String charEle, String enemyEle){

        double Const = 1+(60*EM())/(12609+9*EM());


        if(charEle.equals(Electro) && enemyEle.equals(Hydro)){ //感電
            return Const
                    *((-0.0000014798*Math.pow(LvlCharacter,5))
                    +(0.0002746679*Math.pow(LvlCharacter,4))
                    +(0.0162160738*Math.pow(LvlCharacter,3))
                    +(0.4742385201*Math.pow(LvlCharacter,2))
                    -(1.6987232790*Math.pow(LvlCharacter,1))
                    +(20.8340255487))
                    *ElectroChargedTriggers();
        }else if(charEle.equals(Pyro) && enemyEle.equals(Electro)){ //超載
            return Const
                    *((-0.0000027646*Math.pow(LvlCharacter,5))
                    +(0.0005189440*Math.pow(LvlCharacter,4))
                    +(0.0314790536*Math.pow(LvlCharacter,3))
                    +(0.9268181504*Math.pow(LvlCharacter,2))
                    -(4.3991155718*Math.pow(LvlCharacter,1))
                    +(37.4371542286));
        }else if(charEle.equals(Cryo) && enemyEle.equals(Electro)){ //超導
            return Const
                    *((-0.0000006038*Math.pow(LvlCharacter,5))
                    +(0.0001110078*Math.pow(LvlCharacter,4))
                    +(0.0064237710*Math.pow(LvlCharacter,3))
                    +(0.1836799174*Math.pow(LvlCharacter,2))
                    -(0.4750909512*Math.pow(LvlCharacter,1))
                    +(7.4972486411));
        }else if(charEle.equals(Anemo) && enemyEle.equals(Electro) || charEle.equals(Anemo) && enemyEle.equals(Pyro) || charEle.equals(Anemo) && enemyEle.equals(Hydro)){ //擴散
            return Const
                    *((-0.0000008854*Math.pow(LvlCharacter,5))
                    +(0.0001679502*Math.pow(LvlCharacter,4))
                    +(0.0103922088*Math.pow(LvlCharacter,3))
                    +(0.3097567417*Math.pow(LvlCharacter,2))
                    -(1.7733381829*Math.pow(LvlCharacter,1))
                    +(13.5157684329));
        }else {
            return 0;
        }
    }

    public double MonaC1 (String charEle, String enemyEle, boolean isMonaC1Active){
        if(isMonaC1Active){
            if(charEle.equals(Electro) && enemyEle.equals(Hydro)) { //感電
                return 1.15;
            }else if(charEle.equals(Anemo) && enemyEle.equals(Hydro) ){ //擴散 [水]
                return 1.15;
            }else{
                return 1;
            }
        }
        return 1;
    }

    //元素反應 : 敵人元素抗性
    //https://zhuanlan.zhihu.com/p/374290704
    public double ReactionRES(double res){
        if(res < 0){
            return 1 - res/2;
        }else if (res >= 0 && res < 0.75){
            return 1 - res;
        }else if (res >= 0.75){
            return 1/(4*res+1);
        }else {
            return 1;
        }
    }


    //TalentP
    public double TalentP(String type){
        switch (type){
            //普通攻擊
            case "一段傷害" :  return 普通攻擊_一段傷害;
            case "二段傷害" :  return 普通攻擊_二段傷害;
            case "三段傷害" :  return 普通攻擊_三段傷害;
            case "四段傷害" :  return 普通攻擊_四段傷害;
            case "五段傷害" :  return 普通攻擊_五段傷害;
            case "六段傷害" :  return 普通攻擊_六段傷害;
            case "瞄準射擊" :  return 普通攻擊_瞄準射擊;

            //重擊
            case "滿蓄力瞄準射擊" :  return 普通攻擊_滿蓄力瞄準射擊;
            case "重擊傷害" :  return 普通攻擊_重擊傷害;
            case "重擊循環傷害" :  return 普通攻擊_重擊循環傷害;
            case "重擊終結傷害" :  return 普通攻擊_重擊終結傷害;

            //俯衝攻擊
            case "下墜期間傷害" :  return 普通攻擊_下墜期間傷害;
            case "低空墜地衝擊傷害" :  return 普通攻擊_低空墜地衝擊傷害;
            case "高空墜地衝擊傷害" :  return 普通攻擊_高空墜地衝擊傷害;


            //元素戰技

            //元素爆發

            default: return 0;
        }
    }

    //====================================================//

    public String LoadData(String inFile) {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }

    public String prettyCount(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = Math.round(number.longValue());
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        String plus = "";
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal  = sharedPreferences.getBoolean("decimal", false);
        if (decimal == true){
            if (value >= 3 && base < suffix.length) {
                if (decimal_num == 0){
                    return plus+new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 1){
                    return plus+new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 2){
                    return plus+new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 3){
                    return plus+new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 4){
                    return plus+new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 5){
                    return plus+new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                // Muility
            } else {
                return plus+new DecimalFormat("###,###,###,###,###").format(numValue);
            }
        }
        return plus+new DecimalFormat("###,###,###,###,###").format(numValue);
    }
}
