package com.annie.annieforchild.entity;

import com.annie.annieforchild.view.loopPager.LooperBaseBean;

import java.util.List;

/**
 * Created by shen
 * on 2019/8/29
 */


public class HomeBean {


    /**
     * status : 0
     * msg : success
     * data : {"banner":[{"imageUrl":"https://testapici.anniekids.com/Public/Upload/index/20190131/5c52a615c874c.jpg","url":""},{"imageUrl":"https://testapici.anniekids.com/Public/Upload/index/20190317/5c8de3cf4129e.jpg","url":""}],"order":[],"recommend":{"title":"安妮鲜花每周推荐","dataList":[{"tagName":"0-3","resourceList":[{"bookName":"Hair Brushing","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/sound/tm.mp3","browseNums":391,"bookId":801,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Here Is the Sea","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/sound/tm.mp3","browseNums":667,"bookId":805,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"\"Ruff,\" Says The Dog!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/sound/tm.mp3","browseNums":2431,"bookId":412,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"Hats! Hats! Hats!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/sound/tm.mp3","browseNums":1292,"bookId":437,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","browseNums":19253,"bookId":2,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Susan Blue","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/sound/tm.mp3","browseNums":205,"bookId":1875,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A-Hunting We Will Go","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/sound/tm.mp3","browseNums":1266,"bookId":140,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"PEEK-A-BOO!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/sound/tm.mp3","browseNums":812,"bookId":441,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1}]},{"tagName":"3-6","resourceList":[{"bookName":"The Land of Counterpane","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/sound/tm.mp3","browseNums":28,"bookId":2004,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Dog Ate It! - Book 4 for April","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/sound/tm.mp3","browseNums":49,"bookId":2138,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Two Legs Sat upon Three Legs","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/sound/tm.mp3","browseNums":45,"bookId":1894,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"High There in the Deep Blue Sky","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/sound/tm.mp3","browseNums":82,"bookId":1939,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Summer is Coming","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/sound/tm.mp3","browseNums":33,"bookId":1974,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Five Little Froggies","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/sound/tm.mp3","browseNums":430,"bookId":777,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Little Red Teapot - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/sound/tm.mp3","browseNums":182,"bookId":2064,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Glub, Glub, Glub Your Boat","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/sound/tm.mp3","browseNums":826,"bookId":345,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1}]},{"tagName":"6-8","resourceList":[{"bookName":"Mr Nobody","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/sound/tm.mp3","browseNums":34,"bookId":1972,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Rain (on the green grass)","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/sound/tm.mp3","browseNums":427,"bookId":1923,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Apples","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/sound/tm.mp3","browseNums":975,"bookId":757,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Noodles for Mom - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/sound/tm.mp3","browseNums":102,"bookId":2420,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Let It Snow! - Book 11 for November","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/sound/tm.mp3","browseNums":6,"bookId":2739,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Mother, the Plumber - Book 5 for May","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/sound/tm.mp3","browseNums":15,"bookId":2576,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My culture","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/sound/tm.mp3","browseNums":652,"bookId":279,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Simple Man - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/sound/tm.mp3","browseNums":153,"bookId":2043,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"8-12","resourceList":[{"bookName":"Ben The Inventor - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/sound/tm.mp3","browseNums":6,"bookId":593,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/sound/tm.mp3","browseNums":19,"bookId":640,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Weenie's Seeds","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/sound/tm.mp3","browseNums":962,"bookId":184,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Blossom","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/sound/tm.mp3","browseNums":12,"bookId":2824,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Christmas Memory - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/sound/tm.mp3","browseNums":30,"bookId":2432,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Giant Sunflower - Book 10 for October","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/sound/tm.mp3","browseNums":9,"bookId":2693,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 6","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/sound/tm.mp3","browseNums":17,"bookId":639,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Land of Story Books","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/sound/tm.mp3","browseNums":21,"bookId":2008,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"12+","resourceList":[{"bookName":"Justine McKeen Pooper Scooper - Chapter 5","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/sound/tm.mp3","browseNums":13,"bookId":510,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Gathering Leaves","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/sound/tm.mp3","browseNums":8,"bookId":2846,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Minor Bird","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/sound/tm.mp3","browseNums":10,"bookId":2837,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 10","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/sound/tm.mp3","browseNums":14,"bookId":643,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"PIRATE ISLAND TREASURE - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/sound/tm.mp3","browseNums":20,"bookId":628,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Great Garage Sale - Chapter 7","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/sound/tm.mp3","browseNums":8,"bookId":650,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Messy Miranda - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/sound/tm.mp3","browseNums":13,"bookId":605,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Trees","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/sound/tm.mp3","browseNums":14,"bookId":2827,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]}]},"animation":[{"bookId":3709,"bookName":"Polly Wolly Doodle","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S2/Polly_Wolly_Doodle/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Polly_Wolly_Doodle1.mp4","jurisdiction":1},{"bookId":3711,"bookName":"Glub, Glub, Glub Your Boat","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao3/Glub_Glub_Glub_Your_Boat/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Glub_Glub_Glub_Your_Boat1.mp4","jurisdiction":1},{"bookId":3694,"bookName":"Pass the Hot Potato","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao2/Pass_the_Hot_Potato/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao2/Pass_the_Hot_Potato1.mp4","jurisdiction":1},{"bookId":3706,"bookName":"Take It Out, Remove It","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao3/Take_It_Out_Remove_It/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Take_It_Out_Remove_It1.mp4","jurisdiction":1},{"bookId":3680,"bookName":"The Muffin Man","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo4/The_muffin_man/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mo4/The_Muffin_Man1.mp4","jurisdiction":1},{"bookId":3685,"bookName":"Eensy Weensy Spider","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/Eensy_Weensy_Spider/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao1/Eensy_Weensy_Spider1.mp4","jurisdiction":1}],"label":[{"ID":2,"Title":"0-3"},{"ID":3,"Title":"3-6"},{"ID":4,"Title":"6-8"},{"ID":5,"Title":"8-12"},{"ID":6,"Title":"12+"},{"ID":8,"Title":"磨耳朵"},{"ID":9,"Title":"流利读"},{"ID":10,"Title":"地道说"}],"resource":[{"title":"磨耳朵","subtitle":"磨出宝宝英文耳朵","resourceList":[{"bookName":"ABC Nursery Rhymes","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/sound/tm.mp3","browseNums":8588,"bookId":231,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Six Little Ducks","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/sound/tm.mp3","browseNums":14756,"bookId":234,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"When I Go Trick or Treating","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/sound/tm.mp3","browseNums":3719,"bookId":242,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Up on the Housetop","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/sound/tm.mp3","browseNums":5476,"bookId":240,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"title":"流利读","subtitle":"读原版绘本","resourceList":[{"bookName":"The People On My Street","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Readers_Clubhouse/The_People_On_My_Street/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Readers_Clubhouse/The_People_On_My_Street/sound/tm.mp3","browseNums":747,"bookId":313,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1},{"bookName":"A Day All Green! - Book 3 for March","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Beginners/Book_3/17_A_Day_All_Green/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Beginners/Book_3/17_A_Day_All_Green/sound/tm.mp3","browseNums":31,"bookId":3353,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"When Johnny Comes Marching Home","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/When_Johnny_Comes_Marching_Home/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/When_Johnny_Comes_Marching_Home/sound/tm.mp3","browseNums":410,"bookId":351,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1},{"bookName":"Our Perfect Puppy (Ⅱ) - Book 11 for November","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Our_Perfect_Puppy_2/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Our_Perfect_Puppy_2/sound/tm.mp3","browseNums":10,"bookId":2721,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":0,"isShowRank":1}]},{"title":"地道说","subtitle":"说地道口语","resourceList":[{"bookName":"A Hospital in the Woods-What should we say after visiting the doctor?","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/All_Story/2/Story_4_A_Hospital_in_the_Woods_Cards/Expand/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/All_Story/2/Story_4_A_Hospital_in_the_Woods_Cards/Expand/sound/tm.mp3","browseNums":84,"bookId":3089,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Animals-Look! The monkeys are jumping on the trampoline!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Animals_1_Card/1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Animals_1_Card/1/sound/tm.mp3","browseNums":1266,"bookId":3134,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Field Trip-Hooray, go camping! I love camping!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/2/Field_Trip_1_Card/1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/2/Field_Trip_1_Card/1/sound/tm.mp3","browseNums":59,"bookId":3188,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Down through the Chimney-What's this?","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Down_Through_The_Chimney_Cards/One/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Down_Through_The_Chimney_Cards/One/sound/tm.mp3","browseNums":279,"bookId":3023,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0}]}]}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * banner : [{"imageUrl":"https://testapici.anniekids.com/Public/Upload/index/20190131/5c52a615c874c.jpg","url":""},{"imageUrl":"https://testapici.anniekids.com/Public/Upload/index/20190317/5c8de3cf4129e.jpg","url":""}]
         * order : []
         * recommend : {"title":"安妮鲜花每周推荐","dataList":[{"tagName":"0-3","resourceList":[{"bookName":"Hair Brushing","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/sound/tm.mp3","browseNums":391,"bookId":801,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Here Is the Sea","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/sound/tm.mp3","browseNums":667,"bookId":805,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"\"Ruff,\" Says The Dog!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/sound/tm.mp3","browseNums":2431,"bookId":412,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"Hats! Hats! Hats!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/sound/tm.mp3","browseNums":1292,"bookId":437,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","browseNums":19253,"bookId":2,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Susan Blue","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/sound/tm.mp3","browseNums":205,"bookId":1875,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A-Hunting We Will Go","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/sound/tm.mp3","browseNums":1266,"bookId":140,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"PEEK-A-BOO!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/sound/tm.mp3","browseNums":812,"bookId":441,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1}]},{"tagName":"3-6","resourceList":[{"bookName":"The Land of Counterpane","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/sound/tm.mp3","browseNums":28,"bookId":2004,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Dog Ate It! - Book 4 for April","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/sound/tm.mp3","browseNums":49,"bookId":2138,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Two Legs Sat upon Three Legs","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/sound/tm.mp3","browseNums":45,"bookId":1894,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"High There in the Deep Blue Sky","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/sound/tm.mp3","browseNums":82,"bookId":1939,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Summer is Coming","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/sound/tm.mp3","browseNums":33,"bookId":1974,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Five Little Froggies","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/sound/tm.mp3","browseNums":430,"bookId":777,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Little Red Teapot - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/sound/tm.mp3","browseNums":182,"bookId":2064,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Glub, Glub, Glub Your Boat","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/sound/tm.mp3","browseNums":826,"bookId":345,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1}]},{"tagName":"6-8","resourceList":[{"bookName":"Mr Nobody","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/sound/tm.mp3","browseNums":34,"bookId":1972,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Rain (on the green grass)","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/sound/tm.mp3","browseNums":427,"bookId":1923,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Apples","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/sound/tm.mp3","browseNums":975,"bookId":757,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Noodles for Mom - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/sound/tm.mp3","browseNums":102,"bookId":2420,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Let It Snow! - Book 11 for November","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/sound/tm.mp3","browseNums":6,"bookId":2739,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Mother, the Plumber - Book 5 for May","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/sound/tm.mp3","browseNums":15,"bookId":2576,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My culture","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/sound/tm.mp3","browseNums":652,"bookId":279,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Simple Man - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/sound/tm.mp3","browseNums":153,"bookId":2043,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"8-12","resourceList":[{"bookName":"Ben The Inventor - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/sound/tm.mp3","browseNums":6,"bookId":593,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/sound/tm.mp3","browseNums":19,"bookId":640,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Weenie's Seeds","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/sound/tm.mp3","browseNums":962,"bookId":184,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Blossom","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/sound/tm.mp3","browseNums":12,"bookId":2824,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Christmas Memory - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/sound/tm.mp3","browseNums":30,"bookId":2432,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Giant Sunflower - Book 10 for October","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/sound/tm.mp3","browseNums":9,"bookId":2693,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 6","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/sound/tm.mp3","browseNums":17,"bookId":639,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Land of Story Books","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/sound/tm.mp3","browseNums":21,"bookId":2008,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"12+","resourceList":[{"bookName":"Justine McKeen Pooper Scooper - Chapter 5","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/sound/tm.mp3","browseNums":13,"bookId":510,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Gathering Leaves","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/sound/tm.mp3","browseNums":8,"bookId":2846,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Minor Bird","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/sound/tm.mp3","browseNums":10,"bookId":2837,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 10","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/sound/tm.mp3","browseNums":14,"bookId":643,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"PIRATE ISLAND TREASURE - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/sound/tm.mp3","browseNums":20,"bookId":628,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Great Garage Sale - Chapter 7","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/sound/tm.mp3","browseNums":8,"bookId":650,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Messy Miranda - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/sound/tm.mp3","browseNums":13,"bookId":605,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Trees","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/sound/tm.mp3","browseNums":14,"bookId":2827,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]}]}
         * animation : [{"bookId":3709,"bookName":"Polly Wolly Doodle","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S2/Polly_Wolly_Doodle/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Polly_Wolly_Doodle1.mp4","jurisdiction":1},{"bookId":3711,"bookName":"Glub, Glub, Glub Your Boat","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao3/Glub_Glub_Glub_Your_Boat/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Glub_Glub_Glub_Your_Boat1.mp4","jurisdiction":1},{"bookId":3694,"bookName":"Pass the Hot Potato","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao2/Pass_the_Hot_Potato/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao2/Pass_the_Hot_Potato1.mp4","jurisdiction":1},{"bookId":3706,"bookName":"Take It Out, Remove It","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/mobaobao3/Take_It_Out_Remove_It/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Take_It_Out_Remove_It1.mp4","jurisdiction":1},{"bookId":3680,"bookName":"The Muffin Man","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo4/The_muffin_man/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mo4/The_Muffin_Man1.mp4","jurisdiction":1},{"bookId":3685,"bookName":"Eensy Weensy Spider","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/Eensy_Weensy_Spider/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Cartoons/mobao1/Eensy_Weensy_Spider1.mp4","jurisdiction":1}]
         * label : [{"ID":2,"Title":"0-3"},{"ID":3,"Title":"3-6"},{"ID":4,"Title":"6-8"},{"ID":5,"Title":"8-12"},{"ID":6,"Title":"12+"},{"ID":8,"Title":"磨耳朵"},{"ID":9,"Title":"流利读"},{"ID":10,"Title":"地道说"}]
         * resource : [{"title":"磨耳朵","subtitle":"磨出宝宝英文耳朵","resourceList":[{"bookName":"ABC Nursery Rhymes","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/sound/tm.mp3","browseNums":8588,"bookId":231,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Six Little Ducks","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/sound/tm.mp3","browseNums":14756,"bookId":234,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"When I Go Trick or Treating","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/sound/tm.mp3","browseNums":3719,"bookId":242,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Up on the Housetop","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/sound/tm.mp3","browseNums":5476,"bookId":240,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"title":"流利读","subtitle":"读原版绘本","resourceList":[{"bookName":"The People On My Street","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Readers_Clubhouse/The_People_On_My_Street/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Readers_Clubhouse/The_People_On_My_Street/sound/tm.mp3","browseNums":747,"bookId":313,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1},{"bookName":"A Day All Green! - Book 3 for March","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Beginners/Book_3/17_A_Day_All_Green/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Beginners/Book_3/17_A_Day_All_Green/sound/tm.mp3","browseNums":31,"bookId":3353,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"When Johnny Comes Marching Home","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/When_Johnny_Comes_Marching_Home/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/When_Johnny_Comes_Marching_Home/sound/tm.mp3","browseNums":410,"bookId":351,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1},{"bookName":"Our Perfect Puppy (Ⅱ) - Book 11 for November","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Our_Perfect_Puppy_2/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Our_Perfect_Puppy_2/sound/tm.mp3","browseNums":10,"bookId":2721,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":0,"isShowRank":1}]},{"title":"地道说","subtitle":"说地道口语","resourceList":[{"bookName":"A Hospital in the Woods-What should we say after visiting the doctor?","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/All_Story/2/Story_4_A_Hospital_in_the_Woods_Cards/Expand/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/All_Story/2/Story_4_A_Hospital_in_the_Woods_Cards/Expand/sound/tm.mp3","browseNums":84,"bookId":3089,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Animals-Look! The monkeys are jumping on the trampoline!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Animals_1_Card/1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Animals_1_Card/1/sound/tm.mp3","browseNums":1266,"bookId":3134,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Field Trip-Hooray, go camping! I love camping!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/2/Field_Trip_1_Card/1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/2/Field_Trip_1_Card/1/sound/tm.mp3","browseNums":59,"bookId":3188,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Down through the Chimney-What's this?","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Down_Through_The_Chimney_Cards/One/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Anniekids_Ask_And_Answer_Cards/Moerduo/1/Down_Through_The_Chimney_Cards/One/sound/tm.mp3","browseNums":279,"bookId":3023,"jurisdiction":1,"appType":3,"isAnimation":0,"isShowPk":0,"isShowRank":0}]}]
         */

