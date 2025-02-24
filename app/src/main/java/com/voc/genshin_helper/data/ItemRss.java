package com.voc.genshin_helper.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import com.voc.genshin_helper.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

/*
 * Project Genshin Spirit (原神小幫手) was
 * Created & Develop by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2022 Xectorda 版權所有
 */
public class ItemRss {

    SharedPreferences sharedPreferences;

    /**EDIT WHEN ADD NEW ITEMS*/
    public int[] char_names = {R.string.yae_miko,R.string.shenhe,R.string.yun_jin,R.string.gorou, R.string.arataki_itto, R.string.thoma, R.string.sangonomiya_kokomi, R.string.aloy, R.string.kujou_sara, R.string.raiden_shogun, R.string.sayu, R.string.yoimiya, R.string.kamisato_ayaka, R.string.kaedehara_kazuha, R.string.yanfei, R.string.eula, R.string.rosaria, R.string.xiao, R.string.hu_tao, R.string.ganyu, R.string.albedo, R.string.zhongli, R.string.xinyan, R.string.tartaglia, R.string.diona, R.string.xingqiu, R.string.xiangling, R.string.venti, R.string.sucrose, R.string.razor, R.string.qiqi, R.string.noelle, R.string.ningguang, R.string.mona, R.string.lisa, R.string.klee, R.string.keqing, R.string.kaeya, R.string.jean, R.string.fischl, R.string.diluc, R.string.chongyun, R.string.bennett, R.string.beidou, R.string.barbara, R.string.amber, R.string.traveler_anemo, R.string.traveler_geo, R.string.traveler_electro};
    public int[] weapons_name = {R.string.calamity_queller,R.string.redhorn_stonethresher,R.string.akuoumaru,R.string.akuoumaru,R.string.mouuns_moon,R.string.wavebreakers_fin,R.string.amenoma_kageuchi, R.string.aquila_favonia, R.string.blackcliff_longsword, R.string.cool_steel, R.string.dark_iron_sword, R.string.dull_blade, R.string.favonius_sword, R.string.festering_desire, R.string.fillet_blade, R.string.freedom_sworn, R.string.harbinger_of_dawn, R.string.iron_sting, R.string.lions_roar, R.string.mistsplitter_reforged, R.string.primordial_jade_cutter, R.string.prototype_rancour, R.string.royal_longsword, R.string.sacrificial_sword, R.string.silver_sword, R.string.skyrider_sword, R.string.skyward_blade, R.string.summit_shaper, R.string.sword_of_descension, R.string.the_alley_flash, R.string.the_black_sword, R.string.the_flute, R.string.travelers_handy_sword, R.string.waster_greatsword, R.string.old_mercs_pal, R.string.bloodtainted_greatsword, R.string.debate_club, R.string.quartz, R.string.ferrous_shadow, R.string.skyrider_greatsword, R.string.white_iron_greatsword, R.string.blackcliff_slasher, R.string.favonius_greatsword, R.string.katsuragikiri_nagamasa, R.string.lithic_blade, R.string.luxurious_sea_lord, R.string.prototype_archaic, R.string.rainslasher, R.string.royal_greatsword, R.string.sacrificial_greatsword, R.string.serpent_spine, R.string.snow_tombed_starsilver, R.string.the_bell, R.string.whiteblind, R.string.skyward_pride, R.string.song_of_broken_pines, R.string.the_unforged, R.string.wolfs_gravestone, R.string.beginners_protector, R.string.iron_point, R.string.black_tassel, R.string.halberd, R.string.white_tassel, R.string.blackcliff_pole, R.string.crescent_pike, R.string.deathmatch, R.string.dragons_bane, R.string.dragonspine_spear, R.string.favonius_lance, R.string.kitain_cross_spear, R.string.lithic_spear, R.string.prototype_starglitter, R.string.royal_spear, R.string.the_catch, R.string.engulfing_lightning, R.string.primordial_jade_winged_spear, R.string.skyward_spine, R.string.staff_of_homa, R.string.vortex_vanquisher, R.string.apprentices_notes, R.string.pocket_grimoire, R.string.amber_catalyst, R.string.emerald_orb, R.string.magic_guide, R.string.otherworldly_story, R.string.thrilling_tales_of_dragon_slayers, R.string.twin_nephrite, R.string.blackcliff_agate, R.string.dodoco_tales, R.string.eye_of_perception, R.string.favonius_codex, R.string.frostbearer, R.string.hakushin_ring, R.string.mappa_mare, R.string.prototype_amber, R.string.royal_grimoire, R.string.sacrificial_fragments, R.string.solar_pearl, R.string.the_widsith, R.string.wine_and_song, R.string.everlasting_moonglow, R.string.lost_prayer_to_the_sacred_winds, R.string.memory_of_dust, R.string.skyward_atlas, R.string.hunters_bow, R.string.seasoned_hunters_bow, R.string.ebony_bow, R.string.messenger, R.string.raven_bow, R.string.recurve_bow, R.string.sharpshooters_oath, R.string.slingshot, R.string.alley_hunter, R.string.blackcliff_warbow, R.string.compound_bow, R.string.favonius_warbow, R.string.hamayumi, R.string.mitternachts_waltz, R.string.predator, R.string.prototype_crescent, R.string.royal_bow, R.string.rust, R.string.sacrificial_bow, R.string.the_stringless, R.string.the_viridescent_hunt, R.string.windblume_ode, R.string.amos_bow, R.string.elegy_for_the_end, R.string.skyward_harp, R.string.thundering_pulse, R.string.cinnabar_spindle};
    public int[] artifact_name = {R.string.adventurer, R.string.archaic_petra, R.string.berserker, R.string.blizzard_strayer, R.string.bloodstained_chivalry, R.string.brave_heart, R.string.crimson_witch_of_flames, R.string.defenders_will, R.string.emblem_of_severed_fate, R.string.gambler, R.string.gladiators_finale, R.string.heart_of_depth, R.string.instructor, R.string.lavawalker, R.string.lucky_dog, R.string.maiden_beloved, R.string.martial_artist, R.string.noblesse_oblige, R.string.pale_flame, R.string.prayers_of_destiny, R.string.prayers_of_illumination, R.string.prayers_of_wisdom, R.string.prayers_of_springtime, R.string.resolution_of_sojourner, R.string.retracing_bolide, R.string.scholar, R.string.shimenawas_reminiscence, R.string.tenacity_of_the_millelith, R.string.the_exile, R.string.thundering_fury, R.string.thundersoother, R.string.tiny_miracle, R.string.traveling_doctor, R.string.viridescent_venerer, R.string.wanderers_troupe,R.string.husk_of_opulent_dreams,R.string.ocean_hued_clam};

    public String getLocaleName (String str,Context context) {
        /** Area Name */
        if (str.equals("Mondstadt")){return context.getString(R.string.mondstadt);}
        else if (str.equals("Liyue")){return context.getString(R.string.liyue);}
        else if (str.equals("Inazuma")){return context.getString(R.string.inazuma);}
        else if (str.equals("Nora Fortis")){return context.getString(R.string.nora_fortis);}
        else if (str.equals("Snezhnaya")){return context.getString(R.string.snezhnaya);}
        else if (str.equals("Another World")){return context.getString(R.string.another_world);}
        /** Char's Role Name*/
        else if (str.equals("Main_DPS")){return context.getString(R.string.main_dps);}
        else if (str.equals("Support_DPS")){return context.getString(R.string.support_dps);}
        else if (str.equals("Utility")){return context.getString(R.string.utility);}
        /** Sex Name */
        else if (str.equals("Female")){return context.getString(R.string.female);}
        else if (str.equals("Male")){return context.getString(R.string.male);}
        else if (str.equals("SET_BY_PLAYER")){return context.getString(R.string.set_by_player);}

        else {return str;}
    }
    public String LocaleCharStr(int i, Context context) {
        return context.getString(this.char_names[i]);
    }

    public String LocaleArtifactStr(int i, Context context) {
        return context.getString(this.artifact_name[i]);
    }

    public String LocaleWeaponStr(int i, Context context) {
        return context.getString(this.weapons_name[i]);
    }


    public int[] getRareColorByName(int i) {
        switch (i){
            case 1 : return new int[]{R.drawable.bg_rare1_bg, R.drawable.bg_rare1_char, R.color.rare1};
            case 2 : return new int[]{R.drawable.bg_rare2_bg, R.drawable.bg_rare2_char, R.color.rare2};
            case 3 : return new int[]{R.drawable.bg_rare3_bg, R.drawable.bg_rare3_char, R.color.rare3};
            case 4 : return new int[]{R.drawable.bg_rare4_bg, R.drawable.bg_rare4_char, R.color.rare4};
            case 5 : return new int[]{R.drawable.bg_rare5_bg, R.drawable.bg_rare5_char, R.color.rare5};
            default: return new int[]{R.drawable.paimon_lost, R.drawable.paimon_lost, R.color.rare1};
        }
    }


    public int getWeaponTypeIMG (String str){
        if(str.equals("Bow")){return R.drawable.ico_bow;}
        else if(str.equals("Catalyst")){return R.drawable.ico_catalyst;}
        else if(str.equals("Claymore")){return R.drawable.ico_claymore;}
        else if(str.equals("Polearm")){return R.drawable.ico_polearm;}
        else if(str.equals("Sword")){return R.drawable.ico_sword;}
        else {return R.drawable.paimon_lost;}
    }

