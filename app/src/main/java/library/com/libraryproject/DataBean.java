package library.com.libraryproject;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by zjh on 2018/4/25.
 */

public class DataBean {

    /**
     * rating : {"max":10,"average":5.4,"details":{"1":1646,"3":8916,"2":6160,"5":706,"4":2339},"stars":"30","min":0}
     * reviews_count : 439
     * videos : [{"source":{"literal":"iqiyi","pic":"https://img1.doubanio.com/f/movie/e59bf8556426206eab3591f88a6c8ef8bf371a56/pics/movie/video_icon_new.png","name":"爱奇艺视频"},"sample_link":"http://www.iqiyi.com/v_19rr7q1nms.html?vfm=m_331_dbdy&fv=4904d94982104144a1548dd9040df241","video_id":"19rr7q1nms","need_pay":true}]
     * wish_count : 12266
     * original_title : Maze Runner: The Death Cure
     * blooper_urls : ["http://vt1.doubanio.com/201804251039/7393dc0758d71c433c5a6e69f2d26125/view/movie/M/302260637.mp4","http://vt1.doubanio.com/201804251039/874754922e229925476a50360a7a6bc3/view/movie/M/302260450.mp4","http://vt1.doubanio.com/201804251039/e3fbc260ae69f98fcd2a78fa58a70cab/view/movie/M/302260600.mp4","http://vt1.doubanio.com/201804251039/3205130f5a383569c05d46ce7d730243/view/movie/M/302260837.mp4"]
     * collect_count : 38964
     * images : {"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg"}
     * douban_site :
     * year : 2018
     * popular_comments : [{"rating":{"max":5,"value":2,"min":0},"useful_count":179,"author":{"uid":"172416865","avatar":"http://img7.doubanio.com/icon/u172416865-3.jpg","signature":"","alt":"http://www.douban.com/people/172416865/","id":"172416865","name":"懒人的主"},"subject_id":"26004132","content":"刚看完，感觉越拍越傻了，托马斯被实验了3年，难道3年时间都没验出来他的血清就是解药？而且活生生把一部惊悚电影拍成了动作电影也是醉了，没什么新意就尽量别拍续集了。","created_at":"2018-01-26 23:19:51","id":"1313395106"},{"rating":{"max":5,"value":2,"min":0},"useful_count":107,"author":{"uid":"shunong","avatar":"http://img7.doubanio.com/icon/u1303086-62.jpg","signature":"谁知道怎样寻获","alt":"http://www.douban.com/people/shunong/","id":"1303086","name":"舒农"},"subject_id":"26004132","content":"删掉一个小时会更好。第三幕长到整部电影仿佛3个小时。","created_at":"2018-01-24 21:34:45","id":"1312242381"},{"rating":{"max":5,"value":4,"min":0},"useful_count":209,"author":{"uid":"cheesecakehouse","avatar":"http://img7.doubanio.com/icon/u2456828-185.jpg","signature":"剪了头发轻两斤啊喂！","alt":"http://www.douban.com/people/cheesecakehouse/","id":"2456828","name":"一口吃掉小蛋糕"},"subject_id":"26004132","content":"托马斯，哎。迷宫不见了，大怪物出现一次，彻底变成丧尸片的节奏。bug太多，无力吐槽。但是耐克眉回归还是有惊喜，虽然加入的不是跟顺。剧情算是扣人心弦吧，比2要好看一些。","created_at":"2018-01-24 22:06:52","id":"1312263889"},{"rating":{"max":5,"value":3,"min":0},"useful_count":449,"author":{"uid":"flxjp","avatar":"http://img3.doubanio.com/icon/u2316731-67.jpg","signature":"一愉悦就伴随着痛苦。","alt":"http://www.douban.com/people/flxjp/","id":"2316731","name":"法兰西胶片"},"subject_id":"26004132","content":"两星半。不知道为啥对这个系列一直挺宽容的，可能和《暮光》《分歧者》相比爱情狗血少了很多吧。其实，制作上它一直没掉链子。","created_at":"2018-01-09 12:53:06","id":"1302954355"}]
     * alt : https://movie.douban.com/subject/26004132/
     * id : 26004132
     * mobile_url : https://movie.douban.com/subject/26004132/mobile
     * photos_count : 228
     * pubdate : 2018-01-26
     * title : 移动迷宫3：死亡解药
     * do_count : null
     * has_video : true
     * share_url : http://m.douban.com/movie/subject/26004132
     * seasons_count : null
     * languages : ["英语"]
     * schedule_url :
     * writers : [{"avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg"},"name_en":"T.S. Nowlin","name":"T·S·诺林","alt":"https://movie.douban.com/celebrity/1342902/","id":"1342902"},{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426087493.08.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426087493.08.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426087493.08.jpg"},"name_en":"James Dashner","name":"詹姆斯·达什纳","alt":"https://movie.douban.com/celebrity/1333681/","id":"1333681"}]
     * pubdates : ["2018-01-26(美国)","2018-01-26(中国大陆)"]
     * website :
     * tags : ["科幻","美国","动作","冒险","2018","反乌托邦","小说改编","悬疑","惊悚","青春"]
     * has_schedule : false
     * durations : ["142分钟"]
     * genres : ["动作","科幻","冒险"]
     * collection : null
     * trailers : [{"medium":"http://img7.doubanio.com/img/trailer/medium/2512420390.jpg?","title":"中国预告片 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/227059/","small":"http://img7.doubanio.com/img/trailer/small/2512420390.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/e06954c425d69547393596c5792ba9b2/view/movie/M/302270059.mp4","id":"227059"},{"medium":"http://img3.doubanio.com/img/trailer/medium/2512246766.jpg?","title":"中国预告片：乐高版 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226927/","small":"http://img3.doubanio.com/img/trailer/small/2512246766.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/7bf85d1a7be3f7ab877a0547488439d7/view/movie/M/302260927.mp4","id":"226927"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2512030130.jpg?","title":"中国预告片：肾上腺素版 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226763/","small":"http://img7.doubanio.com/img/trailer/small/2512030130.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/fbae1223e7ecec96649e36c20ed9a654/view/movie/M/302260763.mp4","id":"226763"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2511722934.jpg?","title":"中国预告片 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226701/","small":"http://img7.doubanio.com/img/trailer/small/2511722934.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/362bb70e020b1439766a3e64d5e59c77/view/movie/M/302260701.mp4","id":"226701"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201804251039/e06954c425d69547393596c5792ba9b2/view/movie/M/302270059.mp4","http://vt1.doubanio.com/201804251039/7bf85d1a7be3f7ab877a0547488439d7/view/movie/M/302260927.mp4","http://vt1.doubanio.com/201804251039/fbae1223e7ecec96649e36c20ed9a654/view/movie/M/302260763.mp4","http://vt1.doubanio.com/201804251039/362bb70e020b1439766a3e64d5e59c77/view/movie/M/302260701.mp4"]
     * has_ticket : false
     * bloopers : [{"medium":"http://img7.doubanio.com/img/trailer/medium/2511634245.jpg?","title":"花絮 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226637/","small":"http://img7.doubanio.com/img/trailer/small/2511634245.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/7393dc0758d71c433c5a6e69f2d26125/view/movie/M/302260637.mp4","id":"226637"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2511379821.jpg?","title":"花絮：豆瓣电影专访《移动迷宫3》跑男团 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226450/","small":"http://img7.doubanio.com/img/trailer/small/2511379821.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/874754922e229925476a50360a7a6bc3/view/movie/M/302260450.mp4","id":"226450"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2511534902.jpg?","title":"MV：许魏洲献唱中推广曲《迷宫》 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226600/","small":"http://img7.doubanio.com/img/trailer/small/2511534902.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/e3fbc260ae69f98fcd2a78fa58a70cab/view/movie/M/302260600.mp4","id":"226600"},{"medium":"http://img3.doubanio.com/img/trailer/medium/2512140349.jpg?","title":"其它花絮：曼联特辑 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226837/","small":"http://img3.doubanio.com/img/trailer/small/2512140349.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/3205130f5a383569c05d46ce7d730243/view/movie/M/302260837.mp4","id":"226837"}]
     * clip_urls : ["http://vt1.doubanio.com/201804251039/29ac9b70ae23047c5948fb3e702a21a6/view/movie/M/302260558.mp4","http://vt1.doubanio.com/201804251039/bd301c896b01f26cbdfc888880ac1ef3/view/movie/M/302250928.mp4"]
     * current_season : null
     * casts : [{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg"},"name_en":"Dylan O'Brien","name":"迪伦·奥布莱恩","alt":"https://movie.douban.com/celebrity/1314963/","id":"1314963"},{"avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.jpg"},"name_en":"Kaya Scodelario","name":"卡雅·斯考达里奥","alt":"https://movie.douban.com/celebrity/1031178/","id":"1031178"},{"avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.jpg"},"name_en":"Ki Hong Lee","name":"李起弘","alt":"https://movie.douban.com/celebrity/1333684/","id":"1333684"},{"avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.jpg"},"name_en":"Thomas Brodie-Sangster","name":"托马斯·布罗迪-桑斯特","alt":"https://movie.douban.com/celebrity/1016669/","id":"1016669"}]
     * countries : ["美国"]
     * mainland_pubdate : 2018-01-26
     * photos : [{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2509193839.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2509193839.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2509193839.jpg","alt":"https://movie.douban.com/photos/photo/2509193839/","id":"2509193839","icon":"http://img3.doubanio.com/view/photo/icon/public/p2509193839.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2519360789.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2519360789.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2519360789.jpg","alt":"https://movie.douban.com/photos/photo/2519360789/","id":"2519360789","icon":"http://img3.doubanio.com/view/photo/icon/public/p2519360789.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2519360787.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2519360787.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2519360787.jpg","alt":"https://movie.douban.com/photos/photo/2519360787/","id":"2519360787","icon":"http://img3.doubanio.com/view/photo/icon/public/p2519360787.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2519360776.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2519360776.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2519360776.jpg","alt":"https://movie.douban.com/photos/photo/2519360776/","id":"2519360776","icon":"http://img3.doubanio.com/view/photo/icon/public/p2519360776.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2519360774.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2519360774.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2519360774.jpg","alt":"https://movie.douban.com/photos/photo/2519360774/","id":"2519360774","icon":"http://img7.doubanio.com/view/photo/icon/public/p2519360774.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2519360764.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2519360764.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2519360764.jpg","alt":"https://movie.douban.com/photos/photo/2519360764/","id":"2519360764","icon":"http://img7.doubanio.com/view/photo/icon/public/p2519360764.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2519360762.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2519360762.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2519360762.jpg","alt":"https://movie.douban.com/photos/photo/2519360762/","id":"2519360762","icon":"http://img7.doubanio.com/view/photo/icon/public/p2519360762.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2519360761.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2519360761.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2519360761.jpg","alt":"https://movie.douban.com/photos/photo/2519360761/","id":"2519360761","icon":"http://img7.doubanio.com/view/photo/icon/public/p2519360761.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2519360760.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2519360760.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2519360760.jpg","alt":"https://movie.douban.com/photos/photo/2519360760/","id":"2519360760","icon":"http://img7.doubanio.com/view/photo/icon/public/p2519360760.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2519360759.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2519360759.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2519360759.jpg","alt":"https://movie.douban.com/photos/photo/2519360759/","id":"2519360759","icon":"http://img3.doubanio.com/view/photo/icon/public/p2519360759.jpg"}]
     * summary : 托马斯（迪伦·奥布莱恩饰）率领的林间斗士在经历了迷宫逃脱和末日丧尸的生死考验后，终于迎来最后的正邪较量。由托马斯、纽特（托马斯·桑斯特饰）等人领军的营救团队，耗时三年筹划营救被抓走的米诺，却意外地发现米诺不在劫获的那截火车上。经调查得知，米诺深陷在WCKD组织的控制之中，托马斯和纽特毅然决定起身前往被称为“最后之都”的人类最后净土，更不惜利用背叛林间斗士投身WCKD的特蕾莎（卡雅·斯考达里奥饰）闯入WCKD，营救米诺和其他人。
     * clips : [{"medium":"http://img3.doubanio.com/img/trailer/medium/2511459538.jpg?","title":"片段 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/226558/","small":"http://img3.doubanio.com/img/trailer/small/2511459538.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/29ac9b70ae23047c5948fb3e702a21a6/view/movie/M/302260558.mp4","id":"226558"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2510150361.jpg?","title":"片段 (中文字幕)","subject_id":"26004132","alt":"https://movie.douban.com/trailer/225928/","small":"http://img7.doubanio.com/img/trailer/small/2510150361.jpg?","resource_url":"http://vt1.doubanio.com/201804251039/bd301c896b01f26cbdfc888880ac1ef3/view/movie/M/302250928.mp4","id":"225928"}]
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg"},"name_en":"Wes Ball","name":"韦斯·鲍尔","alt":"https://movie.douban.com/celebrity/1332723/","id":"1332723"}]
     * comments_count : 14435
     * popular_reviews : [{"rating":{"max":5,"value":2,"min":0},"title":"导演的脑回路就是个迷宫，走进去就出不来了","subject_id":"26004132","author":{"uid":"lingrui1995","avatar":"http://img3.doubanio.com/icon/u63688511-18.jpg","signature":"一个影迷","alt":"http://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿大坏蛋"},"summary":"整个系列都没有移动，为什么在片名里写个\u201c移动\u201d？你考虑过联通和电信的感受吗？ 《移动迷宫1》没有移动，好歹还有迷宫。 《移动迷宫2》没有移动，没有迷宫，好歹还很二。 《移动迷宫3：死亡解药》是移动、迷宫...","alt":"https://movie.douban.com/review/9104389/","id":"9104389"},{"rating":{"max":5,"value":2,"min":0},"title":"《移动迷宫3》：所谓的反乌托邦其实就是美国爽文","subject_id":"26004132","author":{"uid":"162000558","avatar":"http://img7.doubanio.com/icon/u162000558-4.jpg","signature":"","alt":"http://www.douban.com/people/162000558/","id":"162000558","name":"架空"},"summary":"经历了迷宫和丧尸的考验，《移动迷宫》系列终于在今天迎来了\u201c收官一跑\u201d。 作为三部曲的最后一部，《移动迷宫3：死亡解药》把四年间的所有谜团一次性解开，而以托马斯为首的林间地\u201c跑男团\u201d成员们，也将一边拯...","alt":"https://movie.douban.com/review/9103822/","id":"9103822"},{"rating":{"max":5,"value":3,"min":0},"title":"只为纪念我的newt","subject_id":"26004132","author":{"uid":"74010591","avatar":"http://img3.doubanio.com/icon/user_normal.jpg","signature":"","alt":"http://www.douban.com/people/74010591/","id":"74010591","name":"开到荼蘼花事了"},"summary":"电影给了三星，完全是冲着newt这个角色和桑总的面子嗯。 开始看移动迷宫是男票推荐的，第一部里面就发现newt比男一更有魅力，然后就意犹未尽的看了第二部，可惜第二部里面给newt的戏份略少，感觉没看过瘾，当时距...","alt":"https://movie.douban.com/review/9106985/","id":"9106985"},{"rating":{"max":5,"value":3,"min":0},"title":"没有惊喜","subject_id":"26004132","author":{"uid":"161206792","avatar":"http://img7.doubanio.com/icon/u161206792-2.jpg","signature":"","alt":"http://www.douban.com/people/161206792/","id":"161206792","name":"F班的袁湘琴"},"summary":"故事和迷宫没什么关系也是很无奈，以为把米诺丢回迷宫故事可以延续的，说实话直观的感觉是一部不如一部，在剧情上看前俩部纽特这么铁的兄弟，一路都过来了，就死在离解药一步之遥 \u2026为了几个人的生存，毁灭了其他...","alt":"https://movie.douban.com/review/9105036/","id":"9105036"},{"rating":{"max":5,"value":2,"min":0},"title":"《移动迷宫3》","subject_id":"26004132","author":{"uid":"160626812","avatar":"http://img3.doubanio.com/icon/u160626812-6.jpg","signature":"","alt":"http://www.douban.com/people/160626812/","id":"160626812","name":"浅夏安然"},"summary":"彻底的烂片，最精彩的还是第一部，后面两部真的是彻头彻尾的失望！剧情无悬念，特效也一般，   开场十分钟就觉得枯燥无味，托马斯的血能拯救世界主角们居然没有人知道？就特瑞莎一个还算明白点研究解药被这帮人说...","alt":"https://movie.douban.com/review/9103734/","id":"9103734"},{"rating":{"max":5,"value":3,"min":0},"title":"没有迷宫了","subject_id":"26004132","author":{"uid":"160550920","avatar":"http://img7.doubanio.com/icon/u160550920-2.jpg","signature":"","alt":"http://www.douban.com/people/160550920/","id":"160550920","name":"雨可"},"summary":"科幻冒险动作片，主角男托马斯一行人一路攻打丧尸，追逐劫持汽车飞机火车，3D刺激玩转飞机吊火车，飞机吊公车，吃鸡完爆攻克城池，dede...只为用死亡解药，解救人类，这个人类就是米诺，拯救米诺，其他人算了，因...","alt":"https://movie.douban.com/review/9294711/","id":"9294711"},{"rating":{"max":5,"value":4,"min":0},"title":"剧透吐槽千里救minho之再见了我的Newt","subject_id":"26004132","author":{"uid":"AnnaDoyle","avatar":"http://img7.doubanio.com/icon/u30263572-12.jpg","signature":"Don't blink.","alt":"http://www.douban.com/people/AnnaDoyle/","id":"30263572","name":"AnnaDoyle"},"summary":"1. 第三部别名：千里救minho 2. 可怜的minho 3. 我不太清楚小说里的泰瑞沙，但上一部她已经没啥存在感（相比Brenda）不拉好感了这一部看到更没啥感觉了 4. 这就是一个看脸的世界，谁能留Newt的发型还能保持帅气？...","alt":"https://movie.douban.com/review/9088112/","id":"9088112"},{"rating":{"max":5,"value":2,"min":0},"title":"1>2>3","subject_id":"26004132","author":{"uid":"sunxun67","avatar":"http://img7.doubanio.com/icon/u153945162-1.jpg","signature":"","alt":"http://www.douban.com/people/sunxun67/","id":"153945162","name":"小兔乖乖"},"summary":"场面创系列之最，槽点也创系列之最，结局就是为了追求大场面不管不顾的胡闹，反派蠢得不能再蠢，最后据点的安保和防御能力差得不能再差，大结局说好是困难模式，结果就是个简单模式，又臭又长，看着这个系列从有...","alt":"https://movie.douban.com/review/9301709/","id":"9301709"},{"rating":{"max":5,"value":4,"min":0},"title":"最后的城市","subject_id":"26004132","author":{"uid":"131371214","avatar":"http://img7.doubanio.com/icon/u131371214-10.jpg","signature":"","alt":"http://www.douban.com/people/131371214/","id":"131371214","name":"满心欢喜"},"summary":"三部电影终于是完美的结局！！最后一部看着很有生化危机终章的感觉 最后主角们的打戏非常精彩 结局也算是美好的 最后一部开头就很带感 是一场视觉盛宴也是一场听觉盛宴 IMAX效果看的 带着特殊效果看更是极好的！...","alt":"https://movie.douban.com/review/9108738/","id":"9108738"},{"rating":{"max":5,"value":2,"min":0},"title":"对着天空大吼一声：\u201c我是主角！\u201d","subject_id":"26004132","author":{"uid":"56453834","avatar":"http://img7.doubanio.com/icon/u56453834-2.jpg","signature":"","alt":"http://www.douban.com/people/56453834/","id":"56453834","name":"ltheyes"},"summary":"叫迷宫没有迷宫也就算了，所有配角和剧情统统给主角光环让路，最后还给个360度大特写，简直怀疑男主跟导演有py交易\u2026\u2026     我是主角托马斯。 别问为什么我是主角，反正我自带光环。  前1+2集里，全球又毁灭了，...","alt":"https://movie.douban.com/review/9103831/","id":"9103831"}]
     * ratings_count : 36446
     * aka : ["移动迷宫3","死亡解药","The Death Cure"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<VideosBean> videos;
    private List<String> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<BloopersBean> bloopers;
    private List<String> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<ClipsBean> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public List<String> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<String> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<BloopersBean> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<BloopersBean> bloopers) {
        this.bloopers = bloopers;
    }

    public List<String> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<String> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<ClipsBean> getClips() {
        return clips;
    }

    public void setClips(List<ClipsBean> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 5.4
         * details : {"1":1646,"3":8916,"2":6160,"5":706,"4":2339}
         * stars : 30
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 1646.0
             * 3 : 8916.0
             * 2 : 6160.0
             * 5 : 706.0
             * 4 : 2339.0
             */

