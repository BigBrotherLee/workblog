package com.workblog.lsy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.Log;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.service.ArticleService;
import com.sunshareteam.workblog.service.CategotyService;
import com.sunshareteam.workblog.service.LogService;
import com.sunshareteam.workblog.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
"classpath:applicationContext-shiro.xml"})
public class TestService {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
	@Test
	public void testaddLog() {
		Log log=new Log();
		log.setLogcontent("日志内容=====================");
		logService.addLog(log);
	}
	@Test
	public void testloggetById() {
		Log log=logService.getById(1);
		System.out.println(log);
	}
	@Test
	public void testloggetAll() {
		PageInfo<Log> info=logService.getAll(0, 4);
		System.out.println(info);
	}
//	--------------------------------user---------------------------------
	@Test
	public void  testgetUserById(){
		User u=userService.getUserById(4);
		System.out.println(u);
	}
	@Test
	public void testgetRoleByUserId() {
		List<Role> list=userService.getRoleByUserId(4);
		System.out.println(list);
	}
	@Test
	public void testgetPermissionByUserId() {
		System.out.println(userService.getPermissionByUserId(4));
	}
	@Test
	public void testaddUser() {
		User user=new User();
		user.setAutograph("你好，世界人");
		user.setEmail("a00dmin@admin.com");
		user.setPassword("1234567");
		user.setPhone("17861324798");
		user.setPic("ghasdjhfg");
		user.setUsername("admin");
		userService.addUser(user);
	}
	@Test
	public void testaddRole() {
		Role role=new Role();
		role.setModifyuser(4);
		role.setRoledetail("测试角色详情");
		role.setRolename("测试角色");
		userService.addRole(role);
	}
	@Test
	public void testaddPermission() {
		Permission p=new Permission();
		p.setMenu("菜单");
		p.setModifyuser(4);
		p.setPermissioncode("article:delete:*");
		p.setPermissionname("删除文章");
		p.setPermissiondetail("删除文章的权限");
		userService.addPermission(p);
	}
	@Test
	public void testaddRoleToUser() {
		userService.addRoleToUser(6, 7);
	}
	@Test
	public void testaddPermissionToRole() {
		userService.addPermissionToRole(7, 3);
	}
	@Test
	public void testupdateUser() {
		User user=new User();
		user.setAutograph("更改签名");
		user.setUserid(5);
		user.setModifyuser(5);
		userService.updateUser(user);
	}
	@Test
	public void testdisableUser() {
		userService.disableUser(7);
	}
	@Test
	public void testgetByKey() {
		PageInfo<User> user=userService.getByKey("ad", 0, 10);
		System.out.println(user);
	}
	@Test
	public void testgetAdmin() {
		PageInfo<User> info=userService.getAdmin(0, 10, "_");
		System.out.println(info);
	}
	@Test
	public void testgetByName() {
		User u=userService.getByName("admin");
		System.out.println(u);
	}
	@Test
	public void testgetByEmail() {
		User u=userService.getByEmail("admin@admin.com");
		System.out.println(u);
	}
//	====================================categoty----------------------------------------
	@Autowired
	private CategotyService categotyService;
	@Test
	public void testcategotygetById() {
		Categoty categoty=categotyService.getById(1);
		System.out.println(categoty);
	}
	@Test
	public void testcategotyinsertCategoty() {
		Categoty categoty=new Categoty();
		categoty.setCategotydetail("技术相关------");
		categoty.setCategotytitle("技术相关");
		categoty.setImg("图片url");
		categoty.setModifyuser(4);
		categotyService.insertCategoty(categoty);
	}
	@Test
	public void testcategotydeleteCategoty() {
		categotyService.deleteCategoty(6);
	}
	@Test
	public void testcategotyupdateGategoty() {
		Categoty categoty=new Categoty();
		categoty.setCategotydetail("技术相关------=====");
		categoty.setCategotyid(6);
		categotyService.updateGategoty(categoty);
	}
	@Test
	public void testcategotygetAll() {
		System.out.println(categotyService.getAll(0, 10));
	}
	@Test
	public void testcategotygetByKey() {
		System.out.println(categotyService.getByKey("_", 0, 10));
	}
	@Test
	public void testcategotygetByArticle() {
		System.out.println(categotyService.getByArticle(2));
	}
	@Test
	public void testcategotychangeCategoty() {
		categotyService.changeCategoty(6, 1);
	}
//	========================================article------------------------------------------
	@Autowired
	private ArticleService articleService;
	@Test
	public void testarticlegetbyid() {
		Article a=articleService.getById(1);
		System.out.println(a);
	}
	@Test
	public void testinsertArticle() {
		Article a=new Article();
		a.setCategoty(1);
		a.setAuthor(5);
		a.setContent("话说生活中我们总能遇到一些喜欢装逼的人，不过有些人却能装逼于无形，看完这期故事才发现，原来装逼也是一件技术活，这期就带大家来看看这些大神是如何做到的 ~！\n" + 
				"开了工资去逛街，看到一件衣服特别漂亮。我试了试，感觉真挺适合我，我问了一下价格……\n" + 
				"竟然要六千五百元，然后我就脱了下来，要知道我一个月工资才 3000，\n" + 
				"售货员一直问我这么适合我，为什么不买呢？\n" + 
				"我把衣服给售货员后说了一句：\n" + 
				"\" 太便宜了   \"\n" + 
				"我就走了，哈哈。\n" + 
				"@** 叶子  \n" + 
				"初二的时候走桃花运，追到了班花，但是一开始大家都不信啊，我就挺生气的。\n" + 
				"一次放学回家坐公交车，我看见我的女朋友还有挺多班级同学都在一辆车上，\n" + 
				"我灵机一动，给他们做手势：我要亲她证明这是我女朋友。\n" + 
				"大家表情一脸诡异 : 懂了，请开始你的表演！ \n" + 
				"于是我全程站在她的身后，等待机会……\n" + 
				"终于一个十字路口有人抢道，司机一脚刹车下去，我瞬间抱住班花，一口亲了下去……\n" + 
				"在她一脸惊愕的表情中，满车欢呼！\n" + 
				"@** � � � �\n" + 
				"小时候，大概五六岁吧，去同村亲戚家吃酒席，我奶奶帮厨房，我跟几个小伙伴一起玩，主人家的小孩在床头柜找到了麻角（一种面粉熟食，菱形的小小的）。\n" + 
				"他就开始分给我们这群小伙伴吃，他们每个人分了一把呢，到我最后就给我几个，\n" + 
				"当时我内心涌起一阵装逼的热血，把麻角往床头柜一扔昂着头说：\n" + 
				"\" 这么点，我不吃！\"。。。\n" + 
				"过了一会我们几个人排排坐的时候，他们几个相继四脚朝天的倒下去了，伴随口吐白沫，我以为是游戏也倒下去玩，但是我吐不出那么多沫沫，\n" + 
				"而且他们没了动静，我就去找我奶奶，后来，那几个全部送去医院急救洗胃，老鼠药拌的麻角啊。。。\n" + 
				"幸亏我装逼了，幸亏我跑去说了，不然四个人全得一命呜呼了都。。。最成功的装逼，没有之一！\n" + 
				"@** 阳光\n" + 
				"本人男，大概是去年的时候，我一个关系很好的女性朋友过生日，然后我带她去酒吧喝酒，她还带上了两个女同学，以上是背景。\n" + 
				"我们聊的正嗨的时候隔壁桌一个哥们过来要跟我们喝酒，重点来了！\n" + 
				"我也不造为什么，他就开始跟我说大学的时候班里就没女生，现在上班了公司里也没妹子，巴拉巴拉，然后问我这三个妹子里面哪个是我女朋友。\n" + 
				"我说都不是啊，我女朋友没来 ( 异地 , 不过现在是前女友了 ) ，\n" + 
				"最后我在那个哥们一脸羡慕的表情中，深藏功与名。\n" + 
				"( 此处应有墨镜和大金链子 )\n" + 
				"@** 之北  \n" + 
				"暑假的时候酒店做服务员，有两个外国人点了两瓶啤酒，\n" + 
				"我送到门口时发现忘记拿起瓶器，因楼层太高懒得去拿，我就用牙把盖子咬开再盖上。\n" + 
				"进去后问老外是否打开，老外说可以，\n" + 
				"我一手拿一瓶，大拇指轻轻一弹……盖子飞了。\n" + 
				"老外惊呼：chinese kungfu？？\n" + 
				"@** 阳\n" + 
				"记得上初一的时候，对新学校不熟悉，上体育课一个人提前回教室，走错楼层了。\n" + 
				"一推门，卧槽，这怎么不对劲呀？里面老师同学都一脸错愕的看着我，\n" + 
				"正当我不知如何是好的时候，看到我脚底下踩了一个塑料袋，于是我弯腰捡起来，甩了甩头发故作镇静说 ~\n" + 
				"\" 说了几遍了，不要乱扔垃圾，好了，你们继续上课吧！\"\n" + 
				"然后就潇洒转头出门。\n" + 
				"@** 旧人\n" + 
				"大学运动会有个特漂亮的女同学背包放我这了，快结束的时候她在很远的地方跟我招手。\n" + 
				"因为人声鼎沸根本听不到，我就也站起来冲她喊：\n" + 
				"\" 我也爱你！\"\n" + 
				"她猛点头继续冲我挥手。\n" + 
				"周围那群单身狗简直生不如死。\n" + 
				"@*** 玛\n" + 
				"异地恋的时候，跟同事围在一起，这个说男朋友对她多好多好，那个说男朋友多听话多帅…\n" + 
				"然后问我：\" 你男朋友呢？\"\n" + 
				"我：\" 我…我男朋友又帅对我又超级好，只要我一句话马上就来我身边。\"  \n" + 
				"刚好那天他放假过来看我，在同事的怀疑声中，在我旁边坐下，\n" + 
				"笑着说：\" 在夸我？\"\n" + 
				"@** 小丸子  \n" + 
				"最成功的一次是和我同事去吃饭，我同事说那边几个妹子挺好看的，\n" + 
				"我顺势看过去是很好看，仔细一看竟然是我女朋友还有她朋友在吃饭，\n" + 
				"他说你去要个微信啊，我说无不无聊，他说要到的话饭我请然后去 KTV 唱歌，\n" + 
				"我说好啊，然后就过去直接给我对象说了一下，就又回到了座位。\n" + 
				"看着我要到的微信，从此同事对我刮目相看，不过他到现在都不知道那是我对象。\n" );
		a.setTitle("论装逼的最高境界是什么？看完不得不服！");
		a.setImg("图片url");
		a.setSummary("最成功的一次是和我同事去吃饭，我同事说那边几个妹子挺好看的，\n" + 
				"我顺势看过去是很好看，仔细一看竟然是我女朋友还有她朋友在吃饭，\n" + 
				"他说你去要个微信啊，我说无不无聊，他说要到的话饭我请然后去 KTV 唱歌，\n" + 
				"我说好啊，然后就过去直接给我对象说了一下，就又回到了座位。\n" + 
				"看着我要到的微信，从此同事对我刮目相看，不过他到现在都不知道那是我对象。\n" );
		articleService.insertArticle(a);
	}
	