    public String[] getWeaponByName(String str,Context context) {
        switch (str){
            case "Amenoma Kageuchi" : return new String[] {context.getString(R.string.amenoma_kageuchi),"/drawable/amenoma_kageuchi.png"};
            case "Aquila Favonia" : return new String[] {context.getString(R.string.aquila_favonia),"/drawable/aquila_favonia.png"};
            case "Blackcliff Longsword" : return new String[] {context.getString(R.string.blackcliff_longsword),"/drawable/blackcliff_longsword.png"};
            case "Cool Steel" : return new String[] {context.getString(R.string.cool_steel),"/drawable/cool_steel.png"};
            case "Dark Iron Sword" : return new String[] {context.getString(R.string.dark_iron_sword),"/drawable/dark_iron_sword.png"};
            case "Dull Blade" : return new String[] {context.getString(R.string.dull_blade),"/drawable/dull_blade.png"};
            case "Favonius Sword" : return new String[] {context.getString(R.string.favonius_sword),"/drawable/favonius_sword.png"};
            case "Festering Desire" : return new String[] {context.getString(R.string.festering_desire),"/drawable/festering_desire.png"};
            case "Fillet Blade" : return new String[] {context.getString(R.string.fillet_blade),"/drawable/fillet_blade.png"};
            case "Freedom-Sworn" : return new String[] {context.getString(R.string.freedom_sworn),"/drawable/freedom_sworn.png"};
            case "Harbinger of Dawn" : return new String[] {context.getString(R.string.harbinger_of_dawn),"/drawable/harbinger_of_dawn.png"};
            case "Iron Sting" : return new String[] {context.getString(R.string.iron_sting),"/drawable/iron_sting.png"};
            case "Lion's Roar" : return new String[] {context.getString(R.string.lions_roar),"/drawable/lions_roar.png"};
            case "Mistsplitter Reforged" : return new String[] {context.getString(R.string.mistsplitter_reforged),"/drawable/mistsplitter_reforged.png"};
            case "Primordial Jade Cutter" : return new String[] {context.getString(R.string.primordial_jade_cutter),"/drawable/primordial_jade_cutter.png"};
            case "Prototype Rancour" : return new String[] {context.getString(R.string.prototype_rancour),"/drawable/prototype_rancour.png"};
            case "Royal Longsword" : return new String[] {context.getString(R.string.royal_longsword),"/drawable/royal_longsword.png"};
            case "Sacrificial Sword" : return new String[] {context.getString(R.string.sacrificial_sword),"/drawable/sacrificial_sword.png"};
            case "Silver Sword" : return new String[] {context.getString(R.string.silver_sword),"/drawable/silver_sword.png"};
            case "Skyrider Sword" : return new String[] {context.getString(R.string.skyrider_sword),"/drawable/skyrider_sword.png"};
            case "Skyward Blade" : return new String[] {context.getString(R.string.skyward_blade),"/drawable/skyward_blade.png"};
            case "Summit Shaper" : return new String[] {context.getString(R.string.summit_shaper),"/drawable/summit_shaper.png"};
            case "Sword of Descension" : return new String[] {context.getString(R.string.sword_of_descension),"/drawable/sword_of_descension.png"};
            case "The Alley Flash" : return new String[] {context.getString(R.string.the_alley_flash),"/drawable/the_alley_flash.png"};
            case "The Black Sword" : return new String[] {context.getString(R.string.the_black_sword),"/drawable/the_black_sword.png"};
            case "The Flute" : return new String[] {context.getString(R.string.the_flute),"/drawable/the_flute.png"};
            case "Traveler's Handy Sword" : return new String[] {context.getString(R.string.travelers_handy_sword),"/drawable/travelers_handy_sword.png"};
            case "Cinnabar Spindle" : return new String[] {context.getString(R.string.cinnabar_spindle),"/drawable/cinnabar_spindle.png"};

            case "Waster Greatsword" : return new String[] {context.getString(R.string.waster_greatsword),"/drawable/waster_greatsword.png"};
            case "Old Merc's Pal" : return new String[] {context.getString(R.string.old_mercs_pal),"/drawable/old_mercs_pal.png"};
            case "Bloodtainted Greatsword" : return new String[] {context.getString(R.string.bloodtainted_greatsword),"/drawable/bloodtainted_greatsword.png"};
            case "Debate Club" : return new String[] {context.getString(R.string.debate_club),"/drawable/debate_club.png"};
            case "Quartz" : return new String[] {context.getString(R.string.quartz),"/drawable/quartz.png"};
            case "Ferrous Shadow" : return new String[] {context.getString(R.string.ferrous_shadow),"/drawable/ferrous_shadow.png"};
            case "Skyrider Greatsword" : return new String[] {context.getString(R.string.skyrider_greatsword),"/drawable/skyrider_greatsword.png"};
            case "White Iron Greatsword" : return new String[] {context.getString(R.string.white_iron_greatsword),"/drawable/white_iron_greatsword.png"};
            case "Blackcliff Slasher" : return new String[] {context.getString(R.string.blackcliff_slasher),"/drawable/blackcliff_slasher.png"};
            case "Favonius Greatsword" : return new String[] {context.getString(R.string.favonius_greatsword),"/drawable/favonius_greatsword.png"};
            case "Katsuragikiri Nagamasa" : return new String[] {context.getString(R.string.katsuragikiri_nagamasa),"/drawable/katsuragikiri_nagamasa.png"};
            case "Lithic Blade" : return new String[] {context.getString(R.string.lithic_blade),"/drawable/lithic_blade.png"};
            case "Luxurious Sea-Lord" : return new String[] {context.getString(R.string.luxurious_sea_lord),"/drawable/luxurious_sea_lord.png"};
            case "Prototype Archaic" : return new String[] {context.getString(R.string.prototype_archaic),"/drawable/prototype_archaic.png"};
            case "Rainslasher" : return new String[] {context.getString(R.string.rainslasher),"/drawable/rainslasher.png"};
            case "Royal Greatsword" : return new String[] {context.getString(R.string.royal_greatsword),"/drawable/royal_greatsword.png"};
            case "Sacrificial Greatsword" : return new String[] {context.getString(R.string.sacrificial_greatsword),"/drawable/sacrificial_greatsword.png"};
            case "Serpent Spine" : return new String[] {context.getString(R.string.serpent_spine),"/drawable/serpent_spine.png"};
            case "Snow-Tombed Starsilver" : return new String[] {context.getString(R.string.snow_tombed_starsilver),"/drawable/snow_tombed_starsilver.png"};
            case "The Bell" : return new String[] {context.getString(R.string.the_bell),"/drawable/the_bell.png"};
            case "Whiteblind" : return new String[] {context.getString(R.string.whiteblind),"/drawable/whiteblind.png"};
            case "Skyward Pride" : return new String[] {context.getString(R.string.skyward_pride),"/drawable/skyward_pride.png"};
            case "Song of Broken Pines" : return new String[] {context.getString(R.string.song_of_broken_pines),"/drawable/song_of_broken_pines.png"};
            case "The Unforged" : return new String[] {context.getString(R.string.the_unforged),"/drawable/the_unforged.png"};
            case "Wolf's Gravestone" : return new String[] {context.getString(R.string.wolfs_gravestone),"/drawable/wolfs_gravestone.png"};
            case "Akuoumaru" : return new String[] {context.getString(R.string.akuoumaru),"/drawable/akuoumaru.png"};
            case "Redhorn Stonethresher" : return new String[] {context.getString(R.string.redhorn_stonethresher),"/drawable/redhorn_stonethresher.png"};

            case "Beginner's Protector" : return new String[] {context.getString(R.string.beginners_protector),"/drawable/beginners_protector.png"};
            case "Iron Point" : return new String[] {context.getString(R.string.iron_point),"/drawable/iron_point.png"};
            case "Black Tassel" : return new String[] {context.getString(R.string.black_tassel),"/drawable/black_tassel.png"};
            case "Halberd" : return new String[] {context.getString(R.string.halberd),"/drawable/halberd.png"};
            case "White Tassel" : return new String[] {context.getString(R.string.white_tassel),"/drawable/white_tassel.png"};
            case "Blackcliff Pole" : return new String[] {context.getString(R.string.blackcliff_pole),"/drawable/blackcliff_pole.png"};
            case "Crescent Pike" : return new String[] {context.getString(R.string.crescent_pike),"/drawable/crescent_pike.png"};
            case "Deathmatch" : return new String[] {context.getString(R.string.deathmatch),"/drawable/deathmatch.png"};
            case "Dragon's Bane" : return new String[] {context.getString(R.string.dragons_bane),"/drawable/dragons_bane.png"};
            case "Dragonspine Spear" : return new String[] {context.getString(R.string.dragonspine_spear),"/drawable/dragonspine_spear.png"};
            case "Favonius Lance" : return new String[] {context.getString(R.string.favonius_lance),"/drawable/favonius_lance.png"};
            case "Kitain Cross Spear" : return new String[] {context.getString(R.string.kitain_cross_spear),"/drawable/kitain_cross_spear.png"};
            case "Lithic Spear" : return new String[] {context.getString(R.string.lithic_spear),"/drawable/lithic_spear.png"};
            case "Prototype Starglitter" : return new String[] {context.getString(R.string.prototype_starglitter),"/drawable/prototype_starglitter.png"};
            case "Royal Spear" : return new String[] {context.getString(R.string.royal_spear),"/drawable/royal_spear.png"};
            case "The Catch" : return new String[] {context.getString(R.string.the_catch),"/drawable/the_catch.png"};
            case "Engulfing Lightning" : return new String[] {context.getString(R.string.engulfing_lightning),"/drawable/engulfing_lightning.png"};
            case "Primordial Jade Winged-Spear" : return new String[] {context.getString(R.string.primordial_jade_winged_spear),"/drawable/primordial_jade_winged_spear.png"};
            case "Skyward Spine" : return new String[] {context.getString(R.string.skyward_spine),"/drawable/skyward_spine.png"};
            case "Staff of Homa" : return new String[] {context.getString(R.string.staff_of_homa),"/drawable/staff_of_homa.png"};
            case "Vortex Vanquisher" : return new String[] {context.getString(R.string.vortex_vanquisher),"/drawable/vortex_vanquisher.png"};
            case "Wavebreaker's Fin" : return new String[] {context.getString(R.string.wavebreakers_fin),"/drawable/wavebreakers_fin.png"};
            case "Calamity Queller" : return new String[] {context.getString(R.string.calamity_queller),"/drawable/calamity_queller.png"};

            case "Apprentice's Notes" : return new String[] {context.getString(R.string.apprentices_notes),"/drawable/apprentices_notes.png"};
            case "Pocket Grimoire" : return new String[] {context.getString(R.string.pocket_grimoire),"/drawable/pocket_grimoire.png"};
            case "Amber Catalyst" : return new String[] {context.getString(R.string.amber_catalyst),"/drawable/amber_catalyst.png"};
            case "Emerald Orb" : return new String[] {context.getString(R.string.emerald_orb),"/drawable/emerald_orb.png"};
            case "Magic Guide" : return new String[] {context.getString(R.string.magic_guide),"/drawable/magic_guide.png"};
            case "Otherworldly Story" : return new String[] {context.getString(R.string.otherworldly_story),"/drawable/otherworldly_story.png"};
            case "Thrilling Tales of Dragon Slayers" : return new String[] {context.getString(R.string.thrilling_tales_of_dragon_slayers),"/drawable/thrilling_tales_of_dragon_slayers.png"};
            case "Twin Nephrite" : return new String[] {context.getString(R.string.twin_nephrite),"/drawable/twin_nephrite.png"};
            case "Blackcliff Agate" : return new String[] {context.getString(R.string.blackcliff_agate),"/drawable/blackcliff_agate.png"};
            case "Dodoco Tales" : return new String[] {context.getString(R.string.dodoco_tales),"/drawable/dodoco_tales.png"};
            case "Eye of Perception" : return new String[] {context.getString(R.string.eye_of_perception),"/drawable/eye_of_perception.png"};
            case "Favonius Codex" : return new String[] {context.getString(R.string.favonius_codex),"/drawable/favonius_codex.png"};
            case "Frostbearer" : return new String[] {context.getString(R.string.frostbearer),"/drawable/frostbearer.png"};
            case "Hakushin Ring" : return new String[] {context.getString(R.string.hakushin_ring),"/drawable/hakushin_ring.png"};
            case "Mappa Mare" : return new String[] {context.getString(R.string.mappa_mare),"/drawable/mappa_mare.png"};
            case "Prototype Amber" : return new String[] {context.getString(R.string.prototype_amber),"/drawable/prototype_amber.png"};
            case "Royal Grimoire" : return new String[] {context.getString(R.string.royal_grimoire),"/drawable/royal_grimoire.png"};
            case "Sacrificial Fragments" : return new String[] {context.getString(R.string.sacrificial_fragments),"/drawable/sacrificial_fragments.png"};
            case "Solar Pearl" : return new String[] {context.getString(R.string.solar_pearl),"/drawable/solar_pearl.png"};
            case "The Widsith" : return new String[] {context.getString(R.string.the_widsith),"/drawable/the_widsith.png"};
            case "Wine and Song" : return new String[] {context.getString(R.string.wine_and_song),"/drawable/wine_and_song.png"};
            case "Everlasting Moonglow" : return new String[] {context.getString(R.string.everlasting_moonglow),"/drawable/everlasting_moonglow.png"};
            case "Lost Prayer to the Sacred Winds" : return new String[] {context.getString(R.string.lost_prayer_to_the_sacred_winds),"/drawable/lost_prayer_to_the_sacred_winds.png"};
            case "Memory of Dust" : return new String[] {context.getString(R.string.memory_of_dust),"/drawable/memory_of_dust.png"};
            case "Skyward Atlas" : return new String[] {context.getString(R.string.skyward_atlas),"/drawable/skyward_atlas.png"};
            //add in 20220126
            case "Kagura's Verity" : return new String[] {context.getString(R.string.kaguras_verity),"/drawable/kaguras_verity.png"};
            case "Oathsworn Eye" : return new String[] {context.getString(R.string.oathsworn_eye),"/drawable/oathsworn_eye.png"};

            case "Hunter's Bow" : return new String[] {context.getString(R.string.hunters_bow),"/drawable/hunters_bow.png"};
            case "Seasoned Hunter's Bow" : return new String[] {context.getString(R.string.seasoned_hunters_bow),"/drawable/seasoned_hunters_bow.png"};
            case "Ebony Bow" : return new String[] {context.getString(R.string.ebony_bow),"/drawable/ebony_bow.png"};
            case "Messenger" : return new String[] {context.getString(R.string.messenger),"/drawable/messenger.png"};
            case "Raven Bow" : return new String[] {context.getString(R.string.raven_bow),"/drawable/raven_bow.png"};
            case "Recurve Bow" : return new String[] {context.getString(R.string.recurve_bow),"/drawable/recurve_bow.png"};
            case "Sharpshooter's Oath" : return new String[] {context.getString(R.string.sharpshooters_oath),"/drawable/sharpshooters_oath.png"};
            case "Slingshot" : return new String[] {context.getString(R.string.slingshot),"/drawable/slingshot.png"};
            case "Alley Hunter" : return new String[] {context.getString(R.string.alley_hunter),"/drawable/alley_hunter.png"};
            case "Blackcliff Warbow" : return new String[] {context.getString(R.string.blackcliff_warbow),"/drawable/blackcliff_warbow.png"};
            case "Compound Bow" : return new String[] {context.getString(R.string.compound_bow),"/drawable/compound_bow.png"};
            case "Favonius Warbow" : return new String[] {context.getString(R.string.favonius_warbow),"/drawable/favonius_warbow.png"};
            case "Hamayumi" : return new String[] {context.getString(R.string.hamayumi),"/drawable/hamayumi.png"};
            case "Mitternachts Waltz" : return new String[] {context.getString(R.string.mitternachts_waltz),"/drawable/mitternachts_waltz.png"};
            case "Predator" : return new String[] {context.getString(R.string.predator),"/drawable/predator.png"};
            case "Prototype Crescent" : return new String[] {context.getString(R.string.prototype_crescent),"/drawable/prototype_crescent.png"};
            case "Royal Bow" : return new String[] {context.getString(R.string.royal_bow),"/drawable/royal_bow.png"};
            case "Rust" : return new String[] {context.getString(R.string.rust),"/drawable/rust.png"};
            case "Sacrificial Bow" : return new String[] {context.getString(R.string.sacrificial_bow),"/drawable/sacrificial_bow.png"};
            case "The Stringless" : return new String[] {context.getString(R.string.the_stringless),"/drawable/the_stringless.png"};
            case "The Viridescent Hunt" : return new String[] {context.getString(R.string.the_viridescent_hunt),"/drawable/the_viridescent_hunt.png"};
            case "Windblume Ode" : return new String[] {context.getString(R.string.windblume_ode),"/drawable/windblume_ode.png"};
            case "Amos' Bow" : return new String[] {context.getString(R.string.amos_bow),"/drawable/amos_bow.png"};
            case "Elegy for the End" : return new String[] {context.getString(R.string.elegy_for_the_end),"/drawable/elegy_for_the_end.png"};
            case "Skyward Harp" : return new String[] {context.getString(R.string.skyward_harp),"/drawable/skyward_harp.png"};
            case "Thundering Pulse" : return new String[] {context.getString(R.string.thundering_pulse),"/drawable/thundering_pulse.png"};
            case "Mouun's Moon" : return new String[] {context.getString(R.string.mouuns_moon),"/drawable/mouuns_moon.png"};

            default : return new String[] {context.getString(R.string.unknown),"/drawable/paimon_lost.png"};
        }
    }