        private RecommendBean recommend;
        private List<BannerBean> banner;
        private List<?> order;
        private List<AnimationBean> animation;
        private List<LabelBean> label;
        private List<ResourceBean> resource;

        public RecommendBean getRecommend() {
            return recommend;
        }

        public void setRecommend(RecommendBean recommend) {
            this.recommend = recommend;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<?> getOrder() {
            return order;
        }

        public void setOrder(List<?> order) {
            this.order = order;
        }

        public List<AnimationBean> getAnimation() {
            return animation;
        }

        public void setAnimation(List<AnimationBean> animation) {
            this.animation = animation;
        }

        public List<LabelBean> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBean> label) {
            this.label = label;
        }

        public List<ResourceBean> getResource() {
            return resource;
        }

        public void setResource(List<ResourceBean> resource) {
            this.resource = resource;
        }

        public static class RecommendBean {
            /**
             * title : 安妮鲜花每周推荐
             * dataList : [{"tagName":"0-3","resourceList":[{"bookName":"Hair Brushing","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/sound/tm.mp3","browseNums":391,"bookId":801,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Here Is the Sea","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/sound/tm.mp3","browseNums":667,"bookId":805,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"\"Ruff,\" Says The Dog!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/sound/tm.mp3","browseNums":2431,"bookId":412,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"Hats! Hats! Hats!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/sound/tm.mp3","browseNums":1292,"bookId":437,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","browseNums":19253,"bookId":2,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Susan Blue","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/sound/tm.mp3","browseNums":205,"bookId":1875,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A-Hunting We Will Go","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/sound/tm.mp3","browseNums":1266,"bookId":140,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"PEEK-A-BOO!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/sound/tm.mp3","browseNums":812,"bookId":441,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1}]},{"tagName":"3-6","resourceList":[{"bookName":"The Land of Counterpane","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Counterpane_1/sound/tm.mp3","browseNums":28,"bookId":2004,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Dog Ate It! - Book 4 for April","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_4/my-dog-ate-it/sound/tm.mp3","browseNums":49,"bookId":2138,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Two Legs Sat upon Three Legs","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Two_Legs_Sat_upon_Three_Legs_1/sound/tm.mp3","browseNums":45,"bookId":1894,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"High There in the Deep Blue Sky","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/High_There_in_the_Deep_Blue_Sky_1/sound/tm.mp3","browseNums":82,"bookId":1939,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Summer is Coming","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Summer_is_Coming_1/sound/tm.mp3","browseNums":33,"bookId":1974,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Five Little Froggies","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Five_Little_Froggies_1/sound/tm.mp3","browseNums":430,"bookId":777,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Little Red Teapot - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_1/The_Little_Red_Teapot/sound/tm.mp3","browseNums":182,"bookId":2064,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Glub, Glub, Glub Your Boat","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Mobaobao/Mobaobao3/Gulb_Gulb_Gulb_Your_Boat/sound/tm.mp3","browseNums":826,"bookId":345,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1}]},{"tagName":"6-8","resourceList":[{"bookName":"Mr Nobody","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/Mr_Nobody_1/sound/tm.mp3","browseNums":34,"bookId":1972,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Rain (on the green grass)","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Rain_on_1/sound/tm.mp3","browseNums":427,"bookId":1923,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Apples","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Apples_1/sound/tm.mp3","browseNums":975,"bookId":757,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Noodles for Mom - Book 1 for January","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_1_for_January/Noodles_for_Mom/sound/tm.mp3","browseNums":102,"bookId":2420,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Let It Snow! - Book 11 for November","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_11_for_November/Let_It_Snow/sound/tm.mp3","browseNums":6,"bookId":2739,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My Mother, the Plumber - Book 5 for May","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_5_for_May/My_Mother_the_Plumber/sound/tm.mp3","browseNums":15,"bookId":2576,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"My culture","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_World/8/My_Culture/sound/tm.mp3","browseNums":652,"bookId":279,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Simple Man - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day_For_Early_Readers/Book_2/A_Simple_Man/sound/tm.mp3","browseNums":153,"bookId":2043,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"8-12","resourceList":[{"bookName":"Ben The Inventor - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Ben_The_Inventor/Chapter9/sound/tm.mp3","browseNums":6,"bookId":593,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter8/sound/tm.mp3","browseNums":19,"bookId":640,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Weenie's Seeds","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P3/Weenies_Seeds/sound/tm.mp3","browseNums":962,"bookId":184,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Blossom","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_89_98/81/sound/tm.mp3","browseNums":12,"bookId":2824,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Christmas Memory - Book 2 for February","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_2_for_February/ChristmasMemory/sound/tm.mp3","browseNums":30,"bookId":2432,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Giant Sunflower - Book 10 for October","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/One_Story_A_Day/Book_10_for_October/GiantSunflower/sound/tm.mp3","browseNums":9,"bookId":2693,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 6","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter6/sound/tm.mp3","browseNums":17,"bookId":639,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Land of Story Books","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo6/The_Land_of_Story_Books_1/sound/tm.mp3","browseNums":21,"bookId":2008,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]},{"tagName":"12+","resourceList":[{"bookName":"Justine McKeen Pooper Scooper - Chapter 5","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_1/Justine_McKeen_Pooper_Scooper/Chapter5/sound/tm.mp3","browseNums":13,"bookId":510,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Gathering Leaves","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_69_78/70/sound/tm.mp3","browseNums":8,"bookId":2846,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A Minor Bird","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/72/sound/tm.mp3","browseNums":10,"bookId":2837,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Something's Fishy - Chapter 10","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Somethings_Fishy/Chapter10/sound/tm.mp3","browseNums":14,"bookId":643,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"PIRATE ISLAND TREASURE - Chapter 8","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/PIRATE_ISLAND_TREASURE/Chapter8/sound/tm.mp3","browseNums":20,"bookId":628,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"The Great Garage Sale - Chapter 7","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/The_Great_Garage_Sale/Chapter7/sound/tm.mp3","browseNums":8,"bookId":650,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Messy Miranda - Chapter 9","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/School_Life/School_Life_2/Messy_Miranda/Chapter9/sound/tm.mp3","browseNums":13,"bookId":605,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Trees","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Poem/Page_79_88/78/sound/tm.mp3","browseNums":14,"bookId":2827,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]}]
             */