	@Test
	public void testupdateArticle() {
		Article a=new Article();
		a.setArticleid(1);
		a.setCommentnum(1);
		articleService.updateArticle(a);
	}
	@Test
	public void testdeleteArticle() {
		articleService.delete(5);
	}
	@Test
	public void tsetArticlegetByKey() {
		System.out.println(articleService.getByKey("_", 0, 10));
	}
	
	@Test
	public void tsetArticleggetByAuthor() {
		System.out.println(articleService.getByAuthor(5, 0, 10));
	}
	@Test
	public void tsetArticleggetByAuthorAll() {
		System.out.println(articleService.getByAuthorAll(5, 0, 10));
	}
	@Test
	public void tsetArticleggetByCategoty() {
		System.out.println(articleService.getByCategoty(1, 0, 10));
	}
	@Test
	public void tsetArticleggetByTag() {
		System.out.println(articleService.getByTag(1, 0, 10));
	}
	
	@Test
	public void tsetArticleggetByKeyAll() {
		System.out.println(articleService.getByKeyAll("_", 0, 10));
	}
	@Test
	public void tsetArticleggethot() {
		System.out.println(articleService.getHot( 0, 10));
	}
	@Test
	public void tsetArticleggetNew() {
		System.out.println(articleService.getNew( 0, 10));
	}
}