    public String getWeaponNameByFileName (String str){
        switch (str){
            case "amenoma_kageuchi" : return "Amenoma Kageuchi";
            case "aquila_favonia" : return "Aquila Favonia";
            case "blackcliff_longsword" : return "Blackcliff Longsword";
            case "cool_steel" : return "Cool Steel";
            case "dark_iron_sword" : return "Dark Iron Sword";
            case "dull_blade" : return "Dull Blade";
            case "favonius_sword" : return "Favonius Sword";
            case "festering_desire" : return "Festering Desire";
            case "fillet_blade" : return "Fillet Blade";
            case "freedom_sworn" : return "Freedom-Sworn";
            case "harbinger_of_dawn" : return "Harbinger of Dawn";
            case "iron_sting" : return "Iron Sting";
            case "lions_roar" : return "Lion's Roar";
            case "mistsplitter_reforged" : return "Mistsplitter Reforged";
            case "primordial_jade_cutter" : return "Primordial Jade Cutter";
            case "prototype_rancour" : return "Prototype Rancour";
            case "royal_longsword" : return "Royal Longsword";
            case "sacrificial_sword" : return "Sacrificial Sword";
            case "silver_sword" : return "Silver Sword";
            case "skyrider_sword" : return "Skyrider Sword";
            case "skyward_blade" : return "Skyward Blade";
            case "summit_shaper" : return "Summit Shaper";
            case "sword_of_descension" : return "Sword of Descension";
            case "the_alley_flash" : return "The Alley Flash";
            case "the_black_sword" : return "The Black Sword";
            case "the_flute" : return "The Flute";
            case "travelers_handy_sword" : return "Traveler's Handy Sword";

            case "waster_greatsword" : return "Waster Greatsword";
            case "old_mercs_pal" : return "Old Merc's Pal";
            case "bloodtainted_greatsword" : return "Bloodtainted Greatsword";
            case "debate_club" : return "Debate Club";
            case "quartz" : return "Quartz";
            case "ferrous_shadow" : return "Ferrous Shadow";
            case "skyrider_greatsword" : return "Skyrider Greatsword";
            case "white_iron_greatsword" : return "White Iron Greatsword";
            case "blackcliff_slasher" : return "Blackcliff Slasher";
            case "favonius_greatsword" : return "Favonius Greatsword";
            case "katsuragikiri_nagamasa" : return "Katsuragikiri Nagamasa";
            case "lithic_blade" : return "Lithic Blade";
            case "luxurious_sea_lord" : return "Luxurious Sea-Lord";
            case "prototype_archaic" : return "Prototype Archaic";
            case "rainslasher" : return "Rainslasher";
            case "royal_greatsword" : return "Royal Greatsword";
            case "sacrificial_greatsword" : return "Sacrificial Greatsword";
            case "serpent_spine" : return "Serpent Spine";
            case "snow_tombed_starsilver" : return "Snow-Tombed Starsilver";
            case "the_bell" : return "The Bell";
            case "whiteblind" : return "Whiteblind";
            case "skyward_pride" : return "Skyward Pride";
            case "song_of_broken_pines" : return "Song of Broken Pines";
            case "the_unforged" : return "The Unforged";
            case "wolfs_gravestone" : return "Wolf's Gravestone";

            case "beginners_protector" : return "Beginner's Protector";
            case "iron_point" : return "Iron Point";
            case "black_tassel" : return "Black Tassel";
            case "halberd" : return "Halberd";
            case "white_tassel" : return "White Tassel";
            case "blackcliff_pole" : return "Blackcliff Pole";
            case "crescent_pike" : return "Crescent Pike";
            case "deathmatch" : return "Deathmatch";
            case "dragons_bane" : return "Dragon's Bane";
            case "dragonspine_spear" : return "Dragonspine Spear";
            case "favonius_lance" : return "Favonius Lance";
            case "kitain_cross_spear" : return "Kitain Cross Spear";
            case "lithic_spear" : return "Lithic Spear";
            case "prototype_starglitter" : return "Prototype Starglitter";
            case "royal_spear" : return "Royal Spear";
            case "the_catch" : return "The Catch";
            case "engulfing_lightning" : return "Engulfing Lightning";
            case "primordial_jade_winged_spear" : return "Primordial Jade Winged-Spear";
            case "skyward_spine" : return "Skyward Spine";
            case "staff_of_homa" : return "Staff of Homa";
            case "vortex_vanquisher" : return "Vortex Vanquisher";

            case "apprentices_notes" : return "Apprentice's Notes";
            case "pocket_grimoire" : return "Pocket Grimoire";
            case "amber_catalyst" : return "Amber Catalyst";
            case "emerald_orb" : return "Emerald Orb";
            case "magic_guide" : return "Magic Guide";
            case "otherworldly_story" : return "Otherworldly Story";
            case "thrilling_tales_of_dragon_slayers" : return "Thrilling Tales of Dragon Slayers";
            case "twin_nephrite" : return "Twin Nephrite";
            case "blackcliff_agate" : return "Blackcliff Agate";
            case "dodoco_tales" : return "Dodoco Tales";
            case "eye_of_perception" : return "Eye of Perception";
            case "favonius_codex" : return "Favonius Codex";
            case "frostbearer" : return "Frostbearer";
            case "hakushin_ring" : return "Hakushin Ring";
            case "mappa_mare" : return "Mappa Mare";
            case "prototype_amber" : return "Prototype Amber";
            case "royal_grimoire" : return "Royal Grimoire";
            case "sacrificial_fragments" : return "Sacrificial Fragments";
            case "solar_pearl" : return "Solar Pearl";
            case "the_widsith" : return "The Widsith";
            case "wine_and_song" : return "Wine and Song";
            case "everlasting_moonglow" : return "Everlasting Moonglow";
            case "lost_prayer_to_the_sacred_winds" : return "Lost Prayer to the Sacred Winds";
            case "memory_of_dust" : return "Memory of Dust";
            case "skyward_atlas" : return "Skyward Atlas";

            case "hunters_bow" : return "Hunter's Bow";
            case "seasoned_hunters_bow" : return "Seasoned Hunter's Bow";
            case "ebony_bow" : return "Ebony Bow";
            case "messenger" : return "Messenger";
            case "raven_bow" : return "Raven Bow";
            case "recurve_bow" : return "Recurve Bow";
            case "sharpshooters_oath" : return "Sharpshooter's Oath";
            case "slingshot" : return "Slingshot";
            case "alley_hunter" : return "Alley Hunter";
            case "blackcliff_warbow" : return "Blackcliff Warbow";
            case "compound_bow" : return "Compound Bow";
            case "favonius_warbow" : return "Favonius Warbow";
            case "hamayumi" : return "Hamayumi";
            case "mitternachts_waltz" : return "Mitternachts Waltz";
            case "predator" : return "Predator";
            case "prototype_crescent" : return "Prototype Crescent";
            case "royal_bow" : return "Royal Bow";
            case "rust" : return "Rust";
            case "sacrificial_bow" : return "Sacrificial Bow";
            case "the_stringless" : return "The Stringless";
            case "the_viridescent_hunt" : return "The Viridescent Hunt";
            case "windblume_ode" : return "Windblume Ode";
            case "amos_bow" : return "Amos' Bow";
            case "elegy_for_the_end" : return "Elegy for the End";
            case "skyward_harp" : return "Skyward Harp";
            case "thundering_pulse" : return "Thundering Pulse";

            // add in 20211030
            case "akuoumaru" : return "Akuoumaru";
            case "wavebreakers_fin" : return "Wavebreaker's Fin";
            case "mouuns_moon" : return "Mouun's Moon";
            // add in 20211127
            case "cinnabar_spindle" : return "Cinnabar Spindle";
            // add in 20220104
            case "redhorn_stonethresher" : return "Redhorn Stonethresher";
            case "calamity_queller" : return "Calamity Queller";
            // add in 20220126
            case "kaguras_verity" : return "Kagura's Verity";
            case "oathsworn_eye" : return "Oathsworn Eye";

            default: return  "PAIMON_ATE";
        }
    }

