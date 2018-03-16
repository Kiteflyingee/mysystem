 画室管理系统


2017-7-31 16:26:34： 更新 修改了修改课次界面的下拉框采用if标签去除重复显示的问题

---------------------------------------------------



项目构思
1.需求分析阶段

	分为两个大模块
		一是教师教课大类管理:
									1）课次管理
									2）作品记录
		二是对学生的专项管理：首先列出学生的列表，管理员通过点击摸个具体的学生以访问该学生的具体管理页面
									1）学生信息管理
									2）学生课次管理
									3）学生进度管理
									4）学生作品管理
								
2.数据库设计

	1.学生表（孩子）
	
		name 姓名
		sex 性别
		school 学校
		classroom 班级
		brithday 生日
		age 年龄
		<!--不维护双胞胎-->
	2.家长信息表（孩子与家长一对多）(考虑修订这个表，把家长合并为一个，多一个与子女关系的属性)
	
		f_name 父亲姓名
		f_job 父亲工作
		f_company 父亲公司
		f_mobile 父亲电话
		m_name 母亲姓名
		m_job 母亲工作
		m_company 母亲公司
		m_mobile 母亲电话
		address 家庭住址
		
	3.课程信息表（每个学生的课时数都是不一样的）
		c_name 课程名
		c_status 课程状态
	
	4.学生上课表（考虑学生续报名课程的问题）
		c_id 课程编号（外键）
		s_id 学生编号（外键）
		classhours 课时数
		resthours 剩余课时数
		signupdate 报名时间（最初的时间）
		
	4.教师信息表（暂时不设置）
		t_name 教师姓名
		t_sex 教师性别
		
	5.作品表
		s_name 学生姓名
		p_name 作品名
		pubtime 作品发表时间
		p_comment 作品评论
		filename 作品文件名（生成文件名算法待考虑）
		
	6.附加表（上课信息表）
		c_id 课程名
		t_id 老师编号
		c_time 上课课次（当日的第几节课）
		
		
3.程序总体设计已经结束

	1.创建DAO
	2.构思界面
	3.controller&service
	
4.导包

		1.spring相关jar
		2.fileupload相关jar
		3.mybatis相关jar
		4.连接池
		
		
5.网站的分离功能已经搭建差不多了。开展搭建学生个人主页管理

	1)删除学生信息
	2)更新学生信息
	3)更新课程状态
	
6.个人中心设计

	1)学生个人信息（改和查）
	2)家长信息的crud
	3)个人作品的crud
	4)课次管理
	5)学习进度
	

增加的需求

	1.学习目标未实现暂时；
	2.考虑添加作品批量上传。
	3.课时数要好修改，方便点错了，撤销

学习目标管理：添加表格	

	CREATE TABLE learngoal
	(
	id int(10) primary key auto_increment,
	sc_id int(10),
	imagepath_1 varchar(255),
	imagepath_2 varchar(255),
	imagepath_3 varchar(255),
	t_comment varchar(255)
	)


学习目标重写

	1.学习目标只需要保存她提供的word文件就行。设计好的方案和代码去除。
	2.学生能够按年龄和学习课程排序。



开始新版制作，后期添加jjweb核心包采用maven进行项目管理
新版本带有new文件夹

1.主页面的编写

	分页重新制作 QueryInfo  QueryResult
	可以用一个page实体来再度封装这两个实体。
	
	
	
	
	
	

学生主体管理：
1.显示
2.添加
3.修改，前端模块完成（通过后台取数据库数据进行转发）

 画室管理系统


2017-7-31 16:26:34： 更新 修改了修改课次界面的下拉框采用if标签去除重复显示的问题

---------------------------------------------------



项目构思
1.需求分析阶段

	分为两个大模块
		一是教师教课大类管理:
									1）课次管理
									2）作品记录
		二是对学生的专项管理：首先列出学生的列表，管理员通过点击摸个具体的学生以访问该学生的具体管理页面
									1）学生信息管理
									2）学生课次管理
									3）学生进度管理
									4）学生作品管理
								
2.数据库设计
	1.学生表（孩子）
		name 姓名
		sex 性别
		school 学校
		classroom 班级
		brithday 生日
		age 年龄
		<!--不维护双胞胎-->
	2.家长信息表（孩子与家长一对多）(考虑修订这个表，把家长合并为一个，多一个与子女关系的属性)
		f_name 父亲姓名
		f_job 父亲工作
		f_company 父亲公司
		f_mobile 父亲电话
		m_name 母亲姓名
		m_job 母亲工作
		m_company 母亲公司
		m_mobile 母亲电话
		address 家庭住址
		
	3.课程信息表（每个学生的课时数都是不一样的）
		c_name 课程名
		c_status 课程状态
	
	4.学生上课表（考虑学生续报名课程的问题）
		c_id 课程编号（外键）
		s_id 学生编号（外键）
		classhours 课时数
		resthours 剩余课时数
		signupdate 报名时间（最初的时间）
		
	4.教师信息表（暂时不设置）
		t_name 教师姓名
		t_sex 教师性别
		
	5.作品表
		s_name 学生姓名
		p_name 作品名
		pubtime 作品发表时间
		p_comment 作品评论
		filename 作品文件名（生成文件名算法待考虑）
		
	6.附加表（上课信息表）
		c_id 课程名
		t_id 老师编号
		c_time 上课课次（当日的第几节课）
		
		
3.程序总体设计已经结束
	1.创建DAO
	2.构思界面
	3.controller&service
	
4.导包
		1.spring相关jar
		2.fileupload相关jar
		3.mybatis相关jar
		4.连接池
		
		
5.网站的分离功能已经搭建差不多了。开展搭建学生个人主页管理
	1)删除学生信息
	2)更新学生信息
	3)更新课程状态
	
6.个人中心设计
	1)学生个人信息（改和查）
	2)家长信息的crud
	3)个人作品的crud
	4)课次管理
	5)学习进度
	

增加的需求
	1.学习目标未实现暂时；
	2.考虑添加作品批量上传。
	3.课时数要好修改，方便点错了，撤销

学习目标管理：添加表格	
CREATE TABLE learngoal
(
id int(10) primary key auto_increment,
sc_id int(10),
imagepath_1 varchar(255),
imagepath_2 varchar(255),
imagepath_3 varchar(255),
t_comment varchar(255)
)

学习目标重写
1.学习目标只需要保存她提供的word文件就行。设计好的方案和代码去除。
2.学生能够按年龄和学习课程排序。



开始新版制作，后期添加jjweb核心包采用maven进行项目管理
新版本带有new文件夹

1.主页面的编写
	分页重新制作 QueryInfo  QueryResult
	可以用一个page实体来再度封装这两个实体。
						
						