            @JSONField(name = "1")
            private double _$1;
            @JSONField(name = "3")
            private double _$3;
            @JSONField(name = "2")
            private double _$2;
            @JSONField(name = "5")
            private double _$5;
            @JSONField(name = "4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg
         * large : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg
         * medium : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class VideosBean {
        /**
         * source : {"literal":"iqiyi","pic":"https://img1.doubanio.com/f/movie/e59bf8556426206eab3591f88a6c8ef8bf371a56/pics/movie/video_icon_new.png","name":"爱奇艺视频"}
         * sample_link : http://www.iqiyi.com/v_19rr7q1nms.html?vfm=m_331_dbdy&fv=4904d94982104144a1548dd9040df241
         * video_id : 19rr7q1nms
         * need_pay : true
         */

        private SourceBean source;
        private String sample_link;
        private String video_id;
        private boolean need_pay;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getSample_link() {
            return sample_link;
        }

        public void setSample_link(String sample_link) {
            this.sample_link = sample_link;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public boolean isNeed_pay() {
            return need_pay;
        }

        public void setNeed_pay(boolean need_pay) {
            this.need_pay = need_pay;
        }

        public static class SourceBean {
            /**
             * literal : iqiyi
             * pic : https://img1.doubanio.com/f/movie/e59bf8556426206eab3591f88a6c8ef8bf371a56/pics/movie/video_icon_new.png
             * name : 爱奇艺视频
             */

            private String literal;
            private String pic;
            private String name;

            public String getLiteral() {
                return literal;
            }

            public void setLiteral(String literal) {
                this.literal = literal;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":2,"min":0}
         * useful_count : 179
         * author : {"uid":"172416865","avatar":"http://img7.doubanio.com/icon/u172416865-3.jpg","signature":"","alt":"http://www.douban.com/people/172416865/","id":"172416865","name":"懒人的主"}
         * subject_id : 26004132
         * content : 刚看完，感觉越拍越傻了，托马斯被实验了3年，难道3年时间都没验出来他的血清就是解药？而且活生生把一部惊悚电影拍成了动作电影也是醉了，没什么新意就尽量别拍续集了。
         * created_at : 2018-01-26 23:19:51
         * id : 1313395106
         */

        private RatingBeanX rating;
        private int useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5
             * value : 2.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : 172416865
             * avatar : http://img7.doubanio.com/icon/u172416865-3.jpg
             * signature :
             * alt : http://www.douban.com/people/172416865/
             * id : 172416865
             * name : 懒人的主
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg"}
         * name_en : T.S. Nowlin
         * name : T·S·诺林
         * alt : https://movie.douban.com/celebrity/1342902/
         * id : 1342902
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522030067.81.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class TrailersBean {
        /**
         * medium : http://img7.doubanio.com/img/trailer/medium/2512420390.jpg?
         * title : 中国预告片 (中文字幕)
         * subject_id : 26004132
         * alt : https://movie.douban.com/trailer/227059/
         * small : http://img7.doubanio.com/img/trailer/small/2512420390.jpg?
         * resource_url : http://vt1.doubanio.com/201804251039/e06954c425d69547393596c5792ba9b2/view/movie/M/302270059.mp4
         * id : 227059
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class BloopersBean {
        /**
         * medium : http://img7.doubanio.com/img/trailer/medium/2511634245.jpg?
         * title : 花絮 (中文字幕)
         * subject_id : 26004132
         * alt : https://movie.douban.com/trailer/226637/
         * small : http://img7.doubanio.com/img/trailer/small/2511634245.jpg?
         * resource_url : http://vt1.doubanio.com/201804251039/7393dc0758d71c433c5a6e69f2d26125/view/movie/M/302260637.mp4
         * id : 226637
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg"}
         * name_en : Dylan O'Brien
         * name : 迪伦·奥布莱恩
         * alt : https://movie.douban.com/celebrity/1314963/
         * id : 1314963
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg
             * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg
             * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PhotosBean {
        /**
         * thumb : http://img3.doubanio.com/view/photo/thumb/public/p2509193839.jpg
         * image : http://img3.doubanio.com/view/photo/photo/public/p2509193839.jpg
         * cover : http://img3.doubanio.com/view/photo/albumcover/public/p2509193839.jpg
         * alt : https://movie.douban.com/photos/photo/2509193839/
         * id : 2509193839
         * icon : http://img3.doubanio.com/view/photo/icon/public/p2509193839.jpg
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class ClipsBean {
        /**
         * medium : http://img3.doubanio.com/img/trailer/medium/2511459538.jpg?
         * title : 片段 (中文字幕)
         * subject_id : 26004132
         * alt : https://movie.douban.com/trailer/226558/
         * small : http://img3.doubanio.com/img/trailer/small/2511459538.jpg?
         * resource_url : http://vt1.doubanio.com/201804251039/29ac9b70ae23047c5948fb3e702a21a6/view/movie/M/302260558.mp4
         * id : 226558
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg"}
         * name_en : Wes Ball
         * name : 韦斯·鲍尔
         * alt : https://movie.douban.com/celebrity/1332723/
         * id : 1332723
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanXX {
            /**
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":2,"min":0}
         * title : 导演的脑回路就是个迷宫，走进去就出不来了
         * subject_id : 26004132
         * author : {"uid":"lingrui1995","avatar":"http://img3.doubanio.com/icon/u63688511-18.jpg","signature":"一个影迷","alt":"http://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿大坏蛋"}
         * summary : 整个系列都没有移动，为什么在片名里写个“移动”？你考虑过联通和电信的感受吗？ 《移动迷宫1》没有移动，好歹还有迷宫。 《移动迷宫2》没有移动，没有迷宫，好歹还很二。 《移动迷宫3：死亡解药》是移动、迷宫...
         * alt : https://movie.douban.com/review/9104389/
         * id : 9104389
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanXX {
            /**
             * max : 5
             * value : 2.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : lingrui1995
             * avatar : http://img3.doubanio.com/icon/u63688511-18.jpg
             * signature : 一个影迷
             * alt : http://www.douban.com/people/lingrui1995/
             * id : 63688511
             * name : 凌睿大坏蛋
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