    public String[] getArtifactByName (String str, Context context){


        switch (str){
            case "Adventurer" : return new String[] {context.getString(R.string.adventurer),"/drawable/adventurer_1.png","/drawable/adventurer_2.png","/drawable/adventurer_3.png","/drawable/adventurer_4.png","/drawable/adventurer_5.png"};
            case "Archaic Petra" : return new String[] {context.getString(R.string.archaic_petra),"/drawable/archaic_petra_1.png","/drawable/archaic_petra_2.png","/drawable/archaic_petra_3.png","/drawable/archaic_petra_4.png","/drawable/archaic_petra_5.png"};
            case "Berserker" : return new String[] {context.getString(R.string.berserker),"/drawable/berserker_1.png","/drawable/berserker_2.png","/drawable/berserker_3.png","/drawable/berserker_4.png","/drawable/berserker_5.png"};
            case "Blizzard Strayer" : return new String[] {context.getString(R.string.blizzard_strayer),"/drawable/blizzard_strayer_1.png","/drawable/blizzard_strayer_2.png","/drawable/blizzard_strayer_3.png","/drawable/blizzard_strayer_4.png","/drawable/blizzard_strayer_5.png"};
            case "Bloodstained Chivalry" : return new String[] {context.getString(R.string.bloodstained_chivalry),"/drawable/bloodstained_chivalry_1.png","/drawable/bloodstained_chivalry_2.png","/drawable/bloodstained_chivalry_3.png","/drawable/bloodstained_chivalry_4.png","/drawable/bloodstained_chivalry_5.png"};
            case "Brave Heart" : return new String[] {context.getString(R.string.brave_heart),"/drawable/brave_heart_1.png","/drawable/brave_heart_2.png","/drawable/brave_heart_3.png","/drawable/brave_heart_4.png","/drawable/brave_heart_5.png"};
            case "Crimson Witch of Flames" : return new String[] {context.getString(R.string.crimson_witch_of_flames),"/drawable/crimson_witch_of_flames_1.png","/drawable/crimson_witch_of_flames_2.png","/drawable/crimson_witch_of_flames_3.png","/drawable/crimson_witch_of_flames_4.png","/drawable/crimson_witch_of_flames_5.png"};
            case "Defender's Will" : return new String[] {context.getString(R.string.defenders_will),"/drawable/defenders_will_1.png","/drawable/defenders_will_2.png","/drawable/defenders_will_3.png","/drawable/defenders_will_4.png","/drawable/defenders_will_5.png"};
            case "Emblem of Severed Fate" : return new String[] {context.getString(R.string.emblem_of_severed_fate),"/drawable/emblem_of_severed_fate_1.png","/drawable/emblem_of_severed_fate_2.png","/drawable/emblem_of_severed_fate_3.png","/drawable/emblem_of_severed_fate_4.png","/drawable/emblem_of_severed_fate_5.png"};
            case "Gambler" : return new String[] {context.getString(R.string.gambler),"/drawable/gambler_1.png","/drawable/gambler_2.png","/drawable/gambler_3.png","/drawable/gambler_4.png","/drawable/gambler_5.png"};
            case "Gladiator's Finale" : return new String[] {context.getString(R.string.gladiators_finale),"/drawable/gladiators_finale_1.png","/drawable/gladiators_finale_2.png","/drawable/gladiators_finale_3.png","/drawable/gladiators_finale_4.png","/drawable/gladiators_finale_5.png"};
            case "Heart of Depth" : return new String[] {context.getString(R.string.heart_of_depth),"/drawable/heart_of_depth_1.png","/drawable/heart_of_depth_2.png","/drawable/heart_of_depth_3.png","/drawable/heart_of_depth_4.png","/drawable/heart_of_depth_5.png"};
            case "Instructor" : return new String[] {context.getString(R.string.instructor),"/drawable/instructor_1.png","/drawable/instructor_2.png","/drawable/instructor_3.png","/drawable/instructor_4.png","/drawable/instructor_5.png"};
            case "Lavawalker" : return new String[] {context.getString(R.string.lavawalker),"/drawable/lavawalker_1.png","/drawable/lavawalker_2.png","/drawable/lavawalker_3.png","/drawable/lavawalker_4.png","/drawable/lavawalker_5.png"};
            case "Lucky Dog" : return new String[] {context.getString(R.string.lucky_dog),"/drawable/lucky_dog_1.png","/drawable/lucky_dog_2.png","/drawable/lucky_dog_3.png","/drawable/lucky_dog_4.png","/drawable/lucky_dog_5.png"};
            case "Maiden Beloved" : return new String[] {context.getString(R.string.maiden_beloved),"/drawable/maiden_beloved_1.png","/drawable/maiden_beloved_2.png","/drawable/maiden_beloved_3.png","/drawable/maiden_beloved_4.png","/drawable/maiden_beloved_5.png"};
            case "Martial Artist" : return new String[] {context.getString(R.string.martial_artist),"/drawable/martial_artist_1.png","/drawable/martial_artist_2.png","/drawable/martial_artist_3.png","/drawable/martial_artist_4.png","/drawable/martial_artist_5.png"};
            case "Noblesse Oblige" : return new String[] {context.getString(R.string.noblesse_oblige),"/drawable/noblesse_oblige_1.png","/drawable/noblesse_oblige_2.png","/drawable/noblesse_oblige_3.png","/drawable/noblesse_oblige_4.png","/drawable/noblesse_oblige_5.png"};
            case "Pale Flame" : return new String[] {context.getString(R.string.pale_flame),"/drawable/pale_flame_1.png","/drawable/pale_flame_2.png","/drawable/pale_flame_3.png","/drawable/pale_flame_4.png","/drawable/pale_flame_5.png"};
            case "Prayers of Destiny" : return new String[] {context.getString(R.string.prayers_of_destiny),"/drawable/prayers_of_destiny_4.png"};
            case "Prayers of Illumination" : return new String[] {context.getString(R.string.prayers_of_illumination),"/drawable/prayers_of_illumination_4.png"};
            case "Prayers of Wisdom" : return new String[] {context.getString(R.string.prayers_of_wisdom),"/drawable/prayers_of_wisdom_4.png"};
            case "Prayers of Springtime" : return new String[] {context.getString(R.string.prayers_of_springtime),"/drawable/prayers_of_springtime_4.png"};
            case "Resolution of Sojourner" : return new String[] {context.getString(R.string.resolution_of_sojourner),"/drawable/resolution_of_sojourner_1.png","/drawable/resolution_of_sojourner_2.png","/drawable/resolution_of_sojourner_3.png","/drawable/resolution_of_sojourner_4.png","/drawable/resolution_of_sojourner_5.png"};
            case "Retracing Bolide" : return new String[] {context.getString(R.string.retracing_bolide),"/drawable/retracing_bolide_1.png","/drawable/retracing_bolide_2.png","/drawable/retracing_bolide_3.png","/drawable/retracing_bolide_4.png","/drawable/retracing_bolide_5.png"};
            case "Scholar" : return new String[] {context.getString(R.string.scholar),"/drawable/scholar_1.png","/drawable/scholar_2.png","/drawable/scholar_3.png","/drawable/scholar_4.png","/drawable/scholar_5.png"};
            case "Shimenawa's Reminiscence" : return new String[] {context.getString(R.string.shimenawas_reminiscence),"/drawable/shimenawas_reminiscence_1.png","/drawable/shimenawas_reminiscence_2.png","/drawable/shimenawas_reminiscence_3.png","/drawable/shimenawas_reminiscence_4.png","/drawable/shimenawas_reminiscence_5.png"};
            case "Tenacity of the Millelith" : return new String[] {context.getString(R.string.tenacity_of_the_millelith),"/drawable/tenacity_of_the_millelith_1.png","/drawable/tenacity_of_the_millelith_2.png","/drawable/tenacity_of_the_millelith_3.png","/drawable/tenacity_of_the_millelith_4.png","/drawable/tenacity_of_the_millelith_5.png"};
            case "The Exile" : return new String[] {context.getString(R.string.the_exile),"/drawable/the_exile_1.png","/drawable/the_exile_2.png","/drawable/the_exile_3.png","/drawable/the_exile_4.png","/drawable/the_exile_5.png"};
            case "Thundering Fury" : return new String[] {context.getString(R.string.thundering_fury),"/drawable/thundering_fury_1.png","/drawable/thundering_fury_2.png","/drawable/thundering_fury_3.png","/drawable/thundering_fury_4.png","/drawable/thundering_fury_5.png"};
            case "Thunder-soother" : return new String[] {context.getString(R.string.thundersoother),"/drawable/thundersoother_1.png","/drawable/thundersoother_2.png","/drawable/thundersoother_3.png","/drawable/thundersoother_4.png","/drawable/thundersoother_5.png"};
            case "Tiny Miracle" : return new String[] {context.getString(R.string.tiny_miracle),"/drawable/tiny_miracle_1.png","/drawable/tiny_miracle_2.png","/drawable/tiny_miracle_3.png","/drawable/tiny_miracle_4.png","/drawable/tiny_miracle_5.png"};
            case "Traveling Doctor" : return new String[] {context.getString(R.string.traveling_doctor),"/drawable/traveling_doctor_1.png","/drawable/traveling_doctor_2.png","/drawable/traveling_doctor_3.png","/drawable/traveling_doctor_4.png","/drawable/traveling_doctor_5.png"};
            case "Viridescent Venerer" : return new String[] {context.getString(R.string.viridescent_venerer),"/drawable/viridescent_venerer_1.png","/drawable/viridescent_venerer_2.png","/drawable/viridescent_venerer_3.png","/drawable/viridescent_venerer_4.png","/drawable/viridescent_venerer_5.png"};
            case "Wanderer's Troupe" : return new String[] {context.getString(R.string.wanderers_troupe),"/drawable/wanderers_troupe_1.png","/drawable/wanderers_troupe_2.png","/drawable/wanderers_troupe_3.png","/drawable/wanderers_troupe_4.png","/drawable/wanderers_troupe_5.png"};

            // add in 20211127
            case "Husk of Opulent Dreams" : return new String[] {context.getString(R.string.husk_of_opulent_dreams),"/drawable/husk_of_opulent_dreams_1.png","/drawable/husk_of_opulent_dreams_2.png","/drawable/husk_of_opulent_dreams_3.png","/drawable/husk_of_opulent_dreams_4.png","/drawable/husk_of_opulent_dreams_5.png"};
            case "Ocean-Hued Clam" : return new String[] {context.getString(R.string.ocean_hued_clam),"/drawable/ocean_hued_clam_1.png","/drawable/ocean_hued_clam_2.png","/drawable/ocean_hued_clam_3.png","/drawable/ocean_hued_clam_4.png","/drawable/ocean_hued_clam_5.png"};

            default: return new String[] {context.getString(R.string.unknown),"/drawable/paimon_lost.png","/drawable/paimon_lost.png","/drawable/paimon_lost.png","/drawable/paimon_lost.png","/drawable/paimon_lost.png"};

        }
    }

    public String getArtifactNameByFileName (String str){
        switch (str){
            case "adventurer" : return "Adventurer";
            case "archaic_petra" : return "Archaic Petra";
            case "berserker" : return "Berserker";
            case "blizzard_strayer" : return "Blizzard Strayer";
            case "bloodstained_chivalry" : return "Bloodstained Chivalry";
            case "brave_heart" : return "Brave Heart";
            case "crimson_witch_of_flames" : return "Crimson Witch of Flames";
            case "defenders_will" : return "Defender's Will";
            case "emblem_of_severed_fate" : return "Emblem of Severed Fate";
            case "gambler" : return "Gambler";
            case "gladiators_finale" : return "Gladiator's Finale";
            case "heart_of_depth" : return "Heart of Depth";
            case "instructor" : return "Instructor";
            case "lavawalker" : return "Lavawalker";
            case "lucky_dog" : return "Lucky Dog";
            case "maiden_beloved" : return "Maiden Beloved";
            case "martial_artist" : return "Martial Artist";
            case "noblesse_oblige" : return "Noblesse Oblige";
            case "pale_flame" : return "Pale Flame";
            case "prayers_of_destiny" : return "Prayers of Destiny";
            case "prayers_of_illumination" : return "Prayers of Illumination";
            case "prayers_of_wisdom" : return "Prayers of Wisdom";
            case "prayers_of_springtime" : return "Prayers of Springtime";
            case "resolution_of_sojourner" : return "Resolution of Sojourner";
            case "retracing_bolide" : return "Retracing Bolide";
            case "scholar" : return "Scholar";
            case "shimenawas_reminiscence" : return "Shimenawa's Reminiscence";
            case "tenacity_of_the_millelith" : return "Tenacity of the Millelith";
            case "the_exile" : return "The Exile";
            case "thundering_fury" : return "Thundering Fury";
            case "thundersoother" : return "Thunder-soother";
            case "tiny_miracle" : return "Tiny Miracle";
            case "traveling_doctor" : return "Traveling Doctor";
            case "viridescent_venerer" : return "Viridescent Venerer";
            case "wanderers_troupe" : return "Wanderer's Troupe";

            // add in 20211127
            case "husk_of_opulent_dreams" : return "Husk of Opulent Dreams";
            case "ocean_hued_clam" : return "Ocean-Hued Clam";

            default: return  "PAIMON_ATE";
        }
    }
        /**
         * @param name is Char's Identify Name -> JSON
         * @return IMG_ID , NAME_LOCAL , FULL_IMG_ID , ICO_IMG_ID
         */