            private String title;
            private List<DataListBean> dataList;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class DataListBean {
                /**
                 * tagName : 0-3
                 * resourceList : [{"bookName":"Hair Brushing","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/sound/tm.mp3","browseNums":391,"bookId":801,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Here Is the Sea","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Here_Is_the_Sea_1/sound/tm.mp3","browseNums":667,"bookId":805,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"\"Ruff,\" Says The Dog!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/My_First_Book/Ruff_Says_The_Dog/sound/tm.mp3","browseNums":2431,"bookId":412,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"Hats! Hats! Hats!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Beginner_Reader_1/Hats_Hats_Hats/sound/tm.mp3","browseNums":1292,"bookId":437,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","browseNums":19253,"bookId":2,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Susan Blue","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Susan_Blue_1/sound/tm.mp3","browseNums":205,"bookId":1875,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"A-Hunting We Will Go","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/S1/A_Hunting_We_Will_Go/sound/tm.mp3","browseNums":1266,"bookId":140,"jurisdiction":1,"appType":2,"isAnimation":1,"isShowPk":1,"isShowRank":1},{"bookName":"PEEK-A-BOO!","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Concepts/Peek_a_BOO/sound/tm.mp3","browseNums":812,"bookId":441,"jurisdiction":1,"appType":2,"isAnimation":0,"isShowPk":1,"isShowRank":1}]
                 */

                private String tagName;
                private List<ResourceListBean> resourceList;

                public String getTagName() {
                    return tagName;
                }

                public void setTagName(String tagName) {
                    this.tagName = tagName;
                }

                public List<ResourceListBean> getResourceList() {
                    return resourceList;
                }

                public void setResourceList(List<ResourceListBean> resourceList) {
                    this.resourceList = resourceList;
                }

                public static class ResourceListBean {
                    /**
                     * bookName : Hair Brushing
                     * bookImageUrl : http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/pic/fm.jpg
                     * path : http://ossfile.anniekids.com/weidiandu/Songs/moerduo5/Hair_Brushing_1/sound/tm.mp3
                     * browseNums : 391
                     * bookId : 801
                     * jurisdiction : 1
                     * appType : 1
                     * isAnimation : 0
                     * isShowPk : 0
                     * isShowRank : 0
                     */

                    private String bookName;
                    private String bookImageUrl;
                    private String path;
                    private int browseNums;
                    private int bookId;
                    private int jurisdiction;
                    private int appType;
                    private int isAnimation;
                    private int isShowPk;
                    private int isShowRank;

                    public String getBookName() {
                        return bookName;
                    }

                    public void setBookName(String bookName) {
                        this.bookName = bookName;
                    }

                    public String getBookImageUrl() {
                        return bookImageUrl;
                    }

                    public void setBookImageUrl(String bookImageUrl) {
                        this.bookImageUrl = bookImageUrl;
                    }

                    public String getPath() {
                        return path;
                    }

                    public void setPath(String path) {
                        this.path = path;
                    }

                    public int getBrowseNums() {
                        return browseNums;
                    }

                    public void setBrowseNums(int browseNums) {
                        this.browseNums = browseNums;
                    }

                    public int getBookId() {
                        return bookId;
                    }

                    public void setBookId(int bookId) {
                        this.bookId = bookId;
                    }

                    public int getJurisdiction() {
                        return jurisdiction;
                    }

                    public void setJurisdiction(int jurisdiction) {
                        this.jurisdiction = jurisdiction;
                    }

                    public int getAppType() {
                        return appType;
                    }

                    public void setAppType(int appType) {
                        this.appType = appType;
                    }

                    public int getIsAnimation() {
                        return isAnimation;
                    }

                    public void setIsAnimation(int isAnimation) {
                        this.isAnimation = isAnimation;
                    }

                    public int getIsShowPk() {
                        return isShowPk;
                    }

                    public void setIsShowPk(int isShowPk) {
                        this.isShowPk = isShowPk;
                    }

                    public int getIsShowRank() {
                        return isShowRank;
                    }

                    public void setIsShowRank(int isShowRank) {
                        this.isShowRank = isShowRank;
                    }
                }
            }
        }

