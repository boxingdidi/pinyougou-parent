## 一、背景分析
### 1.实现背景
    本篇文章是以品牌关联为案例进行编写实现。
    可扩展为，只是改变一下数据库字段即可。
    	省市三级联动，比如 省关联市，市关联县，这是最常见的关联效果

### 2.实现效果
    效果如下图:
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190726010534221.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1NTExNjg1,size_16,color_FFFFFF,t_70)
## 二、准备工作
### 1.查看数据库结构![数据库效果图](https://img-blog.csdnimg.cn/20190726011146761.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1NTExNjg1,size_16,color_FFFFFF,t_70)
### 2.查看后段返回数据格式（json）

```json

一级标签：
	[
	 {
	    "id": 74,
	    "name": "家用电器",
	    "parentId": 0,
	    "typeId": 35
	  }
	]
二级标签：
	[
	  {
	    "id": 75,
	    "name": "大家电",
	    "parentId": 74,
	    "typeId": 35
	  }
	]
三级标题：
    [
      {
        "id": 76,
        "name": "平板电视",
        "parentId": 75,
        "typeId": 37
      },
      {
        "id": 77,
        "name": "空调",
        "parentId": 75,
        "typeId": 35
      },
      { 
        "id": 78,
        "name": "冰箱",
        "parentId": 75,
        "typeId": 35
      }
    ]    
```