    /**EDIT WHEN ADD NEW ITEMS*/
    public String[]  getCharByName(String name, Context context){
        if(name.equals("Yae Miko")){return new String[] {"/drawable/yae_miko_flag.png",context.getString(R.string.yae_miko),"/drawable/yae_miko_full.png","/drawable/yae_miko_ico.png"};}
        else if(name.equals("Shenhe")){return new String[] {"/drawable/shenhe_flag.png",context.getString(R.string.shenhe),"/drawable/shenhe_full.png","/drawable/shenhe_ico.png"};}
        else if(name.equals("Yun Jin")){return new String[] {"/drawable/yun_jin_flag.png",context.getString(R.string.yun_jin),"/drawable/yun_jin_full.png","/drawable/yun_jin_ico.png"};}
        else if(name.equals("Gorou")){return new String[] {"/drawable/gorou_flag.png",context.getString(R.string.gorou),"/drawable/gorou_full.png","/drawable/gorou_ico.png"};}
        else if(name.equals("Arataki Itto")){return new String[] {"/drawable/arataki_itto_flag.png",context.getString(R.string.arataki_itto),"/drawable/arataki_itto_full.png","/drawable/arataki_itto_ico.png"};}
        else if(name.equals("Thoma")){return new String[] {"/drawable/thoma_flag.png",context.getString(R.string.thoma),"/drawable/thoma_full.png","/drawable/thoma_ico.png"};}
        else if(name.equals("Sangonomiya Kokomi")){return new String[] {"/drawable/sangonomiya_kokomi_flag.png",context.getString(R.string.sangonomiya_kokomi),"/drawable/sangonomiya_kokomi_full.png","/drawable/sangonomiya_kokomi_ico.png"};}
        else if(name.equals("Aloy")){return new String[] {"/drawable/aloy.png",context.getString(R.string.aloy),"/drawable/aloy.png","/drawable/aloy_ico.png"};}
        else if(name.equals("Kujou Sara")){return new String[] {"/drawable/kujou_sara_flag.png",context.getString(R.string.kujou_sara),"/drawable/kujou_sara_full.png","/drawable/kujou_sara_ico.png"};}
        else if(name.equals("Raiden Shogun")){return new String[] {"/drawable/raiden_shogun_flag.png",context.getString(R.string.raiden_shogun),"/drawable/raiden_shogun_full.png","/drawable/raiden_shogun_ico.png"};}
        else if(name.equals("Sayu")){return new String[] {"/drawable/sayu_flag.png",context.getString(R.string.sayu),"/drawable/sayu_full.png","/drawable/sayu_ico.png"};}
        else if(name.equals("Yoimiya")){return new String[] {"/drawable/yoimiya_flag.png",context.getString(R.string.yoimiya),"/drawable/yoimiya_full.png","/drawable/yoimiya_ico.png"};}
        else if(name.equals("Kamisato Ayaka")){return new String[] {"/drawable/ayaka_flag.png",context.getString(R.string.kamisato_ayaka),"/drawable/ayaka_full.png","/drawable/ayaka_ico.png"};}
        else if(name.equals("Kaedehara Kazuha")){return new String[] {"/drawable/kazuha_flag.png",context.getString(R.string.kaedehara_kazuha),"/drawable/kazuha_full.png","/drawable/kazuha_ico.png"};}
        else if(name.equals("Yanfei")){return new String[] {"/drawable/yanfei_flag.png",context.getString(R.string.yanfei),"/drawable/yanfei_full.png","/drawable/yanfei_ico.png"};}
        else if(name.equals("Eula")){return new String[] {"/drawable/eula_flag.png",context.getString(R.string.eula),"/drawable/eula_full.png","/drawable/eula_ico.png"};}
        else if(name.equals("Rosaria")){return new String[] {"/drawable/rosaria_flag.png",context.getString(R.string.rosaria),"/drawable/rosaria_full.png","/drawable/rosaria_ico.png"};}
        else if(name.equals("Xiao")){return new String[] {"/drawable/xiao_flag.png",context.getString(R.string.xiao),"/drawable/xiao_full.png","/drawable/xiao_ico.png"};}
        else if(name.equals("Hu Tao")){return new String[] {"/drawable/hu_tao_flag.png",context.getString(R.string.hu_tao),"/drawable/hu_tao_full.png","/drawable/hu_tao_ico.png"};}
        else if(name.equals("Ganyu")){return new String[] {"/drawable/ganyu_flag.png",context.getString(R.string.ganyu),"/drawable/ganyu_full.png","/drawable/ganyu_ico.png"};}
        else if(name.equals("Albedo")){return new String[] {"/drawable/albedo_flag.png",context.getString(R.string.albedo),"/drawable/albedo_full.png","/drawable/albedo_ico.png"};}
        else if(name.equals("Zhongli")){return new String[] {"/drawable/zhongli_flag.png",context.getString(R.string.zhongli),"/drawable/zhongli_full.png","/drawable/zhongli_ico.png"};}
        else if(name.equals("Xinyan")){return new String[] {"/drawable/xinyan_flag.png",context.getString(R.string.xinyan),"/drawable/xinyan_full.png","/drawable/xinyan_ico.png"};}
        else if(name.equals("Tartaglia")){return new String[] {"/drawable/tartaglia_flag.png",context.getString(R.string.tartaglia),"/drawable/tartaglia_full.png","/drawable/tartaglia_ico.png"};}
        else if(name.equals("Diona")){return new String[] {"/drawable/diona_flag.png",context.getString(R.string.diona),"/drawable/diona_full.png","/drawable/diona_ico.png"};}
        else if(name.equals("Xingqiu")){return new String[] {"/drawable/xingqiu_flag.png",context.getString(R.string.xingqiu),"/drawable/xingqiu_full.png","/drawable/xingqiu_ico.png"};}
        else if(name.equals("Xiangling")){return new String[] {"/drawable/xiangling_flag.png",context.getString(R.string.xiangling),"/drawable/xiangling_full.png","/drawable/xiangling_ico.png"};}
        else if(name.equals("Venti")){return new String[] {"/drawable/venti_flag.png",context.getString(R.string.venti),"/drawable/venti_full.png","/drawable/venti_ico.png"};}
        else if(name.equals("Sucrose")){return new String[] {"/drawable/sucrose_flag.png",context.getString(R.string.sucrose),"/drawable/sucrose_full.png","/drawable/sucrose_ico.png"};}
        else if(name.equals("Razor")){return new String[] {"/drawable/razor_flag.png",context.getString(R.string.razor),"/drawable/razor_full.png","/drawable/razor_ico.png"};}
        else if(name.equals("Qiqi")){return new String[] {"/drawable/qiqi_flag.png",context.getString(R.string.qiqi),"/drawable/qiqi_full.png","/drawable/qiqi_ico.png"};}
        else if(name.equals("Noelle")){return new String[] {"/drawable/noelle_flag.png",context.getString(R.string.noelle),"/drawable/noelle_full.png","/drawable/noelle_ico.png"};}
        else if(name.equals("Ningguang")){return new String[] {"/drawable/ningguang_flag.png",context.getString(R.string.ningguang),"/drawable/ningguang_full.png","/drawable/ningguang_ico.png"};}
        else if(name.equals("Mona")){return new String[] {"/drawable/mona_flag.png",context.getString(R.string.mona),"/drawable/mona_full.png","/drawable/mona_ico.png"};}
        else if(name.equals("Lisa")){return new String[] {"/drawable/lisa_flag.png",context.getString(R.string.lisa),"/drawable/lisa_full.png","/drawable/lisa_ico.png"};}
        else if(name.equals("Klee")){return new String[] {"/drawable/klee_flag.png",context.getString(R.string.klee),"/drawable/klee_full.png","/drawable/klee_ico.png"};}
        else if(name.equals("Keqing")){return new String[] {"/drawable/keqing_flag.png",context.getString(R.string.keqing),"/drawable/keqing_full.png","/drawable/keqing_ico.png"};}
        else if(name.equals("Kaeya")){return new String[] {"/drawable/kaeya_flag.png",context.getString(R.string.kaeya),"/drawable/kaeya_full.png","/drawable/kaeya_ico.png"};}
        else if(name.equals("Jean")){return new String[] {"/drawable/jean_flag.png",context.getString(R.string.jean),"/drawable/jean_full.png","/drawable/jean_ico.png"};}
        else if(name.equals("Fischl")){return new String[] {"/drawable/fischl_flag.png",context.getString(R.string.fischl),"/drawable/fischl_full.png","/drawable/fischl_ico.png"};}
        else if(name.equals("Diluc")){return new String[] {"/drawable/diluc_flag.png",context.getString(R.string.diluc),"/drawable/diluc_full.png","/drawable/diluc_ico.png"};}
        else if(name.equals("Chongyun")){return new String[] {"/drawable/chongyun_flag.png",context.getString(R.string.chongyun),"/drawable/chongyun_full.png","/drawable/chongyun_ico.png"};}
        else if(name.equals("Bennett")){return new String[] {"/drawable/bennett_flag.png",context.getString(R.string.bennett),"/drawable/bennett_full.png","/drawable/bennett_ico.png"};}
        else if(name.equals("Beidou")){return new String[] {"/drawable/beidou_flag.png",context.getString(R.string.beidou),"/drawable/beidou_full.png","/drawable/beidou_ico.png"};}
        else if(name.equals("Barbara")){return new String[] {"/drawable/barbara_flag.png",context.getString(R.string.barbara),"/drawable/barbara_full.png","/drawable/barbara_ico.png"};}
        else if(name.equals("Amber")){return new String[] {"/drawable/amber_flag.png",context.getString(R.string.amber),"/drawable/amber_full.png","/drawable/amber_ico.png"};}
        //Add at 20210820, update at 20220109
        else if(name.equals("Traveler-Anemo")){
            sharedPreferences = context.getSharedPreferences("user_info.png",context.MODE_PRIVATE);
            String traveler_sex = sharedPreferences.getString("traveler_sex.png","F");

            if(traveler_sex.equals("M")){
                return new String[] {"/drawable/aether_flag.png",context.getString(R.string.traveler_anemo),"/drawable/aether_full.png","/drawable/aether_ico.png"};
            }else{
                return new String[] {"/drawable/lumine_flag.png",context.getString(R.string.traveler_anemo),"/drawable/lumine_full.png","/drawable/lumine_ico.png"};
            }
        }
        //Add at 20210820, update at 20220109
        else if(name.equals("Traveler-Geo")){
            sharedPreferences = context.getSharedPreferences("user_info.png",context.MODE_PRIVATE);
            String traveler_sex = sharedPreferences.getString("traveler_sex.png","F");

            if(traveler_sex.equals("M")){
                return new String[] {"/drawable/aether_flag.png",context.getString(R.string.traveler_geo),"/drawable/aether_full.png","/drawable/aether_ico.png"};
            }else{
                return new String[] {"/drawable/lumine_flag.png",context.getString(R.string.traveler_geo),"/drawable/lumine_full.png","/drawable/lumine_ico.png"};
            }
        }
        //Add at 20210820, update at 20220109
        else if(name.equals("Traveler-Electro")){
            sharedPreferences = context.getSharedPreferences("user_info.png",context.MODE_PRIVATE);
            String traveler_sex = sharedPreferences.getString("traveler_sex.png","F");

            if(traveler_sex.equals("M")){
                return new String[] {"/drawable/aether_flag.png",context.getString(R.string.traveler_electro),"/drawable/aether_full.png","/drawable/aether_ico.png"};
            }else{
                return new String[] {"/drawable/lumine_flag.png",context.getString(R.string.traveler_electro),"/drawable/lumine_full.png","/drawable/lumine_ico.png"};
            }
        }
        // ???
        else if(name.equals("Voc-夜芷冰")){return new String[] {"/drawable/mascot.png",context.getString(R.string.voc),"/drawable/mascot.png","/drawable/mascot_head.png"};}

        return new String[] {"/drawable/paimon_lost.png",context.getString(R.string.unknown),"/drawable/paimon_lost.png","/drawable/paimon_lost.png"};
    }