        public static class BannerBean   extends LooperBaseBean {
            /**
             * imageUrl : https://testapici.anniekids.com/Public/Upload/index/20190131/5c52a615c874c.jpg
             * url :
             */

            private String imageUrl;
            private String url;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = imageUrl;
            }


            @Override
            public String getImgUrl() {
                return imageUrl;
            }
        }

        public static class AnimationBean {
            /**
             * bookId : 3709
             * bookName : Polly Wolly Doodle
             * bookImageUrl : http://ossfile.anniekids.com/weidiandu/S2/Polly_Wolly_Doodle/pic/fm.jpg
             * path : http://ossfile.anniekids.com/weidiandu/Cartoons/mobao3/Polly_Wolly_Doodle1.mp4
             * jurisdiction : 1
             */

            private int bookId;
            private String bookName;
            private String bookImageUrl;
            private String path;
            private int jurisdiction;

            public int getBookId() {
                return bookId;
            }

            public void setBookId(int bookId) {
                this.bookId = bookId;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

            public String getBookImageUrl() {
                return bookImageUrl;
            }

            public void setBookImageUrl(String bookImageUrl) {
                this.bookImageUrl = bookImageUrl;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getJurisdiction() {
                return jurisdiction;
            }

            public void setJurisdiction(int jurisdiction) {
                this.jurisdiction = jurisdiction;
            }
        }

        public static class LabelBean {
            /**
             * ID : 2
             * Title : 0-3
             */

            private int ID;
            private String Title;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }
        }

        public static class ResourceBean {
            /**
             * title : 磨耳朵
             * subtitle : 磨出宝宝英文耳朵
             * resourceList : [{"bookName":"ABC Nursery Rhymes","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/sound/tm.mp3","browseNums":8588,"bookId":231,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Six Little Ducks","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/Six_Little_Ducks/sound/tm.mp3","browseNums":14756,"bookId":234,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"When I Go Trick or Treating","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/When_i_go_trick_or_treating/sound/tm.mp3","browseNums":3719,"bookId":242,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0},{"bookName":"Up on the Housetop","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Songs/moerduo2/Up_On_The_Housetop/sound/tm.mp3","browseNums":5476,"bookId":240,"jurisdiction":1,"appType":1,"isAnimation":0,"isShowPk":0,"isShowRank":0}]
             */

            private String title;
            private String subtitle;
            private List<ResourceListBeanX> resourceList;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public List<ResourceListBeanX> getResourceList() {
                return resourceList;
            }

            public void setResourceList(List<ResourceListBeanX> resourceList) {
                this.resourceList = resourceList;
            }

            public static class ResourceListBeanX {
                /**
                 * bookName : ABC Nursery Rhymes
                 * bookImageUrl : http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/pic/fm.jpg
                 * path : http://ossfile.anniekids.com/weidiandu/Songs/moerduo1/ABC_Nursery_Rhymes/sound/tm.mp3
                 * browseNums : 8588
                 * bookId : 231
                 * jurisdiction : 1
                 * appType : 1
                 * isAnimation : 0
                 * isShowPk : 0
                 * isShowRank : 0
                 */

                private String bookName;
                private String bookImageUrl;
                private String path;
                private int browseNums;
                private int bookId;
                private int jurisdiction;
                private int appType;
                private int isAnimation;
                private int isShowPk;
                private int isShowRank;

                public String getBookName() {
                    return bookName;
                }

                public void setBookName(String bookName) {
                    this.bookName = bookName;
                }

                public String getBookImageUrl() {
                    return bookImageUrl;
                }

                public void setBookImageUrl(String bookImageUrl) {
                    this.bookImageUrl = bookImageUrl;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public int getBrowseNums() {
                    return browseNums;
                }

                public void setBrowseNums(int browseNums) {
                    this.browseNums = browseNums;
                }

                public int getBookId() {
                    return bookId;
                }

                public void setBookId(int bookId) {
                    this.bookId = bookId;
                }

                public int getJurisdiction() {
                    return jurisdiction;
                }

                public void setJurisdiction(int jurisdiction) {
                    this.jurisdiction = jurisdiction;
                }

                public int getAppType() {
                    return appType;
                }

                public void setAppType(int appType) {
                    this.appType = appType;
                }

                public int getIsAnimation() {
                    return isAnimation;
                }

                public void setIsAnimation(int isAnimation) {
                    this.isAnimation = isAnimation;
                }

                public int getIsShowPk() {
                    return isShowPk;
                }

                public void setIsShowPk(int isShowPk) {
                    this.isShowPk = isShowPk;
                }

                public int getIsShowRank() {
                    return isShowRank;
                }

                public void setIsShowRank(int isShowRank) {
                    this.isShowRank = isShowRank;
                }
            }
        }
    }
}