    /**
     * @param element Element Name
     * @return ICON_ID , RAD_BG_ID , BG_COLOR_ID
     */
    public int[] getElementByName (String element) {
        if(element.equals("Anemo")) {return new int[] {R.drawable.anemo,R.drawable.bg_anemo_char,R.color.anemo};}
        else if(element.equals("Cryo")) {return new int[] {R.drawable.cryo,R.drawable.bg_cryo_char,R.color.cryo};}
        else if(element.equals("Dendor")) {return new int[] {R.drawable.dendro,R.drawable.bg_dendro_char,R.color.dendor};}
        else if(element.equals("Electro")) {return new int[] {R.drawable.electro,R.drawable.bg_electro_char,R.color.electro};}
        else if(element.equals("Geo")) {return new int[] {R.drawable.geo,R.drawable.bg_geo_char,R.color.geo};}
        else if(element.equals("Hydro")) {return new int[] {R.drawable.hydro,R.drawable.bg_hydro_char,R.color.hydro};}
        else if(element.equals("Pyro")) {return new int[] {R.drawable.pyro,R.drawable.bg_pyro_char,R.color.pyro};}
        else return new int[] {R.drawable.paimon_lost,R.drawable.paimon_lost,R.color.anemo};
    }

    public Drawable getTalentIcoByName (String name, Context context){
        try {
            File file = new File(context.getFilesDir()+"/skills/"+name+".png");
            InputStream stream = new FileInputStream(file);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(stream, null);
            // set image to ImageView
            return d;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable myIcon = context.getResources().getDrawable( R.drawable.paimon_lost );
        return myIcon;
    }

    public int getSecAttr(String str) {
        switch (str){
            case "CritRate%" : return R.string.weapon_stat_CritRateP;
            case "ATK" : return R.string.weapon_stat_atk;
            case "HP%" : return R.string.weapon_stat_HPP;
            case "ATK%" : return R.string.weapon_stat_atkP;
            case "DEF%" : return R.string.weapon_stat_DEFP;
            case "EnRech%" : return R.string.weapon_stat_EnRechP;
            case "PhyDMG%" : return R.string.weapon_stat_PhyDMGP;
            case "CritDMG%" : return R.string.weapon_stat_CritDMGP;
            case "EleMas" : return R.string.weapon_stat_EleMas;
            default: return  R.string.weapon_stat_no;
        }
    }

    /**EDIT WHEN ADD NEW ITEMS*/
    public String getItemIcoByName (String name ,Context context){
        /** Boss*/
        if(name.equals("常燃火種")){return "/drawable/everflame_seed.png";}
        else if(name.equals("淨水之心")){return "/drawable/cleansing_heart.png";}
        else if(name.equals("雷光棱鏡")){return "/drawable/lightning_prism.png";}
        else if(name.equals("極寒之核")){return "/drawable/hoarfrost_core.png";}
        else if(name.equals("颶風之種")){return "/drawable/hurricane_seed.png";}
        else if(name.equals("玄岩之塔")){return "/drawable/basalt_pillar.png";}
        else if(name.equals("未熟之玉")){return "/drawable/juvenile_jade.png";}
        else if(name.equals("晶凝之華")){return "/drawable/crystalline_bloom.png";}
        else if(name.equals("魔偶機心")){return "/drawable/maguu_kishin.png";}
        else if(name.equals("恒常機關之心")){return "/drawable/perpetual_heart.png";}
        else if(name.equals("陰燃之珠")){return "/drawable/smoldering_pearl.png";}
        //add in 20210910
        else if(name.equals("雷霆數珠")){return "/drawable/storm_beads.png";}
        else if(name.equals("排異之露")){return "/drawable/dew_of_repudiation.png";}

        /** Local*/
        else if(name.equals("小燈草")){return "/drawable/small_lamp_grass.png";}
        else if(name.equals("慕風蘑菇")){return "/drawable/philanemo_mushroom.png";}
        else if(name.equals("夜泊石")){return "/drawable/noctilous_jade.png";}
        else if(name.equals("風車菊")){return "/drawable/windwheel_aster.png";}
        else if(name.equals("石珀")){return "/drawable/cor_lapis.png";}
        else if(name.equals("蒲公英籽")){return "/drawable/dandelion_seed.png";}
        else if(name.equals("嘟嘟蓮")){return "/drawable/calla_lily.png";}
        else if(name.equals("落落莓")){return "/drawable/valberry.png";}
        else if(name.equals("琉璃百合")){return "/drawable/glaze_lily.png";}
        else if(name.equals("琉璃袋")){return "/drawable/violetgrass.png";}
        else if(name.equals("鉤鉤果")){return "/drawable/wolfhook.png";}
        else if(name.equals("塞西莉亞花")){return "/drawable/cecilia.png";}
        else if(name.equals("絕雲椒椒")){return "/drawable/jueyun_chili.png";}
        else if(name.equals("霓裳花")){return "/drawable/silk_flower.png";}
        else if(name.equals("星螺")){return "/drawable/starconch.png";}
        else if(name.equals("清心")){return "/drawable/qingxin.png";}
        else if(name.equals("海靈芝")){return "/drawable/sea_ganoderma.png";}
        else if(name.equals("緋櫻繡球")){return "/drawable/sakura_bloom.png";}
        else if(name.equals("鳴草")){return "/drawable/naku_weed.png";}
        else if(name.equals("晶化骨髓")){return "/drawable/crystal_marrow.png";}
        //add in 20210910
        else if(name.equals("天雲草實")){return "/drawable/amakumo_fruit.png";}
        else if(name.equals("血斛")){return "/drawable/dendrobium.png";}
        else if(name.equals("幽燈蕈")){return "/drawable/fluorescent_fungus.png";}
        else if(name.equals("珊瑚真珠")){return "/drawable/sango_pearl.png";}


        /** T-Boss*/
        else if(name.equals("北風之環")){return "/drawable/ring_of_boreas.png";}
        else if(name.equals("東風的吐息")){return "/drawable/dvalins_sigh.png";}
        else if(name.equals("東風之翎")){return "/drawable/dvalins_plume.png";}
        else if(name.equals("北風的魂匣")){return "/drawable/spirit_locket_of_boreas.png";}
        else if(name.equals("東風之爪")){return "/drawable/dvalins_claw.png";}
        else if(name.equals("北風之尾")){return "/drawable/tail_of_boreas.png";}
        else if(name.equals("魔王之刃·殘片")){return "/drawable/shard_of_foul_legacy.png";}
        else if(name.equals("吞天之鯨·只角")){return "/drawable/tusk_of_monoceros_caeli.png";}
        else if(name.equals("武煉之魂·孤影")){return "/drawable/shadow_of_the_warrior.png";}
        else if(name.equals("龍王之冕")){return "/drawable/dragon_lords_crown.png";}
        else if(name.equals("血玉之枝")){return "/drawable/bloodjade_branch.png";}
        else if(name.equals("鎏金之鱗")){return "/drawable/gilded_scale.png";}
        //add in 20210910
        else if(name.equals("熔毀之刻")){return "/drawable/molten_moment.png";}
        else if(name.equals("灰燼之心")){return "/drawable/ashen_heart.png";}
        else if(name.equals("獄火之蝶")){return "/drawable/hellfire_butterfly.png";}

        /** Common*/
        else if(name.equals("牢固的箭簇")){return "/drawable/firm_arrowhead.png";}
        else if(name.equals("銳利的箭簇")){return "/drawable/sharp_arrowhead.png";}
        else if(name.equals("歷戰的箭簇")){return "/drawable/weathered_arrowhead.png";}
        else if(name.equals("導能繪卷")){return "/drawable/divining_scroll.png";}
        else if(name.equals("封魔繪卷")){return "/drawable/sealed_scroll.png";}
        else if(name.equals("禁咒繪卷")){return "/drawable/forbidden_curse_scroll.png";}
        else if(name.equals("尋寶鴉印")){return "/drawable/treasure_hoarder_insignia.png";}
        else if(name.equals("藏銀鴉印")){return "/drawable/silver_raven_insignia.png";}
        else if(name.equals("攫金鴉印")){return "/drawable/golden_raven_insignia.png";}
        else if(name.equals("破損的面具")){return "/drawable/damaged_mask.png";}
        else if(name.equals("污穢的面具")){return "/drawable/stained_mask.png";}
        else if(name.equals("不祥的面具")){return "/drawable/ominous_mask.png";}
        else if(name.equals("新兵的徽記")){return "/drawable/recruits_insignia.png";}
        else if(name.equals("士官的徽記")){return "/drawable/sergeants_insignia.png";}
        else if(name.equals("尉官的徽記")){return "/drawable/lieutenants_insignia.png";}
        else if(name.equals("騙騙花蜜")){return "/drawable/whopperflower_nectar.png";}
        else if(name.equals("微光花蜜")){return "/drawable/shimmering_nectar.png";}
        else if(name.equals("原素花蜜")){return "/drawable/energy_nectar.png";}
        else if(name.equals("史萊姆凝液")){return "/drawable/slime_condensate.png";}
        else if(name.equals("史萊姆清")){return "/drawable/slime_secretions.png";}
        else if(name.equals("史萊姆原漿")){return "/drawable/slime_concentrate.png";}
        else if(name.equals("破舊的刀鐔")){return "/drawable/old_handguard.png";}
        else if(name.equals("影打刀鐔")){return "/drawable/kageuchi_handguard.png";}
        else if(name.equals("名刀鐔")){return "/drawable/famed_handguard.png";}
        //add in 20210910
        else if(name.equals("浮游乾核")){return "/drawable/spectral_husk.png";}
        else if(name.equals("浮游幽核")){return "/drawable/spectral_heart.png";}
        else if(name.equals("浮游晶化核")){return "/drawable/spectral_nucleus.png";}
        //add in 20211024 (RE)
        else if(name.equals("漆黑隕鐵的一粒")){return "/drawable/grain_of_aerosiderite.png";}
        else if(name.equals("漆黑隕鐵的一片")){return "/drawable/piece_of_aerosiderite.png";}
        else if(name.equals("漆黑隕鐵的一角")){return "/drawable/bit_of_aerosiderite.png";}
        else if(name.equals("漆黑隕鐵的一塊")){return "/drawable/chunk_of_aerosiderite.png";}
        else if(name.equals("鳴神御靈的明惠")){return "/drawable/narukamis_wisdom.png";}
        else if(name.equals("鳴神御靈的歡喜")){return "/drawable/narukamis_joy.png";}
        else if(name.equals("鳴神御靈的親愛")){return "/drawable/narukamis_affection.png";}
        else if(name.equals("鳴神御靈的勇武")){return "/drawable/narukamis_valor.png";}
        else if(name.equals("遠海夷地的瑚枝")){return "/drawable/coral_branch_of_a_distant_sea.png";}
        else if(name.equals("遠海夷地的玉枝")){return "/drawable/jeweled_branch_of_a_distant_sea.png";}
        else if(name.equals("遠海夷地的瓊枝")){return "/drawable/jade_branch_of_a_distant_sea.png";}
        else if(name.equals("遠海夷地的金枝")){return "/drawable/golden_branch_of_a_distant_sea.png";}
        else if(name.equals("凜風奔狼的始齔")){return "/drawable/boreal_wolfs_milk_tooth.png";}
        else if(name.equals("凜風奔狼的裂齒")){return "/drawable/boreal_wolfs_cracked_tooth.png";}
        else if(name.equals("凜風奔狼的斷牙")){return "/drawable/boreal_wolfs_broken_fang.png";}
        else if(name.equals("凜風奔狼的懷鄉")){return "/drawable/boreal_wolfs_nostalgia.png";}
        else if(name.equals("高塔孤王的破瓦")){return "/drawable/tile_of_decarabians_tower.png";}
        else if(name.equals("高塔孤王的殘垣")){return "/drawable/debris_of_decarabians_city.png";}
        else if(name.equals("高塔孤王的斷片")){return "/drawable/fragment_of_decarabians_epic.png";}
        else if(name.equals("高塔孤王的碎夢")){return "/drawable/scattered_piece_of_decarabianss_dream.png";}
        else if(name.equals("霧海雲間的鉛丹")){return "/drawable/mist_veiled_lead_elixir.png";}
        else if(name.equals("霧海雲間的汞丹")){return "/drawable/mist_veiled_mercury_elixir.png";}
        else if(name.equals("霧海雲間的金丹")){return "/drawable/mist_veiled_gold_elixir.png";}
        else if(name.equals("霧海雲間的轉還")){return "/drawable/mist_veiled_primo_elixir.png";}
        else if(name.equals("獅牙鬥士的枷鎖")){return "/drawable/fetters_of_the_dandelion_gladiator.png";}
        else if(name.equals("獅牙鬥士的鐵鍊")){return "/drawable/chains_of_the_dandelion_gladiator.png";}
        else if(name.equals("獅牙鬥士的鐐銬")){return "/drawable/shackles_of_the_dandelion_gladiator.png";}
        else if(name.equals("獅牙鬥士的理想")){return "/drawable/dream_of_the_dandelion_gladiator.png";}
        else if(name.equals("孤雲寒林的光砂")){return "/drawable/luminous_sands_from_guyun.png";}
        else if(name.equals("孤雲寒林的輝岩")){return "/drawable/lustrous_stone_from_guyun.png";}
        else if(name.equals("孤雲寒林的聖骸")){return "/drawable/relic_from_guyun.png";}
        else if(name.equals("孤雲寒林的神體")){return "/drawable/divine_body_from_guyun.png";}
        else if(name.equals("今昔劇畫的惡尉")){return "/drawable/mask_of_the_wicked_lieutenant.png";}
        else if(name.equals("今昔劇畫的虎囓")){return "/drawable/mask_of_the_tigers_bite.png";}
        else if(name.equals("今昔劇畫的一角")){return "/drawable/mask_of_the_one_horned.png";}
        else if(name.equals("今昔劇畫的鬼人")){return "/drawable/mask_of_the_kijin.png";}

        else if(name.equals("混沌機關")){return "/drawable/chaos_gear.png";}
        else if(name.equals("混沌樞紐")){return "/drawable/chaos_axis.png";}
        else if(name.equals("混沌真眼")){return "/drawable/chaos_oculus.png";}
        else if(name.equals("混沌裝置")){return "/drawable/chaos_device.png";}
        else if(name.equals("混沌迴路")){return "/drawable/chaos_circuit.png";}
        else if(name.equals("混沌爐心")){return "/drawable/chaos_core.png";}
        else if(name.equals("脆弱的骨片")){return "/drawable/sturdy_bone_shard.png";}
        else if(name.equals("結實的骨片")){return "/drawable/fragile_bone_shard.png";}
        else if(name.equals("石化的骨片")){return "/drawable/fossilized_bone_shard.png";}
        else if(name.equals("霧虛花粉")){return "/drawable/mist_grass_pollen.png";}
        else if(name.equals("霧虛草囊")){return "/drawable/mist_grass_wick.png";}
        else if(name.equals("霧虛燈芯")){return "/drawable/mist_grass.png";}
        else if(name.equals("獵兵祭刀")){return "/drawable/hunters_sacrificial_knife.png";}
        else if(name.equals("特工祭刀")){return "/drawable/inspectors_sacrificial_knife.png";}
        else if(name.equals("督察長祭刀")){return "/drawable/agents_sacrificial_knife.png";}
        else if(name.equals("沉重號角")){return "/drawable/heavy_horn.png";}
        else if(name.equals("黑銅號角")){return "/drawable/black_bronze_horn.png";}
        else if(name.equals("黑晶號角")){return "/drawable/black_crystal_horn.png";}
        else if(name.equals("地脈的舊枝")){return "/drawable/dead_ley_line_branch.png";}
        else if(name.equals("地脈的枯葉")){return "/drawable/dead_ley_line_leaves.png";}
        else if(name.equals("地脈的新芽")){return "/drawable/ley_line_sprout.png";}
        else if(name.equals("黯淡棱鏡")){return "/drawable/dismal_prism.png";}
        else if(name.equals("水晶棱鏡")){return "/drawable/crystal_prism.png";}
        else if(name.equals("偏光棱鏡")){return "/drawable/polarizing_prism.png";}
        else if(name.equals("隱獸指爪")){return "/drawable/concealed_claw.png";}
        else if(name.equals("隱獸利爪")){return "/drawable/concealed_unguis.png";}
        else if(name.equals("隱獸鬼爪")){return "/drawable/concealed_talon.png";}
        //add in 20220105
        else if(name.equals("獸境王器")){return "/drawable/riftborn_regalia.png";}
        else if(name.equals("龍嗣偽鰭")){return "/drawable/dragonheirs_false_fin.png";}


        /** T-Book*/
        else if(name.equals("「自由」的教導")){return "/drawable/teaching_of_freedom.png";}
        else if(name.equals("「黃金」的教導")){return "/drawable/teaching_of_gold.png";}
        else if(name.equals("「抗爭」的教導")){return "/drawable/teaching_of_resistance.png";}
        else if(name.equals("「繁榮」的教導")){return "/drawable/teaching_of_prosperity.png";}
        else if(name.equals("「詩文」的教導")){return "/drawable/teaching_of_ballad.png";}
        else if(name.equals("「勤勞」的教導")){return "/drawable/teaching_of_diligence.png";}
        else if(name.equals("「風雅」的教導")){return "/drawable/teachings_of_elegance.png";}
        else if(name.equals("「浮世」的教導")){return "/drawable/teachings_of_transience.png";}
        else if(name.equals("「天光」的教導")){return "/drawable/teachings_of_light.png";}
        else if(name.equals("「自由」的指引")){return "/drawable/guide_to_freedom.png";}
        else if(name.equals("「黃金」的指引")){return "/drawable/guide_to_gold.png";}
        else if(name.equals("「抗爭」的指引")){return "/drawable/guide_to_resistance.png";}
        else if(name.equals("「繁榮」的指引")){return "/drawable/guide_to_prosperity.png";}
        else if(name.equals("「詩文」的指引")){return "/drawable/guide_to_ballad.png";}
        else if(name.equals("「勤勞」的指引")){return "/drawable/guide_to_diligence.png";}
        else if(name.equals("「風雅」的指引")){return "/drawable/guide_of_elegance.png";}
        else if(name.equals("「浮世」的指引")){return "/drawable/guide_of_transience.png";}
        else if(name.equals("「天光」的指引")){return "/drawable/guide_of_light.png";}
        else if(name.equals("「自由」的哲學")){return "/drawable/philosophies_of_freedom.png";}
        else if(name.equals("「黃金」的哲學")){return "/drawable/philosophies_of_gold.png";}
        else if(name.equals("「抗爭」的哲學")){return "/drawable/philosophies_of_resistance.png";}
        else if(name.equals("「繁榮」的哲學")){return "/drawable/philosophies_of_prosperity.png";}
        else if(name.equals("「詩文」的哲學")){return "/drawable/philosophies_of_ballad.png";}
        else if(name.equals("「勤勞」的哲學")){return "/drawable/philosophies_of_diligence.png";}
        else if(name.equals("「風雅」的哲學")){return "/drawable/philosophies_of_elegance.png";}
        else if(name.equals("「浮世」的哲學")){return "/drawable/philosophies_of_transience.png";}
        else if(name.equals("「天光」的哲學")){return "/drawable/philosophies_of_light.png";}

        /** Crystal*/
        else if(name.equals("燃願瑪瑙碎屑")){return "/drawable/agnidus_agate_sliver.png";}
        else if(name.equals("燃願瑪瑙斷片")){return "/drawable/agnidus_agate_fragment.png";}
        else if(name.equals("燃願瑪瑙塊")){return "/drawable/agnidus_agate_chunk.png";}
        else if(name.equals("燃願瑪瑙")){return "/drawable/agnidus_agate_gemstone.png";}
        else if(name.equals("滌淨青金碎屑")){return "/drawable/varunada_lazurite_sliver.png";}
        else if(name.equals("滌淨青金斷片")){return "/drawable/varunada_lazurite_fragment.png";}
        else if(name.equals("滌淨青金塊")){return "/drawable/varunada_lazurite_chunk.png";}
        else if(name.equals("滌淨青金")){return "/drawable/varunada_lazurite_gemstone.png";}
        else if(name.equals("最勝紫晶碎屑")){return "/drawable/vajrada_amethyst_sliver.png";}
        else if(name.equals("最勝紫晶斷片")){return "/drawable/vajrada_amethyst_fragment.png";}
        else if(name.equals("最勝紫晶塊")){return "/drawable/vajrada_amethyst_chunk.png";}
        else if(name.equals("最勝紫晶")){return "/drawable/vajrada_amethyst_gemstone.png";}
        else if(name.equals("哀敘冰玉碎屑")){return "/drawable/shivada_jade_sliver.png";}
        else if(name.equals("哀敘冰玉斷片")){return "/drawable/shivada_jade_fragment.png";}
        else if(name.equals("哀敘冰玉塊")){return "/drawable/shivada_jade_chunk.png";}
        else if(name.equals("哀敘冰玉")){return "/drawable/shivada_jade_gemstone.png";}
        else if(name.equals("自在松石碎屑")){return "/drawable/vayuda_turquoise_sliver.png";}
        else if(name.equals("自在松石斷片")){return "/drawable/vayuda_turquoise_fragment.png";}
        else if(name.equals("自在松石塊")){return "/drawable/vayuda_turquoise_chunk.png";}
        else if(name.equals("自在松石")){return "/drawable/vayuda_turquoise_gemstone.png";}
        else if(name.equals("堅牢黃玉碎屑")){return "/drawable/prithiva_topaz_sliver.png";}
        else if(name.equals("堅牢黃玉斷片")){return "/drawable/prithiva_topaz_fragment.png";}
        else if(name.equals("堅牢黃玉塊")){return "/drawable/prithiva_topaz_chunk.png";}
        else if(name.equals("堅牢黃玉")){return "/drawable/prithiva_topaz_gemstone.png";}
        else if(name.equals("brilliant_diamond_sliver")){return "/drawable/brilliant_diamond_sliver.png";}
        else if(name.equals("brilliant_diamond_fragment")){return "/drawable/brilliant_diamond_fragment.png";}
        else if(name.equals("brilliant_diamond_chunk")){return "/drawable/brilliant_diamond_chunk.png";}
        else if(name.equals("brilliant_diamond_gemstone")){return "/drawable/brilliant_diamond_gemstone.png";}
        else if(name.equals("nagadus_emerald_sliver")){return "/drawable/nagadus_emerald_sliver.png";}
        else if(name.equals("nagadus_emerald_fragment")){return "/drawable/nagadus_emerald_fragment.png";}
        else if(name.equals("nagadus_emerald_chunk")){return "/drawable/nagadus_emerald_chunk.png";}
        else if(name.equals("nagadus_emerald_gemstone")){return "/drawable/nagadus_emerald_gemstone.png";}

        /** Others*/
        else if(name.equals("智識之冕")){return "/drawable/crown_of_sagehood.png";}
        else if(name.equals("摩拉")){return "/drawable/mora.png";}
        else if(name.equals("流浪者的經驗")){return "/drawable/wanderers_advice.png";}
        else if(name.equals("冒險家的經驗")){return "/drawable/adventurers_experience.png";}
        else if(name.equals("大英雄的經驗")){return "/drawable/heros_wit.png";}
        else if(name.equals("精鍛用雜礦")){return "/drawable/enchancement_ore.png";}
        else if(name.equals("精鍛用良礦")){return "/drawable/fine_enchancement_ore.png";}
        else if(name.equals("精鍛用魔礦")){return "/drawable/mystic_enchancement_ore.png";}
        else if(name.equals("祝聖油膏")){return "/drawable/sanctifying_unction.png";}
        else if(name.equals("祝聖精華")){return "/drawable/sanctifying_essence.png";}

        else {return "/drawable/paimon_lost.png";}
    }

    public String getLocaleTeaches (String name, Context context){
        if(name.equals("「自由」的教導")){return context.getString(R.string.teaching_of_freedom);}
        else if(name.equals("「黃金」的教導")){return context.getString(R.string.teaching_of_gold);}
        else if(name.equals("「抗爭」的教導")){return context.getString(R.string.teaching_of_resistance);}
        else if(name.equals("「繁榮」的教導")){return context.getString(R.string.teaching_of_prosperity);}
        else if(name.equals("「詩文」的教導")){return context.getString(R.string.teaching_of_ballad);}
        else if(name.equals("「勤勞」的教導")){return context.getString(R.string.teaching_of_diligence);}
        else if(name.equals("「風雅」的教導")){return context.getString(R.string.teachings_of_elegance);}
        else if(name.equals("「浮世」的教導")){return context.getString(R.string.teachings_of_transience);}
        else if(name.equals("「天光」的教導")){return context.getString(R.string.teachings_of_light);}
        else if(name.equals("「自由」的指引")){return context.getString(R.string.guide_of_freedom);}
        else if(name.equals("「黃金」的指引")){return context.getString(R.string.guide_of_gold);}
        else if(name.equals("「抗爭」的指引")){return context.getString(R.string.guide_of_resistance);}
        else if(name.equals("「繁榮」的指引")){return context.getString(R.string.guide_of_prosperity);}
        else if(name.equals("「詩文」的指引")){return context.getString(R.string.guide_of_ballad);}
        else if(name.equals("「勤勞」的指引")){return context.getString(R.string.guide_of_diligence);}
        else if(name.equals("「風雅」的指引")){return context.getString(R.string.guides_of_elegance);}
        else if(name.equals("「浮世」的指引")){return context.getString(R.string.guides_of_transience);}
        else if(name.equals("「天光」的指引")){return context.getString(R.string.guides_of_light);}
        else if(name.equals("「自由」的哲學")){return context.getString(R.string.philosophies_of_freedom);}
        else if(name.equals("「黃金」的哲學")){return context.getString(R.string.philosophies_of_gold);}
        else if(name.equals("「抗爭」的哲學")){return context.getString(R.string.philosophies_of_resistance);}
        else if(name.equals("「繁榮」的哲學")){return context.getString(R.string.philosophies_of_prosperity);}
        else if(name.equals("「詩文」的哲學")){return context.getString(R.string.philosophies_of_ballad);}
        else if(name.equals("「勤勞」的哲學")){return context.getString(R.string.philosophies_of_diligence);}
        else if(name.equals("「風雅」的哲學")){return context.getString(R.string.philosophiess_of_elegance);}
        else if(name.equals("「浮世」的哲學")){return context.getString(R.string.philosophiess_of_transience);}
        else if(name.equals("「天光」的哲學")){return context.getString(R.string.philosophiess_of_light);}

        else {return context.getString(R.string.unknown);}

    }

    public String getLocaleBirth (String str,Context context) {
        if(!str.equals("SET_BY_PLAYER")){
        String[] date = str.split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);

        String returns = "Jan 1st";
        if(month == 1){returns = context.getString(R.string.date_jan);}
        else if(month == 2){returns = context.getString(R.string.date_feb);}
        else if(month == 3){returns = context.getString(R.string.date_mar);}
        else if(month == 4){returns = context.getString(R.string.date_apr);}
        else if(month == 5){returns = context.getString(R.string.date_may);}
        else if(month == 6){returns = context.getString(R.string.date_jun);}
        else if(month == 7){returns = context.getString(R.string.date_jul);}
        else if(month == 8){returns = context.getString(R.string.date_aug);}
        else if(month == 9){returns = context.getString(R.string.date_sep);}
        else if(month == 10){returns = context.getString(R.string.date_oct);}
        else if(month == 11){returns = context.getString(R.string.date_nov);}
        else if(month == 12){returns = context.getString(R.string.date_dec);}

        if(day == 1){returns = returns + context.getString(R.string.date_1st);}
        else if(day == 2){returns = returns + context.getString(R.string.date_2nd);}
        else if(day == 3){returns = returns + context.getString(R.string.date_3rd);}
        else if(day == 4){returns = returns + context.getString(R.string.date_4th);}
        else if(day == 5){returns = returns + context.getString(R.string.date_5th);}
        else if(day == 6){returns = returns + context.getString(R.string.date_6th);}
        else if(day == 7){returns = returns + context.getString(R.string.date_7th);}
        else if(day == 8){returns = returns + context.getString(R.string.date_8th);}
        else if(day == 9){returns = returns + context.getString(R.string.date_9th);}
        else if(day == 10){returns = returns + context.getString(R.string.date_10th);}
        else if(day == 11){returns = returns + context.getString(R.string.date_11th);}
        else if(day == 12){returns = returns + context.getString(R.string.date_12th);}
        else if(day == 13){returns = returns + context.getString(R.string.date_13th);}
        else if(day == 14){returns = returns + context.getString(R.string.date_14th);}
        else if(day == 15){returns = returns + context.getString(R.string.date_15th);}
        else if(day == 16){returns = returns + context.getString(R.string.date_16th);}
        else if(day == 17){returns = returns + context.getString(R.string.date_17th);}
        else if(day == 18){returns = returns + context.getString(R.string.date_18th);}
        else if(day == 19){returns = returns + context.getString(R.string.date_19th);}
        else if(day == 20){returns = returns + context.getString(R.string.date_20th);}
        else if(day == 21){returns = returns + context.getString(R.string.date_21st);}
        else if(day == 22){returns = returns + context.getString(R.string.date_22nd);}
        else if(day == 23){returns = returns + context.getString(R.string.date_23rd);}
        else if(day == 24){returns = returns + context.getString(R.string.date_24th);}
        else if(day == 25){returns = returns + context.getString(R.string.date_25th);}
        else if(day == 26){returns = returns + context.getString(R.string.date_26th);}
        else if(day == 27){returns = returns + context.getString(R.string.date_27th);}
        else if(day == 28){returns = returns + context.getString(R.string.date_28th);}
        else if(day == 29){returns = returns + context.getString(R.string.date_29th);}
        else if(day == 30){returns = returns + context.getString(R.string.date_30th);}
        else if(day == 31){returns = returns + context.getString(R.string.date_31st);}


        return returns;
        }else return context.getString(R.string.set_by_player);
    }

    public String char_birth(int moy, int dom){
        String char_name = "EMPTY";
        switch (moy){
            case Calendar.JANUARY: {
                switch (dom) {
                    case 9 : char_name = "Thoma"; break;
                    case 18 : char_name = "Diona"; break;
                    case 24 : char_name = "Rosaria"; break;
                }
                break;
            }
            case Calendar.FEBRUARY: {
                switch (dom) {
                    case 14 : char_name = "Beidou"; break;
                    case 22 : char_name = "Sangonomiya Kokomi"; break;
                    case 29 : char_name = "Bennett"; break;
                }
                break;
            }
            case Calendar.MARCH: {
                switch (dom) {
                    case 3 : char_name = "Qiqi"; break;
                    case 10 : char_name = "Shenhe"; break;
                    case 14 : char_name = "Jean"; break;
                    case 21 : char_name = "Noelle"; break;
                }
                break;
            }
            case Calendar.APRIL: {
                switch (dom) {
                    case 4 : char_name = "Aloy"; break;
                    case 17 : char_name = "Xiao"; break;
                    case 30 : char_name = "Diluc"; break;
                }
                break;
            }
            case Calendar.MAY: {
                switch (dom) {
                    case 18 : char_name = "Gorou"; break;
                    case 21 : char_name = "Yun Jin"; break;
                    case 27 : char_name = "Fischl"; break;
                }
                break;
            }
            case Calendar.JUNE: {
                switch (dom) {
                    case 1 : char_name = "Arataki Itto"; break;
                    case 9 : char_name = "Lisa"; break;
                    case 16 : char_name = "Venti"; break;
                    case 21 : char_name = "Yoimiya"; break;
                    case 26 : char_name = "Raiden Shogun"; break;
                    case 27 : char_name = "Yae Miko"; break;
                }
                break;
            }
            case Calendar.JULY: {
                switch (dom) {
                    case 5 : char_name = "Barbara"; break;
                    case 14 : char_name = "Kujou Sara"; break;
                    case 15 : char_name = "Hu Tao"; break;
                    case 19 : char_name = "Voc-夜芷冰"; break;
                    case 20 : char_name = "Tartaglia"; break;
                    case 27 : char_name = "Klee"; break;
                    case 28 : char_name = "Yanfei"; break;
                }
                break;
            }
            case Calendar.AUGUST: {
                switch (dom) {
                    case 10 : char_name = "Amber"; break;
                    case 26 : char_name = "Ningguang"; break;
                    case 31 : char_name = "Mona"; break;
                }
                break;
            }
            case Calendar.SEPTEMBER: {
                switch (dom) {
                    case 7 : char_name = "Diona"; break;
                    case 9 : char_name = "Razor"; break;
                    case 13 : char_name = "Albedo"; break;
                    case 28 : char_name = "Kamisato Ayaka"; break;
                }
                break;
            }
            case Calendar.OCTOBER: {
                switch (dom) {
                    case 9 : char_name = "Xingqiu"; break;
                    case 16 : char_name = "Xinyan"; break;
                    case 19 : char_name = "Sayu"; break;
                    case 25 : char_name = "Eula"; break;
                    case 29 : char_name = "Kaedehara Kazuha"; break;
                }
                break;
            }
            case Calendar.NOVEMBER: {
                switch (dom) {
                    case 2 : char_name = "Xiangling"; break;
                    case 20 : char_name = "Keqing"; break;
                    case 26 : char_name = "Sucrose"; break;
                    case 30 : char_name = "Kaeya"; break;
                }
                break;
            }
            case Calendar.DECEMBER: {
                switch (dom) {
                    case 2 : char_name = "Ganyu"; break;
                    case 31 : char_name = "Zhongli"; break;
                }
                break;
            }

        }
        return char_name;
    }

    public int getArtifactBuffName (String nickname){
        switch (nickname){
            case "baseHP" : return R.string.weapon_stat_HP;
            case "baseATK" : return R.string.weapon_stat_atk;
            case "baseDEF" : return R.string.weapon_stat_DEF;
            case "HP" : return R.string.weapon_stat_HPP;
            case "ATK" : return R.string.weapon_stat_atkP;
            case "DEF" : return R.string.weapon_stat_DEFP;
            case "EleMas" : return R.string.weapon_stat_EleMas;
            case "EnRech" : return R.string.weapon_stat_EnRechP;
            case "PhyDMG" : return R.string.weapon_stat_PhyDMGP;
            case "EleDMG_Electro" : return R.string.weapon_stat_EleDMGP_Electro;
            case "EleDMG_Pyro" : return R.string.weapon_stat_EleDMGP_Pyro;
            case "EleDMG_Hydro" : return R.string.weapon_stat_EleDMGP_Hydro;
            case "EleDMG_Dendor" : return R.string.weapon_stat_EleDMGP_Dendor;
            case "EleDMG_Cryo" : return R.string.weapon_stat_EleDMGP_Cryo;
            case "EleDMG_Anemo" : return R.string.weapon_stat_EleDMGP_Anemo;
            case "EleDMG_Geo" : return R.string.weapon_stat_EleDMGP_Geo;
            case "CritRate" : return R.string.weapon_stat_CritRateP;
            case "CritDMG" : return R.string.weapon_stat_CritDMGP;
            case "Healing" : return R.string.weapon_stat_HealingP;

            default: return R.string.unknown;
        }
    }
}
